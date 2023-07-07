package com.examen.springexamen.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.examen.springexamen.model.EmpleadoModel;


@Repository
public class EmpleadoDao {
	@Autowired
	JdbcTemplate jdbcTemplate; 
	
	public List<EmpleadoModel> findALlByEmpleado(String cia, String empleado,String fechaInicio,String fechaTermino) {
		Object[] params= {cia, empleado,fechaInicio,fechaTermino};
		List<EmpleadoModel> empleados= jdbcTemplate.query(
				"SELECT NUM_CIA,NUM_EMP, APELL_PAT,APELL_MAT ,NOMBRE,FECHA_INGRESO FROM HU_EMPLS "
				+ " WHERE  NUM_CIA=?  AND NUM_EMP=? AND FECHA_INGRESO > to_date(?,'YYYY-MM-DD') AND FECHA_INGRESO < to_date(?,'YYYY-MM-DD')",
				new RowMapper<EmpleadoModel>() {

			@Override
			public EmpleadoModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				EmpleadoModel empleado=new EmpleadoModel();
				empleado.setCia(rs.getInt(1));
				empleado.setEmpleado(rs.getInt(2));
				empleado.setApellidoPaterno(rs.getString(3));
				empleado.setApellidoMaterno(rs.getString(4));
				empleado.setNombre(rs.getString(5));
				empleado.setFechaInicio(rs.getString(6));
				
				return empleado;
			}
			
		}, params);
		return empleados;
	}

	public List<EmpleadoModel> findALl(String cia,String fechaInicio,String fechaTermino) {
		Object[] params= {cia,fechaInicio,fechaTermino};
		List<EmpleadoModel> empleados= jdbcTemplate.query(
				"SELECT NUM_CIA,NUM_EMP, APELL_PAT,APELL_MAT ,NOMBRE,FECHA_INGRESO FROM HU_EMPLS "
						+ "WHERE  NUM_CIA=? AND FECHA_INGRESO >to_date(?,'YYYY-MM-DD') AND FECHA_INGRESO <to_date(?,'YYYY-MM-DD') ",
				new RowMapper<EmpleadoModel>() {

			@Override
			public EmpleadoModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				EmpleadoModel empleado=new EmpleadoModel();
				empleado.setCia(rs.getInt(1));
				empleado.setEmpleado(rs.getInt(2));
				empleado.setApellidoPaterno(rs.getString(3));
				empleado.setApellidoMaterno(rs.getString(4));
				empleado.setNombre(rs.getString(5));
				
				return empleado;
			}
			
		}, params);
		return empleados;
	}
	
}
