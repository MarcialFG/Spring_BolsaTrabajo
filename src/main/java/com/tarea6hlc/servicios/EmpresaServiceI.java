package com.tarea6hlc.servicios;

import java.util.List;

import com.tarea6hlc.entidades.Empresa;





/**
 * Servicio de Empresa
 *
 */
public interface EmpresaServiceI {
	
	/**
	 * Obtiene una lista con todos las empresas.
	 * @return Lista de objetos empresa.
	 */
	public List<Empresa> obtenerEmpresas();
	
	/**
	 * Obtiene la empresa que tenga el codigo pasado por argumento.
	 * @param codigoEmpresa el codigo de la empresa a buscar.
	 * @return Objeto Empresa.
	 */
	public Empresa obtenerPorCodigo(String codigoEmpresa);

	/**
	 * Obtiene las empresas que tengan el nombre pasado por argumento.
	 * @param nombre el nombre a buscar.
	 * @return Lista de objetos Empresa.
	 */
	public List<Empresa> obtenerPorNombre(String nombre);

	/**
	 * Obtiene las empresas que tengan la direccion pasada por argumento..
	 * @param direccion la direccion a buscar.
	 * @return Lista de objetos Empresa.
	 */
	public List<Empresa> obtenerPorDireccion(String direccion);
	
	/**
	 * Obtiene las empresas que tengan el sector pasado por argumento.
	 * @param sector el sector a buscar.
	 * @return Lista de objetos Empresa.
	 */
	public List<Empresa> obtenerPorSector(String sector);

	/**
	 * Obtiene las empresas que tengan el numero de trabajdores pasado por argumento.
	 * @param ntrabajadores el numero de trabajadores a buscar.
	 * @return Lista de objetos Empresa.
	 */
	public List<Empresa> obtenerPorNtrabajadores(int ntrabajadores);

	/**
	 * Obtiene las empresas que tengan el correo pasado por argumento.
	 * @param correo el correo a buscar.
	 * @return Lista de objetos Empresa.
	 */
	public List<Empresa> obtenerPorCorreo(String correo);

	/**
	 * Obtiene las empresas que tengan el numero de telefono pasado por argumento.
	 * @param telefono el telefono a buscar.
	 * @return Lista de objetos Empresa.
	 */
	public List<Empresa> obtenerPortelefono(int telefono);

	/**
	 * Obtiene las empresas que tengan el nombre y la direccion pasados por argmento.
	 * @param nombre el nombre a buscar.
	 * @param direccion la direccion a buscar.
	 * @return Lista de objetos Empresa.
	 */
	public List<Empresa> obtenerPorNombreYDireccion(String nombre, String direccion);
	/**
	 * Obtiene las empresas que tengan el nombre y el sector pasados por argmento.
	 * @param nombre el nombre a buscar.
	 * @param sector el sector a buscar.
	 * @return Lista de objetos Empresa.
	 */
	public List<Empresa> obtenerPorNombreYsector(String nombre, String sector);
	/**
	 * Obtiene las empresas que tengan el numero de trabjadores y la direccion pasados por argmento.
	 * @param ntrabajadores el numero de trabajadores a buscar.
	 * @param direccion la direccion a buscar.
	 * @return Lista de objetos Empresa.
	 */
	public List<Empresa> obtenerPorNtrabajadoresyDireccion(int ntrabajadores,String direccion);

	/**
	 * Inserta una empresa en la base de datos.
	 * @param e el objeto Empresa a insertar.
	 */
	public void insertarEmpresa(Empresa e);
	
	/**
	 * Actualiza una empresa ya existente en la base de datos.
	 * @param e el objeto Empresa a actualizar.
	 */
	public void actualizarEmpresa (Empresa e);
	
	/**
	 * Elimina una empresa en la base de datos.
	 * @param codigo el codigo de la Empresa a eliminar.
	 */
	public void eliminarEmpresaPorCodigo(String codigo);
	
}
