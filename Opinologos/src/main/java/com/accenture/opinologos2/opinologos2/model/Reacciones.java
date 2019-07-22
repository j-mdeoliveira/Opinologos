package com.accenture.opinologos2.opinologos2.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Reacciones {
	private int reacciones;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "opinion_id")
	private Opinion opinion;

	
	public Reacciones() {
		super();
	}

	public int getReacciones() {
		return reacciones;
	}

	public void setReacciones(int reacciones) {
		this.reacciones = reacciones;
	}

	public Reacciones(int reacciones) {
		super();
		this.reacciones = reacciones;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Opinion getOpinion() {
		return opinion;
	}

	public void setOpinion(Opinion opinion) {
		this.opinion = opinion;
	}

	@Override
	public String toString() {
		return "Reacciones [reacciones=" + reacciones + "]";
	}
	
	
}
