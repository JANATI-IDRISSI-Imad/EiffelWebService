package fr.uge.dao;

import java.rmi.Remote;
import java.rmi.RemoteException;

import commun.ListeAttente;
import commun.Utilisateur;

public interface ListAttenteDao extends Remote {

	public ListeAttente AfficherListeAttenteByVoiture(int idVoiture)  throws RemoteException;
	public Utilisateur UtilisateurPrioritaire(ListeAttente a)  throws RemoteException;
	public void TraitementListAttente(int idVoiture)  throws RemoteException;
}
