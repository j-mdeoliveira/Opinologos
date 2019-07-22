package com.accenture.opinologos2.opinologos2.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.accenture.opinologos2.opinologos2.model.Opinion;
import com.accenture.opinologos2.opinologos2.model.Reacciones;
import com.accenture.opinologos2.opinologos2.model.User;
import com.accenture.opinologos2.opinologos2.repository.OpinionRepository;
import com.accenture.opinologos2.opinologos2.repository.ReaccionRepository;

import com.accenture.opinologos2.opinologos2.service.UserService;

@Controller
public class OpinionesController {

	@Autowired
	UserService userService;

	@Autowired
	private OpinionRepository oRepo;

	@Autowired
	private ReaccionRepository rRepo;

	@GetMapping("/opinar")
	public String opinPage() {
		return "opinar";
	}

	@PostMapping("/opinar")
	public String opinionPage(Model model, @RequestParam String titulo, @RequestParam String detalle) {
		System.out.println(titulo + " " + detalle);
		Date fechaActual = new Date();
		Opinion opinion = new Opinion();
		User user = new User();
		user = userService.getLoggedUser();
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

		User user = userService.getLoggedUser();
		Float puntuacion;
		user.getOpiniones();
		if (user != null) {
			boolean log = true;
			model.addAttribute("logueado", log);
			model.addAttribute("userLogueado", user);
			System.out.println(user.getName() + " " + user.getOpiniones());

			for (Opinion op : user.getOpiniones()) {
				puntuacion = this.getPuntuacion(op.getPuntuaciones());
				if (!puntuacion.isNaN()) {
					op.setReacciones(puntuacion);
				}
				System.out.println(puntuacion);
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
	public String editarOpiniones(Model model, @RequestBody Long id) {

		return "";
	}

	@PostMapping("/puntuar")
	public String homePost(Model model, @RequestParam("idOpinion") Long idOpinion, @RequestParam("rating") int rating) {
		User user = userService.getLoggedUser();
		Opinion opinion = oRepo.findById(idOpinion).get();
		Reacciones reaccion = new Reacciones(rating);
		if (user != null) {
			boolean log = true;
			model.addAttribute("logueado", log);
			model.addAttribute("usuarioLogueado", user);
			reaccion.setOpinion(opinion);
			rRepo.save(reaccion);
			opinion.addPuntuacion(reaccion);
			System.out.println(opinion.getPuntuaciones());
		}

		return "redirect:/home";
	}

	private Float getPuntuacion(List<Reacciones> puntuaciones) {
		Float porce;
		Float base = 0f;

		for (Reacciones puntuacion : puntuaciones) {
			base += puntuacion.getReacciones();
		}

		porce = base / puntuaciones.size();

		return porce;
	}

}
