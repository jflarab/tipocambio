package com.desafio.tipocambio;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.http.ResponseEntity;

import com.desafio.tipocambio.exception.ResourceNotFoundException;
import com.desafio.tipocambio.model.ReqTipoCambio;
import com.desafio.tipocambio.model.ResTipoCambio;
import com.desafio.tipocambio.model.TipoCambio;
import com.desafio.tipocambio.repository.TipoCambioRepository;

//@SpringBootTest
@RunWith(SpringRunner.class)
@DataJpaTest
public class TipocambioApplicationTests {
	@Autowired
    private TipoCambioRepository repository;
	
	@Test
	public void getMontoTipoCambio() {	        
			
	        ReqTipoCambio tipoCambio = getTipoCambio();
	        List<TipoCambio> lista = repository.getMontoTipoCambio(tipoCambio.getMonedaorigen(), tipoCambio.getMonedadestino());
	        System.out.println("size:"+lista.size());
	        Assert.assertTrue(lista.size()>0);
	    }

	private ReqTipoCambio getTipoCambio() {
	    
		ReqTipoCambio reqTipoCambio = new ReqTipoCambio();
		reqTipoCambio.setMonedaorigen("USD");
		reqTipoCambio.setMonedadestino("SOL");
		reqTipoCambio.setMonto(10.0);	
	    return reqTipoCambio;
	  }
}
