package com.gestion.tipocambioapi.model;

public class Mensaje {
	
	private String cod;
	private String msg;
	
	public static Mensaje build(String newCod, String newMsg) {
		Mensaje rpta = new Mensaje();
		rpta.setCod(newCod);
		rpta.setMsg(newMsg);
		return rpta;
	}
	
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}	

}
