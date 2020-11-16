package fr.uge.dao;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import commun.DemandeLocation;
import commun.Utilisateur;
import commun.Voiture;
import fr.uge.dao.jdbc.Database;
import fr.uge.dao.mappers.ModelMapper;

public class DemandeLocationDaoJdbc implements DemandeLocationDao{

	private String tableName ="demandelocation";
	private Database db;
	private UtilisateurDAO utilisateurDAO;
	private VoitureDao voitureDao;
	private NotificationDao notificationDao;
	

	public DemandeLocationDaoJdbc(Database db,UtilisateurDAO utilisateurDAO,VoitureDao voitureDao,NotificationDao notificationDao) {
		this.db=db;
		this.utilisateurDAO=utilisateurDAO;
		this.voitureDao=voitureDao;
		this.notificationDao=notificationDao;
	}
	
	@Override
	public boolean newDemandeLocation(DemandeLocation d) throws RemoteException {
		db.insert(tableName,d.getVoiture().getIdVoiture(),  d.getUtilisateur().getIdUtilisateur() ,d.getDateDemande(),d.isTraitementDemande());	
		return true;
	}

	@Override
	public void traitementDemande(int idDemandeLocation) throws RemoteException {
		DemandeLocation d=getDLocationByIdDemande(idDemandeLocation);
		d.setTraitementDemande(true);
		db.update(tableName,d.getIdDemande(), d.getVoiture().getIdVoiture(),d.getUtilisateur().getIdUtilisateur() ,d.getDateDemande(),d.isTraitementDemande());	
	}

	@Override
	public DemandeLocation getDLocationByIdDemande(int idDemande) throws RemoteException {
		String data[][] = db.select(tableName, "idDemande", idDemande);
		if (data == null) return null;
		if (data.length <= 1) return null;
		return  ModelMapper.getDemandeLocation(utilisateurDAO,voitureDao,data[1]);
	}

	
	@Override
	public DemandeLocation getDemandeLocationByidVoitureAndIdUtilisateur(int idVoiture, int idUtilisateur)
			throws RemoteException {
		List<DemandeLocation>list=getDemandeLocationByidUser(idUtilisateur);
		for (DemandeLocation d : list) {
			if(d.getVoiture().getIdVoiture()==idVoiture) return d;
		}
		return null;
	}

	@Override
	public List<DemandeLocation> getDemandeLocationByidUser(int idUtilisateur) throws RemoteException {
		String[][] tab =db.select(tableName, "idUtilisateur", idUtilisateur);
		List<DemandeLocation> list = new ArrayList<>();
		if(tab == null) return list;
		
		for (int i = 1; i < tab.length; i++) {
			list.add(ModelMapper.getDemandeLocation(utilisateurDAO, voitureDao, tab[i]));
			
		}
		return list;
	}
	
	@Override
	public List<DemandeLocation> getDemandeLocationByidVoiture(int idVoiture) throws RemoteException {
		String[][] tab =db.select(tableName, "idVoiture", idVoiture);
		List<DemandeLocation> list = new ArrayList<>();
		if(tab == null) return list;
		
		for (int i = 1; i < tab.length; i++) {
			list.add(ModelMapper.getDemandeLocation(utilisateurDAO, voitureDao, tab[i]));
			
		}
		return list;
	}

	@Override
	public List<DemandeLocation> getDemandeLocationNonTraiteByVoiture(int idVoiture) throws RemoteException {
		Voiture v=voitureDao.GetVoitureById(idVoiture);
		List<DemandeLocation>list=getDemandeLocationByidUser(v.getIdVoiture());
		List<DemandeLocation>demandeLocations=new ArrayList<>();
		for (DemandeLocation d : list) {
			if (d.isTraitementDemande()==false) {
				demandeLocations.add(d);
			}
		}
		return demandeLocations;
	}

	@Override
	public List<DemandeLocation> getListAttente() throws RemoteException {
		String[][] tab =db.select(tableName, "traitementDemande", false);
		List<DemandeLocation> list = new ArrayList<>();
		if(tab == null) return list;
		
		for (int i = 1; i < tab.length; i++) {
			list.add(ModelMapper.getDemandeLocation(utilisateurDAO, voitureDao, tab[i]));		
		}
		return list;
	}

	@Override
	public Utilisateur UtilisateurPrioritaire() throws RemoteException {
		try {
			return getListAttente().get(0).getUtilisateur();
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public void traitementListAttente(Voiture v) throws RemoteException {
		Utilisateur u=UtilisateurPrioritaire();
		if(u!=null) {
			String date =getDemandeLocationByidVoitureAndIdUtilisateur(v.getIdVoiture(),u.getIdUtilisateur()).getDateDemande();
			String notifiaction = "La voiture "+u.getNomU()+" est actuellement disponible vous pouvez l\\'emprunter dès maintentant";
			notificationDao.NotifierUtilisateur(u.getIdUtilisateur(), notifiaction);
		}else {
			
		}
	}

	

	

}
