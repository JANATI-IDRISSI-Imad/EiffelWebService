package commun;

import java.io.Serializable;

public class Avis implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idAvis;
	private int idUtlisateur;
	private int idVoiture;
	private double note;
	private String etat;
	
	public Avis() {
		// TODO Auto-generated constructor stub
	}

	public Avis(int idAvis, int idUtlisateur, int idVoiture, double note, String etat) {
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

	public int getIdUtlisateur() {
		return idUtlisateur;
	}

	public void setIdUtlisateur(int idUtlisateur) {
		this.idUtlisateur = idUtlisateur;
	}

	public int getIdVoiture() {
		return idVoiture;
	}

	public void setIdVoiture(int idVoiture) {
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
