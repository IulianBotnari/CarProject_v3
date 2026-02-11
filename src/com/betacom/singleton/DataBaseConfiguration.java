package com.betacom.singleton;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.betacom.utils.SQLManager;

public class DataBaseConfiguration {
	
	private static DataBaseConfiguration dataBaseConfiguration = null;
	private static Properties dbProperties = new Properties();
	private static Properties macchinaQueryProperties = new Properties();
	private static Properties motoQueryProperties = new Properties();
	private static Properties biciclettaQueryProperties = new Properties();
	private  SQLManager sqlManager = new SQLManager();
	private Connection connection = null;
	
	private DataBaseConfiguration() {}
	
	public static DataBaseConfiguration getInstance() throws Exception{
		if(dataBaseConfiguration == null) {
			dataBaseConfiguration = new DataBaseConfiguration();
			loadConfiguration();
		}
		
		return dataBaseConfiguration;
	}
	
	
	private static void loadConfiguration() throws Exception{
		
		try {
			FileInputStream inputDbProperties = new FileInputStream("src/sql.properties");
			dbProperties.load(inputDbProperties);
			FileInputStream inputMacchinaQueryProperties = new FileInputStream("src/macchina_query.properties");
			macchinaQueryProperties.load(inputMacchinaQueryProperties);
			
			FileInputStream inputMotoQueryProperties = new FileInputStream("src/moto_query.properties");
			motoQueryProperties.load(inputMotoQueryProperties);
			
			FileInputStream inputBiciclettaQueryProperties = new FileInputStream("src/bicicletta_query.properties");
			biciclettaQueryProperties.load(inputBiciclettaQueryProperties);
			
			
		} catch (Exception e) {
			System.out.println("Errore durante il caricamento file properties: " + e.getMessage());
		}
		
	}
	
	public Connection getConnection() throws Exception{
		try {
			if (connection == null) {
				connection = sqlManager.getConnection();
			}
		} catch (Exception e) {
			System.out.println("Tentativo di conessione al db fallito: " + e.getMessage());
		}
		
		return connection;
	}
	
	public String getDbProperties(String proprieta) {
		return dbProperties.getProperty(proprieta);
	}
	
	public String getMacchinaQueryProperties(String proprieta) {
		return macchinaQueryProperties.getProperty(proprieta);
	}
	
	
	public String getMotoQueryProperties(String proprieta) {
		return motoQueryProperties.getProperty(proprieta);
	}
	
	public String getBiciclettaQueryProperties(String proprieta) {
		return biciclettaQueryProperties.getProperty(proprieta);
	}
	
	public void setAutoCommit(boolean value) throws SQLException {
		connection.setAutoCommit(value);
	}
	

}
