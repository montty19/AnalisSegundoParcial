package com.umgprojects.controlcitas.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "CITA")
public class Cita implements Serializable {

	private static final long serialVersionUID = 2535835855602087175L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "FECHA")
	private Date fecha;
	@Column(name = "DESCRIPCION")
	private String descripcion;
	@Column(name = "HORA")
	private Timestamp hora;
	@ManyToOne
	@JoinColumn(name = "IDPACIENTE", referencedColumnName = "ID")
	private Paciente listaPaciente;
	@ManyToOne
	@JoinColumn(name = "IDTRABAJADOR", referencedColumnName = "ID")
	private Trabajador listaTrabajador;
	@Column(name = "CREATEBY")
	private String createdBy;
	@Column(name = "CREATEDATE")
	private Date createDate;
	
	@OneToMany(mappedBy = "listaCita", cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	@JsonIgnore
	Set<DetalleCita> detalleCita = new HashSet<>();
	
	public Cita() {}

	public Cita(Integer id, Date fecha, String descripcion, Timestamp hora, Paciente listaPaciente,
			Trabajador listaTrabajador, String createdBy, Date createDate, Set<DetalleCita> detalleCita) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.hora = hora;
		this.listaPaciente = listaPaciente;
		this.listaTrabajador = listaTrabajador;
		this.createdBy = createdBy;
		this.createDate = createDate;
		this.detalleCita = detalleCita;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Timestamp getHora() {
		return hora;
	}

	public void setHora(Timestamp hora) {
		this.hora = hora;
	}

	public Paciente getListaPaciente() {
		return listaPaciente;
	}

	public void setListaPaciente(Paciente listaPaciente) {
		this.listaPaciente = listaPaciente;
	}

	public Trabajador getListaTrabajador() {
		return listaTrabajador;
	}

	public void setListaTrabajador(Trabajador listaTrabajador) {
		this.listaTrabajador = listaTrabajador;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Set<DetalleCita> getDetalleCita() {
		return detalleCita;
	}

	public void setDetalleCita(Set<DetalleCita> detalleCita) {
		this.detalleCita = detalleCita;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((detalleCita == null) ? 0 : detalleCita.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((hora == null) ? 0 : hora.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((listaPaciente == null) ? 0 : listaPaciente.hashCode());
		result = prime * result + ((listaTrabajador == null) ? 0 : listaTrabajador.hashCode());
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
		Cita other = (Cita) obj;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (detalleCita == null) {
			if (other.detalleCita != null)
				return false;
		} else if (!detalleCita.equals(other.detalleCita))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (hora == null) {
			if (other.hora != null)
				return false;
		} else if (!hora.equals(other.hora))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (listaPaciente == null) {
			if (other.listaPaciente != null)
				return false;
		} else if (!listaPaciente.equals(other.listaPaciente))
			return false;
		if (listaTrabajador == null) {
			if (other.listaTrabajador != null)
				return false;
		} else if (!listaTrabajador.equals(other.listaTrabajador))
			return false;
		return true;
	}
	
	

}
