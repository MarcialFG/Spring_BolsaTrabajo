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
import org.unbescape.xml.XmlEscapeType;

import com.tarea6hlc.entidades.Empresa;
import com.tarea6hlc.entidades.Estudiante;
import com.tarea6hlc.servicios.EmpresaServiceI;
import com.tarea6hlc.servicios.EstudianteServiceI;

import ch.qos.logback.core.read.ListAppender;

/**
 * Controlador referente a las vistas y acciones de Proyecto
 *
 */
@Controller
public class EstudianteController {
	
	/**
	 * El servicio de Estudiante.
	 */
	@Autowired
	private EstudianteServiceI estudianteServiceI;
	
	/**
	 * El servicio de Empresa.
	 */
	@Autowired
	private EmpresaServiceI empresaServiceI;
	

	/*
	 * VISTAS
	 */
	
	/**
	 * La lista de todos los estudiantes.
	 * @param model el modelo de la aplicación.
	 * @return estudiante.html
	 */
	@GetMapping("/showEstudiantesView")
	public String mostrarEstudiantes(Model model) {

		// Obtención de Estudiantes
		final List<Estudiante> listaEstudiantes = estudianteServiceI.obtenerEstudiantes();

		// Carga de datos al modelo
		model.addAttribute("estudiantesListView", listaEstudiantes);

		return "estudiante";
	}
	
	/**
	 * La vista de modificación de un estudiante.
	 * @param DNI el DNI del estudiante a modificar.
	 * @param model el modelo de la aplicación.
	 * @return estudianteModificar.html
	 */
	@GetMapping("/showEstudianteMod")
	public String mostrarModEstudiante(@RequestParam String DNI, Model model) {
		// Obtención de estudiante a modificar
		final Estudiante estudianteToMod = estudianteServiceI.obtenerPorDni(DNI);

		// Carga de datos al modelo
		model.addAttribute("estudianteToMod", estudianteToMod);

		return "estudianteModificar";
	}
	
	/**
	 * Muestra una lista de las empresas donde esta integrado el estudiante.
	 * @param DNI el DNI del estudiante a mostrar.
	 * @param model el modelo de la aplicación.
	 * @return estudianteEmpresas.html
	 */
	@GetMapping("/showEstudianteEmpresas")
	public String mostrarEstudiantesEmpresas(@RequestParam String DNI, Model model) {

		// Obtención de estudiante 
		final Estudiante estudiante = estudianteServiceI.obtenerPorDni(DNI);
		List<Empresa> empresas = empresaServiceI.obtenerEmpresas();
		empresas.removeAll(estudiante.getEmpresas());

		// Carga de datos al modelo
		model.addAttribute("estudiante", estudiante);
		model.addAttribute("empresas", empresas);

		return "estudianteEmpresas";
	}
	/**
	 * Se realizar la búsqueda por parámetros y se muestra una lista de estudiantes filtrados.
	 * @param searchedEstudiante el estudiante buscado, sacado del formulario de búsqueda.
	 * @param model el modelo de la aplicación.
	 * @return estudiante.html
	 * @throws Exception en caso de que no se haya introducido parámetros o sean incorrectos.
	 */
	@PostMapping("/actSearchEstudiante")
	public String submitBuscarEstudianteForm(@ModelAttribute Estudiante searchedEstudiante, Model model) throws Exception {
		List<Estudiante> lista = new ArrayList<>();
		if (searchedEstudiante.getDNI().isBlank() && searchedEstudiante.getCarrera() == null && searchedEstudiante.getDireccion().isBlank() && searchedEstudiante.getNombre().isBlank()) {
			new Exception("ERROR.");
		} else if (!searchedEstudiante.getDNI().isBlank()) {
			//Por DNI, resultado único
			final Estudiante e = estudianteServiceI.obtenerPorDni(searchedEstudiante.getDNI());
			lista.add(e);
			model.addAttribute("estudiantesListView", lista);
			return "estudiante";
		}
		if (!searchedEstudiante.getNombre().isBlank() && !searchedEstudiante.getCarrera().isBlank() && searchedEstudiante.getDireccion() != null) {
			//Todos los parámetros
			lista = estudianteServiceI.obtenerPorNombreyDireccionyCarrera(searchedEstudiante.getNombre(), searchedEstudiante.getDireccion(), searchedEstudiante.getCarrera());
		} else if (searchedEstudiante.getNombre().isBlank()) {
			//Nombre esta vacio: Carrera, Año o Carrera+Año
			if (!searchedEstudiante.getCarrera().isBlank() && !toString().valueOf(searchedEstudiante.getAnio()).isBlank()) {
				//Carrera+Año
				lista = estudianteServiceI.obtenerPorCarrerayAnio(searchedEstudiante.getCarrera(), searchedEstudiante.getAnio());
			} else if (!searchedEstudiante.getCarrera().isBlank()) {
				//Carrera
				lista = estudianteServiceI.obtenerPorCarrera(searchedEstudiante.getCarrera());
			} else {
				//Año
				lista = estudianteServiceI.obtenerPorAnio(searchedEstudiante.getAnio());
			}
		} else {
			//Nombre esta completo: Nombre, Nombre+Direccion o Nombre+FechaNacimiento
			if (!searchedEstudiante.getDireccion().isBlank()) {
				//Nombre+Direccion
				lista = estudianteServiceI.obtenerPorNombreYDireccion(searchedEstudiante.getNombre(), searchedEstudiante.getDireccion());			
			} else {
				//Nombre
				lista = estudianteServiceI.obtenerPorNombre(searchedEstudiante.getNombre());
			}
		}
		model.addAttribute("estudiantesListView", lista);
		return "estudiante";
	}
	
	/*
	 * ACCIONES
	 */
	
	/**
	 * Insertar un estudiante nuevo
	 * @param newestudiante el nuevo estudiante a añadir.
	 * @param result el resultado de la aplicación.
	 * @return estudiante.html
	 * @throws Exception en caso de falta de parámetros o parámetros incorrectos.
	 */
	@PostMapping("/actAddEstudiante")
	private String insertarEstudiante(@Valid @ModelAttribute Estudiante newEstudiante, BindingResult result) throws Exception {
		if (result.hasErrors()) {
			throw new Exception("Parámetros de proyecto erróneos");
		} else {

			// Se añade el nuevo estudiante
			estudianteServiceI.insertarEstudiante(newEstudiante);
		}

		return "redirect:showEstudiantesView";
	}
	
	/**
	 * Eliminar un estudiante.
	 * @param DNI el DNI del estudiante a eliminar.
	 * @param model el modelo de la aplicación.
	 * @return estudiante.html
	 */
	@GetMapping("/actDropEstudiante")
	public String eliminarEstudiante(@RequestParam String DNI, Model model) {

		// Eliminación de estudiante
		estudianteServiceI.eliminarEstudianteporDNI(DNI);

		return "redirect:showEstudiantesView";

	}
	
	/**
	 * Modificación de un estudiante.
	 * @param newEstudiante el estudiante a modificar con los datos nuevos.
	 * @param result el resultado de la aplicación.
	 * @return estudiante.html
	 * @throws Exception en caso de falta de parámetros o parámetros incorrectos.
	 */
	@PostMapping("/actModEstudiante")
	private String modificarEstudiante(@Valid @ModelAttribute Estudiante newEstudiante, BindingResult result) throws Exception {
		Estudiante estudianteToMod = estudianteServiceI.obtenerPorDni(newEstudiante.getDNI());
		estudianteToMod.setAdicional(newEstudiante.getAdicional());
		estudianteToMod.setAnio(newEstudiante.getAnio());
		estudianteToMod.setCarrera(newEstudiante.getCarrera());
		estudianteToMod.setCorreo(newEstudiante.getCorreo());
		estudianteToMod.setDireccion(newEstudiante.getDireccion());
		estudianteToMod.setHabilidades(newEstudiante.getHabilidades());
		estudianteToMod.setNombre(newEstudiante.getNombre());
		estudianteToMod.setTelefono(newEstudiante.getTelefono());
		if (result.hasErrors()) {
			throw new Exception("Parámetros de proyecto erróneos");
		} else {

			// Se añade el nuevo estudiante
			estudianteServiceI.actualizarEstudiante(estudianteToMod);
		}

		return "redirect:showEstudiantesView";
	}
	
	/**
	 * Eliminar una empresa de un estudiante.
	 * @param DNI el DNI del estudiante.
	 * @param codigoEmpresa el codigo de la empresa a eliminar del estudiante.
	 * @param model el modelo de la aplicación.
	 * @return estudianteEmpresas.html
	 */
	@GetMapping("/actDropEmpresaEstudiante")
	public String eliminarEmpresadeEstudiante(@RequestParam String codigoEmpresa, @RequestParam String DNI, Model model) {
		Estudiante estudiante = estudianteServiceI.obtenerPorDni(DNI);
		Empresa empresa = empresaServiceI.obtenerPorCodigo(codigoEmpresa);
		estudiante.getEmpresas().remove(empresa);
		
		// Se actualiza el estudiante
		estudianteServiceI.actualizarEstudiante(estudiante);
		
		return "redirect:showEstudiantesEmpresas?DNI=" + estudiante.getDNI();

	}
	
	/**
	 * Agregar una empresa a un estudiante.
	 * @param DNI el DNI del estudiante.
	 * @param codigoEmpresa el codigo de la empresa a eliminar del estudiante.
	 * @param model el modelo de la aplicación.
	 * @return estudianteEmpresas.html
	 */
	@GetMapping("/actAddEmpresaEstudiante")
	public String insertarEmpresadeEstudiante(@RequestParam String codigoEmpresa, @RequestParam String DNI, Model model) {
		Estudiante estudiante = estudianteServiceI.obtenerPorDni(DNI);
		Empresa empresa = empresaServiceI.obtenerPorCodigo(codigoEmpresa);
		estudiante.getEmpresas().add(empresa);
		
		// Se actualiza elestudiante
		estudianteServiceI.actualizarEstudiante(estudiante);
		
		return "redirect:showEstudiantesEmpresas?DNI=" + estudiante.getDNI();
	}
}
