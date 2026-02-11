package com.betacom.dao;

import com.betacom.utils.SQLManager;

public class MacchinaDao {
	
	private SQLManager sqlManager = new SQLManager();
	
	
	public int inserisciMacchina(String query, Object[] params) throws Exception {
		return sqlManager.save(query, params, "macchine");
	}

}
