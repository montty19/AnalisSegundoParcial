package com.umgprojects.controlcitas.entity;

import java.io.Serializable;

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

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PACIENTE")
public class Paciente implements Serializable  {

	private static final long serialVersionUID = 5383471278181352830L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "DPI")
	private String dpi;
	@Column(name = "PASS")
	private String pass;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "APELLIDO")
	private String apellido;
	@Column(name = "GENERO")
	private String genero;
	@Column(name = "FEC_NACIMIENTO")
	private Date fecNacimiento;
	@Column(name = "DIRECCION")
	private String direccion;
	@Column(name = "TIPO_SANGRE")
	private String tipoSangre;
	@Column(name = "NUM_SERGURO_MED")
	private String numSeguroMed;
	@OneToMany(mappedBy = "listaPaciente", cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Cita> cita = new HashSet<>();
	
	public Paciente() {}
	
	public Paciente(Integer id, String dpi, String pass, String nombre, String apellido, String genero,
			Date fecNacimiento, String direccion, String tipoSangre, String numSeguroMed, Set<Cita> cita) {
		super();
		this.id = id;
		this.dpi = dpi;
		this.pass = pass;
		this.nombre = nombre;
		this.apellido = apellido;
		this.genero = genero;
		this.fecNacimiento = fecNacimiento;
		this.direccion = direccion;
		this.tipoSangre = tipoSangre;
		this.numSeguroMed = numSeguroMed;
		this.cita = cita;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDpi() {
		return dpi;
	}

	public void setDpi(String dpi) {
		this.dpi = dpi;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Date getFecNacimiento() {
		return fecNacimiento;
	}

	public void setFecNacimiento(Date fecNacimiento) {
		this.fecNacimiento = fecNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTipoSangre() {
		return tipoSangre;
	}

	public void setTipoSangre(String tipoSangre) {
		this.tipoSangre = tipoSangre;
	}

	public String getNumSeguroMed() {
		return numSeguroMed;
	}

	public void setNumSeguroMed(String numSeguroMed) {
		this.numSeguroMed = numSeguroMed;
	}

	public Set<Cita> getCita() {
		return cita;
	}

	public void setCita(Set<Cita> cita) {
		this.cita = cita;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((cita == null) ? 0 : cita.hashCode());
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((dpi == null) ? 0 : dpi.hashCode());
		result = prime * result + ((fecNacimiento == null) ? 0 : fecNacimiento.hashCode());
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((numSeguroMed == null) ? 0 : numSeguroMed.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + ((tipoSangre == null) ? 0 : tipoSangre.hashCode());
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
		Paciente other = (Paciente) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (cita == null) {
			if (other.cita != null)
				return false;
		} else if (!cita.equals(other.cita))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (dpi == null) {
			if (other.dpi != null)
				return false;
		} else if (!dpi.equals(other.dpi))
			return false;
		if (fecNacimiento == null) {
			if (other.fecNacimiento != null)
				return false;
		} else if (!fecNacimiento.equals(other.fecNacimiento))
			return false;
		if (genero == null) {
			if (other.genero != null)
				return false;
		} else if (!genero.equals(other.genero))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (numSeguroMed == null) {
			if (other.numSeguroMed != null)
				return false;
		} else if (!numSeguroMed.equals(other.numSeguroMed))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (tipoSangre == null) {
			if (other.tipoSangre != null)
				return false;
		} else if (!tipoSangre.equals(other.tipoSangre))
			return false;
		return true;
	}
	
	
	
}
