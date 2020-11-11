package fr.uge.main;
import commun.Notification;
import fr.uge.dao.NotificationDao;
import fr.uge.dao.NotificationDaoJdbc;
import fr.uge.dao.UtilisateurDAO;
import fr.uge.dao.UtilisateurDaoJdbc;
import fr.uge.dao.VoitureDao;
import fr.uge.dao.VoitureDaoJdbc;
import fr.uge.dao.jdbc.DataSource;
import fr.uge.dao.jdbc.Database;
import fr.uge.dao.jdbc.MySQLDataSource;



public class Client {

	public Client() {
		exp01();
	}
	public static void main(String[] args) {
		new Client();

	}
	
	void exp01() {
		try {
			DataSource ds=new MySQLDataSource("eiffel");
			Database db=new Database(ds);
			//VoitureDao dao = new VoitureDaoJdbc(db);
			NotificationDao dao = new NotificationDaoJdbc(db);
		//	UtilisateurDAO utilisateurDAO=new UtilisateurDaoJdbc(db);
			for (Notification e : dao.GetNotificationByUtilisateur(1)) {
				System.out.println(e.getMessage());
			}
			//kayn hta voiture
		
		} catch (Exception e) {
			
		}
	}
	
	
	


}
