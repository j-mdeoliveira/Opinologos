package com.accenture.opinologos2.opinologos2.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.accenture.opinologos2.opinologos2.model.User;
import com.accenture.opinologos2.opinologos2.service.RolService;
import com.accenture.opinologos2.opinologos2.service.UserService;


@Controller
@RequestMapping("/protected")
@PreAuthorize("hasAuthority('ADMINISTRADOR')||hasAuthority('MODERADOR')")
public class UsersController {

	@Autowired
	private UserService userService;
	@Autowired
	private RolService rolService;
	
	@GetMapping("/users")
	public String usuarios(Model model, String error) {
		User user = userService.getLoggedUser();
		if (user!=null) {
			boolean log = true;
	 		model.addAttribute("logueado", log);
			model.addAttribute("usuarioLogueado",user);
			Boolean isAdmin = user.getRoles().contains(rolService.findByRole("ADMINISTRADOR"));
			model.addAttribute("adminValidator",isAdmin);
			}
		List<User> usuarios = userService.findAll();
		model.addAttribute("todos",usuarios);
		return "usuarios";
	}
	
	@PostMapping("/busqueda")
	public String busquedaUsuarios(Model model, @RequestParam String busqueda, @RequestParam String searchby){
		
		List<User> todos = new ArrayList<User>();
		
		if (busqueda != null) {
			switch(searchby)
			{
			case "nombre":				
				model.addAttribute("todos",userService.findByName(busqueda));
				break;
			case "mail":				
				todos.add(userService.findByMail(busqueda));
				model.addAttribute("todos",todos);
				break;
			case "nick":
				todos.add(userService.findByNick(busqueda));
				model.addAttribute("todos",todos);
				break;
			}
		}
		
		return "usuarios";
	}
	
	@GetMapping("/controlUsuario/nick/{username}")
	public String controlUsuarios(@PathVariable final String username) {
		System.out.println(1);
		System.out.println(username);
		return "usuarios";
	}
			
}
