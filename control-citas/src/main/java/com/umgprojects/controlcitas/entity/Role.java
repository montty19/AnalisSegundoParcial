package com.umgprojects.controlcitas.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ROLES")
public class Role implements Serializable {
	
	private static final long serialVersionUID = 4920742223987060955L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "DESCRIPCION")
	private String descripcion;
	@OneToMany(mappedBy = "listRole", cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Trabajador> trabajador = new HashSet<>();
	
	public Role() {}
	
	public Role(Integer id, String descripcion, Set<Trabajador> trabajador) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.trabajador = trabajador;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Trabajador> getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(Set<Trabajador> trabajador) {
		this.trabajador = trabajador;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((trabajador == null) ? 0 : trabajador.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (trabajador == null) {
			if (other.trabajador != null)
				return false;
		} else if (!trabajador.equals(other.trabajador))
			return false;
		return true;
	}

}
