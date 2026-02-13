package com.betacom.dao;

import java.util.List;

import com.betacom.singleton.DataBaseConfiguration;
import com.betacom.utils.SQLManager;

public class BiciclettaDao {
	private SQLManager sqlManager = new SQLManager();
	
	
	public int inserisciBicicletta(List<Object> params) throws Exception {
		return sqlManager.save(DataBaseConfiguration.getInstance().getBiciclettaQueryProperties("insert.bicicletta"), params, "biciclette");
	}
	
	public int deleteBiciclettaById(List<Object> params) throws Exception {
		return sqlManager.save(DataBaseConfiguration.getInstance().getBiciclettaQueryProperties("delete.bicicletta.byId"), params, "biciclette");
	}
}
