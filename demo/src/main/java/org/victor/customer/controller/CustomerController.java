package org.victor.customer.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.victor.customer.model.Customer;
import org.victor.customer.service.CustomerService;

import io.swagger.annotations.Api;

@CrossOrigin(origins = "*", maxAge = 3600) 
@RestController
@Api
class CustomerController {

@Autowired
private CustomerService customerService;
	@GetMapping("/customers")
	Iterable<Customer> all() {
		return customerService.getAll();
	}

	@PostMapping("/customers")
	Customer add(@RequestBody Customer customer) {
		customerService.add(customer);
		return customer;
	}

	@GetMapping("/customers/{id}")
	Customer one(@PathVariable UUID id) {
		return customerService.get(id);
	}

	@PutMapping("/customers/{id}")
	Customer replace(@RequestBody Customer customer, @PathVariable UUID id) {
		customerService.update(customer, id);
		return customer;
	}

	@DeleteMapping("/customers/{id}")
	Customer delete(@PathVariable UUID id) {
		Customer deletedcustomer = customerService.delete(id);
		return deletedcustomer;
	}
}
