package com.chaos.valoraservice.controller;

import com.chaos.valoraservice.model.Room;
import com.chaos.valoraservice.model.RoomVendor;
import com.chaos.valoraservice.model.Transaction;
import com.chaos.valoraservice.model.Vendor;
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

    @PostMapping("/rooms/book")
    public @ResponseBody Mono<Transaction> bookRoom(@RequestBody Transaction transaction) {
        /*
            1. cek transaksi sebelumnya, ada ngga yang idempotencyKey nya sama.
                a. kalo ada, return transaksi nya langsung.
                b. kalo ngga ada, lanjut ke langkah 2.
            2. cek kamarnya booked atau available.
                a. kalo booked, set response jadi "failed"
                b. kalo available, langsung book dan set response jadi "success"
            3. save transaksi nya dan return transaksinya.
        */
    }

    @PostMapping("/rooms/unbook")
    public @ResponseBody Mono<Transaction> unbookRoom(@RequestBody Transaction transaction) {
        /*
            1. cek transaksi sebelumnya, ada ngga yang idempotencyKey nya sama.
                a. kalo ada, return transaksi nya langsung.
                b. kalo ngga ada, lanjut ke langkah 2.
            2. cek kamarnya booked atau available.
                a. kalo available, set response jadi "failed"
                b. kalo booked, langsung book dan set response jadi "success"
            3. save transaksi nya dan return transaksinya.
        */
        @Autowired
        private TransactionRepository transactionRepository;

        this.transactionRepository = new Transaction; 
        if (transactionRepository.idempotencyKey == 0) { 
            return Transaction;
        } 
    }

}
