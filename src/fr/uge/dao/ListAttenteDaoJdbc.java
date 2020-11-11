package fr.uge.dao;

import java.rmi.RemoteException;

import commun.DemandeLocation;
import commun.ListeAttente;
import commun.Utilisateur;
import fr.uge.dao.jdbc.Database;

public class ListAttenteDaoJdbc implements ListAttenteDao{

	private Database db;
	private VoitureDao voitureDao;
	private UtilisateurDAO utilisateurDao;
	//Makamlach khassna DemandelocationDao
	//notificationDao sawebtha
	
	
	
	@Override
	public ListeAttente AfficherListeAttenteByVoiture(int idVoiture) throws RemoteException {
		//ListeAttente listA = new ListeAttente(idVoiture,);
		return null;
	}

	@Override
	public Utilisateur UtilisateurPrioritaire(ListeAttente a) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void TraitementListAttente(int idVoiture) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	

}
