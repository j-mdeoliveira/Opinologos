package com.accenture.opinologos2.opinologos2.controller;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import com.accenture.opinologos2.opinologos2.repository.OpinionRepository;
import com.accenture.opinologos2.opinologos2.repository.RolRepository;
import com.accenture.opinologos2.opinologos2.repository.UserRepository;
import com.accenture.opinologos2.opinologos2.service.UserService;
import com.accenture.opinologos2.opinologos2.service.OpinionService;
import com.accenture.opinologos2.opinologos2.service.RolService.TipoRol;
import com.accenture.opinologos2.opinologos2.model.Opinion;
import com.accenture.opinologos2.opinologos2.model.Rol;
import com.accenture.opinologos2.opinologos2.model.User;

@Controller
public class SignUpController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RolRepository rolRepository;

	@Autowired
	private UserService usuarioService;
	
	@Autowired
	private OpinionService OpinionService;

	@Autowired
	private BCryptPasswordEncoder passEncoder;

	@Autowired
	private OpinionRepository oRepo;
	
	@GetMapping("/login")
	public String loginPage(Model model, String error, String logout) {
		if (logout != null) {
			return "hello";
		}

		if (error != null) {
			System.out.println("Usuario o contraseña incorrectos"); // MOSTRAR ERROR AL USUARIO
		}
		return "login";// IR A PANTALLA DE LOGIN.JSP
	}

	@GetMapping("/signup")
	public String signUpPage(WebRequest request, Model model) {
		model.addAttribute("roles",rolRepository.findAll());
		for (Rol rol : rolRepository.findAll()) {
			System.out.println(rol.getRole());
		}

		return "signup";
	}

	@PostMapping("/signup")
	public String signUpSubmit(@RequestParam String name, @RequestParam String userName, @RequestParam String mail,
			@RequestParam String password, @RequestParam String passAgain, Model userModel) {
		Boolean passwordNull = false;
		if (password == null || password.trim().isEmpty()) {
			passwordNull = true;
		}

		Boolean noIguales = false;
		Boolean nickIguales = false;
		Boolean mailIguales = false;

		User userNick = userRepository.findByUserNameIgnoreCase(userName);
		User userMail = userRepository.findByMail(mail);

		User userP;
		
		if (password.equals(passAgain)) {

			if (userNick == null) {

				if (userMail == null) {
					String encryptPass = passEncoder.encode(password);
					userP = new User(name, userName, mail, encryptPass);
					userP.getRoles().add(TipoRol.SOCIO.getRol());
				
					usuarioService.save(userP);

				} else {
					mailIguales = true;
					userModel.addAttribute("mailIguales", mailIguales);
					return "signup";
				}

			} else {
				nickIguales = true;
				userModel.addAttribute("nickIguales", nickIguales);
				return "signup";
			}

		} else {
			System.out.println("Las contraseñas tienen que ser iguales");
			noIguales = true;
			userModel.addAttribute("noIguales", noIguales);
			return "signup";
		}
		
		return "redirect:/login";
	}

	@GetMapping({ "/hello", "/" })
	public String helloPage(WebRequest request, Model model) {
		User user = getLoggedUser();


		if(user != null) {
			boolean log = true;
			model.addAttribute("usuarioLogueado", getLoggedUser());
			model.addAttribute("logueado", log);
		} else {
			boolean log = false;
			model.addAttribute("logueado", log);
		}
		return "hello";
	}
	
	@GetMapping("/home")
	public String homePage(Model model) {
		User user = getLoggedUser();
		List<Opinion> opiniones = oRepo.findAll();
		
		if(user != null) {	
			boolean log = true;
			model.addAttribute("logueado", log);
			model.addAttribute("usuarioLogueado",user);
			Boolean isAdmin = user.getRoles().contains(rolRepository.findByRole("ADMINISTRADOR"));
			model.addAttribute("adminValidator",isAdmin);
			
		}
		model.addAttribute("todaVaina", opiniones);
		
		return "home";
	}
	
	@GetMapping("/opinar")
	public String opinPage() {
		return "opinar";
	}
	
	@PostMapping("/opinar")
	public String opinionPage(Model model, @RequestParam String titulo, @RequestParam String detalle){
		System.out.println(titulo +" "+ detalle);
		Date fechaActual = new Date();
		Opinion opinion = new Opinion();
		User user = new User();
		user = getLoggedUser();
		System.out.println(user);
		
		if (user != null) {
			opinion.setTitulo(titulo);
		opinion.setDetalle(detalle);
		opinion.setUser(user);
		opinion.setBlockeada(false);
		opinion.setFechaCreacion(fechaActual);
		oRepo.save(opinion);
		return "redirect:/home";
		} else {
			return "error";
		}
		
		
	}
	
//	@GetMapping("/logout")
//	public String logout() {
//		return "redirect:/hello";
//	}
//	
	public User getLoggedUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		if(currentPrincipalName != null) {
			return userRepository.findByUserNameIgnoreCase(currentPrincipalName);
		}
		return null;
	}
}