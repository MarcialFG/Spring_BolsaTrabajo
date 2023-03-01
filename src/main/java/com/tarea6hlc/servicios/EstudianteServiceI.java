package com.tarea6hlc.servicios;


import java.util.List;

import com.tarea6hlc.entidades.Estudiante;




/**
 * Servicio de Proyecto
 *
 */
public interface EstudianteServiceI {

	/**
	 * Obtiene una lista con todos los estudiantes.
	 * @return Lista de objetos estudiante.
	 */
	public List<Estudiante> obtenerEstudiantes();
	
	/**
	 * Obtiene el estudiante que tenga el dni pasado por argumento.
	 * @param DNI el dni del estudiante a buscar.
	 * @return Objeto Estudiante.
	 */
	public Estudiante obtenerPorDni(String DNI);

	/**
	 * Obtiene los estudiantes que tengan el nombre pasado por argumento.
	 * @param nombre el nombre a buscar.
	 * @return Lista de objetos Estudiante.
	 */
	public List<Estudiante> obtenerPorNombre(String nombre);

	/**
	 * Obtiene los estudiantes que tengan la direccion pasada por argumento..
	 * @param direccion la direccion a buscar.
	 * @return Lista de objetos Estudiante.
	 */
	public List<Estudiante> obtenerPorDireccion(String direccion);
	
	/**
	 * Obtiene los estudiantes que tengan la carrera pasado por argumento.
	 * @param carrera la carrera a buscar.
	 * @return Lista de objetos Estudiante.
	 */
	public List<Estudiante> obtenerPorCarrera(String carrera);

	/**
	 * Obtiene los estudiantes que tengan el año pasado por argumento.
	 * @param anio el año a buscar.
	 * @return Lista de objetos Estudiante.
	 */
	public List<Estudiante> obtenerPorAnio(int anio);

	/**
	 * Obtiene los estudiantes que tengan el correo pasado por argumento.
	 * @param correo el correo a buscar.
	 * @return Lista de objetos Estudiante.
	 */
	public List<Estudiante> obtenerPorCorreo(String correo);

	/**
	 * Obtiene los estudiantes con el numero de telefono pasado por argumento.
	 * @param telefono el telefono a buscar.
	 * @return Lista de objetos Estudiante.
	 */
	public List<Estudiante> obtenerPortelefono(int telefono);

	/**
	 * Obtiene los estudiantes que tengan el nombre y la direccion pasados por argmento.
	 * @param nombre el nombre a buscar.
	 * @param direccion la direccion a buscar.
	 * @return Lista de objetos Estudiante.
	 */
	public List<Estudiante> obtenerPorNombreYDireccion(String nombre, String direccion);
	/**
	 * Obtiene los estudiantes que tengan la direccion y la carrera pasados por argmento.
	 * @param direccion la direccion a buscar.
	 * @param carrera la carrera a buscar.
	 * @return Lista de objetos Estudiante.
	 */
	public List<Estudiante> obtenerPorDireccionYCarrera(String direccion, String carrera);
	/**
	 * Obtiene los estudiantes que tengan la carrera y el año pasados por argmento.
	 * @param carrera la carrera a buscar.
	 * @param anio el año a buscar.
	 * @return Lista de objetos Estudiante.
	 */
	public List<Estudiante> obtenerPorCarrerayAnio(String carrera,int anio);

	/**
	 * Obtiene los estudiantes que tengan el nombre, la direccion y la carrera pasados por argmento.
	 * @param nombre el nombre a buscar.
	 * @param direccion la direccion a buscar.
	 * @param carrera la carrera a buscar.
	 * @return Lista de objetos Estudiante.
	 */
	public List<Estudiante> obtenerPorNombreyDireccionyCarrera(String nombre, String direccion, String carrera);
	
	/**
	 * Obtiene los estudiantes que tengan el nombre, la direccion y el anio pasados por argmento.
	 * @param nombre el nombre a buscar.
	 * @param direccion la direccion a buscar.
	 * @param anio el año a buscar.
	 * @return Lista de objetos Estudiante.
	 */
	public List<Estudiante> obtenerPorNombreyDireccionyAnio(String nombre, String direccion, int anio);
	
	
	/**
	 * Inserta un estudiante en la base de datos.
	 * @param e el objeto Estudiante a insertar.
	 */
	public void insertarEstudiante(Estudiante e);
	
	/**
	 * Actualiza un estudiante ya existente en la base de datos.
	 * @param e el objeto Empresa a actualizar.
	 */
	public void actualizarEstudiante(Estudiante e);
	
	/**
	 * Elimina un estudiante en la base de datos.
	 * @param codigo el codigo de la Empresa a eliminar.
	 */
	public void eliminarEstudianteporDNI(String DNI);
	
}
