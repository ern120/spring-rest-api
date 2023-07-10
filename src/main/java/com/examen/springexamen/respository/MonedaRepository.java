package com.examen.springexamen.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examen.springexamen.model.Moneda;
import com.examen.springexamen.model.MonedaId;

public interface MonedaRepository extends JpaRepository<Moneda, MonedaId>{
	


		
}
