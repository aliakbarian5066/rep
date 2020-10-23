package com.todos.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.todos.model.Property;
import com.todos.model.User;
import com.todos.service.PropertiesService;
import com.todos.service.UsersService;

@Controller
public class PropertiesController {
	
	@Autowired
	private PropertiesService propertiesService;
	@Autowired
	private UsersService usersService;
	
	@GetMapping("/")
	public String home(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "index";
	}
	
	@GetMapping("/all-properties")
	public String allProperties(HttpServletRequest request) {
		request.setAttribute("properties", propertiesService.findAll());
		request.setAttribute("mode", "MODE_PROPERTIES");
		return "index";
	}
	
	@GetMapping("/new-property")
	public String newProperty(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_NEW");
		return "index";
	}
	@PostMapping("/save-property")
	public String saveProperty(@ModelAttribute Property property, BindingResult bindingResult, HttpServletRequest request) {
	//	todo.setDateCreated(new Date());
		propertiesService.save(property);
		request.setAttribute("properties", propertiesService.findAll());
		request.setAttribute("mode", "MODE_PROPERTIES");
		return "index";
	}
	
	@GetMapping("/update-property")
	public String updateProperty(@RequestParam int id, HttpServletRequest request) {
		request.setAttribute("property", propertiesService.findProperty(id).get());
		request.setAttribute("mode", "MODE_UPDATE");
		return "index";
	}
	
	@GetMapping("/delete-property")
	public String deleteProperty(@RequestParam int id, HttpServletRequest request) {
		propertiesService.delete(id);
		request.setAttribute("properties", propertiesService.findAll());
		request.setAttribute("mode", "MODE_PROPERTIES");
		return "index";
	}
	@GetMapping("/all-users")
	public String allUsers(HttpServletRequest request) {
		request.setAttribute("users", usersService.findAll());
		request.setAttribute("mode", "MODE_USERS");
		return "index";
	}
	
	@GetMapping("/new-user")
	public String newUser(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_NEW");
		return "index";
	}
	@PostMapping("/save-user")
	public String saveUser(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request) {
	//	todo.setDateCreated(new Date());
		int property_id = Integer.parseInt(request.getParameter("property_id"));
		user.setProperty(propertiesService.findProperty(property_id).get());
		usersService.save(user);
		request.setAttribute("users", usersService.findAll());
		request.setAttribute("mode", "MODE_USERS");
		return "index";
	}
	
	@GetMapping("/update-user")
	public String updateUser(@RequestParam int id, HttpServletRequest request) {
		request.setAttribute("user", usersService.findUser(id).get());
		request.setAttribute("mode", "MODE_UPDATE");
		return "index";
	}
	
	@GetMapping("/delete-user")
	public String deleteUser(@RequestParam int id, HttpServletRequest request) {
		usersService.delete(id);
		request.setAttribute("users", usersService.findAll());
		request.setAttribute("mode", "MODE_USERS");
		return "index";
	}
}

