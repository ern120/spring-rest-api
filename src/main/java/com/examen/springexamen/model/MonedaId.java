package com.examen.springexamen.model;

import java.io.Serializable;

public class MonedaId implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long numCia;
	private String claveMoneda;
	
	
	public MonedaId() {
		super();
	}
	public long getNumCia() {
		return numCia;
	}
	public void setNumCia(long numCia) {
		this.numCia = numCia;
	}
	public String getClaveMoneda() {
		return claveMoneda;
	}
	public void setClaveMoneda(String claveMoneda) {
		this.claveMoneda = claveMoneda;
	}

	
	

}
