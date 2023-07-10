package com.examen.springexamen.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.examen.springexamen.model.MonedaModel;
import com.examen.springexamen.model.MonedaRequest;

@Repository
public class CatMonedaDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<MonedaModel> getAllMonedas(){
		return jdbcTemplate.query("SELECT * FROM HU_CAT_MONEDA", new RowMapper<MonedaModel>() {

			@Override
			public MonedaModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				MonedaModel moneda=new MonedaModel();
				moneda.setNumCia(String.valueOf( (rs.getInt(1))));
				moneda.setClaveMoneda(rs.getString(2));
				moneda.setDescripcion(rs.getString(3));
				moneda.setSimbolo(rs.getString(4));
				moneda.setAbreviacion(rs.getString(5));
				moneda.setMonedaCorriente(rs.getString(6));
				moneda.setStatus(rs.getString(7));
				return moneda;
			}
			
		});
		
		
		
	}
	
	public MonedaModel getMoneda(String cia, String claveMoneda){
		Object params[]= {cia,claveMoneda};
		try {
			return jdbcTemplate.queryForObject("SELECT * FROM HU_CAT_MONEDA WHERE NUM_CIA=? AND CLAVE_MONEDA=? FETCH FIRST 1 ROWS ONLY",new RowMapper<MonedaModel>() {

				@Override
				public MonedaModel mapRow(ResultSet rs, int rowNum) throws SQLException {
					MonedaModel moneda=new MonedaModel();
					moneda.setNumCia(String.valueOf( (rs.getInt(1))));
					moneda.setClaveMoneda(rs.getString(2));
					moneda.setDescripcion(rs.getString(3));
					moneda.setSimbolo(rs.getString(4));
					moneda.setAbreviacion(rs.getString(5));
					moneda.setMonedaCorriente(rs.getString(6));
					moneda.setStatus(rs.getString(7));
					return moneda;
				}
				
			}, params);
		} catch (Exception e) {
			return null;
		}
		
		
	}
	
	public boolean deleteMoneda(String cia, String claveMoneda) {
		Object params[]= {cia,claveMoneda};
		int result=jdbcTemplate.update("DELETE FROM HU_CAT_MONEDA WHERE num_cia=? AND clave_moneda=?",params);
		if(result>0) {
			return true;
		}
		return false;
	}
	
	public boolean createMoneda(MonedaRequest request) {
		Object params[]= {request.getNumCia(),request.getClaveMoneda(),request.getDescripcion(),
				request.getSimbolo(),request.getAbreviacion(),request.getMonedaCorriente(),request.getStatus()};
		int result=jdbcTemplate.update("INSERT INTO HU_CAT_MONEDA  (NUM_CIA, CLAVE_MONEDA, DESCRIPCION,SIMBOLO,ABREVIACION,MONEDA_CORRIENTE,STATUS)"
				+ "VALUES (?,? ,?, ?,?,?,?)",params);
		if(result>0) {
			return true;
		}
		return false;
	}
	
	public boolean updateMoneda(MonedaRequest request,String cia, String claveMoneda) {
		Object params[]= {request.getNumCia(),request.getClaveMoneda(),request.getDescripcion(),
				request.getSimbolo(),request.getAbreviacion(),request.getMonedaCorriente(),request.getStatus(),
				cia, claveMoneda};
		int result=jdbcTemplate.update("UPDATE HU_CAT_MONEDA SET NUM_CIA=?, CLAVE_MONEDA=?, DESCRIPCION=?,SIMBOLO=?,ABREVIACION=?,MONEDA_CORRIENTE=?,STATUS=? WHERE NUM_CIA=? AND CLAVE_MONEDA=?",
				params);
		if(result>0) {
			return true;
		}
		return false;
	}
}
