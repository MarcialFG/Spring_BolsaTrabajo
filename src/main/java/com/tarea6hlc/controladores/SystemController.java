package com.tarea6hlc.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador principal de vistas.
 *
 */
@Controller
@RequestMapping("*")
public class SystemController {
	
	/**
	 * Redireccionamiento principal
	 * @return index.html
	 */
	@GetMapping
	public String showIndex() {
		return "index";
	}
	
	/*
	 * EMPRESAS
	 */
	
	/**
	 * Va a la lista de empresas.
	 * @return empresa.html
	 */
	//Listado
	@GetMapping("/EmpresasView")
	public String redirectToEmpresaController() {
		return "redirect:showEmpresasView";
	}
	
	/**
	 * Va a la vista de inserción de empresas.
	 * @return empresaInsertar.html
	 */
	//Insertar
	@GetMapping("/newEmpresaView")
	public String redirectToNewEmpresaTemplate() {
		return "empresaInsertar";
	}
	
	/*
	 * ESTUDIANTES
	 */
	
	/**
	 * Va a la lista de estudiantes.
	 * @return estudiante.html
	 */
	//Listado
	@GetMapping("/EstudiantesView")
	public String redirectToEstudianteController() {
		return "redirect:showEstudiantesView";
	}
	
	/**
	 * Va a la vista de insercción de estudiantes.
	 * @return estudianteInsertar.html
	 */
	//Insertar
	@GetMapping("/newEstudianteView")
	public String redirectToNewEstudianteTemplate() {
		return "estudianteInsertar";
	}
	
}
