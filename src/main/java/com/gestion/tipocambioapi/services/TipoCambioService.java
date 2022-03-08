package com.gestion.tipocambioapi.services;

import com.gestion.tipocambioapi.domain.TipoCambio;

public interface TipoCambioService {
	
	void registrar(TipoCambio tipoCambio);
	
	void actualizar(TipoCambio tipoCambio);
	
	TipoCambio buscar(String codMonedaOrigen, String codMonedaDestino);	
}