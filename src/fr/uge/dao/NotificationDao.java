package fr.uge.dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import commun.Notification;

public interface NotificationDao extends Remote {

	public void NotifierUtilisateur(int IdUtilisateur,String message)  throws RemoteException;
	public Notification GetNotificationById(int idNotification)  throws RemoteException;
	public List<Notification> GetNotificationByUtilisateur(int idUtilisateur)  throws RemoteException;
}
