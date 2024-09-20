package com.spring_boot_mongodb_k8s;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    Customer findByFirstName(String firstName);
    List<Customer> findByLastName(String lastName);
}
