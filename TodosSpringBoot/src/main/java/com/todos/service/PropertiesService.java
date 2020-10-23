package com.todos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.todos.dao.PropertiesRepository;
import com.todos.model.Property;

@Service
@Transactional
public class PropertiesService {

	private final PropertiesRepository propertiesRepository;

	public PropertiesService(PropertiesRepository propertiesRepository) {
		this.propertiesRepository = propertiesRepository;
	}

	public List<Property> findAll() {
		List<Property> properties = new ArrayList<>();
		for (Property property : propertiesRepository.findAll()) {
			properties.add(property);
		}
		return properties;
	}

	public void save(Property property) {
		propertiesRepository.save(property);
	}

	public void delete(int id) {
		Optional<Property> property = propertiesRepository.findById(id);
		propertiesRepository.delete(property.get());
	}
	public Optional<Property> findProperty(int id) {
		return propertiesRepository.findById(id);
	}
	
}

