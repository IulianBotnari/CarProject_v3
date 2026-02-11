package com.betacom.utils;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.betacom.singleton.DataBaseConfiguration;


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
	
	
	private PreparedStatement createSet(PreparedStatement pstm, Object[] params) {
		
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
	
	
	public List<Map<String, Object>> lista (String query, Object[] params) throws Exception{
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
	
	
	
	public int save(String query, Object[] params, String nomeTabella)throws Exception{
		if (query == null || params.length < 1) {
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
		
				Object[] paramsPerQueryUno = Arrays.copyOfRange(params, 0, params.length - numeroColonne +2);
				Object[] paramsRimanenti = Arrays.copyOfRange(params, paramsPerQueryUno.length, params.length);
			

				
				PreparedStatement pstm = this.getConnection().prepareStatement(querySuperClasse, java.sql.Statement.RETURN_GENERATED_KEYS);
				pstm = createSet(pstm, paramsPerQueryUno);
				pstm.executeUpdate();
				
				ResultSet resultSet = pstm.getGeneratedKeys();
				
				int idVeicolo = 0;
				
				if (resultSet.next()) {
					idVeicolo = resultSet.getInt(1);
				}
				
				Object[] paramsPerQueryDue = new Object[paramsRimanenti.length + 1];
				paramsPerQueryDue[0] = idVeicolo;
				for (int i = 1; i < paramsPerQueryDue.length; i++) {
					paramsPerQueryDue[i] = paramsRimanenti[i -1];
				}
				
				PreparedStatement pstm2 = this.getConnection().prepareStatement(querySottoClasse);
				pstm2 = createSet(pstm2, paramsPerQueryDue);
				risultato = pstm2.executeUpdate();
				
				
				DataBaseConfiguration.getInstance().getConnection().commit();;

			} catch (Exception e) {
				System.out.println("Errore durante il salvataggio: " + e.getMessage());
				e.printStackTrace();
			}
			
			
		} else {
			try {
				PreparedStatement pstm = this.getConnection().prepareStatement(query);
				pstm = createSet(pstm, params);
				risultato = pstm.executeUpdate();
				
			
				
			} catch (Exception e) {
				System.out.println("Errore durante il salvataggio: " + e.getMessage());
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
	
}
