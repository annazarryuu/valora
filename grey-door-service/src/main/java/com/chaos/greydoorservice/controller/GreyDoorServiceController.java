package com.chaos.greydoorservice.controller;

import com.chaos.greydoorservice.model.Room;
import com.chaos.greydoorservice.repository.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class GreyDoorServiceController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/rooms/list")
    public @ResponseBody Flux<Room> findAllRooms() {
        return this.roomRepository.findAll();
    }

    @GetMapping("/rooms/list/status/{status}")
    public @ResponseBody Flux<Room> findRoomsByStatus(@PathVariable("status") String status) {
        return this.roomRepository.findByStatus(status);
    }

    @GetMapping("/rooms/list/type/{type}")
    public @ResponseBody Flux<Room> findRoomsByType(@PathVariable("type") String type) {
        return this.roomRepository.findByType(type);
    }

    @GetMapping("/rooms/id/{id}")
    public @ResponseBody Mono<Room> findRoom(@PathVariable("id") String id) {
        return this.roomRepository.findById(id);
    }

    @PostMapping("/rooms")
    public @ResponseBody Mono<Void> insertRoom(@RequestBody Room room) {
        return this.roomRepository.save(room).then();
    }

    @PutMapping("/rooms")
    public @ResponseBody Mono<Void> updateRoom(@RequestBody Room room) {
        return this.roomRepository.save(room).then();
    }

    @DeleteMapping("/rooms/id/{id}")
    public @ResponseBody Mono<Void> deleteRoom(@PathVariable("id") String id) {
        return this.roomRepository.deleteById(id).then();
    }
    
}
