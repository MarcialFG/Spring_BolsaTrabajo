package com.tarea6hlc.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarea6hlc.entidades.Estudiante;
import com.tarea6hlc.repositorio.EstudianteRepo;



/**
 * Implementacion del servicio (ProyectoServiceI)
 *
 */
@Service
public class EstudianteServiceImpl implements EstudianteServiceI{

	@Autowired
	private EstudianteRepo estudianteRepo;

	@Override
	public List<Estudiante> obtenerEstudiantes() {
		// TODO Auto-generated method stub
		return estudianteRepo.findAll();
	}

	@Override
	public Estudiante obtenerPorDni(String DNI) {
		// TODO Auto-generated method stub
		return estudianteRepo.findByDNI(DNI);
	}

	@Override
	public List<Estudiante> obtenerPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return estudianteRepo.findByNombre(nombre);
	}

	@Override
	public List<Estudiante> obtenerPorDireccion(String direccion) {
		// TODO Auto-generated method stub
		return estudianteRepo.findByDireccion(direccion);
	}

	@Override
	public List<Estudiante> obtenerPorCarrera(String carrera) {
		// TODO Auto-generated method stub
		return estudianteRepo.findByCarrera(carrera);
	}

	@Override
	public List<Estudiante> obtenerPorAnio(int anio) {
		// TODO Auto-generated method stub
		return estudianteRepo.findByAnio(anio);
	}

	@Override
	public List<Estudiante> obtenerPorCorreo(String correo) {
		// TODO Auto-generated method stub
		return estudianteRepo.findByCorreo(correo);
	}

	@Override
	public List<Estudiante> obtenerPortelefono(int telefono) {
		// TODO Auto-generated method stub
		return estudianteRepo.findByTelefono(telefono);
	}


	@Override
	public List<Estudiante> obtenerPorNombreYDireccion(String nombre, String direccion) {
		// TODO Auto-generated method stub
		return estudianteRepo.findByNombreAndDireccion(nombre, direccion);
	}

	@Override
	public List<Estudiante> obtenerPorDireccionYCarrera(String nombre, String carrera) {
		// TODO Auto-generated method stub
		return estudianteRepo.findByDireccionAndCarrera(nombre, carrera);
	}

	@Override
	public List<Estudiante> obtenerPorCarrerayAnio(String carrera, int anio) {
		// TODO Auto-generated method stub
		return estudianteRepo.findByCarreraAndAnio(carrera, anio);
	}

	@Override
	public List<Estudiante> obtenerPorNombreyDireccionyCarrera(String nombre, String correo, String carrera) {
		// TODO Auto-generated method stub
		return estudianteRepo.findByNombreAndDireccionAndCarrera(nombre, correo, carrera);
	}

	@Override
	public List<Estudiante> obtenerPorNombreyDireccionyAnio(String nombre, String direccion, int anio) {
		// TODO Auto-generated method stub
		return estudianteRepo.findByNombreAndDireccionAndAnio(nombre, direccion, anio);
	}


	@Override
	public void insertarEstudiante(Estudiante e) {
		// TODO Auto-generated method stub
		estudianteRepo.save(e);
		
	}

	@Override
	public void actualizarEstudiante(Estudiante e) {
		// TODO Auto-generated method stub
		estudianteRepo.save(e);
	}

	@Override
	public void eliminarEstudianteporDNI(String DNI) {
		// TODO Auto-generated method stub
		estudianteRepo.deleteById(DNI);
	}


}
