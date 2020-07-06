package com.chaos.valoraservice.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TransactionRepository extends ReactiveMongoRepository<TransactionRepository, String> {
    
}