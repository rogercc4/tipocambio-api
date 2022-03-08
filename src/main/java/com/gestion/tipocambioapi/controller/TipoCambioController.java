package com.gestion.tipocambioapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.tipocambioapi.dao.TipoCambioDAO;
import com.gestion.tipocambioapi.domain.TipoCambio;

@RestController
public class TipoCambioController {

	@Autowired
	private TipoCambioDAO tipoCambioDAO;	
	
	@GetMapping("/v1/tiposdecambio/{origen}-{destino}")
	public TipoCambio buscar(@PathVariable("origen") String codMonedaOrigen, 
							 @PathVariable("destino") String codMonedaDestino) {		
		
		TipoCambio.keyTipoCambio keyTipoCambio = new TipoCambio.keyTipoCambio();
		keyTipoCambio.setCodMonedaOrigen(codMonedaOrigen);
		keyTipoCambio.setCodMonedaDestino(codMonedaDestino);
		
		return this.tipoCambioDAO.findById(keyTipoCambio).get();
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