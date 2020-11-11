package fr.uge.dao;

import java.rmi.RemoteException;
import java.util.List;

import commun.DemandeLocation;

public class DemandeLocationDaoJdbc implements DemandeLocationDao{

	@Override
	public boolean newDemandeLocation(DemandeLocation d) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void traitementDemande(int idDemandeLocation) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DemandeLocation getDLocationByIdDemande(int idDemandeLocation) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DemandeLocation> getDemandeLocationNonTraiteByidProduit(int idVoiture) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DemandeLocation getDemandeLocationByidVoitureAndIdUtilisateur(int idVoiture, int idUtilisateur)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DemandeLocation> getDemandeLocationByidUser(int idUtilisateur) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
