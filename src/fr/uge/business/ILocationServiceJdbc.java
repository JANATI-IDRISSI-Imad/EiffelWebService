package fr.uge.business;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import commun.DemandeLocation;
import commun.ILocationService;
import commun.Location;
import commun.Voiture;
import fr.uge.dao.AvisDao;
import fr.uge.dao.LocationDao;
import fr.uge.dao.NotificationDao;
import fr.uge.dao.UtilisateurDAO;
import fr.uge.dao.VoitureDao;
import fr.uge.dao.jdbc.Database;

public class ILocationServiceJdbc extends UnicastRemoteObject implements ILocationService{

	
	private Database db;
	
	private AvisDao avisDao;
	private VoitureDao voitureDao;
	private NotificationDao notificationDao;
	private UtilisateurDAO utilisateurDAO;
	private LocationDao locationDao;
	
	
	protected ILocationServiceJdbc() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	@Override
	public boolean AjouterVoiture(Voiture v) throws RemoteException {
	
		return voitureDao.AjouterVoiture(v);
	}

	@Override
	public boolean ModifierVoiture(Voiture v) throws RemoteException {
		return voitureDao.ModifierVoiture(v);
	}

	@Override
	public boolean SupprimerVoiture(Voiture v) throws RemoteException {
		return voitureDao.SupprimerVoiture(v);
	}

	@Override
	public Voiture GetVoitureById(int idVoiture) throws RemoteException {
		return voitureDao.GetVoitureById(idVoiture);
	}

	@Override
	public boolean DisponibliteVoiture(int idVoiture) throws RemoteException {
		
		return voitureDao.DisponibiliteVoiture(idVoiture);
	}

	@Override
	public boolean UpdateProduitLouer(int idVoiture) throws RemoteException {

		return voitureDao.UpdateVoitureLouer(idVoiture);
	}

	@Override
	public List<Voiture> ListVoiture() throws RemoteException {
		
		return voitureDao.ListVoiture();
	}

	@Override
	public List<Voiture> ListVoitureByMarque(String marque) throws RemoteException {
		return voitureDao.ListVoitureByMarque(marque);
	}


	@Override
	public List<Voiture> ListVoiturePretEtreVendu() throws RemoteException {
		return voitureDao.ListVoiturePretEtreVendu();
	}

	@Override
	public List<Voiture> RechercherVoitureByKeyWord(String key) throws RemoteException {
		return voitureDao.RechercherVoitureByKeyWord(key);
	}

	@Override
	public boolean LouerVoiture(Location l) throws RemoteException {
		
		return locationDao.LouerVoiture(l);
	}

	@Override
	public void RetournerVoiture(Location l,String etat) throws RemoteException {
		locationDao.ReturnVoiture(l, etat);
		
	}

	@Override
	public Location GetLocationById(int id) throws RemoteException {
		
		return locationDao.GetLocationById(id);
	}

	@Override
	public List<Location> ListLocationByVoiture(int idVoiture) throws RemoteException {
		
		return locationDao.ListLocationByVoiture(idVoiture);
	}

	@Override
	public List<Location> ListLocationByUtilisateur(int idUtilisateur) throws RemoteException {
		
		return locationDao.GetLocationByUtilisateur(idUtilisateur);
	}

	@Override
	public boolean NouvelleDemandeLocation(DemandeLocation d) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void TraitementDemande(int idDemandeLocation) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DemandeLocation getDemandeLocationByidDemande(int idDemandeLocation) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DemandeLocation> getDemandeLocationNonTraiteByidProduit(int idVoiture) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DemandeLocation> getDemandeLocationByidUser(int idUser) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
