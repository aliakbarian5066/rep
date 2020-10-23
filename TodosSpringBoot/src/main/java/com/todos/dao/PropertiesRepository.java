package com.todos.dao;

import org.springframework.data.repository.CrudRepository;

import com.todos.model.Property;
public interface PropertiesRepository extends CrudRepository<Property,Integer>{

}
