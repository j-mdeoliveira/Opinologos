package com.accenture.opinologos2.opinologos2.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@Autowired
	private OpinionRepository oRepo;

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
	
	@GetMapping("/opiniones")
	public String getOpiniones(Model model) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		User user = getLoggedUser();
		Float puntuacion;
		
		if(user!=null) {
			boolean log = true;
			model.addAttribute("logueado", log);
			model.addAttribute("userLogueado",user);
			System.out.println(user.getName()+" "+user.getOpiniones());
			for (Opinion op : user.getOpiniones()) {
				puntuacion = this.getPuntuacion(op.getPuntuaciones());
				model.addAttribute("puntuacion", puntuacion);
			}
			
			return "opiniones";

		} else {
			return "redirect:/login";
		}
		
	}
	
	@GetMapping("/edicionopinion")
	public String getEdicion() {
		
		return "edicionopinion";
	}
	
	@PostMapping("/edicionopinion")
	public String editarOpiniones (Model model, @RequestBody Long id) {
				
		return "";
	} 
	
	@PostMapping("/puntuar")
	public String homePost(Model model, @RequestParam("idOpinion") Long idOpinion, @RequestParam("rating") Integer rating) {
		User user = getLoggedUser();
		List<Opinion> opiniones = oRepo.findAll();
		Opinion opinion = oRepo.findById(idOpinion).get();
		 
		//TODO agregarle la puntuacion a la opinion
		if(user != null) {	
			boolean log = true;
			model.addAttribute("logueado", log);
			model.addAttribute("usuarioLogueado",user);
			//Boolean isAdmin = user.getRoles().contains(rolRepository.findByRole("ADMINISTRADOR"));
			//model.addAttribute("adminValidator",isAdmin);
			System.out.println(opinion.getTitulo());
			opinion.setPuntuaciones(rating);
			
		}
		model.addAttribute("todaVaina", opiniones);
		
		return "home";
	}
	
	private Float getPuntuacion(List<Float> puntuaciones) {
		Float porce;
		Float base = 0f;
		
		for (Float puntuacion : puntuaciones) {
			base += puntuacion;
		}
		
		porce = base/puntuaciones.size();
		
		return porce;
		
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
