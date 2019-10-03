package org.victor.client.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.victor.client.model.Client;



@Repository
public interface ClientRepository extends CrudRepository<Client, UUID>{

}
