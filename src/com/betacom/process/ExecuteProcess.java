package com.betacom.process;

import java.util.HashMap;
import java.util.Map;

import com.betacom.interaface.ProcessInterface;
import com.betacom.service.BiciclettaService;
import com.betacom.service.MacchinaService;
import com.betacom.service.MotoService;

public class ExecuteProcess {
	
	
	public void execute() {
		
		
		String key = "bicicletta";
		
		Map<String, ProcessInterface> mappaProcessi = new HashMap<String, ProcessInterface>();
		
		mappaProcessi.put("macchina", new MacchinaService());
		mappaProcessi.put("moto", new MotoService());
		mappaProcessi.put("bicicletta", new BiciclettaService());
		ProcessInterface process = null;
		
		for(Map.Entry<String, ProcessInterface> entry : mappaProcessi.entrySet()) {
			
			if (entry.getKey().equals(key)) {
				process = entry.getValue();
				break;
			}
			
		}
		

		
		try {
			process.execute();
		} catch (Exception e) {
			System.err.println("Errore durante l'avvio del processo: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	

}
