package com.desafio.tipocambio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.desafio.tipocambio.TipocambioApplication;
import com.desafio.tipocambio.exception.ResourceNotFoundException;
import com.desafio.tipocambio.model.ReqTipoCambio;
import com.desafio.tipocambio.model.ResTipoCambio;
import com.desafio.tipocambio.model.TipoCambio;
import com.desafio.tipocambio.repository.TipoCambioRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class TipoCambioService {
	private static final Logger logger = LoggerFactory.getLogger(TipocambioApplication.class);
	@Autowired
    private TipoCambioRepository repository;
	
	public List<TipoCambio> getAllTipoCambios() {
        logger.info("Get all the TipoCambio...");
        return repository.findAll();
    }

    public List<TipoCambio>  getMontoTipoCambio(ReqTipoCambio tipocambio) throws ResourceNotFoundException{
    	return repository.getMontoTipoCambio(tipocambio.getMonedaorigen(), tipocambio.getMonedadestino());
    }
}
