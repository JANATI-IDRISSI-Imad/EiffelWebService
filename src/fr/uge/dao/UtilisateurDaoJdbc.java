package fr.uge.dao;

import java.rmi.RemoteException;

import commun.Utilisateur;
import fr.uge.dao.jdbc.Database;
import fr.uge.dao.mappers.ModelMapper;

public class UtilisateurDaoJdbc implements UtilisateurDAO{

	private Database db;
	private String tableName ="utilisateur";
	private RoleDAO roleDAO;
	public UtilisateurDaoJdbc(Database db,RoleDAO roleDAO) {
		this.db=db;
		this.roleDAO=roleDAO;
	}
	
	@Override
	public String Authentification(String email, String password) throws RemoteException {
		String data[][] = db.select(tableName, "emailU", email);
		if (data == null) return "not Exist";
		if (data.length <= 1) return "not Exist";
		Utilisateur u=ModelMapper.getUtilisateur(roleDAO,data[1]);
		if(u.getMdp().equals(password))return "ok";
		return "mot de passe incorrecte";
	}



	@Override
	public Utilisateur GetUtilisateurById(int id) throws RemoteException {
		String data[][] = db.select(tableName, "idUtilisateur", id);
		if (data == null) return null;
		if (data.length <= 1) return null;
		return  ModelMapper.getUtilisateur(roleDAO,data[1]);		
	}

	@Override
	public Utilisateur GetUtilisateurByEmail(String email) throws RemoteException {
		String data[][] = db.select(tableName, "emailU", email);
		if (data == null) return null;
		if (data.length <= 1) return null;
		return  ModelMapper.getUtilisateur(roleDAO,data[1]);		
	}
	
}
