package fr.uge.dao;

import java.rmi.RemoteException;
import java.util.List;

import commun.Location;
import commun.Voiture;
import fr.uge.dao.jdbc.Database;

public class LocationDaoJdbc implements LocationDao{
	
	private Database db;
	private VoitureDao voitureDao;
	private UtilisateurDAO utilisateurDao;
	
	
	
	public LocationDaoJdbc(Database db) {
		super();
		this.db = db;
		voitureDao = new VoitureDaoJdbc(db);
		utilisateurDao = new UtilisateurDaoJdbc(db);
	}

	public LocationDaoJdbc(Database db, VoitureDao voitureDao, UtilisateurDAO utilisateurDao) {
		super();
		this.db = db;
		this.voitureDao = voitureDao;
		this.utilisateurDao = utilisateurDao;
	}

	@Override
	public boolean LouerVoiture(Location v) throws RemoteException {
		if(v.getVoiture().isDisponible()) {
			db.insert("demandelocation",v.getVoiture().getIdVoiture(),  v.getUtilisateur().getIdUtilisateur() ,v.getDateLocation(),true);	
			db.insert("location", v.getUtilisateur().getIdUtilisateur(),v.getVoiture().getIdVoiture(),v.getDateLocation());
			v.getVoiture().setDisponible(false);
			return true;	
		}	
		db.insert("demandelocation",v.getVoiture().getIdVoiture(),  v.getUtilisateur().getIdUtilisateur() ,v.getDateLocation(),false);
		return false;
	}

	@Override
	public boolean ReturnVoiture(Location l, String etat) throws RemoteException {
		db.update("location", l.getIdLocation(), l.getUtilisateur().getIdUtilisateur(),l.getVoiture().getIdVoiture(),l.getDateLocation());
	
		voitureDao.UpdateVoitureReturner(l.getVoiture().getIdVoiture(), etat);
		return true;
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
