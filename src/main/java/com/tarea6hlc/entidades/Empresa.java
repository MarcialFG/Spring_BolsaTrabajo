package com.tarea6hlc.entidades;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="Empresa")
@AllArgsConstructor @NoArgsConstructor
public class Empresa implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Codigo */
	@Id
	@NotEmpty(message = "Debe especificar un codigo")
	@Column(nullable = false)
	private String codigoEmpresa;
	
	/** Nombre */
	@NotEmpty(message = "Debe especificar el nombre de la empresa")
	@Column(nullable=false)
	private String nombre;
	
	/** Direccion */
	@NotEmpty(message = "Tienes que introducir una dirección")
	@Column(nullable = false)
	private String direccion;
	
	/** Sector */
	@NotEmpty(message = "Tienes que introducir un sector")
	@Column(nullable = false)
	private String sector;
	
	/** N trabajadores */
	@NotNull(message = "Debe especificar el número de trabajadores")
	@Column(nullable = false)
	private int ntrabajadores;
	
	/** Correo */
	@NotEmpty(message = "Tienes que introducir un email")
	@Column(nullable = false)
	private String correo;
	
	/** Informacion adicional */
	@Column(name = "Adicional", nullable = false)
	private String adicional;
	
	/** Telefono */
	@NotNull(message = "Debe especificar el número de telefono")
	@Column(name = "Telefono", nullable = false)
	private int telefono;
	
	@ManyToMany
	@JoinTable( name = "EmpresasEstudiantes", 
	joinColumns = @JoinColumn(name = "codigoEmpresa"),
	inverseJoinColumns = @JoinColumn(name = "estudianteDNI"))
	private List<Estudiante> estudiantes;

	public String getCodigoEmpresa() {
		return codigoEmpresa;
	}

	public void setCodigoEmpresa(String codigoEmpresa) {
		this.codigoEmpresa = codigoEmpresa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public int getNtrabajadores() {
		return ntrabajadores;
	}

	public void setNtrabajadores(int ntrabajadores) {
		this.ntrabajadores = ntrabajadores;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getAdicional() {
		return adicional;
	}

	public void setAdicional(String adicional) {
		this.adicional = adicional;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}
	
	
}
