package fr.uge.dao.mappers;

import java.rmi.RemoteException;

import commun.Avis;
import commun.DemandeLocation;
import commun.Location;
import commun.Notification;
import commun.Role;
import commun.Utilisateur;
import commun.Voiture;
import fr.uge.dao.RoleDAO;
import fr.uge.dao.UtilisateurDAO;
import fr.uge.dao.VoitureDao;

public class ModelMapper {

	public static Utilisateur getUtilisateur (RoleDAO roleDAO,String...row) {
		Utilisateur u=new Utilisateur();
		u.setIdUtilisateur(getInt(row[0]));
		u.setNomU(row[1]);
		u.setPrenomU(row[2]);
		u.setEmailU(row[3]);
		u.setAdressU(row[4]);
		u.setTelephoneU(row[5]);
		u.setMdp(row[6]);
		u.setRole(roleDAO.getRoleById(getInt(row[7])));
		return u;
	}
	
	public static Location getLocation(UtilisateurDAO utilisateurDAO, VoitureDao voitureDao, String...row) throws RemoteException {
		Location l = new Location();
		l.setIdLocation(getInt(row[0]));
		l.setVoiture(voitureDao.GetVoitureById(getInt(row[1])));
		l.setUtilisateur(utilisateurDAO.GetUtilisateurById(getInt(row[2])));
		l.setDateLocation(row[3]);
		return l;
	}
	

	public static Notification getNotification(UtilisateurDAO utilisateurdao,String...row) throws RemoteException {
		
		Notification notification = new Notification();
		notification.setIdNotification(getInt(row[0]));
		notification.setUtilisateur(utilisateurdao.GetUtilisateurById(getInt(row[1])));
		notification.setMessage(row[2]);
		return notification;
	}
	
	
	public static Voiture getVoiture(String...row) {
			Voiture voiture = new Voiture();
			voiture.setIdVoiture(getInt(row[0]));
			voiture.setNomVoiture(row[1]);
			voiture.setDescriptionVoiture(row[2]);
			voiture.setMatriculeVoiture(row[3]);
			voiture.setDisponible(Boolean.getBoolean(row[4]));
			voiture.setMarqueVoiture(row[5]);
			voiture.setNbrLocation(getInt(row[6]));
			voiture.setPrixVoiture(Double.parseDouble(row[7]));
			voiture.setPhotoVoiture(row[8]);			
			voiture.setPhotoVoiture(row[8]);
			return voiture;
		}
	
	public static Avis getAvis(UtilisateurDAO utilisateurDAO, VoitureDao voitureDao, String...row) throws RemoteException {
		Avis a = new Avis();
		a.setIdAvis(getInt(row[0]));
		a.setIdUtlisateur(utilisateurDAO.GetUtilisateurById(getInt(row[1])));
		a.setIdVoiture(voitureDao.GetVoitureById(getInt(row[2])));
		a.setNote(getInt(row[3]));
		a.setEtat(row[4]);
		return a;
	}
		
	public static int getInt(String data) {
		
		try {
			return Integer.parseInt(data);
		} 
		catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
			return 0;
		}
	}
	
	public static Role getRole(String...row) {
		Role r=new Role();
		r.setIdRole(getInt(row[0]));
		r.setRole(row[1]);
		return r;
	}
	public static DemandeLocation getDemandeLocation(UtilisateurDAO utilisateurDAO,VoitureDao voitureDao,String...row) throws RemoteException {
		DemandeLocation d=new DemandeLocation();
		d.setIdDemande(getInt(row[0]));
		d.setIdVoiture(voitureDao.GetVoitureById(getInt(row[1])));
		d.setUtilisateur(utilisateurDAO.GetUtilisateurById(getInt(row[2])));
		d.setDateDemande(row[3]);
		d.setTraitementDemande(getBoolean(row[4]));
		return d;
	}
	
public static Boolean getBoolean(String data) {
		
		try {
			return Boolean.getBoolean(data);
		} 
		catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
			return false;
		}
	}
	
	
}
