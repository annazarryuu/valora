package com.chaos.valoraservice.repository;

import com.chaos.valoraservice.model.Vendor;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface VendorRepository extends ReactiveMongoRepository<Vendor, String> {
    
}