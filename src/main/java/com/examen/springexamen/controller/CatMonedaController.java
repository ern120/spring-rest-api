package com.examen.springexamen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examen.springexamen.model.Moneda;
import com.examen.springexamen.model.MonedaModel;
import com.examen.springexamen.model.MonedaRequest;
import com.examen.springexamen.services.CatMonedaService;

@RestController
public class CatMonedaController {
	
	@Autowired
	CatMonedaService catMonedaService;
	
	@GetMapping("/moneda")
	public ResponseEntity<List<Moneda>> getAllMonedas() {
		return new ResponseEntity<List<Moneda>> (catMonedaService.getAllMonedas(),HttpStatus.FOUND);
	}
	
	
	@GetMapping("/moneda/{cia}/{clave_moneda}")
	public Moneda getMoneda(@PathVariable String cia,@PathVariable("clave_moneda") String claveMoneda) {
		return catMonedaService.getMoneda(cia, claveMoneda);
	}
	
	@DeleteMapping("/moneda/{cia}/{clave_moneda}")
	public ResponseEntity<Moneda> deleteMoneda(@PathVariable String cia,@PathVariable("clave_moneda") String claveMoneda ) {
		if(catMonedaService.deleteMoneda(cia, claveMoneda)) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);	
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/moneda")
	public ResponseEntity<Moneda> createMoneda(@RequestBody Moneda moneda) {
		if (catMonedaService.createMoneda(moneda)) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);	
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PutMapping("/moneda/{cia}/{clave_moneda}")
	public ResponseEntity<Moneda> updateMoneda(@RequestBody Moneda moneda ,@PathVariable("cia") String cia,@PathVariable("clave_moneda") String claveMoneda) {	
		
		if (catMonedaService.updateMoneda(moneda, cia, claveMoneda)) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);	
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
