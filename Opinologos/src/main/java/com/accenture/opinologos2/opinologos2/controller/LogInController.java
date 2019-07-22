package com.accenture.opinologos2.opinologos2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.accenture.opinologos2.opinologos2.repository.UserRepository;

@Controller
public class LogInController {

	@Autowired
	UserRepository userRepository;

	@GetMapping("/login")
	public String loginPage(Model model, String error, String logout) {
		if (logout != null) {
			return "hello";
		}

		if (error != null) {
			boolean err = true;
			String msg = "Usuario o contraseña incorrectos";
			model.addAttribute("noLog", msg);
			model.addAttribute("error", err);
			System.out.println("Usuario o contraseña incorrectos"); // MOSTRAR ERROR AL USUARIO
		}

		return "login";// IR A PANTALLA DE LOGIN.JSP
	}

}
