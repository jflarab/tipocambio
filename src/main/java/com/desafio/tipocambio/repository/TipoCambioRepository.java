package com.desafio.tipocambio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.desafio.tipocambio.model.TipoCambio;

@Repository
public interface TipoCambioRepository extends JpaRepository<TipoCambio,Long> {
	@Query(value = "SELECT * FROM tipocambio t WHERE t.monedaorigen = ?1 AND t.monedadestino= ?2", nativeQuery=true)
	public List<TipoCambio> getMontoTipoCambio(String monedaOrigen, String monedaDestino);
}
