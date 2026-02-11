package com.betacom.dao;

import com.betacom.utils.SQLManager;

public class MotoDao {
	private SQLManager sqlManager = new SQLManager();
	
	
	public int inserisciMoto(String query, Object[] params) throws Exception {
		return sqlManager.save(query, params, "moto");
	}
}
