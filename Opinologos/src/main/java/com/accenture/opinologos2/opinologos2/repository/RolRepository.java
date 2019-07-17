package com.accenture.opinologos2.opinologos2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accenture.opinologos2.opinologos2.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
	
	public Rol findByRole(String role);
}
