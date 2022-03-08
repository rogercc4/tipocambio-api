package com.gestion.tipocambioapi.services.impl;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.tipocambioapi.dao.TipoCambioDAO;
import com.gestion.tipocambioapi.domain.TipoCambio;
import com.gestion.tipocambioapi.services.TipoCambioService;

import io.reactivex.Single;

@Service
public class TipoCambioServiceImpl implements TipoCambioService {

	@Autowired
	private TipoCambioDAO tipoCambioDAO;
	
	
	@Override
	public void registrar(TipoCambio tipoCambio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(TipoCambio tipoCambio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Single<TipoCambio> buscar(String codMonedaOrigen, String codMonedaDestino) {
		return Single.create(singleSubscriber -> {
			TipoCambio.keyTipoCambio keyTipoCambio = new TipoCambio.keyTipoCambio();
			keyTipoCambio.setCodMonedaOrigen(codMonedaOrigen);
			keyTipoCambio.setCodMonedaDestino(codMonedaDestino);
			Optional<TipoCambio> optionalTipoCambio = this.tipoCambioDAO.findById(keyTipoCambio);
			
			if ( !optionalTipoCambio.isPresent() ) {
				singleSubscriber.onError(new EntityNotFoundException());
			} else {
				singleSubscriber.onSuccess(optionalTipoCambio.get());
			}
		});
	}
}
