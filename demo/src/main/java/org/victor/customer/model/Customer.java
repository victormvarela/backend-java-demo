package org.victor.customer.model;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Customer {
	
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
	
	@NotNull
	private String name;
	
	private String address;
	
	@Lob
	private String notes;
	
	@Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
	private LocalDateTime startDate;
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", notes=" + notes + ", startDate="
				+ startDate + "]";
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

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	
	

}
