package com.todos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.todos.dao.UsersRepository;
import com.todos.model.User;

@Service
@Transactional
public class UsersService {

	private final UsersRepository usersRepository;

	public UsersService(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	public List<User> findAll() {
		List<User> users = new ArrayList<>();
		for (User user : usersRepository.findAll()) {
			users.add(user);
		}
		return users;
	}

	public void save(User user) {
		usersRepository.save(user);
	}

	public void delete(int id) {
		Optional<User> user = usersRepository.findById(id);
		usersRepository.delete(user.get());
	}
	public Optional<User> findUser(int id) {
		return usersRepository.findById(id);
	}

}
