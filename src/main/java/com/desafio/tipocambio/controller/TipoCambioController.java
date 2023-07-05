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
import com.desafio.tipocambio.dto.ReqMontoTipoCambio;
import com.desafio.tipocambio.dto.ResMontoTipoCambio;
import com.desafio.tipocambio.dto.ResTipoCambio;
import com.desafio.tipocambio.exception.ResourceNotFoundException;
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
    public List<ResTipoCambio> getAllTipoCambios() {
        logger.info("Get all the TipoCambio...");
        return tipoCambioService.getAllTipoCambios();
    }

    @PostMapping("/tipocambio/monto")
    public ResponseEntity<ResMontoTipoCambio> getMontoTipoCambio(@RequestBody ReqMontoTipoCambio tipocambio) throws ResourceNotFoundException {
    	logger.info("Get MontoTipoCambio...");
    	ResMontoTipoCambio response = tipoCambioService.getMontoTipoCambio(tipocambio);        
        return ResponseEntity.ok().body(response);
    }
   
}
