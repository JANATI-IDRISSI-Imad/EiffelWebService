package fr.uge.dao;



import commun.Role;
import fr.uge.dao.jdbc.Database;
import fr.uge.dao.mappers.ModelMapper;

public class RoleDaoJdbc implements RoleDAO{
	private String tableName="role";
	private Database db;
	public RoleDaoJdbc(Database db) {
		this.db=db;
	}
	
	@Override
	public  Role getRoleById(int id) {
		String data[][] = db.select(tableName, "idRole", id);
		if (data == null) return null;
		if (data.length <= 1) return null;
		return  ModelMapper.getRole(data[1]);	
	}

}
