package com.tarea6hlc.repositorio;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tarea6hlc.entidades.Estudiante;


/**
 * Repositorio de Estudiante
 *
 */
public interface EstudianteRepo extends JpaRepository<Estudiante, String> {
	
	/**
	 * Encontrar por DNI
	 * @param DNI el dni del estudiante
	 * @return un estudiante.
	 */
	Estudiante findByDNI(String DNI);
	
	/**
	 * Encontrar por nombre.
	 * @param nombre es el nombre del estudiante.
	 * @return lista de estudiantes.
	 */
	List<Estudiante> findByNombre(String nombre);
	
	/**
	 * Encontrar por direccion.
	 * @param direccion es la direccion del estudiante.
	 * @return lista de estudiantes.
	 */
	List<Estudiante> findByDireccion(String direccion);
	
	/**
	 * Encontrar por carrera
	 * @param carrera es el nombre de la carrera.
	 * @return lista de estudiantes.
	 */
	List<Estudiante> findByCarrera(String carrera);
	
	
	/**
	 * Encontrar por correo.
	 * @param correo es el correo del estudiante.
	 * @return lista de estudiantes.
	 */
	List<Estudiante> findByCorreo(String correo);
	
	/**
	 * Encontrar por telefono.
	 * @param telefono es el telefono del estudiante
	 * @return lista de estudiantes.
	 */
	List<Estudiante> findByTelefono(int telefono);
	
	/**
	 * Encontrar por año.
	 * @param anio es el año de estudio.
	 * @return lista de estudiantes.
	 */
	List<Estudiante> findByAnio(int anio);
	
	/**
	 * Encontrar por nombre y direccion.
	 * @param nombre el nombre a buscar.
	 * @param direccion la direccion a buscar.
	 * @return lista de estudiantes.
	 */
	List<Estudiante> findByNombreAndDireccion(String nombre, String direccion);
	
	/**
	 * Encontrar por direccion y carrera.
	 * @param direccion la direccion a buscar.
	 * @param carrera la carrera a buscar.
	 * @return lista de estudiantes.
	 */
	List<Estudiante> findByDireccionAndCarrera(String direccion, String carrera);
	
	/**
	 * Encontrar por carrera y anio.
	 * @param carrera la carrera a buscar.
	 * @param anio el año de estudio a buscar.
	 * @return lista de estudiantes.
	 */
	List<Estudiante> findByCarreraAndAnio(String carrera,int anio);
	/**
	 * Encontrar por nombre, direccion y carrera.
	 * @param nombre el nombre a buscar.
	 * @param direccion la direccion a buscar.
	 * @param carrera la carrera a buscar.
	 * @return lista de estudiantes.
	 */
	List<Estudiante> findByNombreAndDireccionAndCarrera(String nombre, String direccion, String carrera);
	/**
	 * Encontrar por nombre, direccion y año.
	 * @param nombre el nombre a buscar.
	 * @param direccion la direccion a buscar.
	 * @param anio el año de estudio a buscar.
	 * @return lista de estudiantes.
	 */
	List<Estudiante> findByNombreAndDireccionAndAnio(String nombre, String direccion, int anio);
}
