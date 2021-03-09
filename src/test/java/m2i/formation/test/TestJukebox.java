package m2i.formation.test;

import m2i.formation.Application;
import m2i.formation.dao.IJukeboxDao;
import m2i.formation.dao.IUtilisateurDao;
import m2i.formation.model.Administrateur;
import m2i.formation.model.Jukebox;
import m2i.formation.model.TypeEnchere;

public class TestJukebox {

	public static void main(String[] args) {
		IJukeboxDao jukeboxDao = Application.getInstance().getJukeboxDao();

		Jukebox jukeboxDisco = new Jukebox("Le jukebox disco", "54198498", TypeEnchere.GRATUITE);
		Jukebox jukeboxRock = new Jukebox("Le jukebox rock", "54198498", TypeEnchere.MIXTE);
		
		jukeboxDao.create(jukeboxDisco);
		jukeboxDao.create(jukeboxRock);
		
		Administrateur admin = new Administrateur("Admin", 0, "***");
		
		IUtilisateurDao utilisateurDao = Application.getInstance().getUtilisateurDao();
		
		utilisateurDao.create(admin);
		
		jukeboxDisco.setAdministrateur(admin);
		
		jukeboxDao.update(jukeboxDisco);

	}

}
