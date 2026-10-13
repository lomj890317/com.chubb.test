package com.chubb.test.model.dtos;

import lombok.Data;

@Data
public class ClientDto {
	int id;
	String firstName;
	String lastName;
	String surname;
	String phone;
	

	 public ClientDto(int id, String firstName, String lastName, String surname, String phone){
		super();
		this.id = id; 
		this.firstName = firstName; 
		this.lastName = lastName; 
		this.surname = surname; 
		this.phone = phone;
	 }
}
