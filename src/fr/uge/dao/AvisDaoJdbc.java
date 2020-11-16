package fr.uge.dao;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import commun.Avis;
import commun.Voiture;
import fr.uge.dao.jdbc.Database;
import fr.uge.dao.mappers.ModelMapper;

public class AvisDaoJdbc implements AvisDao{
	
	private Database db;
	private VoitureDao voitureDao;
	private UtilisateurDAO utilisateurDAO;
	private String tableName ="avis"; 
	
	public AvisDaoJdbc() {
		
	}
	
	public AvisDaoJdbc(Database db,UtilisateurDAO utilisateurDAO,VoitureDao voitureDao) {
		super();
		this.db = db;
		this.utilisateurDAO = utilisateurDAO;
		this.voitureDao = voitureDao;
	}

	@Override
	public boolean AjouterAvis(Avis a) throws RemoteException {
		db.insert(tableName, a.getIdAvis(), a.getIdUtlisateur(), a.getIdVoiture(),a.getNote(), a.getEtat());
		return true;
	}

	@Override
	public boolean SupprimerAvis(Avis a) throws RemoteException {
		db.delete(tableName, "idAvis", a.getIdAvis());
		return true;
	}

	@Override
	public Avis GetAvisById(int idAvis) throws RemoteException {
		String[][] t = db.select(tableName, "idAvis", idAvis);
		if (t == null) {
			return null;
		}
		return ModelMapper.getAvis(utilisateurDAO, voitureDao, t[1]);
	}

	@Override
	public List<Avis> ListAvisByVoiture(int idVoiture) throws RemoteException {
		String[][] t = db.select(tableName, "idVoiture", idVoiture);
		List<Avis> listAvis = new ArrayList<>();
		if (t == null) return null;
		for (int i = 1; i < t.length; i++) {
			listAvis.add(ModelMapper.getAvis(utilisateurDAO, voitureDao, t[i]));	
		}
		return listAvis;
	}

	@Override
	public boolean ModifierAvis(Avis a) throws RemoteException {
		db.update(tableName, a.getIdAvis(), a.getIdUtlisateur(), a.getIdVoiture(), a.getEtat(), a.getNote());
		return true;
	}

}
