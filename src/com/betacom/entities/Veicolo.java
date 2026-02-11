package com.betacom.entities;

public abstract class Veicolo {
	private Integer idVeicolo;
	private String tipoVeicolo;
	private Integer numeroRuote;
	private Integer idAlimentazione;
	private Integer idCategoria;
	private Integer idColore;
	private String marca;
	private Integer annoDiProduzione;
	private String modello;
	public Integer getIdVeicolo() {
		return idVeicolo;
	}
	public void setIdVeicolo(Integer idVeicolo) {
		this.idVeicolo = idVeicolo;
	}
	public String getTipoVeicolo() {
		return tipoVeicolo;
	}
	public void setTipoVeicolo(String tipoVeicolo) {
		this.tipoVeicolo = tipoVeicolo;
	}
	public Integer getNumeroRuote() {
		return numeroRuote;
	}
	public void setNumeroRuote(Integer numeroRuote) {
		this.numeroRuote = numeroRuote;
	}
	public Integer getIdAlimentazione() {
		return idAlimentazione;
	}
	public void setIdAlimentazione(Integer idAlimentazione) {
		this.idAlimentazione = idAlimentazione;
	}
	public Integer getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	public Integer getIdColore() {
		return idColore;
	}
	public void setIdColore(Integer idColore) {
		this.idColore = idColore;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Integer getAnnoDiProduzione() {
		return annoDiProduzione;
	}
	public void setAnnoDiProduzione(Integer annoDiProduzione) {
		this.annoDiProduzione = annoDiProduzione;
	}
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	@Override
	public String toString() {
		return "Veicoli [idVeicolo=" + idVeicolo + ", tipoVeicolo=" + tipoVeicolo + ", numeroRuote=" + numeroRuote
				+ ", idAlimentazione=" + idAlimentazione + ", idCategoria=" + idCategoria + ", idColore=" + idColore
				+ ", marca=" + marca + ", annoDiProduzione=" + annoDiProduzione + ", modello=" + modello + "]";
	}
	
	

}
