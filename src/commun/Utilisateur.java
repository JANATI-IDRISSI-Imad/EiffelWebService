package commun;

import java.io.Serializable;

public class Utilisateur implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idUtilisateur;
	private String nomU;
	private String prenomU;
	private String emailU;
	private String adressU;
	private String telephoneU;
	private String mdp;
	private Role role;
	
	public Utilisateur() {
		
	}

	public Utilisateur(int idUtilisateur, String nomU, String prenomU, String emailU, String adressU, String telephoneU,
			String mdp, Role role) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.nomU = nomU;
		this.prenomU = prenomU;
		this.emailU = emailU;
		this.adressU = adressU;
		this.telephoneU = telephoneU;
		this.mdp = mdp;
		this.role = role;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role row) {
		this.role = row;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getNomU() {
		return nomU;
	}

	public void setNomU(String nomU) {
		this.nomU = nomU;
	}

	public String getPrenomU() {
		return prenomU;
	}

	public void setPrenomU(String prenomU) {
		this.prenomU = prenomU;
	}

	public String getEmailU() {
		return emailU;
	}

	public void setEmailU(String emailU) {
		this.emailU = emailU;
	}

	public String getAdressU() {
		return adressU;
	}

	public void setAdressU(String adressU) {
		this.adressU = adressU;
	}

	public String getTelephoneU() {
		return telephoneU;
	}

	public void setTelephoneU(String telephoneU) {
		this.telephoneU = telephoneU;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", nomU=" + nomU + ", prenomU=" + prenomU + ", emailU="
				+ emailU + ", adressU=" + adressU + ", telephoneU=" + telephoneU + ", mdp=" + mdp + ", role=" + role
				+ "]";
	}
	

}
