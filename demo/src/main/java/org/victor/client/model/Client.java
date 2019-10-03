package org.victor.client.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Client {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
			name ="UUID",
			strategy="org.hibernate.id.UUIDGenerator",
			parameters = {
					@Parameter(
							name ="uuid_gen_strategy_class",
							value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
							)
			})
	@Column (name="id", updatable = false, nullable = false)
	private UUID id;
	
	private String name;
	
	private String address;
	
	private String notes;
	
	@Override
	public String toString() {
		return "Client [name=" + name + ", address=" + address + ", notes=" + notes + ", toString()=" + super.toString()
				+ "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	
	

}
