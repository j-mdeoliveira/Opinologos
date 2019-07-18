package com.accenture.opinologos2.opinologos2.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Opinion {
	@Id
	@GeneratedValue
	private Long id;
	private String titulo;
	private String detalle;
	private String imagen;
	private Long reacciones;
	
	private Boolean blockeada;
	private Date fechaCreacion;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_user")
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Long getReacciones() {
		return reacciones;
	}

	public void setReacciones(Long reacciones) {
		this.reacciones = reacciones;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	public Boolean getBlockeada() {
		return blockeada;
	}

	public void setBlockeada(Boolean blockeada) {
		this.blockeada = blockeada;
	}
	
	
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Override
	public String toString() {
		return "Opinion [id=" + id + ", titulo=" + titulo + ", detalle=" + detalle + ", imagen=" + imagen
				+ ", reacciones=" + reacciones + "]";
	}
	
	

}
