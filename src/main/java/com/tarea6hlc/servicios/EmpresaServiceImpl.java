package com.tarea6hlc.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.tarea6hlc.entidades.Empresa;
import com.tarea6hlc.repositorio.EmpresaRepo;




/**
 * Implementación del servicio de Empleado
 *
 */
@Service
public class EmpresaServiceImpl implements EmpresaServiceI {

	@Autowired
	private EmpresaRepo empresaRepositorio;

	@Override
	public List<Empresa> obtenerEmpresas() {
		// TODO Auto-generated method stub
		return empresaRepositorio.findAll();
	}

	@Override
	public Empresa obtenerPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		return empresaRepositorio.findByCodigoEmpresa(codigo);
	}

	@Override
	public List<Empresa> obtenerPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return empresaRepositorio.findByNombre(nombre);
	}

	@Override
	public List<Empresa> obtenerPorDireccion(String direccion) {
		// TODO Auto-generated method stub
		return empresaRepositorio.findByDireccion(direccion);
	}

	@Override
	public List<Empresa> obtenerPorSector(String sector) {
		// TODO Auto-generated method stub
		return empresaRepositorio.findBySector(sector);
	}

	@Override
	public List<Empresa> obtenerPorNtrabajadores(int ntrabajadores) {
		// TODO Auto-generated method stub
		return empresaRepositorio.findByNtrabajadores(ntrabajadores);
	}

	@Override
	public List<Empresa> obtenerPorCorreo(String correo) {
		// TODO Auto-generated method stub
		return empresaRepositorio.findByCorreo(correo);
	}

	@Override
	public List<Empresa> obtenerPortelefono(int telefono) {
		// TODO Auto-generated method stub
		return empresaRepositorio.findByTelefono(telefono);
	}

	@Override
	public List<Empresa> obtenerPorNombreYDireccion(String nombre, String direccion) {
		// TODO Auto-generated method stub
		return empresaRepositorio.findByNombreAndDireccion(nombre, direccion);
	}

	@Override
	public List<Empresa> obtenerPorNombreYsector(String nombre, String sector) {
		// TODO Auto-generated method stub
		return empresaRepositorio.findByNombreAndSector(nombre, sector);
	}

	@Override
	public List<Empresa> obtenerPorNtrabajadoresyDireccion(int ntrabajadores, String direccion) {
		// TODO Auto-generated method stub
		return empresaRepositorio.findByNtrabajadoresAndDireccion(ntrabajadores, direccion);
	}

	@Override
	public void insertarEmpresa(Empresa e) {
		// TODO Auto-generated method stub
		empresaRepositorio.save(e);
	}

	@Override
	public void actualizarEmpresa(Empresa e) {
		// TODO Auto-generated method stub
		empresaRepositorio.save(e);
	}

	@Override
	public void eliminarEmpresaPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		empresaRepositorio.deleteById(codigo);
	}

	
	
}
