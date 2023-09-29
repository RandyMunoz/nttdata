package com.randylab.nttdata.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class ClientTO {

	private Long id;
	@Pattern(regexp = "^(C|P)$", message = "Only you can insert C and P")
	private String documentType;
	@NotNull(message = "document number cannot be null")
	private Integer documentNumber;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	private String city;

	public ClientTO(Long id, String documentType, Integer documentNumber, String firstName, String lastName,
			String phone, String address, String city) {
		super();
		this.id = id;
		this.documentType = documentType;
		this.documentNumber = documentNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
		this.city = city;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public Integer getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(Integer documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
