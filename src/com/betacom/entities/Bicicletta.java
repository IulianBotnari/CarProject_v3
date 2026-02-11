package com.betacom.entities;

public class Bicicletta extends Veicolo{
	
	private Integer idBicicletta;
	private Integer numeroMarce;
	private Integer idVeicolo;
	private Integer idFreno;
	private Integer idSospensione;
	
	
	public Bicicletta() {}
	
	public Bicicletta(Integer idBicicletta, Integer numeroMarce, Integer idVeicolo, Integer idFreno,
			Integer idSospensione) {
		super();
		this.idBicicletta = idBicicletta;
		this.numeroMarce = numeroMarce;
		this.idVeicolo = idVeicolo;
		this.idFreno = idFreno;
		this.idSospensione = idSospensione;
	}
	public Integer getIdBicicletta() {
		return idBicicletta;
	}
	public void setIdBicicletta(Integer idBicicletta) {
		this.idBicicletta = idBicicletta;
	}
	public Integer getNumeroMarce() {
		return numeroMarce;
	}
	public void setNumeroMarce(Integer numeroMarce) {
		this.numeroMarce = numeroMarce;
	}
	public Integer getIdVeicolo() {
		return idVeicolo;
	}
	public void setIdVeicolo(Integer idVeicolo) {
		this.idVeicolo = idVeicolo;
	}
	public Integer getIdFreno() {
		return idFreno;
	}
	public void setIdFreno(Integer idFreno) {
		this.idFreno = idFreno;
	}
	public Integer getIdSospensione() {
		return idSospensione;
	}
	public void setIdSospensione(Integer idSospensione) {
		this.idSospensione = idSospensione;
	}
	@Override
	public String toString() {
		return "Bicicletta [idBicicletta=" + idBicicletta + ", numeroMarce=" + numeroMarce + ", idVeicolo=" + idVeicolo
				+ ", idFreno=" + idFreno + ", idSospensione=" + idSospensione + ", toString()=" + super.toString()
				+ "]";
	}
	
	

}
