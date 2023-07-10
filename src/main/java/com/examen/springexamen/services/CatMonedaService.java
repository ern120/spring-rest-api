package com.examen.springexamen.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.springexamen.dao.CatMonedaDao;
import com.examen.springexamen.model.Moneda;
import com.examen.springexamen.model.MonedaId;
import com.examen.springexamen.model.MonedaModel;
import com.examen.springexamen.model.MonedaRequest;
import com.examen.springexamen.respository.MonedaRepository;



@Service
public class CatMonedaService {
	@Autowired
	MonedaRepository monedaRepository;
	public List<Moneda> getAllMonedas(){
		return monedaRepository.findAll();
	}
	
	public Moneda getMoneda(String cia, String claveMoneda){
		MonedaId monedaId=new MonedaId();
		monedaId.setClaveMoneda(claveMoneda);
		monedaId.setNumCia(Integer.parseInt(cia));
		return monedaRepository.findById(monedaId).orElse(new Moneda());
	}
	
	public boolean deleteMoneda(String cia, String claveMoneda) {
		MonedaId monedaId=new MonedaId();
		monedaId.setClaveMoneda(claveMoneda);
		monedaId.setNumCia(Integer.parseInt(cia));
		monedaRepository.deleteById(monedaId);
		return true;
	}
	
	public boolean createMoneda(Moneda request) {
		if(Objects.nonNull(monedaRepository.save(request))) {
			return true;
		}else {
			return false;
		}			
	}
	
	public boolean updateMoneda(Moneda request, String cia, String claveMoneda) {
		MonedaId monedaId=new MonedaId();
		monedaId.setClaveMoneda(claveMoneda);
		monedaId.setNumCia(Integer.parseInt(cia));
		
		if(monedaRepository.existsById(monedaId)) {
			if(request.getNumCia()!=Integer.parseInt(cia)|| !request.getClaveMoneda().equals(claveMoneda)) {
				monedaRepository.deleteById(monedaId);
			}
			monedaRepository.save(request);
			return true;			
		}
		return false;
	}
}
