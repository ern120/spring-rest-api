package com.examen.springexamen.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.springexamen.dao.EmpleadoDao;
import com.examen.springexamen.model.EmpleadoModel;

@Service
public class EmpleadoService {
	
	@Autowired
	EmpleadoDao empleadoDao;
	public List<EmpleadoModel>  consultarEmpleadosPorEmpleado(String id, String empleado, String fechaInicio, String fechaTermino) {
		if(Objects.isNull(empleado)) {
			return empleadoDao.findALl(id,fechaInicio,fechaTermino);	
		}else {
			return empleadoDao.findALlByEmpleado(id,empleado,fechaInicio,fechaTermino);
		}
		
	}
}
