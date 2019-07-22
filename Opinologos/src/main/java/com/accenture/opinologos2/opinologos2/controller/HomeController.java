package com.accenture.opinologos2.opinologos2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.accenture.opinologos2.opinologos2.model.Opinion;
import com.accenture.opinologos2.opinologos2.model.User;
import com.accenture.opinologos2.opinologos2.repository.OpinionRepository;
import com.accenture.opinologos2.opinologos2.repository.RolRepository;
import com.accenture.opinologos2.opinologos2.repository.UserRepository;
import com.accenture.opinologos2.opinologos2.service.UserService;

@Controller
public class HomeController {

	@Autowired
	OpinionRepository oRepo;

	@Autowired
	RolRepository rolRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserService userService;

	@GetMapping({ "/home", "/" })
	public String homePage(Model model) {
		User user = userService.getLoggedUser();
		List<Opinion> opiniones = oRepo.findAll();

		if (user != null) {
			boolean log = true;
			model.addAttribute("logueado", log);
			model.addAttribute("usuarioLogueado", user);
			System.out.println(user.getOpiniones());
		}
		model.addAttribute("todaVaina", opiniones);

		return "home";
	}

}
