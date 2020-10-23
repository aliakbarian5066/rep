package com.todos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;




//@Entity
//@Table(name = "owner")
//@PrimaryKeyJoinColumn(name="user_id")  
public class Owner extends User{
	
	//@Column(name="main_owner")
	private boolean main_owner;
	public boolean isMain_owner() {
		return main_owner;
	}

	public void setMain_owner(boolean main_owner) {
		this.main_owner = main_owner;
	}
}
