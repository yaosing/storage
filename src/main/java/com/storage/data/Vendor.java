package com.storage.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "vendor")
public class Vendor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String sku;
	private String name;
	private String address;
	private String phoneNumber;
	private String comment;
	private String saler;
	private String salerLink;

	public Vendor(String sku, String name, String address, String phoneNumber, String comment, String saler,
			String salerLink) {
		this.sku = sku;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.comment = comment;
		this.saler = saler;
		this.salerLink = salerLink;
	}

	public String getSaler() {
		return saler;
	}

	public void setSaler(String saler) {
		this.saler = saler;
	}

	public String getSalerLink() {
		return salerLink;
	}

	public void setSalerLink(String salerLink) {
		this.salerLink = salerLink;
	}

	public Long getId() {
		return id;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
