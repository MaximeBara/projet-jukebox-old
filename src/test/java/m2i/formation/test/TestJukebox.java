package m2i.formation.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import m2i.formation.dao.IJukeboxDao;
import m2i.formation.dao.IUtilisateurDao;
import m2i.formation.model.Administrateur;
import m2i.formation.model.Jukebox;
import m2i.formation.model.TypeEnchere;

public class TestJukebox {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		IJukeboxDao jukeboxDao = context.getBean(IJukeboxDao.class);
		IUtilisateurDao utilisateurDao = context.getBean(IUtilisateurDao.class);

		Jukebox jukeboxDisco = new Jukebox("Le jukebox disco", "54198498", TypeEnchere.GRATUITE);
		Jukebox jukeboxRock = new Jukebox("Le jukebox rock", "54198498", TypeEnchere.MIXTE);

		jukeboxDao.save(jukeboxDisco);
		jukeboxDao.save(jukeboxRock);

		Administrateur admin = new Administrateur("Admin", 0, "***");

		utilisateurDao.save(admin);

		jukeboxDisco.setAdministrateur(admin);

		jukeboxDao.save(jukeboxDisco);

		context.close();
	}

}
