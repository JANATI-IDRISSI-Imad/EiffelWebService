package fr.uge.business;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import commun.ILocationService;

public class MainServeur {
	
	public MainServeur() {
		try {
			LocateRegistry.createRegistry(1099);
			ILocationService service = new ILocationServiceJdbc();
			Naming.rebind("eiffel", service);
			System.out.println("Service RMI partage Université Gustave Eiffel bien demarré");
		} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		new MainServeur();
	}

}
