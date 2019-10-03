package org.victor.client.controller;

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
import org.victor.client.model.Client;
import org.victor.client.service.ClientService;

import io.swagger.annotations.Api;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Api
class ClientController {

@Autowired
private ClientService clientModel;
	@GetMapping("/clients")
	Iterable<Client> all() {
		return clientModel.getAll();
	}

	@PostMapping("/clients")
	Client add(@RequestBody Client client) {
		clientModel.add(client);
		return client;
	}

	@GetMapping("/clients/{id}")
	Client one(@PathVariable UUID id) {
		return clientModel.get(id);
	}

	@PutMapping("/clients/{id}")
	Client replace(@RequestBody Client client, @PathVariable UUID id) {
		clientModel.update(client, id);
		return client;
	}

	@DeleteMapping("/clients/{id}")
	Client delete(@PathVariable UUID id) {
		Client deletedClient = clientModel.delete(id);
		return deletedClient;
	}
}
