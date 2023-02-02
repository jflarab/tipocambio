package com.desafio.tipocambio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipocambio")
public class TipoCambio {

    @Id
    private long id;

    @Column(name = "monedaorigen")
    private String monedaorigen;
    
    @Column(name = "monedadestino")
    private String monedadestino;

    @Column(name = "tipocambio")
    private Double tipocambio;




	public TipoCambio() {
        super();
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMonedaOrigen() {
		return monedaorigen;
	}

	public void setMonedaOrigen(String monedaOrigen) {
		this.monedaorigen = monedaOrigen;
	}

	public String getMonedaDestino() {
		return monedadestino;
	}

	public void setMonedaDestino(String monedaDestino) {
		this.monedadestino = monedaDestino;
	}

	public Double getTipocambio() {
		return tipocambio;
	}

	public void setTipocambio(Double tipocambio) {
		this.tipocambio = tipocambio;
	}
	
	public TipoCambio(TipoCambio tipocambio) {
		this.monedaorigen = tipocambio.getMonedaOrigen();
		this.monedadestino = tipocambio.getMonedaDestino();		
		
	}
   
}
