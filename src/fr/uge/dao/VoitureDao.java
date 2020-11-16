package fr.uge.dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import commun.Voiture;

public interface VoitureDao extends Remote {

	public boolean AjouterVoiture(Voiture v) throws RemoteException;
	public boolean ModifierVoiture(Voiture v) throws RemoteException;
	public boolean SupprimerVoiture(Voiture v) throws RemoteException;
	public boolean DisponibiliteVoiture(int idVoiture) throws RemoteException;
	public boolean UpdateVoitureLouer(int idVoiture) throws RemoteException;
	public boolean UpdateVoitureReturner(int idVoiture, String etat) throws RemoteException;
	public Voiture GetVoitureById(int idVoiture) throws RemoteException;
	
	public List<Voiture> ListVoiture() throws RemoteException;
	
	public List<Voiture> ListVoitureByMarque(String marque) throws RemoteException;
	
	public List<Voiture> ListVoiturePretEtreVendu() throws RemoteException;
	public List<Voiture> RechercherVoitureByKeyWord(String key) throws RemoteException;
}
