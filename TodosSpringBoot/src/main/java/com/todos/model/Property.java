package com.todos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
/**
 * 
 *
 */
@Entity
@Table(name = "property")
public class Property implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="property_id")
    private int id;
    
    @Column(name="postcode")
	private String postcode;
	
	@Column(name="house_name_number")
	private String house_name_number;
	
//  @Embedded
//  @Column(name="address")
//  private Address address;
  
//	@OneToMany
//	@OrderColumn(name = "property_owner_id") 
	
	
	
	
	//private User[] users;
//    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<User> users = new ArrayList<>();
//     
//     
//    public Property addUser(User user) {
//        users.add(user);
//        user.setProperty(this);
//        return this;
//    }


//	public Property(int id, String postcode, String house_name_number, List<User> users) {
//		super();
//		this.id = id;
//		this.postcode = postcode;
//		this.house_name_number = house_name_number;
//		this.users = users;
//	}


	public Property() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Property(int id, String postcode, String house_name_number) {
		super();
		this.id = id;
		this.postcode = postcode;
		this.house_name_number = house_name_number;
}

//	public List<User> getUsers() {
//		return users;
//	}
//
//
//	public void setUsers(List<User> users) {
//		this.users = users;
//	}


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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	




//	public Address getAddress() {
//		return address;
//	}
//	
//	public void setAddress(Address address) {
//		this.address = address;
//	}

   
}