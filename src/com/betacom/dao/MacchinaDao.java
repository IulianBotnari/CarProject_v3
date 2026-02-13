package com.betacom.dao;

import java.util.List;
import java.util.Map;

import com.betacom.entities.Macchina;
import com.betacom.singleton.DataBaseConfiguration;
import com.betacom.utils.SQLManager;

public class MacchinaDao {
	
	private SQLManager sqlManager = new SQLManager();
	
	
	public int inserisciMacchina(List<Object> params) throws Exception {
		return sqlManager.save(DataBaseConfiguration.getInstance().getMacchinaQueryProperties("insert.macchina"), params, "macchine");
	}
	
	public int deleteMacchinaById( List<Object> params) throws Exception {
		return sqlManager.save(DataBaseConfiguration.getInstance().getMacchinaQueryProperties("delete.macchina.byId"), params, "macchine");
	}
	
	public Macchina findMacchinaById(List<Object> params) throws Exception {
		
		Macchina macchina = new Macchina();
		
		Map<String,Object> mapResult = sqlManager.getObject(DataBaseConfiguration.getInstance().getMacchinaQueryProperties("find.macchina.byId"), params);
		
	
		macchina.setIdMacchina((Integer)mapResult.get("id_macchina"));
		macchina.setIdVeicolo((Integer)mapResult.get("id_veicolo"));
		macchina.setAnnoDiProduzione((Integer) mapResult.get("anno_produzione"));
		macchina.setCilindrata((Integer) mapResult.get("cilindrata"));
		macchina.setIdAlimentazione((Integer) mapResult.get("id_alimentazione"));
		macchina.setIdCategoria((Integer) mapResult.get("id_categoria"));
		macchina.setIdColore((Integer) mapResult.get("id_colore"));
		macchina.setMarca((String) mapResult.get("marca"));
		macchina.setModello((String) mapResult.get("modello"));
		macchina.setNumeroRuote((Integer) mapResult.get("numero_ruote"));
		macchina.setPorte((Integer) mapResult.get("porte"));
		macchina.setTarga((String) mapResult.get("targa"));
		macchina.setTipoVeicolo((String) mapResult.get("tipo_veicolo"));
			
		
		
		
		return macchina;
	}

}
