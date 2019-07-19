package com.accenture.opinologos2.opinologos2.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.accenture.opinologos2.opinologos2.model.User;
import com.accenture.opinologos2.opinologos2.service.UserService;


@Controller
public class UsersController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/protected/users")
	@PreAuthorize("hasAuthority('ADMINISTRADOR')")
	public String usuarios(Model model, String error) {
		System.out.println(error);
		if (error!=null) {
			return "you should not be here";
		}
		List<User> usuarios = userService.findAll();
		model.addAttribute("todos",usuarios);
		return "usuarios";
	}
	
}
