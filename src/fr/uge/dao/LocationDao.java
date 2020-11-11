package fr.uge.dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import commun.Location;
import commun.Voiture;

public interface LocationDao extends Remote{
	
	public boolean LouerVoiture(Voiture v) throws RemoteException;
	public boolean ReturnVoiture(Voiture v) throws RemoteException;
	public Location GetLocationById(int id) throws RemoteException;
	
	public List<Location> ListLocationByVoiture(int idVoiture) throws RemoteException;
	public List<Location> ListLocationByUser(int idUtilisateur) throws RemoteException;

}
