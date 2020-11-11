package commun;

import java.io.Serializable;

public class Notification implements Serializable{
	private int idNotification;
	private int idUser;
	private String message;
	
	public Notification() {
		// TODO Auto-generated constructor stub
	}

	public Notification(int idNotification, int idUser, String message) {
		super();
		this.idNotification = idNotification;
		this.idUser = idUser;
		this.message = message;
	}

	public int getIdNotification() {
		return idNotification;
	}

	public void setIdNotification(int idNotification) {
		this.idNotification = idNotification;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Notification [idNotification=" + idNotification + ", idUser=" + idUser + ", message=" + message + "]";
	}
	
	

}
