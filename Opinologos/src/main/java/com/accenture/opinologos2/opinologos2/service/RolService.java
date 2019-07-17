package com.accenture.opinologos2.opinologos2.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.opinologos2.opinologos2.model.Rol;
import com.accenture.opinologos2.opinologos2.repository.RolRepository;

@Service
public class RolService {

	public enum TipoRol{
		SOCIO, MODERADOR, ADMINISTRADOR;
		
		private Rol rol;
		
		public Rol getRol() {
			return rol;
		}
		
		public void setRol(Rol rol) {
			this.rol=rol;
		}
	}
	
	@PostConstruct
	private void loadRoles() {
		for(TipoRol tipoRol : TipoRol.values()) {
			if(tipoRol.getRol()==null) {
				Rol rol = findByRole(tipoRol.name());
				if(rol == null) {
					rol = new Rol();
					rol.setRole(tipoRol.name());
					rol = save(rol);
				}
				tipoRol.setRol(rol);
			}
		}
	}
	
	@Autowired
	private RolRepository rolDAO;
	
	public Rol findById(Long id) {
		return rolDAO.findById(id).get();
	}
	
	public List<Rol> findAll() {
		return rolDAO.findAll();
	}
	
	public Rol save(Rol rol) {
		return rolDAO.save(rol);
	}
	
	public Rol findByRole(String role) {
		return rolDAO.findByRole(role);
	}	
}
