package org.victor.client.service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.victor.client.model.Client;
import org.victor.client.repository.ClientRepository;

@Service
public class ClientService {
	@Autowired
	private ClientRepository repo;

	public Iterable<Client> getAll() {
		return repo.findAll();
	}

	public Client add(Client client) {
		Client savedClient = repo.save(client);
		return savedClient;
	}

	public Client get(UUID id) {
		Optional<Client> client = repo.findById(id);
		return client.get();
	}

	public Client update(Client client, UUID id) {
		if (repo.existsById(id)) {
			Client savedClient = repo.save(client);
			return savedClient;			
		}
		throw new NoSuchElementException();
	}

	public Client delete(UUID id) {
		Optional<Client> savedClient = repo.findById(id);
		if (savedClient.isPresent()) {
			repo.deleteById(id);		
		}
		return savedClient.get();
	}

}
