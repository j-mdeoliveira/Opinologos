package com.accenture.opinologos2.opinologos2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accenture.opinologos2.opinologos2.model.Opinion;
import com.accenture.opinologos2.opinologos2.model.User;
import com.accenture.opinologos2.opinologos2.repository.OpinionRepository;
import com.accenture.opinologos2.opinologos2.repository.UserRepository;
import com.accenture.opinologos2.opinologos2.service.OpinionService;
import com.accenture.opinologos2.opinologos2.service.UserService;

@Controller
public class OpinionesController {
	
	
	@Autowired 
	UserService userService;
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OpinionService opService;
	
	
	@GetMapping("/opiniones")
	public String getOpiniones(Model model) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		
		User user = getLoggedUser();
		model.addAttribute("userLogueado",user);
		
		System.out.println(user.getName()+" "+user.getOpiniones());
		return "opiniones";
		
	}
	
	@GetMapping("/edicionopinion")
	public String getEdicion() {
		
		return "edicionopinion";
	}
	
	@PostMapping("/edicionopinion")
	public String editarOpiniones (Model model, @RequestBody Long id) {
				
		return "";
	} 
	
	
	
	public User getLoggedUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		if(currentPrincipalName != null) {
			return userService.findByNick(currentPrincipalName);
		}
		return null;
	}
}
