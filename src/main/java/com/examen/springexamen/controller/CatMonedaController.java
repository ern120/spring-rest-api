package com.examen.springexamen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examen.springexamen.model.MonedaModel;
import com.examen.springexamen.model.MonedaRequest;
import com.examen.springexamen.services.CatMonedaService;

@RestController
public class CatMonedaController {
	
	@Autowired
	CatMonedaService catMonedaService;
	
	@GetMapping("/moneda")
	public List<MonedaModel> getAllMonedas() {
		return catMonedaService.getAllMonedas();
	}
	
	
	@GetMapping("/moneda/{cia}/{clave_moneda}")
	public MonedaModel getMoneda(@PathVariable String cia,@PathVariable("clave_moneda") String claveMoneda) {
		return catMonedaService.getMoneda(cia, claveMoneda);
	}
	
	@DeleteMapping("/moneda/{cia}/{clave_moneda}")
	public void deleteMoneda(@PathVariable String cia,@PathVariable("clave_moneda") String claveMoneda ) {
		catMonedaService.deleteMoneda(cia, claveMoneda);
	}
	
	@PostMapping("/moneda")
	public void createMoneda(@RequestBody MonedaRequest moneda) {
		catMonedaService.createMoneda(moneda);
	}
	
	@PutMapping("/moneda")
	public void updateMoneda(@RequestBody MonedaRequest moneda ) {
		catMonedaService.updateMoneda(moneda);
	}
}
