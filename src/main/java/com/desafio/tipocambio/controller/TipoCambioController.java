package com.desafio.tipocambio.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.tipocambio.TipocambioApplication;
import com.desafio.tipocambio.exception.ResourceNotFoundException;
import com.desafio.tipocambio.model.ReqTipoCambio;
import com.desafio.tipocambio.model.ResTipoCambio;
import com.desafio.tipocambio.model.TipoCambio;
import com.desafio.tipocambio.repository.TipoCambioRepository;
import com.desafio.tipocambio.service.TipoCambioService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.DELETE, RequestMethod.POST, RequestMethod.GET, RequestMethod.OPTIONS})
@RequestMapping("/api/v1")
public class TipoCambioController {
    private static final Logger logger = LoggerFactory.getLogger(TipocambioApplication.class);
    @Autowired
    private TipoCambioService tipoCambioService;

    @GetMapping("/tipocambios")
    public List<TipoCambio> getAllTipoCambios() {
        logger.info("Get all the TipoCambio...");
        return tipoCambioService.getAllTipoCambios();
    }

    @PostMapping("/tipocambio/monto")
    public ResponseEntity<ResTipoCambio> getMontoTipoCambio(@RequestBody ReqTipoCambio tipocambio) throws ResourceNotFoundException{
    	
    	System.out.println("origen:"+tipocambio.getMonedaorigen());
    	System.out.println("destino:"+tipocambio.getMonedadestino());
        List<TipoCambio> lista = tipoCambioService.getMontoTipoCambio(tipocambio);
        System.out.println("size:"+lista.size());
        if(lista.size()==0) 
        	throw new ResourceNotFoundException("Tipo de cambio no encontrado:: " + tipocambio);
        
        ResTipoCambio response = new ResTipoCambio();
        response.setMonedaorigen(tipocambio.getMonedaorigen());
        response.setMonedadestino(tipocambio.getMonedadestino());        
        response.setMonto((double)Math.round(lista.get(0).getTipocambio()*tipocambio.getMonto()*100)/100);
        response.setTipocambio(lista.get(0).getTipocambio());
        return ResponseEntity.ok().body(response);
    }
   
}
