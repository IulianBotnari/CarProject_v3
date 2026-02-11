package com.betacom;

import com.betacom.process.ExecuteProcess;

public class Application {

	public static void main(String[] args) {
		ExecuteProcess executeProcess = new ExecuteProcess();
		
		try {
			System.out.println("app execute");
			executeProcess.execute();
		} catch (Exception e) {
			
		}
		
	}

}
