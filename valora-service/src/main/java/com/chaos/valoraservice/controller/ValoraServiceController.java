package com.chaos.valoraservice.controller;

import com.chaos.valoraservice.model.Room;
import com.chaos.valoraservice.model.RoomVendor;
import com.chaos.valoraservice.model.Transaction;
import com.chaos.valoraservice.model.Vendor;
import com.chaos.valoraservice.repository.TransactionRepository;
import com.chaos.valoraservice.repository.VendorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ValoraServiceController {

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping("/rooms/list")
    public @ResponseBody Flux<RoomVendor> findAllRooms() {
        Flux<Vendor> fluxVendor = this.vendorRepository.findAll();
        return fluxVendor.flatMap(vendor -> {
            WebClient webClient = WebClient.create();
            Flux<Room> fluxRoom = webClient
                .get()
                .uri(vendor.getUrl() + "/rooms/list")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Room.class);
            return fluxRoom.map(room -> {
                return new RoomVendor(room.getId(), room.getType(),
                    room.getStatus(), vendor.getId(), vendor.getName());
            });  
        });
    }

    @GetMapping("/rooms/transactions/list")
    public @ResponseBody Flux<Transaction> findAllTransactions() {
        return this.transactionRepository.findAll();
    }

    @PostMapping("/rooms/transactions")
    public @ResponseBody Mono<Transaction> bookRoom(@RequestBody Transaction transaction) {
        return this.transactionRepository
                .existsById(transaction.getIdempotencyKey())
                .flatMap(isExist -> {
                    if(isExist) {
                        return this.transactionRepository
                            .findById(transaction.getIdempotencyKey())
                            .map(trans -> {
                                trans.setResponse("repeated, " + trans.getResponse());
                                return trans;
                            });
                    }
                    else {
                        return this.vendorRepository
                            .findById(transaction.getVendorId())
                            .flatMap(vendor -> {
                                return WebClient.create()
                                    .get()
                                    .uri(vendor.getUrl() + "/rooms/id/" + transaction.getRoomId())
                                    .accept(MediaType.APPLICATION_JSON)
                                    .retrieve()
                                    .bodyToMono(Room.class)
                                    .flatMap(room -> {
                                        String beforeStatus = "available", afterStatus = "booked";
                                        if(transaction.getType().equals("unbook")) {
                                            beforeStatus = "booked";
                                            afterStatus = "available";
                                        }
                                        if(room.getStatus().equals(beforeStatus)) {
                                            transaction.setResponse("success");
                                            room.setStatus(afterStatus);
                                            return WebClient.create()
                                                .put()
                                                .uri(vendor.getUrl() + "/rooms")
                                                .body(Mono.just(room), Room.class)
                                                .retrieve()
                                                .bodyToMono(Room.class)
                                                .flatMap(roomBooked -> {
                                                    return this.transactionRepository
                                                        .save(transaction);
                                                });
                                        }
                                        else {
                                            transaction.setResponse("failed");
                                            return this.transactionRepository
                                                .save(transaction);
                                        }
                                    });
                            });
                    }
                });
    }

}
