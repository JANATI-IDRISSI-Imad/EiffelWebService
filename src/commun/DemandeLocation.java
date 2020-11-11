package commun;

import java.io.Serializable;

public class DemandeLocation implements Serializable{
	private int idDemande;
	private int idUtilisateur;
	private int idVoiture;
	private String dateDemande;
	private boolean traitementDemande;
	
	public DemandeLocation() {
		// TODO Auto-generated constructor stub
	}

	public DemandeLocation(int idDemande, int idUtilisateur, int idVoiture, String dateDemande, boolean traitementDemande) {
		super();
		this.idDemande = idDemande;
		this.idUtilisateur = idUtilisateur;
		this.idVoiture = idVoiture;
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

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public int getIdVoiture() {
		return idVoiture;
	}

	public void setIdVoiture(int idVoiture) {
		this.idVoiture = idVoiture;
	}

	public String getDateDemande() {
		return dateDemande;
	}

	public void setDateDemande(String dateDemande) {
		this.dateDemande = dateDemande;
	}

	@Override
	public String toString() {
		return "DemandeLocation [idDemande=" + idDemande + ", idUtilisateur=" + idUtilisateur + ", idVoiture="
				+ idVoiture + ", dateDemande=" + dateDemande + ", traitementDemande=" + traitementDemande + "]";
	}
	
	
}
