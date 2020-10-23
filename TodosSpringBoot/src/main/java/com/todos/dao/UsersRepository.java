package com.todos.dao;

import org.springframework.data.repository.CrudRepository;

import com.todos.model.User;
public interface UsersRepository extends CrudRepository<User,Integer>{

}
