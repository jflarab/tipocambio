package com.desafio.tipocambio.mapper;

import org.springframework.stereotype.Component;

import com.desafio.tipocambio.dto.ResMontoTipoCambio;
import com.desafio.tipocambio.dto.ResTipoCambio;
import com.desafio.tipocambio.model.TipoCambio;

import java.time.LocalDateTime;

@Component
public class TipoCambioMapper  {    
    public ResMontoTipoCambio mapTipoCambioTOResMontoTipoCambio(TipoCambio in){
    	ResMontoTipoCambio resMontoTipoCambio= new ResMontoTipoCambio();
    	resMontoTipoCambio.setMonedaorigen(in.getMonedaOrigen());
    	resMontoTipoCambio.setMonedadestino(in.getMonedaDestino());
    	resMontoTipoCambio.setTipocambio(in.getTipocambio());
        return resMontoTipoCambio;
    }
    public ResTipoCambio mapTipoCambioTOResTipoCambio(TipoCambio in){
    	ResTipoCambio resTipoCambio= new ResTipoCambio();
    	resTipoCambio.setMonedaorigen(in.getMonedaOrigen());
    	resTipoCambio.setMonedadestino(in.getMonedaDestino());
    	resTipoCambio.setTipocambio(in.getTipocambio());
        return resTipoCambio;
    }
}
