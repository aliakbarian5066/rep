package com.todos.model;

import java.io.Serializable;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;





@Entity
//@Inheritance(strategy=InheritanceType.JOINED)  

public class User implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name="user_id")
	private int id;	
	
//	@Column(name="firstName")
	private String firstName;
	
//	@Column(name="lastName")
	private String lastName;
	
//	@Column(name="phone")
	private int phone;
	
//	@Column(name="main_owner")
	private boolean main_owner;
	
	@ManyToOne
	@JoinColumn(name="property_id",foreignKey=@ForeignKey(name="property_id_fk"))    
    private Property property;
	

	public User(int id, String firstName, String lastName, int phone, boolean main_owner, Property property) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.main_owner = main_owner;
		this.property = property;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public boolean isMain_owner() {
		return main_owner;
	}
	public void setMain_owner(boolean main_owner) {
		this.main_owner = main_owner;
	}
	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName +  ", phone=" + phone + "]";
	}


	
}
