package commun;

import java.io.Serializable;

public class Role implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idRole;
	private String role;
	
	public Role() {
		// TODO Auto-generated constructor stub
	}
	public Role(int idRole, String role) {
		super();
		this.idRole = idRole;
		this.role = role;
	}
	
	public int getIdRole() {
		return idRole;
	}
	
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "Role [idRole=" + idRole + ", role=" + role + "]";
	}
	

}
