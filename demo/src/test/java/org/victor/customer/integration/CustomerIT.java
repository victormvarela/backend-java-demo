package org.victor.customer.integration;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerIT {
	@Autowired
	private TestRestTemplate restTemplate;
	
	private HttpHeaders httpHeaders = new HttpHeaders();
	
	private String URL="/customers";

	@Test
	public void addCustomer() {
		String body="{\"name\":\"First customer\",\"address\":\"First customer address\",\"notes\":\"First customer notes\"}";
		HttpEntity<String> request = new HttpEntity<String>(body, httpHeaders);
		
		ResponseEntity<String> responseEntity = restTemplate.postForEntity(URL, request, String.class);
		System.out.println(responseEntity.getBody());
	}
	
	@Test
	public void getAllCustomers() {
		String response = restTemplate.getForObject("/customers", String.class, "");
		
		System.out.println(response);
	}

}
