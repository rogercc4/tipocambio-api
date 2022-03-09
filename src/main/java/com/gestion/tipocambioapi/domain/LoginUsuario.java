package com.gestion.tipocambioapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login_usuario")
public class LoginUsuario {
	
	@Id
	@Column(name="usuario")
	private String usuario;
	
	@Column(name="clave")
	private String clave;	
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}

}