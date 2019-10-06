package org.victor.customer.service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.victor.customer.model.Customer;
import org.victor.customer.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository repo;

	public Iterable<Customer> getAll() {
		return repo.findAll();
	}

	public Customer add(Customer customer) {
		Customer savedCustomer = repo.save(customer);
		return savedCustomer;
	}

	public Customer get(UUID id) {
		Optional<Customer> customer = repo.findById(id);
		return customer.get();
	}

	public Customer update(Customer customer, UUID id) {
		if (repo.existsById(id)) {
			Customer savedCustomer = repo.save(customer);
			return savedCustomer;			
		}
		throw new NoSuchElementException();
	}

	public Customer delete(UUID id) {
		Optional<Customer> savedCustomer = repo.findById(id);
		if (savedCustomer.isPresent()) {
			repo.deleteById(id);		
		}
		return savedCustomer.get();
	}

}
