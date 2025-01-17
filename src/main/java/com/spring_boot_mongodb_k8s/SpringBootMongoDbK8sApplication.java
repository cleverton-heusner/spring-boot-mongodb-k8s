package com.spring_boot_mongodb_k8s;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootMongoDbK8sApplication implements CommandLineRunner {

	@Autowired
	private CustomerService customerService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongoDbK8sApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		customerService.deleteAll();

		// save a couple of customers
		customerService.save(new Customer("Alice", "Smith"));
		customerService.save(new Customer("Bob", "Smith"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : customerService.findAll()) {
			System.out.println(customer);
		}

		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(customerService.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : customerService.findByLastName("Smith")) {
			System.out.println(customer);
		}
	}
}