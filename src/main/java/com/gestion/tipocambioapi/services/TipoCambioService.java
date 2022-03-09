package com.gestion.tipocambioapi.services;

import java.util.List;

import com.gestion.tipocambioapi.domain.TipoCambio;

import io.reactivex.Single;

public interface TipoCambioService {
	
	void registrar(TipoCambio tipoCambio);
	
	void actualizar(TipoCambio tipoCambio);
	
	Single<TipoCambio> buscar(String codMonedaOrigen, String codMonedaDestino);	
	
	Single<List<TipoCambio>> listar();
}