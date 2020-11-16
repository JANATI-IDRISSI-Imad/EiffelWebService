package fr.uge.dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import commun.Avis;
import commun.Voiture;

public interface AvisDao extends Remote{
	
	public boolean AjouterAvis(Avis a) throws RemoteException;
	public boolean SupprimerAvis(Avis a) throws RemoteException;
	public boolean ModifierAvis(Avis a) throws RemoteException;
	public Avis GetAvisById(int idAvis) throws RemoteException;
	public List<Avis> ListAvisByVoiture(int idVoiture) throws RemoteException;

}
