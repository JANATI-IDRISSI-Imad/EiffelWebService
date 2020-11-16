package fr.uge.dao;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import commun.DemandeLocation;
import commun.Location;
import commun.Voiture;
import fr.uge.dao.jdbc.Database;
import fr.uge.dao.mappers.ModelMapper;

public class LocationDaoJdbc implements LocationDao{
	
	private Database db;
	private VoitureDao voitureDao;
	private UtilisateurDAO utilisateurDao;
	private DemandeLocationDao demandeLocationDao;

	public LocationDaoJdbc(Database db, VoitureDao voitureDao, UtilisateurDAO utilisateurDao,LocationDao locationDao,DemandeLocationDao demandeLocationDao) {
		super();
		this.db = db;
		this.voitureDao = voitureDao;
		this.utilisateurDao = utilisateurDao;
		this.demandeLocationDao=demandeLocationDao;
	}

	@Override
	public boolean LouerVoiture(Location v) throws RemoteException {
		if(v.getVoiture().isDisponible()) {
			DemandeLocation d=demandeLocationDao.getDemandeLocationByidVoitureAndIdUtilisateur(v.getVoiture().getIdVoiture(), v.getUtilisateur().getIdUtilisateur());
			if(d==null) {
				db.insert("demandelocation",v.getVoiture().getIdVoiture(),  v.getUtilisateur().getIdUtilisateur() ,v.getDateLocation(),true);	
			}
			else {
				demandeLocationDao.traitementDemande(d.getIdDemande());
			}
			db.insert("location", v.getUtilisateur().getIdUtilisateur(),v.getVoiture().getIdVoiture(),v.getDateLocation());
			v.getVoiture().setDisponible(false);
			v.getVoiture().setNbrLocation(v.getVoiture().getNbrLocation()+1);
			voitureDao.ModifierVoiture(v.getVoiture());
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
		String[][] t = db.select("location", "idLocation", id);
		if (t == null) {
			return null;
		}
		return ModelMapper.getLocation(utilisateurDao, voitureDao, t[1]);
	}

	@Override
	public List<Location> ListLocationByVoiture(int idVoiture) throws RemoteException {
		String[][] t = db.select("location", "idVoiture", idVoiture);
		List<Location> listLocation = new ArrayList<>();
		if(t == null) return null;	
		for (int i = 1; i < t.length; i++) {
			listLocation.add(ModelMapper.getLocation(utilisateurDao, voitureDao, t[i]));
		}
		return listLocation;
	}

	@Override
	public List<Location> ListLocationByUser(int idUtilisateur) throws RemoteException {
		String[][] t = db.select("location", "idUtilisateur", idUtilisateur);
		List<Location> listLocation = new ArrayList<Location>();
		if (t == null) return null;
		for (int i=1; i<t.length; i++) {
			listLocation.add(ModelMapper.getLocation(utilisateurDao, voitureDao, t[i]));
		}
		return listLocation;
	}

}
