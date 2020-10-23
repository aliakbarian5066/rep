package com.todos.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.todos.types.PhoneType;

@Embeddable
public class Phone {
	
	@Column(name="number")
	private String number;	
	
	@Column(name="type")
	private PhoneType type;
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public PhoneType getType() {
		return type;
	}
	public void setType(PhoneType type) {
		this.type = type;
	}
	public Phone(String number, PhoneType type) {
		
		this.number = number;
		this.type = type;
	}
	
}
