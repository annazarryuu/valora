package com.chaos.valoraservice.repository;

import com.chaos.valoraservice.model.Transaction;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TransactionRepository extends ReactiveMongoRepository<Transaction, String> {
    
}