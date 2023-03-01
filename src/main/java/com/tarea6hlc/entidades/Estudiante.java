package com.tarea6hlc.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Estudiante")
@AllArgsConstructor @NoArgsConstructor
public class Estudiante {

	/** DNI */
	@Id
	@NotEmpty(message = "Tienes que introducir un DNI")
	@Column(nullable = false)
	private String DNI;
	
	/** Nombre */
	@NotEmpty(message = "Debe especificar un nombre")
	@Column(nullable = false)
	private String nombre;
	
	/** Direccion */
	@NotEmpty(message = "Tienes que especificar una direccion")
	@Column(nullable = false)
	private String direccion;
	
	/** Carrera */
	@NotEmpty(message = "Tienes que especificar una carrera")
	@Column(nullable = false)
	private String carrera;

	
	/** Año */
	@NotNull(message="Tienes que especificar un año de estudio")
	@Column(nullable=false)
	private int anio;
	
	/** Habilidades */
	@NotEmpty(message="Tiene que especificar las habilidades")
	@Column(nullable=false)
	private String habilidades;
	
	/** telefono */
	@NotNull(message="Tiene que especificar un número de teléfono")
	@Column(nullable = false)
	private int telefono;
	
	/** Correo */
	@NotEmpty(message="Tiene que especificar un email")
	@Column(nullable = false)
	private String correo;
	
	/** Informacion adicional */
	@Column(name = "Adicional", nullable = false)
	private String adicional;
	
	@ManyToMany
	@JoinTable( name = "EmpresasEstudiantes", 
		joinColumns = @JoinColumn(name = "estudianteDNI"),
		inverseJoinColumns = @JoinColumn(name = "codigoEmpresa"))
	private List<Empresa> empresas;

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
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

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(String habilidades) {
		this.habilidades = habilidades;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
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

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}
	
}
