package fr.uge.dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import commun.DemandeLocation;
import commun.Utilisateur;
import commun.Voiture;

public interface DemandeLocationDao extends Remote{
	
	public boolean newDemandeLocation(DemandeLocation d) throws RemoteException;
	public void traitementDemande(DemandeLocation d) throws RemoteException;
	public DemandeLocation getDLocationByIdDemande(int idDemandeLocation) throws RemoteException;
	public List<DemandeLocation> getDemandeLocationNonTraiteByVoiture(Voiture v) throws RemoteException;
	public DemandeLocation getDemandeLocationByidVoitureAndIdUtilisateur(int idVoiture,int idUtilisateur) throws RemoteException;
	public List<DemandeLocation> getDemandeLocationByidUser(int idUtilisateur) throws RemoteException;
	public List<DemandeLocation> getListAttente()throws RemoteException;
	public Utilisateur UtilisateurPrioritaire()  throws RemoteException;
	public List<DemandeLocation> getDemandeLocationByidVoiture(int idVoiture)throws RemoteException;
	public void traitementListAttente(Voiture v) throws RemoteException;
	
	
}
