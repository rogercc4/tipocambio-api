package com.gestion.tipocambioapi.dao;

import org.springframework.data.repository.CrudRepository;

import com.gestion.tipocambioapi.domain.TipoCambio;

public interface TipoCambioDAO extends CrudRepository<TipoCambio, TipoCambio.keyTipoCambio> {

}
