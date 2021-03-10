package m2i.formation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import m2i.formation.dao.IEnchereDao;
import m2i.formation.dao.IJukeboxDao;
import m2i.formation.dao.IUtilisateurDao;
import m2i.formation.dao.jpa.EnchereDao;
import m2i.formation.dao.jpa.JukeboxDao;
import m2i.formation.dao.jpa.UtilisateurDao;

public class Application {
	private static Application instance = null;

	private final IEnchereDao enchereDao = new EnchereDao();
	private final IJukeboxDao jukeboxDao = new JukeboxDao();
	private final IUtilisateurDao utilisateurDao = new UtilisateurDao();
	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("jukebox-data");

	private Application() {
	}

	public static Application getInstance() {
		if (instance == null) {
			instance = new Application();
		}

		return instance;
	}

	public IEnchereDao getEnchereDao() {
		return enchereDao;
	}
	
	public IJukeboxDao getJukeboxDao() {
		return jukeboxDao;
	}
	
	public IUtilisateurDao getUtilisateurDao() {
		return utilisateurDao;
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox-data", "root", "root");
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

}
