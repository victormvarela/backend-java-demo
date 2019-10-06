package org.victor.customer.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.victor.customer.model.Customer;



@Repository
public interface CustomerRepository extends CrudRepository<Customer, UUID>{

}
