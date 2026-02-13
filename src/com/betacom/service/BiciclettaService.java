package com.betacom.service;

import java.util.ArrayList;
import java.util.List;

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
		bicicletta.setMarca("BMX");
		bicicletta.setModello("125d");
		bicicletta.setNumeroRuote(4);
		bicicletta.setTipoVeicolo("xxx");
		bicicletta.setIdSospensione(1);
		bicicletta.setIdFreno(1);
		bicicletta.setNumeroMarce(21);
		
		
		List<Object> listaParametri = new ArrayList<Object>();
		listaParametri.add(bicicletta.getTipoVeicolo());
		listaParametri.add(bicicletta.getNumeroRuote());
		listaParametri.add(bicicletta.getIdAlimentazione());
		listaParametri.add(bicicletta.getIdCategoria());
		listaParametri.add(bicicletta.getIdColore());
		listaParametri.add(bicicletta.getMarca());
		listaParametri.add(bicicletta.getAnnoDiProduzione());
		listaParametri.add(bicicletta.getModello());
		listaParametri.add(bicicletta.getNumeroMarce());
		listaParametri.add(bicicletta.getIdFreno());
		listaParametri.add(bicicletta.getIdSospensione());
		
		listaParametri.add(21);
		
		inserisciBicicletta(listaParametri);
		deleteBiciclettaById(listaParametri);
	}
	
	
	
	
	public int inserisciBicicletta(List<Object> params) throws Exception {
		return biciclettaDao.inserisciBicicletta(params);
	}
	
	
	public int deleteBiciclettaById(List<Object> params) throws Exception {
		return biciclettaDao.deleteBiciclettaById(params);
	}

}
