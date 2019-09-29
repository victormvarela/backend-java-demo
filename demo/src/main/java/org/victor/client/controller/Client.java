package org.victor.client.controller;

public class Client {
	
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
	
	

}
