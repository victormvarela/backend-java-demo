package org.victor.customer.unit;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import org.victor.customer.CustomerTestUtil;
import org.victor.customer.model.Customer;
import org.victor.customer.repository.CustomerRepository;
import org.victor.customer.service.CustomerService;

@RunWith(SpringRunner.class)
public class CustomerServiceTest {
	private int CUSTOMERS_TO_SAVE = 10;

	@TestConfiguration
	static class CustomerServiceTestContextConfiguration {
		@Bean
		public CustomerService customerService() {
			return new CustomerService();
		}
	}

	@Autowired
	private CustomerService customerService;

	@MockBean
	private CustomerRepository customerRepository;

	private List<Customer> customers;

	@Before
	public void setUp() {
		customers = CustomerTestUtil.createCustomer(CUSTOMERS_TO_SAVE);
		Mockito.when(customerRepository.findAll()).thenReturn(customers);

		PageImpl<Customer> page0 = new PageImpl<>(customers.subList(0, 5));
		Mockito.when(customerRepository.findAll(PageRequest.of(0, 5))).thenReturn(page0);
		PageImpl<Customer> page1 = new PageImpl<>(customers.subList(0, 5));
		Mockito.when(customerRepository.findAll(PageRequest.of(1, 5))).thenReturn(page1);
	}

	@Test
	public void getAll() {
		Pageable page0 = PageRequest.of(0, 5);
		Page<Customer> readCustomersPage0 = customerService.getAll(page0);

		assertThat(readCustomersPage0.get()).hasSize(5);

		Pageable page1 = PageRequest.of(1, 5);
		Page<Customer> readCustomersPage1 = customerService.getAll(page1);

		assertThat(readCustomersPage1.getContent()).hasSize(5)
				.doesNotContainAnyElementsOf(readCustomersPage0.getContent());

		assertThat(customers).containsAll(readCustomersPage1.getContent()).containsAll(readCustomersPage0.getContent());
	}
}
