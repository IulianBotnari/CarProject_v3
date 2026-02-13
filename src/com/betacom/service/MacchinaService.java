package com.betacom.service;

import java.util.ArrayList;
import java.util.List;

import com.betacom.dao.MacchinaDao;
import com.betacom.entities.Macchina;
import com.betacom.interaface.ProcessInterface;
import com.betacom.singleton.DataBaseConfiguration;

public class MacchinaService implements ProcessInterface{
	private MacchinaDao macchinaDao = new MacchinaDao();
	

	@Override
	public void execute() throws Exception {
		System.out.println("Macchina service start execute");
	
		
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
		
		//System.out.println(macchina.toString());
		List<Object> listaParametri = new ArrayList<Object>();
		/*listaParametri.add(macchina.getTipoVeicolo());
		listaParametri.add(macchina.getNumeroRuote());
		listaParametri.add(macchina.getIdAlimentazione());
		listaParametri.add(macchina.getIdCategoria());
		listaParametri.add(macchina.getIdColore());
		listaParametri.add(macchina.getMarca());
		listaParametri.add(macchina.getAnnoDiProduzione());
		listaParametri.add(macchina.getModello());
		listaParametri.add(macchina.getPorte());
		listaParametri.add(macchina.getTarga());
		listaParametri.add(macchina.getCilindrata());*/
		
		listaParametri.add(1);
		Macchina macchinaTrovata = findMacchinaById(listaParametri);
		
		System.out.println(macchinaTrovata.toString());
		
	} 

	
	
	public int inserisciMacchina(List<Object> params) throws Exception {
		return macchinaDao.inserisciMacchina(params);
	}
	
	
	public int deleteMacchinaById( List<Object> params) throws Exception {
		return macchinaDao.deleteMacchinaById(params);
	}
	
	public Macchina findMacchinaById(List<Object> params) throws Exception{
		
		return macchinaDao.findMacchinaById(params);
	
	}


}
