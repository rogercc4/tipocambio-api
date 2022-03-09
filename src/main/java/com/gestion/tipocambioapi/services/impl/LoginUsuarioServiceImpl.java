package com.gestion.tipocambioapi.services.impl;

import java.security.MessageDigest;
import java.util.Optional;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.tipocambioapi.dao.LoginDAO;
import com.gestion.tipocambioapi.domain.LoginUsuario;
import com.gestion.tipocambioapi.services.LoginUsuarioService;

@Service
public class LoginUsuarioServiceImpl implements LoginUsuarioService {

	@Autowired
	private LoginDAO loginDAO;
	
	
	@Override
	public boolean isLoginValido(String user, String passwd) {
		Optional<LoginUsuario> optLoginUsuario = this.loginDAO.findById(user);
		
		if ( !optLoginUsuario.isPresent() ) {
			return false;
		}
		
		LoginUsuario loginUsuario = optLoginUsuario.get();
		
		String passwdEncrypt = this.getPasswdEcrypt(passwd);
		
		return passwdEncrypt.equalsIgnoreCase(loginUsuario.getClave());
	}
	
	
	private String getPasswdEcrypt(String password)  {
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
		    md.update(password.getBytes());
		    byte[] digest = md.digest();
		    return DatatypeConverter.printHexBinary(digest);
		} catch ( java.lang.Exception ex ) {
			return null;
		}
		
		
	    
	}

}