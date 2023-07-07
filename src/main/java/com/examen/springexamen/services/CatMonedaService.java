package com.examen.springexamen.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.springexamen.dao.CatMonedaDao;
import com.examen.springexamen.model.MonedaModel;
import com.examen.springexamen.model.MonedaRequest;



@Service
public class CatMonedaService {
	@Autowired
	CatMonedaDao catMonedaDao;
	public List<MonedaModel> getAllMonedas(){
		return catMonedaDao.getAllMonedas();
	}
	
	public MonedaModel getMoneda(String cia, String claveMoneda){
		return catMonedaDao.getMoneda(cia, claveMoneda);
	}
	
	public boolean deleteMoneda(String cia, String claveMoneda) {
		return catMonedaDao.deleteMoneda(cia, claveMoneda);
	}
	
	public boolean createMoneda(MonedaRequest request) {
		return catMonedaDao.createMoneda(request);
	}
	
	public boolean updateMoneda(MonedaRequest request) {
		return  catMonedaDao.updateMoneda(request);
	}
}
