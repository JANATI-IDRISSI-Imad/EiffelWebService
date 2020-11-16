package commun;

import java.io.Serializable;

public class Notification implements Serializable{
	private int idNotification;
	private Utilisateur utilisateur;
	private String message;
	
	public Notification() {
		// TODO Auto-generated constructor stub
	}

	public Notification(int idNotification, Utilisateur idUser, String message) {
		super();
		this.idNotification = idNotification;
		this.utilisateur = idUser;
		this.message = message;
	}

	public int getIdNotification() {
		return idNotification;
	}

	public void setIdNotification(int idNotification) {
		this.idNotification = idNotification;
	}

	

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Notification [idNotification=" + idNotification + ", idUser=" + utilisateur + ", message=" + message + "]";
	}
	
	

}
