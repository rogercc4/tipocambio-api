package com.gestion.tipocambioapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(TipoCambio.keyTipoCambio.class)
@Table(name="tipos_cambio")
public class TipoCambio implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8232568283429564373L;
	
	
	@Id
	@Column(name="cod_moneda_origen")
	private String codMonedaOrigen;
	
	@Id
	@Column(name="cod_moneda_destino")
	private String codMonedaDestino;	
	
	@Column(name="mnt_destino")
	private java.math.BigDecimal montoDestino;	
	
	@Column(name="fecha")
	private java.util.Date fecha;
	
	@Column(name="usuario")
	private String usuario;
	
	public String getCodMonedaOrigen() {
		return codMonedaOrigen;
	}
	public void setCodMonedaOrigen(String codMonedaOrigen) {
		this.codMonedaOrigen = codMonedaOrigen;
	}
	public String getCodMonedaDestino() {
		return codMonedaDestino;
	}
	public void setCodMonedaDestino(String codMonedaDestino) {
		this.codMonedaDestino = codMonedaDestino;
	}
	public java.math.BigDecimal getMontoDestino() {
		return montoDestino;
	}
	public void setMontoDestino(java.math.BigDecimal montoDestino) {
		this.montoDestino = montoDestino;
	}
	public java.util.Date getFecha() {
		return fecha;
	}
	public void setFecha(java.util.Date fecha) {
		this.fecha = fecha;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public static class keyTipoCambio implements java.io.Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 778162788584404730L;
		private String codMonedaOrigen;
		private String codMonedaDestino;
		public String getCodMonedaOrigen() {
			return codMonedaOrigen;
		}
		public void setCodMonedaOrigen(String codMonedaOrigen) {
			this.codMonedaOrigen = codMonedaOrigen;
		}
		public String getCodMonedaDestino() {
			return codMonedaDestino;
		}
		public void setCodMonedaDestino(String codMonedaDestino) {
			this.codMonedaDestino = codMonedaDestino;
		}
		
	}
	
}