package com.betacom.service;

import com.betacom.dao.BiciclettaDao;
import com.betacom.entities.Bicicletta;
import com.betacom.interaface.ProcessInterface;
import com.betacom.singleton.DataBaseConfiguration;

public class BiciclettaService implements ProcessInterface {
	BiciclettaDao biciclettaDao = new BiciclettaDao();

	@Override
	public void execute() throws Exception {
		System.out.println("Bicicletta service start execute");
		DataBaseConfiguration istanzaDb = DataBaseConfiguration.getInstance();
		
		System.out.println("Db istanziato");
		
		Bicicletta bicicletta = new Bicicletta();
		bicicletta.setAnnoDiProduzione(2020);
		bicicletta.setIdAlimentazione(1);
		bicicletta.setIdCategoria(1);
		bicicletta.setIdColore(1);
		bicicletta.setMarca("Bmw");
		bicicletta.setModello("125d");
		bicicletta.setNumeroRuote(4);
		bicicletta.setTipoVeicolo("Macchina");
		bicicletta.setIdSospensione(1);
		bicicletta.setIdFreno(1);
		bicicletta.setNumeroMarce(21);
		
		
		inserisciBicicletta(istanzaDb.getBiciclettaQueryProperties("insert.bicicletta"), new Object[] {
				bicicletta.getTipoVeicolo(),
				bicicletta.getNumeroRuote(),
				bicicletta.getIdAlimentazione(),
				bicicletta.getIdCategoria(),
				bicicletta.getIdColore(),
				bicicletta.getMarca(),
				bicicletta.getAnnoDiProduzione(),
				bicicletta.getModello(),
				bicicletta.getNumeroMarce(),
				bicicletta.getIdFreno(),
				bicicletta.getIdSospensione()
				
		});
		
	}
	
	
	
	
	public int inserisciBicicletta(String query, Object[] params) throws Exception {
		return biciclettaDao.inserisciBicicletta(query, params);
	}

}
