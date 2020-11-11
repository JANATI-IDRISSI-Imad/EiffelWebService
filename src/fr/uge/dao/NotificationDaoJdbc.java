package fr.uge.dao;

import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;



import commun.Notification;
import commun.Voiture;
import fr.uge.dao.jdbc.Database;
import fr.uge.dao.mappers.ModelMapper;

public class NotificationDaoJdbc implements NotificationDao{

	private Database db;
	private UtilisateurDAO utilisateurDao;
	
	public NotificationDaoJdbc(Database db) {
		super();
		this.db = db;
		utilisateurDao = new UtilisateurDaoJdbc(db);
	}

	@Override
	public void NotifierUtilisateur(int IdUtilisateur, String message) throws RemoteException {
		
		db.insert("notification", IdUtilisateur, message);
	}

	@Override
	public Notification GetNotificationById(int idNotification) throws RemoteException {
		String[][] tab = db.select("notification","idNotification", idNotification);
		if(tab == null) {
			return null;
		}
		return ModelMapper.getNotification(utilisateurDao, tab[1]);
	}

	@Override
	public List<Notification> GetNotificationByUtilisateur(int idUtilisateur) throws RemoteException {
		
		String[][] tab = db.select("notification","idUtilisateur", idUtilisateur);
		List<Notification> listNotif = new ArrayList<>();
		if(tab == null) return null;
		
		for (int i = 1; i < tab.length; i++) {
			listNotif.add(ModelMapper.getNotification(utilisateurDao, tab[i]));
		}
		
		
		return listNotif;
	
	}

	
	public String DateAujourdhui() {
	    LocalDateTime myDateObj = LocalDateTime.now(); 
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"); 
	    return myDateObj.format(myFormatObj);
	}
	
	

}
