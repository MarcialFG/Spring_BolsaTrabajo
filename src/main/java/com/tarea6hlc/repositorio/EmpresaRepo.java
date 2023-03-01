package com.tarea6hlc.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tarea6hlc.entidades.Empresa;




/**
 * Repositorio de Empresa
 *
 */
public interface EmpresaRepo extends JpaRepository<Empresa, String> {
	
	/**
	 * Encontrar por codigo
	 * @param CodigoEmpresa el codigo unico de la empresa
	 * @return una empresa
	 */
	Empresa findByCodigoEmpresa(String CodigoEmpresa);
	
	/**
	 * Encontrar por nombre.
	 * @param nombre es el nombre de la empresa.
	 * @return lista de empresas.
	 */
	List<Empresa> findByNombre(String nombre);
	
	/**
	 * Encontrar por direccion.
	 * @param direccion es la direccion de la empresa.
	 * @return lista de empresas.
	 */
	List<Empresa> findByDireccion(String direccion);
	
	/**
	 * Encontrar por sector de trabajo
	 * @param sector es el sector de trabajo de la empresa.
	 * @return lista de empresas.
	 */
	List<Empresa> findBySector(String sector);
	
	/**
	 * Encontrar por numero de trabajadores.
	 * @param ntrabajadores es el numero de trabajadores de la empresa..
	 * @return lista de empresas.
	 */
	List<Empresa> findByNtrabajadores(int ntrabajadores);
	
	/**
	 * Encontrar por correo.
	 * @param correo es el correo de la empresa.
	 * @return lista de empresas.
	 */
	List<Empresa> findByCorreo(String correo);
	
	/**
	 * Encontrar por telefono.
	 * @param telefono es el telefono de la empresa
	 * @return lista de empresas.
	 */
	List<Empresa> findByTelefono(int telefono);
	
	/**
	 * Encontrar por nombre y direccion.
	 * @param nombre es el nombre a buscar.
	 * @param direccion es la direccion a buscar.
	 * @return lista de empresas.
	 */
	List<Empresa> findByNombreAndDireccion(String nombre, String direccion);
	/**
	 * Encontrar por nombre y sector.
	 * @param nombre es el nombre a buscar.
	 * @param sector es el sector de trabajo a buscar.
	 * @return lista de empresas.
	 */
	List<Empresa> findByNombreAndSector(String nombre, String sector);
	/**
	 * Encontrar por numero de trabajadores y direccion.
	 * @param ntrabajadores es el numero de trabajadores a buscar.
	 * @param direccion es la direccion a buscar.
	 * @return lista de empresas.
	 */
	List<Empresa> findByNtrabajadoresAndDireccion(int ntrabajadores,String direccion);
}
