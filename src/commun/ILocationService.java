package commun;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ILocationService extends Remote{

	
	public boolean AjouterVoiture(Voiture v) throws RemoteException;
	public boolean ModifierVoiture(Voiture v) throws RemoteException;
	public boolean SupprimerVoiture(Voiture v) throws RemoteException;
	public Voiture GetVoitureById(int Voiture) throws RemoteException;
	public boolean DisponibliteVoiture(int idVoiture) throws RemoteException;
	public boolean UpdateProduitLouer(int idVoiture) throws RemoteException;
	public List<Voiture> ListVoiture() throws RemoteException;
	public List<Voiture> ListVoitureByMarque(String marque) throws RemoteException;
	public List<Voiture> ListVoitureByType(String type) throws RemoteException;
	public List<Voiture> ListVoiturePretEtreVendu() throws RemoteException;
	public List<Voiture> RechercherVoitureByKeyWord(String key) throws RemoteException;


	public boolean LouerVoiture(Location l) throws RemoteException;
	public void RetournerVoiture(Location l,String etat) throws RemoteException;
	public Location GetLocationById(int id) throws RemoteException;
	public List<Location> ListLocationByVoiture(int idVoture) throws RemoteException;
	public List<Location> ListLocationByUser(int idUtilisateur) throws RemoteException;
	

	public boolean newDemandeLocation(DemandeLocation d) throws RemoteException;
	public void traitementDemande(int idDemandeLocation) throws RemoteException;
	public DemandeLocation getDLocationByIdDemande(int idDemandeLocation) throws RemoteException;
	public List<DemandeLocation> getDemandeLocationNonTraiteByidVoiture(int idVoiture) throws RemoteException;
	public DemandeLocation getDemandeLocationByidVoitureAndIdUtilisateur(int idVoiture,int idUtilisateur) throws RemoteException;
	public List<DemandeLocation> getDemandeLocationByidUser(int idUtilisateur) throws RemoteException;
	public List<DemandeLocation> getListAttente()throws RemoteException;
	public Utilisateur UtilisateurPrioritaire()  throws RemoteException;
	public List<DemandeLocation> getDemandeLocationByidVoiture(int idVoiture)throws RemoteException;
	public void traitementListAttente(int idVoiture) throws RemoteException;
	
	public String Authentification(String email,String password)  throws RemoteException;
	public Utilisateur GetUtilisateurById(int id)  throws RemoteException;
	public Utilisateur GetUtilisateurByEmail(String email)  throws RemoteException;
	
	//public Role getRoleById(int id);
	
	public void NotifierUtilisateur(int IdUtilisateur,String message)  throws RemoteException;
	public Notification GetNotificationById(int idNotification)  throws RemoteException;
	public List<Notification> GetNotificationByUtilisateur(int idUtilisateur)  throws RemoteException;
	
	public ListeAttente AfficherListeAttenteByVoiture(int idVoiture)  throws RemoteException;
	public Utilisateur UtilisateurPrioritaire(ListeAttente a)  throws RemoteException;
	public void TraitementListAttente(int idVoiture)  throws RemoteException;
	
	public boolean AjouterAvis(Avis a) throws RemoteException;
	public boolean SupprimerAvis(Avis a) throws RemoteException;
	public boolean ModifierAvis(Avis a) throws RemoteException;
	public Avis GetAvisById(int idAvis) throws RemoteException;
	public List<Avis> ListAvisByVoiture(int idVoiture) throws RemoteException;
	
}
