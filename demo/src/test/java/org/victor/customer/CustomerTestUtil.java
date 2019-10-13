package org.victor.customer;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.logging.LogLevel;
import org.victor.customer.model.Customer;

import com.github.javafaker.Faker;
import com.github.rozidan.springboot.logger.Loggable;

public class CustomerTestUtil {
	private static Faker faker = new Faker();

	@Loggable(value = LogLevel.TRACE)
	public static Customer createCustomer() {
		Customer c = new Customer();
		c.setAddress(faker.address().fullAddress());
		c.setName(faker.name().name());
		c.setNotes(faker.lorem().characters(0, 50));
		c.setStartDate(faker.date().future(10, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());

		return c;
	}
	
	public static List<Customer> createCustomer(int numOfCustomers){
		var customers= new ArrayList<Customer>();
		
		for (int i=0;i<numOfCustomers;i++) {
			Customer c = createCustomer();
			customers.add(c);
		}
		return customers;
	}
}
