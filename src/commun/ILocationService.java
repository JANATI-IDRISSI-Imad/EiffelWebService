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
	public List<Location> ListLocationByUtilisateur(int idUtilisateur) throws RemoteException;
	
	

	public boolean NouvelleDemandeLocation(DemandeLocation d) throws RemoteException;
	public void TraitementDemande(int idDemandeLocation) throws RemoteException;
	public DemandeLocation getDemandeLocationByidDemande(int idDemandeLocation) throws RemoteException;
	public List<DemandeLocation>  getDemandeLocationNonTraiteByidProduit(int idVoiture) throws RemoteException;
	public List<DemandeLocation> getDemandeLocationByidUser(int idUser) throws RemoteException;
	
	
	
}
