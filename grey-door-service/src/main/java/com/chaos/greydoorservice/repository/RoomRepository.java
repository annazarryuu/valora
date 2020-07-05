package com.chaos.greydoorservice.repository;

import com.chaos.greydoorservice.model.Room;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Flux;

public interface RoomRepository extends ReactiveMongoRepository<Room, String> {
    
    public Flux<Room> findByStatus(String status);
    public Flux<Room> findByType(String type);

}
