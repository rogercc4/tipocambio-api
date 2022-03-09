package com.gestion.tipocambioapi.dao;

import org.springframework.data.repository.CrudRepository;

import com.gestion.tipocambioapi.domain.LoginUsuario;

public interface LoginDAO extends CrudRepository<LoginUsuario, String> {

}
