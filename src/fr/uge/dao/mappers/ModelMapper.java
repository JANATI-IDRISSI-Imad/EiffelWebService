package fr.uge.dao.mappers;

import commun.Role;
import commun.Utilisateur;
import commun.Voiture;
import fr.uge.dao.RoleDAO;

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
			
			
			
			return voiture;
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
	
	
}