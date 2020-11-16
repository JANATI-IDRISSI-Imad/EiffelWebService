package fr.uge.business;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import commun.Avis;
import commun.DemandeLocation;
import commun.ILocationService;
import commun.ListeAttente;
import commun.Location;
import commun.Notification;
import commun.Role;
import commun.Utilisateur;
import commun.Voiture;
import fr.uge.dao.AvisDao;
import fr.uge.dao.AvisDaoJdbc;
import fr.uge.dao.DemandeLocationDao;
import fr.uge.dao.DemandeLocationDaoJdbc;
import fr.uge.dao.ListAttenteDao;
import fr.uge.dao.ListAttenteDaoJdbc;
import fr.uge.dao.LocationDao;
import fr.uge.dao.LocationDaoJdbc;
import fr.uge.dao.NotificationDao;
import fr.uge.dao.NotificationDaoJdbc;
import fr.uge.dao.RoleDAO;
import fr.uge.dao.RoleDaoJdbc;
import fr.uge.dao.UtilisateurDAO;
import fr.uge.dao.UtilisateurDaoJdbc;
import fr.uge.dao.VoitureDao;
import fr.uge.dao.VoitureDaoJdbc;
import fr.uge.dao.jdbc.DataSource;
import fr.uge.dao.jdbc.Database;
import fr.uge.dao.jdbc.MySQLDataSource;

public class ILocationServiceJdbc extends UnicastRemoteObject implements ILocationService{

	
	private Database db;
	
	private AvisDao avisDao;
	private VoitureDao voitureDao;
	private NotificationDao notificationDao;
	private UtilisateurDAO utilisateurDAO;
	private LocationDao locationDao;
	private DemandeLocationDao demandeLocationDao;
	private ListAttenteDao listAttenteDao;
	private RoleDAO roleDAO;
	
	protected ILocationServiceJdbc() throws RemoteException {
		DataSource ds = new MySQLDataSource("eiffel");
		db = new Database(ds);
		roleDAO = new RoleDaoJdbc(db);
		voitureDao = new VoitureDaoJdbc(db);
		utilisateurDAO = new UtilisateurDaoJdbc(db,roleDAO);
		notificationDao = new NotificationDaoJdbc(db,utilisateurDAO);
		avisDao = new AvisDaoJdbc(db,utilisateurDAO,voitureDao);		
		demandeLocationDao = new DemandeLocationDaoJdbc(db, utilisateurDAO, voitureDao, notificationDao);
		locationDao = new LocationDaoJdbc(db, voitureDao, utilisateurDAO, locationDao, demandeLocationDao);
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
	public List<Location> ListLocationByUser(int idUtilisateur) throws RemoteException {
		return locationDao.ListLocationByUser(idUtilisateur);
	}

	@Override
	public List<DemandeLocation> getDemandeLocationNonTraiteByidVoiture(int idVoiture) throws RemoteException {
		return demandeLocationDao.getDemandeLocationNonTraiteByVoiture(idVoiture);
	}

	@Override
	public List<DemandeLocation> getDemandeLocationByidUser(int idUser) throws RemoteException {
		return demandeLocationDao.getDemandeLocationByidUser(idUser);
	}

	@Override
	public List<Voiture> ListVoitureByType(String type) throws RemoteException {
		return null;
	}

	@Override
	public boolean newDemandeLocation(DemandeLocation d) throws RemoteException {
		return demandeLocationDao.newDemandeLocation(d);
	}

	@Override
	public void traitementDemande(int idDemandeLocation) throws RemoteException {
		demandeLocationDao.traitementDemande(idDemandeLocation);
	}

	@Override
	public DemandeLocation getDLocationByIdDemande(int idDemandeLocation) throws RemoteException {
		return demandeLocationDao.getDLocationByIdDemande(idDemandeLocation);
	}

	@Override
	public DemandeLocation getDemandeLocationByidVoitureAndIdUtilisateur(int idVoiture, int idUtilisateur) throws RemoteException {
		return demandeLocationDao.getDemandeLocationByidVoitureAndIdUtilisateur(idVoiture, idUtilisateur);
	}

	@Override
	public String Authentification(String email, String password) throws RemoteException {
		return utilisateurDAO.Authentification(email, password);
	}

	@Override
	public Utilisateur GetUtilisateurById(int id) throws RemoteException {
		return utilisateurDAO.GetUtilisateurById(id);
	}

	@Override
	public Role getRoleById(int id) {
		return roleDAO.getRoleById(id);
	}

	@Override
	public void NotifierUtilisateur(int IdUtilisateur, String message) throws RemoteException {
		notificationDao.NotifierUtilisateur(IdUtilisateur, message);
	}

	@Override
	public Notification GetNotificationById(int idNotification) throws RemoteException {
		return notificationDao.GetNotificationById(idNotification);
	}

	@Override
	public List<Notification> GetNotificationByUtilisateur(int idUtilisateur) throws RemoteException {
		return notificationDao.GetNotificationByUtilisateur(idUtilisateur);
	}

	@Override
	public ListeAttente AfficherListeAttenteByVoiture(int idVoiture) throws RemoteException {
		return listAttenteDao.AfficherListeAttenteByVoiture(idVoiture);
	}

	@Override
	public Utilisateur UtilisateurPrioritaire(ListeAttente a) throws RemoteException {
		return listAttenteDao.UtilisateurPrioritaire(a);
	}

	@Override
	public void TraitementListAttente(int idVoiture) throws RemoteException {
		listAttenteDao.TraitementListAttente(idVoiture);
	}

	@Override
	public boolean AjouterAvis(Avis a) throws RemoteException {
		return avisDao.AjouterAvis(a);
	}

	@Override
	public boolean SupprimerAvis(Avis a) throws RemoteException {
		return avisDao.SupprimerAvis(a);
	}

	@Override
	public boolean ModifierAvis(Avis a) throws RemoteException {
		return avisDao.ModifierAvis(a);
	}

	@Override
	public Avis GetAvisById(int idAvis) throws RemoteException {
		return avisDao.GetAvisById(idAvis);
	}

	@Override
	public List<Avis> ListAvisByVoiture(int idVoiture) throws RemoteException {
		return avisDao.ListAvisByVoiture(idVoiture);
	}

	@Override
	public List<DemandeLocation> getListAttente() throws RemoteException {
		return demandeLocationDao.getListAttente();
	}

	@Override
	public Utilisateur UtilisateurPrioritaire() throws RemoteException {
		return demandeLocationDao.UtilisateurPrioritaire();
	}

	@Override
	public List<DemandeLocation> getDemandeLocationByidVoiture(int idVoiture) throws RemoteException {
		return demandeLocationDao.getDemandeLocationByidVoiture(idVoiture);
	}

	@Override
	public void traitementListAttente(int idVoiture) throws RemoteException {
		demandeLocationDao.traitementListAttente(voitureDao.GetVoitureById(idVoiture));
	}

	

}
