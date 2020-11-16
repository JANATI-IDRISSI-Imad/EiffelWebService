package fr.uge.dao;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;



import commun.Voiture;
import fr.uge.dao.jdbc.Database;
import fr.uge.dao.mappers.ModelMapper;

public class VoitureDaoJdbc implements VoitureDao{
	
	private Database db;
	
	
	

	public VoitureDaoJdbc(Database db) {
		super();
		this.db = db;
	}

	@Override
	public boolean AjouterVoiture(Voiture v) throws RemoteException {
		
		db.insert("voiture", v.getIdVoiture(), v.getMarqueVoiture(),v.getMatriculeVoiture(),
				v.getDescriptionVoiture(),v.getModelVoiture(),v.getNbrLocation(),
				v.getNomVoiture(),v.getPhotoVoiture(),v.getPrixVoiture());
		
		return true;
	}	

	@Override
	public boolean ModifierVoiture(Voiture v) throws RemoteException {

		db.update("voiture",  v.getIdVoiture(), v.getMarqueVoiture(),v.getMatriculeVoiture(),
				v.getDescriptionVoiture(),v.getModelVoiture(),v.getNbrLocation(),
				v.getNomVoiture(),v.getPhotoVoiture(),v.getPrixVoiture());
		return true;
	}

	@Override
	public boolean SupprimerVoiture(Voiture v) throws RemoteException {
		if( db.delete("voiture","idVoiture", v.getIdVoiture())>0) {
			return true;
		}
		return false;
		
	}

	@Override
	public boolean DisponibiliteVoiture(int idVoiture) throws RemoteException {
		Voiture v = GetVoitureById(idVoiture);
		return v.isDisponible();
	}

	@Override
	public boolean UpdateVoitureLouer(int idVoiture) throws RemoteException {
		Voiture v = GetVoitureById(idVoiture);
		v.setDisponible(false);
		v.setNbrLocation(v.getNbrLocation()+1);
		
		return ModifierVoiture(v);
	}

	@Override
	public boolean UpdateVoitureReturner(int idVoiture, String etat) throws RemoteException {
		Voiture v = GetVoitureById(idVoiture);
		v.setDisponible(true);
		v.setDescriptionVoiture(etat);
		
		return ModifierVoiture(v);
	}

	@Override
	public Voiture GetVoitureById(int idVoiture) throws RemoteException {
		String[][] tab = db.select("voiture", "idVoiture", idVoiture);
		if(tab == null) {
			return null;
		}
		return ModelMapper.getVoiture(tab[1]);
		
	}

	@Override
	public List<Voiture> ListVoiture() throws RemoteException {
		String[][] tab = db.select("voiture");
		List<Voiture> listVoiture = new ArrayList<>();
		if(tab == null) return null;
		
		for (int i = 1; i < tab.length; i++) {
			listVoiture.add(ModelMapper.getVoiture(tab[i]));
			
		}
		return listVoiture;
		
	}

	
	@Override
	public List<Voiture> ListVoitureByMarque(String marque) throws RemoteException {
		String[][] tab = db.select("voiture","marqueVoiture",marque);
		List<Voiture> listVoiture = new ArrayList<>();
		if(tab == null) return null;
		
		for (int i = 1; i < tab.length; i++) {
			listVoiture.add(ModelMapper.getVoiture(tab[i]));
			
		}
		return listVoiture;
	}

	@Override
	public List<Voiture> ListVoiturePretEtreVendu() throws RemoteException {
		List<Voiture> list = ListVoiture();
		Vector<Voiture> res =new Vector<Voiture>();
		for (Voiture voiture : list) {
			if(  voiture.getNbrLocation()>=1) res.add(voiture);
		}
		
		return res;
	}

	@Override
	public List<Voiture> RechercherVoitureByKeyWord(String key) throws RemoteException {
		List<Voiture> listVoiture= ListVoiture();
		Vector<Voiture> res = new Vector<Voiture>();
		for (Voiture voiture : listVoiture) {
			if(voiture.getNomVoiture().contains(key) || voiture.getMarqueVoiture().contains(key)|| voiture.getPhotoVoiture().contains(key))
				res.add(voiture);
			
		}
		return res;
	}

}
