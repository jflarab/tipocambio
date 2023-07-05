package com.desafio.tipocambio.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.desafio.tipocambio.TipocambioApplication;
import com.desafio.tipocambio.dto.ReqMontoTipoCambio;
import com.desafio.tipocambio.dto.ResMontoTipoCambio;
import com.desafio.tipocambio.dto.ResTipoCambio;
import com.desafio.tipocambio.exception.ResourceNotFoundException;
import com.desafio.tipocambio.mapper.TipoCambioMapper;
import com.desafio.tipocambio.model.TipoCambio;
import com.desafio.tipocambio.repository.TipoCambioRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class TipoCambioService {
	private static final Logger logger = LoggerFactory.getLogger(TipocambioApplication.class);
	@Autowired
    private TipoCambioRepository repository;
	@Autowired
    private TipoCambioMapper tipoCambioMapper;
	
	public List<ResTipoCambio> getAllTipoCambios() {
        logger.info("Get all the TipoCambio...");
        return repository.findAll().stream()
        		.map(tc -> tipoCambioMapper.mapTipoCambioTOResTipoCambio(tc)).collect(Collectors.toList());
    }

    public ResMontoTipoCambio  getMontoTipoCambio(ReqMontoTipoCambio tipocambio) throws ResourceNotFoundException{
    	logger.info("Get MontoTipoCambio...");
    	List<TipoCambio> lista = repository.getMontoTipoCambio(tipocambio.getMonedaorigen(), tipocambio.getMonedadestino());
    	System.out.println("size:"+lista.size());
        if(lista.size()==0) 
        	throw new ResourceNotFoundException("Tipo de cambio no encontrado:: " + tipocambio);        
        ResMontoTipoCambio response = tipoCambioMapper.mapTipoCambioTOResMontoTipoCambio(lista.get(0));         
        response.setMonto((double)Math.round(response.getTipocambio()*tipocambio.getMonto()*100)/100);        
        return response;     
    }
}
