package com.betacom.utils;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.betacom.singleton.DataBaseConfiguration;

import java.sql.Statement;


public class SQLManager {

	
	public Connection getConnection() throws Exception{
		Connection connection = null;
		
		Class.forName(DataBaseConfiguration.getInstance().getDbProperties("driver"));
		
		
		try {
			connection = DriverManager.getConnection(
					DataBaseConfiguration.getInstance().getDbProperties("url"),
					DataBaseConfiguration.getInstance().getDbProperties("user"),
					DataBaseConfiguration.getInstance().getDbProperties("password")
					);
		} catch (Exception e) {
			System.out.println("Errore durante la configurazione della conessione al database: " + e.getMessage());
		}
		
		return connection;
	}
	
	
	public List<Map<String, Object>> resultSetToList(ResultSet resultSet) throws SQLException{
		ResultSetMetaData metaData = resultSet.getMetaData();
		int numeroColonne = metaData.getColumnCount();
		List<Map<String, Object>> rows = new ArrayList<Map<String,Object>>();
		while (resultSet.next()) {
			Map<String,Object> row = new HashMap<String, Object>();
			for (int i = 1; i<=numeroColonne; i++) {
				row.put(metaData.getColumnLabel(i), resultSet.getObject(i));
			}
			
			rows.add(row);
		}
		return rows;
	}
	
	
	private PreparedStatement createSet(PreparedStatement pstm, List<Object> params) {
		
		int idx = 1;
		
		for (Object element : params) {
			try {
				pstm.setObject(idx++, element);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}

		return pstm;
	}
	
	
	public List<Map<String, Object>> lista (String query, List<Object> params) throws Exception{
		try {
			PreparedStatement pstm = DataBaseConfiguration.getInstance().getConnection().prepareStatement(query);
			pstm = createSet(pstm, params);
			ResultSet resultSet = pstm.executeQuery();
			return resultSetToList(resultSet);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Errore durante il recupero della lista dal db" + e.getMessage());
		
		}
	
	}
	
	
	
	public int save(String query, List<Object> params, String nomeTabella)throws Exception{
		if (query == null || params.size() < 1) {
			throw new Exception("Query non trovata oppure parametri non trovati");
		};
		int numeroColonne = getNumeroColonneTabella(nomeTabella);
		System.out.println("numero colonne macchina: " + numeroColonne);
		int risultato = 0;
		
		
		String[] splitQuery = null;
		String querySuperClasse = null;
		String querySottoClasse = null;
		
		if (query.contains(";")) {
			try {
				splitQuery = query.split(";");	
				
				querySuperClasse = splitQuery[0];
				System.out.println("Query per veicolo: " + querySuperClasse);
				querySottoClasse = splitQuery[1];
				System.out.println("Query per macchina: " + querySottoClasse);
				
				DataBaseConfiguration.getInstance().getConnection().setAutoCommit(false);
		
				List<Object> paramsPerQueryUno = new ArrayList<Object>(params.subList(0, params.size() - numeroColonne + 2));
				List<Object> paramsPerQueryDue = new ArrayList<Object>(params.subList(paramsPerQueryUno.size(), params.size()));
			

				
				PreparedStatement pstm = this.getConnection().prepareStatement(querySuperClasse, Statement.RETURN_GENERATED_KEYS);
				pstm = createSet(pstm, paramsPerQueryUno);
				pstm.executeUpdate();
				
				ResultSet resultSet = pstm.getGeneratedKeys();
				
				if (resultSet.next()) {
					risultato = resultSet.getInt(1);
				}
				
				paramsPerQueryDue.add(0, risultato);
				
				PreparedStatement pstm2 = this.getConnection().prepareStatement(querySottoClasse);
				pstm2 = createSet(pstm2, paramsPerQueryDue);
				risultato = pstm2.executeUpdate();
		
				DataBaseConfiguration.getInstance().getConnection().commit();;

			} catch (Exception e) {
				System.out.println("Errore durante il salvataggio: " + e.getMessage());
				DataBaseConfiguration.getInstance().getConnection().rollback();
				e.printStackTrace();
			} finally {
				DataBaseConfiguration.getInstance().getConnection().setAutoCommit(true);
			}
			
			
		} else {
			try {
				PreparedStatement pstm = this.getConnection().prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
				pstm = createSet(pstm, params);
				risultato = pstm.executeUpdate();
										
			} catch (Exception e) {
				System.out.println("Errore durante il salvataggio: " + e.getMessage());
				e.printStackTrace();
			}
			
		}
		
		return risultato;
	}
	
	
	private int getNumeroColonneTabella(String nomeTabella) throws SQLException, Exception {
		DatabaseMetaData dbmd = this.getConnection().getMetaData();
		
		ResultSet rs = dbmd.getColumns(null, null, nomeTabella, null);
		int numeroColonne = 0;
		
		while(rs.next()) {
			numeroColonne++;
		}
		
		return numeroColonne;
	}
	
	
	public Map<String, Object> getObject (String query, List<Object> params) throws Exception{
		try {
			PreparedStatement pstm = DataBaseConfiguration.getInstance().getConnection().prepareStatement(query);
			pstm = createSet(pstm, params);
			ResultSet resultSet = pstm.executeQuery();
			return resultSetToMap(resultSet);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		
		}
		
	
	}
	
	
	public Map<String, Object> resultSetToMap(ResultSet resultSet) throws SQLException{
		ResultSetMetaData metaData = resultSet.getMetaData();
		int numeroColonne = metaData.getColumnCount();
		Map<String, Object> map = new HashMap<String,Object>();
		while (resultSet.next()) {

			for (int i = 1; i<=numeroColonne; i++) {
				map.put(metaData.getColumnName(i), resultSet.getObject(i));
			}
	
		}
		return map;
	}
	
}
