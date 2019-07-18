package com.accenture.opinologos2.opinologos2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.opinologos2.opinologos2.model.Opinion;
import com.accenture.opinologos2.opinologos2.model.Rol;
import com.accenture.opinologos2.opinologos2.repository.OpinionRepository;

@Service
public class OpinionService {
	
	@Autowired
	private OpinionRepository repo;
	
	public List<Opinion> findAll() {
		return repo.findAll();
	}
	
	public Opinion save (Opinion opinion) {
		return repo.save(opinion);
	}
	
	public Opinion findById(Long id) {
		return repo.findById(id).get();
	}
	
	public Opinion findByTitulo (String titulo) {
		return repo.findByTitulo(titulo);
	}

}
