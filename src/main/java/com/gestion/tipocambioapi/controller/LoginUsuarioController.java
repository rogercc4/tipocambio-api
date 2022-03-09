package com.gestion.tipocambioapi.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.tipocambioapi.model.Mensaje;
import com.gestion.tipocambioapi.model.UsuarioToken;
import com.gestion.tipocambioapi.services.LoginUsuarioService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class LoginUsuarioController {	
	
	@Autowired
	private LoginUsuarioService loginUsuarioService;
	
	@PostMapping("validarlogin")
	public ResponseEntity<?> login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
		
		boolean isLoginValido = this.loginUsuarioService.isLoginValido(username, pwd);
		
		if ( !isLoginValido ) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(Mensaje.build("001", "Usuario o clave incorrecta"));
		}
		
		String token = getJWTToken(username);
		UsuarioToken user = new UsuarioToken();
		user.setUser(username);
		user.setToken(token);
		return ResponseEntity.ok(user);
	}
	
	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("ApiTipoCambioJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 3600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return token;
	}

}
