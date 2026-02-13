package com.betacom.dao;

import java.util.List;

import com.betacom.singleton.DataBaseConfiguration;
import com.betacom.utils.SQLManager;

public class MotoDao {
	private SQLManager sqlManager = new SQLManager();
	
	
	public int inserisciMoto( List<Object> params) throws Exception {
		return sqlManager.save(DataBaseConfiguration.getInstance().getMacchinaQueryProperties("insert.moto"), params, "moto");
	}
	
	public int deleteMotoById(List<Object> params) throws Exception {
		return sqlManager.save(DataBaseConfiguration.getInstance().getMacchinaQueryProperties("delete.moto.byId"), params, "moto");
	}
}
