package commun;

import java.io.Serializable;

public class DemandeLocation implements Serializable{
	private int idDemande;
	private Utilisateur utilisateur;
	private Voiture voiture;
	private String dateDemande;
	private boolean traitementDemande;
	
	public DemandeLocation() {
		// TODO Auto-generated constructor stub
	}

	public DemandeLocation(int idDemande, Utilisateur utilisateur, Voiture voiture, String dateDemande, boolean traitementDemande) {
		super();
		this.idDemande = idDemande;
		this.utilisateur = utilisateur;
		this.voiture = voiture;
		this.dateDemande = dateDemande;
		this.traitementDemande = traitementDemande;
	}
	
	

	public boolean isTraitementDemande() {
		return traitementDemande;
	}

	public void setTraitementDemande(boolean traitementDemande) {
		this.traitementDemande = traitementDemande;
	}

	public int getIdDemande() {
		return idDemande;
	}

	public void setIdDemande(int idDemande) {
		this.idDemande = idDemande;
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

	public void setIdVoiture(Voiture voiture) {
		this.voiture = voiture;
	}

	public String getDateDemande() {
		return dateDemande;
	}

	public void setDateDemande(String dateDemande) {
		this.dateDemande = dateDemande;
	}
	
	

	@Override
	public String toString() {
		return "DemandeLocation [idDemande=" + idDemande + ", idUtilisateur=" + utilisateur + ", idVoiture="
				+ voiture + ", dateDemande=" + dateDemande + ", traitementDemande=" + traitementDemande + "]";
	}
	
	
}
