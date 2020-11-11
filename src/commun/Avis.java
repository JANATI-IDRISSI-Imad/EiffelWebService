package commun;

import java.io.Serializable;

public class Avis implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idAvis;
	private Utilisateur idUtlisateur;
	private Voiture idVoiture;
	private double note;
	private String etat;
	
	public Avis() {
		// TODO Auto-generated constructor stub
	}

	public Avis(int idAvis, Utilisateur idUtlisateur, Voiture idVoiture, double note, String etat) {
		super();
		this.idAvis = idAvis;
		this.idUtlisateur = idUtlisateur;
		this.idVoiture = idVoiture;
		this.note = note;
		this.etat = etat;
	}

	public int getIdAvis() {
		return idAvis;
	}

	public void setIdAvis(int idAvis) {
		this.idAvis = idAvis;
	}

	public Utilisateur getIdUtlisateur() {
		return idUtlisateur;
	}

	public void setIdUtlisateur(Utilisateur idUtlisateur) {
		this.idUtlisateur = idUtlisateur;
	}

	public Voiture getIdVoiture() {
		return idVoiture;
	}

	public void setIdVoiture(Voiture idVoiture) {
		this.idVoiture = idVoiture;
	}

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	@Override
	public String toString() {
		return "Avis [idAvis=" + idAvis + ", idUtlisateur=" + idUtlisateur + ", idVoiture=" + idVoiture + ", note="
				+ note + ", etat=" + etat + "]";
	}
	
	
}
