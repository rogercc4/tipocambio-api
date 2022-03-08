package com.gestion.tipocambioapi.controller;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.gestion.tipocambioapi.model.Mensaje;

@RestControllerAdvice
public class ExceptionRestController {
	
	 @ExceptionHandler(EntityNotFoundException.class)
	 public ResponseEntity<Mensaje> handleEntityNotFoundException() {
		 	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Mensaje.build("001", "Tipo de cambio no encontrado"));
	 }
	 
}
