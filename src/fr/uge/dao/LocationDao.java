package fr.uge.dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import commun.Location;
import commun.Voiture;

public interface LocationDao extends Remote{
	
	public boolean LouerVoiture(Location v) throws RemoteException;
	public boolean ReturnVoiture(Location v, String etat) throws RemoteException;
	public Location GetLocationById(int id) throws RemoteException;
	
	public List<Location> ListLocationByVoiture(int idVoiture) throws RemoteException;
	public List<Location> ListLocationByUser(int idUtilisateur) throws RemoteException;

}
