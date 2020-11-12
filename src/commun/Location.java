package commun;

import java.io.Serializable;

public class Location implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int idLocation;
	private Utilisateur utilisateur;
	private Voiture voiture;
	private String dateLocation;
	
	public Location() {
		
	}

	public Location(int idLocation, Utilisateur idUtilisateur, Voiture idVoiture, String dateLocation) {
		super();
		this.idLocation = idLocation;
		this.utilisateur = idUtilisateur;
		this.voiture = idVoiture;
		this.dateLocation = dateLocation;
	}

	public int getIdLocation() {
		return idLocation;
	}

	public void setIdLocation(int idLocation) {
		this.idLocation = idLocation;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Voiture getVoiture() {
		return voiture;
	}

	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}

	public String getDateLocation() {
		return dateLocation;
	}

	public void setDateLocation(String dateLocation) {
		this.dateLocation = dateLocation;
	}

	@Override
	public String toString() {
		return "Location [idLocation=" + idLocation + ", Utilisateur=" + utilisateur + ", Voiture=" + voiture
				+ ", dateLocation=" + dateLocation + "]";
	}
	
	
}
