package com.betacom.dao;

import com.betacom.utils.SQLManager;

public class BiciclettaDao {
	private SQLManager sqlManager = new SQLManager();
	
	
	public int inserisciBicicletta(String query, Object[] params) throws Exception {
		return sqlManager.save(query, params, "biciclette");
	}
}
