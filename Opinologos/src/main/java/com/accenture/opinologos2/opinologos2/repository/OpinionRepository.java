package com.accenture.opinologos2.opinologos2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.opinologos2.opinologos2.model.Opinion;

public interface OpinionRepository extends JpaRepository<Opinion, Long> {

	Opinion findByTitulo(String titulo);

}
