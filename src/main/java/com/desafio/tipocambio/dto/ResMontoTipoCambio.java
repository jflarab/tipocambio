package com.desafio.tipocambio.dto;

public class ResMontoTipoCambio {
   
    private String monedaorigen;    
   
    private String monedadestino;
   
    private Double monto;
    
    private Double tipocambio;

	public Double getTipocambio() {
		return tipocambio;
	}

	public void setTipocambio(Double tipocambio) {
		this.tipocambio = tipocambio;
	}

	public String getMonedaorigen() {
		return monedaorigen;
	}

	public void setMonedaorigen(String monedaorigen) {
		this.monedaorigen = monedaorigen;
	}

	public String getMonedadestino() {
		return monedadestino;
	}

	public void setMonedadestino(String monedadestino) {
		this.monedadestino = monedadestino;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}
    

   
}
