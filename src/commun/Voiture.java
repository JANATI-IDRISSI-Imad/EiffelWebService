package commun;

import java.io.Serializable;

public class Voiture implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idVoiture;
	private String nomVoiture;
	private String descriptionVoiture;
	private String matriculeVoiture;
	private String modelVoiture;
	private boolean disponible;
	private String marqueVoiture;
	private int nbrLocation;
	private double prixVoiture;
	private String photoVoiture;
	
	public Voiture() {
		
	}

	public Voiture(int idVoiture, String nomVoiture, String descriptionVoiture, String matriculeVoiture,
			String modelVoiture, boolean disponible, String marqueVoiture, int nbrLocation, double prixVoiture,
			String photoVoiture) {
		super();
		this.idVoiture = idVoiture;
		this.nomVoiture = nomVoiture;
		this.descriptionVoiture = descriptionVoiture;
		this.matriculeVoiture = matriculeVoiture;
		this.modelVoiture = modelVoiture;
		this.disponible = disponible;
		this.marqueVoiture = marqueVoiture;
		this.nbrLocation = nbrLocation;
		this.prixVoiture = prixVoiture;
		this.photoVoiture = photoVoiture;
	}

	public int getIdVoiture() {
		return idVoiture;
	}

	public void setIdVoiture(int idVoiture) {
		this.idVoiture = idVoiture;
	}

	public String getNomVoiture() {
		return nomVoiture;
	}

	public void setNomVoiture(String nomVoiture) {
		this.nomVoiture = nomVoiture;
	}

	public String getDescriptionVoiture() {
		return descriptionVoiture;
	}

	public void setDescriptionVoiture(String descriptionVoiture) {
		this.descriptionVoiture = descriptionVoiture;
	}

	public String getMatriculeVoiture() {
		return matriculeVoiture;
	}

	public void setMatriculeVoiture(String matriculeVoiture) {
		this.matriculeVoiture = matriculeVoiture;
	}

	public String getModelVoiture() {
		return modelVoiture;
	}

	public void setModelVoiture(String modelVoiture) {
		this.modelVoiture = modelVoiture;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public String getMarqueVoiture() {
		return marqueVoiture;
	}

	public void setMarqueVoiture(String marqueVoiture) {
		this.marqueVoiture = marqueVoiture;
	}

	public int getNbrLocation() {
		return nbrLocation;
	}

	public void setNbrLocation(int nbrLocation) {
		this.nbrLocation = nbrLocation;
	}

	public double getPrixVoiture() {
		return prixVoiture;
	}

	public void setPrixVoiture(double prixVoiture) {
		this.prixVoiture = prixVoiture;
	}

	public String getPhotoVoiture() {
		return photoVoiture;
	}

	public void setPhotoVoiture(String photoVoiture) {
		this.photoVoiture = photoVoiture;
	}

	@Override
	public String toString() {
		return "Voiture [idVoiture=" + idVoiture + ", nomVoiture=" + nomVoiture + ", descriptionVoiture="
				+ descriptionVoiture + ", matriculeVoiture=" + matriculeVoiture + ", modelVoiture=" + modelVoiture
				+ ", disponible=" + disponible + ", marqueVoiture=" + marqueVoiture + ", nbrLocation=" + nbrLocation
				+ ", prixVoiture=" + prixVoiture + ", photoVoiture=" + photoVoiture + "]";
	}
	
	

}
