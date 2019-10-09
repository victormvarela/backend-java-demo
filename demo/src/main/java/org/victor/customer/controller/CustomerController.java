package org.victor.customer.controller;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LogLevel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

import com.github.rozidan.springboot.logger.Loggable;

import io.swagger.annotations.Api;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Api
class CustomerController {	
	private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;

	@GetMapping("/customers")
	@Loggable()
	Page<Customer> all(@PageableDefault(size = 50, sort = "id") Pageable pageable) {
		log.debug("getall",pageable);
		return customerService.getAll(pageable);
	}

	@PostMapping("/customers")
	@Loggable(entered = true, value = LogLevel.INFO)
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
