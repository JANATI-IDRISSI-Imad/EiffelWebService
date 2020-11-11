package fr.uge.dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import commun.DemandeLocation;

public interface DemandeLocationDao extends Remote{
	
	public boolean newDemandeLocation(DemandeLocation d) throws RemoteException;
	public void traitementDemande(int idDemandeLocation) throws RemoteException;
	public DemandeLocation getDLocationByIdDemande(int idDemandeLocation) throws RemoteException;
	public List<DemandeLocation> getDemandeLocationNonTraiteByidProduit(int idVoiture) throws RemoteException;
	public DemandeLocation getDemandeLocationByidVoitureAndIdUtilisateur(int idVoiture,int idUtilisateur) throws RemoteException;
	public List<DemandeLocation> getDemandeLocationByidUser(int idUtilisateur) throws RemoteException;

}
