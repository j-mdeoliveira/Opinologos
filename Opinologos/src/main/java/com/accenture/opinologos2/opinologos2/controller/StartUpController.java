package com.accenture.opinologos2.opinologos2.controller;

import java.util.Arrays;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.accenture.opinologos2.opinologos2.model.Rol;
import com.accenture.opinologos2.opinologos2.model.User;
import com.accenture.opinologos2.opinologos2.service.RolService;
import com.accenture.opinologos2.opinologos2.service.RolService.TipoRol;
import com.accenture.opinologos2.opinologos2.service.UserService;

@Component
public class StartUpController implements InitializingBean {

	public final static String ADMIN_USER_NAME= "admin";
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RolService rolService;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		loadRoles();
		crearAdmin();
	}
	
	private void loadRoles() {
		for(TipoRol tipoRol : TipoRol.values()) {
			if(tipoRol.getRol()==null) {
				Rol rol = rolService.findByRole(tipoRol.name());
				if(rol == null) {
					rol = new Rol();
					rol.setRole(tipoRol.name());
					rol = rolService.save(rol);
				}
				tipoRol.setRol(rol);
			}
		}
	}
	
	private void crearAdmin() {
		User admin = userService.findByNick(ADMIN_USER_NAME);
		if(admin == null) {
			admin = new User(ADMIN_USER_NAME, ADMIN_USER_NAME, ADMIN_USER_NAME, ADMIN_USER_NAME);
			admin.getRoles().addAll(
					Arrays.asList(
							TipoRol.ADMINISTRADOR.getRol(),
							TipoRol.MODERADOR.getRol(),
							TipoRol.SOCIO.getRol()
							)
					);
			userService.saveAndEncrypt(admin);
			System.out.println("Se creo el usuario admin!");
		}
	}

}