package org.victor.client.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@Api
class ClientController {

	private static List<Client> clients = new ArrayList<>();
	@GetMapping("/clients")
	List<Client> all() {
		return clients;
	}

	@PostMapping("/clients")
	Client add(@RequestBody Client client) {
		clients.add(client);
		return client;
	}

	@GetMapping("/clients/{id}")
	Client one(@PathVariable Integer id) {
		return clients.get(id);
	}

	@PutMapping("/clients/{id}")
	Client replace(@RequestBody Client client, @PathVariable Integer id) {
		clients.set(id, client);
		return client;
	}

	@DeleteMapping("/clients/{id}")
	Client delete(@PathVariable Integer id) {
		Client client = clients.get(id);
		clients.remove(client);
		return client;
	}
}
