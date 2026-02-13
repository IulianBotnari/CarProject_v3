package com.betacom.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
		
		List<Object> listaParametri = new ArrayList<Object>();
		listaParametri.add(moto.getTipoVeicolo());
		listaParametri.add(moto.getNumeroRuote());
		listaParametri.add(moto.getIdAlimentazione());
		listaParametri.add(moto.getIdCategoria());
		listaParametri.add(moto.getIdColore());
		listaParametri.add(moto.getMarca());
		listaParametri.add(moto.getAnnoDiProduzione());
		listaParametri.add(moto.getModello());
		listaParametri.add(moto.getTarga());
		listaParametri.add(moto.getCilindrata());
		
		inserisciMoto(listaParametri);
	}
	
	
	public int inserisciMoto(List<Object> params) throws Exception {
		return motoDao.inserisciMoto(params);
	}
	
	public int deleteMotoById(String query, List<Object> params) throws Exception {
		return motoDao.deleteMotoById(params);
	}
	

}
