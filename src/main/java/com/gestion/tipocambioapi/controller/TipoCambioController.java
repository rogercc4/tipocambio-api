package com.gestion.tipocambioapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.tipocambioapi.dao.TipoCambioDAO;
import com.gestion.tipocambioapi.domain.TipoCambio;
import com.gestion.tipocambioapi.services.TipoCambioService;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

@RestController
public class TipoCambioController {

	@Autowired
	private TipoCambioDAO tipoCambioDAO;
	
	@Autowired
	private TipoCambioService tipoCambioService;
	
	@GetMapping("/v1/tiposdecambio/{origen}-{destino}")
	public Single<ResponseEntity<TipoCambio>> buscar(@PathVariable("origen") String codMonedaOrigen, 
							 											@PathVariable("destino") String codMonedaDestino) {		
		return this.tipoCambioService.buscar(codMonedaOrigen, codMonedaDestino)
				.subscribeOn(Schedulers.io())
				.map(tipoCambioResponse -> ResponseEntity.ok(tipoCambioResponse));		
	}
	
	@PostMapping("/v1/tiposdecambio")
	public TipoCambio buscar(@RequestBody TipoCambio tipoCambio) {
		tipoCambio.setFecha(new java.util.Date());
		return tipoCambioDAO.save(tipoCambio);
	}
	
	@PutMapping("/v1/tiposdecambio")
	public TipoCambio actualizar(@RequestBody TipoCambio tipoCambio) {
		tipoCambio.setFecha(new java.util.Date());
		return tipoCambioDAO.save(tipoCambio);
	}
	
}