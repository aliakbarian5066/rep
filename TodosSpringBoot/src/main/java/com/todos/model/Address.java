package com.todos.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class Address {
	
	@Column(name="postcode")
	private String postcode;
	
	@Column(name="house_name_number")
	private String house_name_number;
	
	public String getHouse_name_number() {
		return house_name_number;
	}
	public void setHouse_name_number(String house_name_number) {
		this.house_name_number = house_name_number;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public Address(String postcode, String house_name_number) {
		this.postcode = postcode;
		this.house_name_number = house_name_number;
	}

}
