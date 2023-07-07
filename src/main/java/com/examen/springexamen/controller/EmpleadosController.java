package com.examen.springexamen.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.springexamen.model.EmpleadoModel;
import com.examen.springexamen.services.EmpleadoService;

@RestController
@RequestMapping("/empleado")
public class EmpleadosController {
	@Autowired
	EmpleadoService empleadoService;
	
	@GetMapping(value={"/{cia}/{empleado}/{fechaInicio}/{fechaTermino}","/{cia}/{fechaInicio}/{fechaTermino}"})	
	public List<EmpleadoModel> consultarEmpleadosPorEmpleado(@PathVariable String cia,@PathVariable(required = false) String empleado,
			@PathVariable String fechaInicio,@PathVariable String fechaTermino) {
		return empleadoService.consultarEmpleadosPorEmpleado(cia,empleado,fechaInicio,fechaTermino);
	}
	
	
}
