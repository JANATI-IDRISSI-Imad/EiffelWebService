package fr.uge.dao;

import java.rmi.RemoteException;

import commun.Utilisateur;

public interface UtilisateurDAO {
	public String Authentification(String email,String password)  throws RemoteException;
	public Utilisateur GetUtilisateurById(int id)  throws RemoteException;
	public Utilisateur GetUtilisateurByEmail(String email)  throws RemoteException;
}
