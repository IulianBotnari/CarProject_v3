package com.betacom.service;

import com.betacom.dao.MacchinaDao;
import com.betacom.entities.Macchina;
import com.betacom.interaface.ProcessInterface;
import com.betacom.singleton.DataBaseConfiguration;

public class MacchinaService implements ProcessInterface{
	private MacchinaDao macchinaDao = new MacchinaDao();
	

	@Override
	public void execute() throws Exception {
		System.out.println("Macchina service start execute");
		DataBaseConfiguration istanzaDb = DataBaseConfiguration.getInstance();
		
		System.out.println("Db istanziato");
		
		Macchina macchina = new Macchina();
		macchina.setAnnoDiProduzione(2020);
		macchina.setCilindrata(2000);
		macchina.setIdAlimentazione(1);
		macchina.setIdCategoria(1);
		macchina.setIdColore(1);
		macchina.setMarca("Bmw");
		macchina.setModello("125d");
		macchina.setNumeroRuote(4);
		macchina.setPorte(5);
		macchina.setTarga("CX548SA");
		macchina.setTipoVeicolo("Macchina");
		
		System.out.println(macchina.toString());
		
		
		inserisciMacchina(istanzaDb.getMacchinaQueryProperties("insert.macchina"), new Object[] {
				macchina.getTipoVeicolo(),
				macchina.getNumeroRuote(),
				macchina.getIdAlimentazione(),
				macchina.getIdCategoria(),
				macchina.getIdColore(),
				macchina.getMarca(),
				macchina.getAnnoDiProduzione(),
				macchina.getModello(),
				macchina.getPorte(),
				macchina.getTarga(),
				macchina.getCilindrata()
				
		});
		
	} 

	
	
	public int inserisciMacchina(String query, Object[] params) throws Exception {
		return macchinaDao.inserisciMacchina(query, params);
	}


}
