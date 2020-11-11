package commun;

import java.io.Serializable;

public class Location implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int idLocation;
	private Utilisateur idUtilisateur;
	private Voiture idVoiture;
	private String dateLocation;
	
	public Location() {
		
	}

	public Location(int idLocation, Utilisateur idUtilisateur, Voiture idVoiture, String dateLocation) {
		super();
		this.idLocation = idLocation;
		this.idUtilisateur = idUtilisateur;
		this.idVoiture = idVoiture;
		this.dateLocation = dateLocation;
	}

	public int getIdLocation() {
		return idLocation;
	}

	public void setIdLocation(int idLocation) {
		this.idLocation = idLocation;
	}

	public Utilisateur getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Utilisateur idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public Voiture getIdVoiture() {
		return idVoiture;
	}

	public void setIdVoiture(Voiture idVoiture) {
		this.idVoiture = idVoiture;
	}

	public String getDateLocation() {
		return dateLocation;
	}

	public void setDateLocation(String dateLocation) {
		this.dateLocation = dateLocation;
	}

	@Override
	public String toString() {
		return "Location [idLocation=" + idLocation + ", idUtilisateur=" + idUtilisateur + ", idVoiture=" + idVoiture
				+ ", dateLocation=" + dateLocation + "]";
	}
	
	
}
