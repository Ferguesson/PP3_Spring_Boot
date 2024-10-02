package com.ferguesson.spring_boot.controller;

import com.ferguesson.spring_boot.model.User;
import com.ferguesson.spring_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		model.addAttribute("messages", List.of("Hello!", "I'm User Controller!"));
		model.addAttribute("users", userService.getAllUsers());
		return "index";
	}

	@PostMapping("/addUser")
	public String addUser(User user) {
		userService.saveUser(user);
		return "redirect:/";
	}

	@PostMapping("/deleteUser")
	public String deleteUser(Long userId) {
		userService.removeUserById(userId);
		return "redirect:/";
	}

	@PostMapping("/updateUser")
	public String updateUser(User user) {
		userService.updateUser(user);
		return "redirect:/";
	}

	@PostMapping("/clearUsers")
	public String clearUsers() {
		userService.cleanUsersTable();
		return "redirect:/";
	}
	
}