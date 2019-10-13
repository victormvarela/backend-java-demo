package org.victor.customer.unit;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.victor.customer.CustomerTestUtil;
import org.victor.customer.model.Customer;
import org.victor.customer.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTest {
	private int CUSTOMERS_TO_SAVE =10;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Test
	public void findAll() {
		List<Customer> customers = CustomerTestUtil.createCustomer(CUSTOMERS_TO_SAVE);
		customers.forEach(entityManager::persist);
		entityManager.flush();
		
		Iterable<Customer> dbCustomers = customerRepository.findAll();
		
		assertThat(dbCustomers)
			.hasSize(CUSTOMERS_TO_SAVE)
			.extracting(Customer::getName).contains(customers.get(0).getName());
		
	}
}
