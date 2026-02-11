package com.betacom.service;

import com.betacom.dao.MotoDao;
import com.betacom.entities.Moto;
import com.betacom.interaface.ProcessInterface;
import com.betacom.singleton.DataBaseConfiguration;

public class MotoService implements ProcessInterface{
	MotoDao motoDao = new MotoDao();
	@Override
	public void execute() throws Exception {
		System.out.println("Moto service start execute");
		DataBaseConfiguration istanzaDb = DataBaseConfiguration.getInstance();
		
		System.out.println("Db istanziato");
		
		Moto moto = new Moto();
		moto.setAnnoDiProduzione(2020);
		moto.setCilindrata(2000);
		moto.setIdAlimentazione(1);
		moto.setIdCategoria(1);
		moto.setIdColore(1);
		moto.setMarca("Yamaha");
		moto.setModello("R6");
		moto.setNumeroRuote(2);
		moto.setTarga("CX548SA");
		moto.setTipoVeicolo("Moto");
		
		
		
		inserisciMoto(istanzaDb.getMotoQueryProperties("insert.moto"), new Object[] {
				moto.getTipoVeicolo(),
				moto.getNumeroRuote(),
				moto.getIdAlimentazione(),
				moto.getIdCategoria(),
				moto.getIdColore(),
				moto.getMarca(),
				moto.getAnnoDiProduzione(),
				moto.getModello(),
				moto.getTarga(),
				moto.getCilindrata()
				
		});
	}
	
	
	public int inserisciMoto(String query, Object[] params) throws Exception {
		return motoDao.inserisciMoto(query, params);
	}

}
