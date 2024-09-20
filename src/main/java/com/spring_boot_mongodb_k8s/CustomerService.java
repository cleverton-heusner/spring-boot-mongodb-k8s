package com.spring_boot_mongodb_k8s;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findByFirstName(final String firstName) {
        return customerRepository.findByFirstName(firstName);
    }

    public List<Customer> findByLastName(final String lastName) {
        return customerRepository.findByLastName(lastName);
    }

    public void save(final Customer customer) {
        customerRepository.save(customer);
    }

    public void deleteAll() {
        customerRepository.deleteAll();
    }
}