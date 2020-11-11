package commun;

import java.io.Serializable;

public class Panier implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idPanier;
	private int idVoiture;
	private int idUtilisateur;
	private int prixTotal;
	
	public Panier() {
		
	}

	public Panier(int idPanier, int idVoiture, int idUtilisateur, int prixTotal) {
		super();
		this.idPanier = idPanier;
		this.idVoiture = idVoiture;
		this.idUtilisateur = idUtilisateur;
		this.prixTotal = prixTotal;
	}

	public int getIdPanier() {
		return idPanier;
	}

	public void setIdPanier(int idPanier) {
		this.idPanier = idPanier;
	}

	public int getIdVoiture() {
		return idVoiture;
	}

	public void setIdVoiture(int idVoiture) {
		this.idVoiture = idVoiture;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public int getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(int prixTotal) {
		this.prixTotal = prixTotal;
	}

	@Override
	public String toString() {
		return "Panier [idPanier=" + idPanier + ", idVoiture=" + idVoiture + ", idUtilisateur=" + idUtilisateur
				+ ", prixTotal=" + prixTotal + "]";
	}
	
	
}
