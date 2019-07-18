package com.accenture.opinologos2.opinologos2.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.transaction.Transactional;

@Entity
public class User {

	@Id

	@GeneratedValue
	private Long id;
	private String name;
	private String userName;
	private String mail;
	@Column(name = "password", nullable = false)
	private String password;
	
//	@Transactional
//	private int vecesPuntuadas;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Rol> roles;

	@Transient
	private List<String> rol;

	public User() {
	}

	public User(String nombre, String userName, String mail, String password) {
		super();
		this.name = nombre;
		this.userName = userName;
		this.mail = mail;
		this.password = password;
		this.roles = new HashSet<Rol>();
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Opinion> opiniones;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String nombre) {
		this.name = nombre;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Opinion> getOpiniones() {
		return opiniones;
	}

	public void setOpiniones(List<Opinion> opiniones) {
		this.opiniones = opiniones;
	}

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}

}
