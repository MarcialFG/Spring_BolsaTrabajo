package com.tarea6hlc.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tarea6hlc.entidades.Empresa;
import com.tarea6hlc.entidades.Estudiante;
import com.tarea6hlc.servicios.EmpresaServiceI;
import com.tarea6hlc.servicios.EstudianteServiceI;
import lombok.Data;


/**
 * Controlador referente a las vistas y acciones de Empresa.
 *
 */
@Controller
public class EmpresaController {

	/**
	 * El servicio de Empresa.
	 */
	@Autowired
	private EmpresaServiceI empresaServiceI;
	
	/**
	 * El servicio de Estudiante.
	 */
	@Autowired
	private EstudianteServiceI estudianteServiceI;

	/*
	 * VISTAS
	 */

	/**
	 * La lista de empresas completa.
	 * @param model el modelo de la aplicación.
	 * @return empresa.html
	 */
	@GetMapping("/showEmpresasView")
	public String mostrarEmpresas(Model model) {

		// Obtención de empresas
		final List<Empresa> listaEmpresas = empresaServiceI.obtenerEmpresas();

		// Carga de datos al modelo
		model.addAttribute("empresasListView", listaEmpresas);

		return "empresa";
	}
	
	/**
	 * Vista de modificación de una empresa.
	 * @param codigoEmpresa el codigo de la empresa a modificar/actualizar.
	 * @param model el modelo de la aplicación.
	 * @return empresaoModificar.html
	 */
	@GetMapping("/showEmpresaMod")
	public String mostrarModEmpresa(@RequestParam String codigoEmpresa, Model model) {

		// Obtención de empresa a modificar
		final Empresa empresaToMod = empresaServiceI.obtenerPorCodigo(codigoEmpresa);

		// Carga de datos al modelo
		model.addAttribute("empresaToMod", empresaToMod);

		return "empresaModificar";
	}
	/**
	 * La vista de estudiantes pertenecientes a una empresa.
	 * @param codigoEmpresa el codigo de la empresa del que visualizar los estudiantes miembro.
	 * @param model el modelo de la aplicación.
	 * @return empresaIntegrantes.html
	 */
	@GetMapping("/showEmpresaEstudiantes")
	public String mostrarEmpresaEstudiantes(@RequestParam String codigoEmpresa, Model model) {

		// Obtención de empresa
		final Empresa empresa = empresaServiceI.obtenerPorCodigo(codigoEmpresa);
		List<Estudiante> estudiantesElegibles = estudianteServiceI.obtenerEstudiantes();
		estudiantesElegibles.removeAll(empresa.getEstudiantes());
		
		// Carga de datos al modelo
		model.addAttribute("empresa", empresa);
		model.addAttribute("estudiantesElegibles", estudiantesElegibles);

		return "empresaEstudiantes";
	}
	
	
	/**
	 * Búsqueda de empresas por parámetros, para visualizarse en una lista.
	 * @param searchedEmpresa la empresa con los parámetros a buscar, sacado del formulario.
	 * @param model el modelo de la aplicación.
	 * @return empresa.html
	 * @throws Exception en caso de falta de parámetros o parámetros incorrectos.
	 */
	@PostMapping("/actSearchEmpresa")
	public String submitBuscarEmpresaForm(@ModelAttribute Empresa searchedEmpresa, Model model) throws Exception {
		List<Empresa> lista = new ArrayList<>();
		if (searchedEmpresa.getCodigoEmpresa() == null && searchedEmpresa.getNombre().isBlank() && searchedEmpresa.getSector() == null) {
			new Exception("ERROR");
		} else if (!searchedEmpresa.getCodigoEmpresa().isBlank()) {
			//Por codigo, resultado único
			final Empresa e = empresaServiceI.obtenerPorCodigo(searchedEmpresa.getCodigoEmpresa());
			lista.add(e);
			model.addAttribute("empresasListView", lista);
			return "empresa";				
		} else {
			//Nombre esta completo: Direccion , Nombre y Direccion
			if (!searchedEmpresa.getDireccion().isBlank()) {
				//Nombre+Direccion
				lista = empresaServiceI.obtenerPorNombreYDireccion(searchedEmpresa.getNombre(), searchedEmpresa.getDireccion());
			} else {
				//Direccion
				lista = empresaServiceI.obtenerPorDireccion(searchedEmpresa.getDireccion());
			}
		}
		model.addAttribute("empresasListView", lista);
		return "empresa";
	}
	
	/*
	 * ACCIONES
	 */

	/**
	 * Insertar una nueva empresa.
	 * @param newEmpresa la nueva empresa a añadir, sacado del formulario.
	 * @param result el resultado de la aplicación.
	 * @return empleado.html
	 * @throws Exception en caso de que los parámetros sean incorrectos.
	 */
	@PostMapping("/actAddEmpresa")
	private String insertarEmpresa(@Valid @ModelAttribute Empresa newEmpresa, BindingResult result) throws Exception {
		if (result.hasErrors()) {
			throw new Exception("Parámetros de empresa erróneos");
		} else {
			// Se añade la nueva empresa
			empresaServiceI.insertarEmpresa(newEmpresa);
		}

		return "redirect:showEmpresasView";
	}
	
	/**
	 * Modificar una empresa ya existente.
	 * @param newEmpresa la empresa modificado, sacado del formulario.
	 * @param result el resultado de la aplicación.
	 * @return empresa.html
	 * @throws Exception en caso de que se pasen parámetros incorrectos.
	 */
	@PostMapping("/actModEmpresa")
	private String modificarEmpresa(@Valid @ModelAttribute Empresa newEmpresa, BindingResult result) throws Exception {
		Empresa empresaToMod = empresaServiceI.obtenerPorCodigo(newEmpresa.getCodigoEmpresa());
		empresaToMod.setNombre(newEmpresa.getNombre()); 
		empresaToMod.setSector(newEmpresa.getSector());
		empresaToMod.setTelefono(newEmpresa.getTelefono());
		empresaToMod.setNtrabajadores(newEmpresa.getNtrabajadores()); 
		empresaToMod.setDireccion(newEmpresa.getDireccion());
		empresaToMod.setCorreo(newEmpresa.getCorreo());
		empresaToMod.setAdicional(newEmpresa.getAdicional());
		if (result.hasErrors()) {
			throw new Exception("Parámetros de empresa erróneos");
		} else {

			// Se añade la nueva empresa
			empresaServiceI.actualizarEmpresa(empresaToMod);
		}

		return "redirect:showEmpresasView";
	}

	/**
	 * Eliminar una empresa.
	 * @param codigoEmpresa el codigo de la empresa a eliminar.
	 * @param model el modelo de la aplicación.
	 * @return empresa.html
	 */
	@GetMapping("/actDropEmpresa")
	public String eliminarEmpresa(@RequestParam String codigoEmpresa, Model model) {

		// Eliminación de empresa
		empresaServiceI.eliminarEmpresaPorCodigo(codigoEmpresa);
		
		return "redirect:showEmpresasView";

	}
	
	/**
	 * Eliminar a un estudiante de una empresa.
	 * @param codigoEmpresa el codigo de la empresa.
	 * @param DNI el DNI del estudiante a eliminar.
	 * @param model el modelo de la aplicación.
	 * @return empresaEstudiantes.html
	 */
	@GetMapping("/actDropEstudianteEmpresa")
	public String eliminarEstudianteEmpresa(@RequestParam String codigoEmpresa, @RequestParam String DNI, Model model) {
		Empresa empresa = empresaServiceI.obtenerPorCodigo(codigoEmpresa);
		Estudiante estudiante = estudianteServiceI.obtenerPorDni(DNI);
		empresa.getEstudiantes().remove(estudiante);
		
		// Se actualiza la empresa sin el estudiante
		empresaServiceI.actualizarEmpresa(empresa);
		
		return "redirect:showEmpresasEstudiantes?codigoEmpresa=" + empresa.getCodigoEmpresa();

	}
	
	/**
	 * Añadir a un estudiante a una empresa.
	 * @param empleadoDni el DNI del empleado.
	 * @param proyectoId el ID del proyecto a añadirle.
	 * @param model el modelo de la aplicación.
	 * @return empresaEsudiantes.html
	 */
	@GetMapping("/actAddEstudianteEmpresa")
	public String insertarEstudianteEmpresa(@RequestParam String codigoEmpresa, @RequestParam String DNI, Model model) {
		Empresa empresa = empresaServiceI.obtenerPorCodigo(codigoEmpresa);
		Estudiante estudiante = estudianteServiceI.obtenerPorDni(DNI);
		empresa.getEstudiantes().add(estudiante);
		
		// Se actualiza la empresa con el estudiante
		empresaServiceI.actualizarEmpresa(empresa);
		
		return "redirect:showEmpresasEstudiantes?codigoEmpresa=" + empresa.getCodigoEmpresa();

	}
	
}
