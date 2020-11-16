package fr.uge.dao;

import java.rmi.RemoteException;
import java.util.List;

import commun.Location;
import commun.Voiture;
import fr.uge.dao.jdbc.Database;

public class LocationDaoJdbc implements LocationDao{
	
	private Database db;
	private VoitureDao voitureDao;

	@Override
	public boolean LouerVoiture(Voiture v) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ReturnVoiture(Voiture v) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Location GetLocationById(int id) throws RemoteException {
	
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Location> ListLocationByVoiture(int idVoiture) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Location> ListLocationByUser(int idUtilisateur) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
