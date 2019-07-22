package com.accenture.opinologos2.opinologos2.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Opinion {
	
	
	@Id
	@GeneratedValue
	private Long id;
	private String titulo;
	private String detalle;
	private String imagen;
	private Float reacciones;
	@OneToMany(cascade = CascadeType.ALL,
			   mappedBy = "opinion")
	private List<Reacciones> puntuaciones;
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

	public Float getReacciones() {
		return reacciones;
	}

	public void setReacciones(Float reacciones) {
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
	
	
	public List<Reacciones> getPuntuaciones() {
		return puntuaciones;
	}

	public void addPuntuacion(Reacciones reaccion) {
		this.puntuaciones.add(reaccion);
	}
	
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Override
	public String toString() {
		return "Opinion [puntuaciones=" + puntuaciones + "]";
	}

	
}
