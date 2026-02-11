package com.betacom.entities;

public class Macchina extends Veicolo{
	private Integer idMacchina;
	private Integer idVeicolo;
	private Integer porte;
	private String targa;
	private Integer cilindrata;
	
	public Macchina() {}
	
	public Macchina(Integer idMacchina, Integer idVeicolo, Integer porte,String targa, Integer cilindrata) {
		super();
		this.idMacchina = idMacchina;
		this.idVeicolo = idVeicolo;
		this.porte = porte;
		this.targa = targa;
		this.cilindrata = cilindrata;
	}

	public Integer getIdMacchina() {
		return idMacchina;
	}
	public void setIdMacchina(Integer idMacchina) {
		this.idMacchina = idMacchina;
	}
	public Integer getIdVeicolo() {
		return idVeicolo;
	}
	public void setIdVeicolo(Integer idVeicolo) {
		this.idVeicolo = idVeicolo;
	}
	public Integer getPorte() {
		return porte;
	}
	public void setPorte(Integer porte) {
		this.porte = porte;
	}
	public String getTarga() {
		return targa;
	}
	public void setTarga(String targa) {
		this.targa = targa;
	}
	public Integer getCilindrata() {
		return cilindrata;
	}
	public void setCilindrata(Integer cilindrata) {
		this.cilindrata = cilindrata;
	}

	@Override
	public String toString() {
		return "Macchina [idMacchina=" + idMacchina + ", idVeicolo=" + idVeicolo + ", porte=" + porte + ", targa="
				+ targa + ", cilindrata=" + cilindrata + ", toString()=" + super.toString() + "]";
	}
	
	

}
