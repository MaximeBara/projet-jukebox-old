package m2i.formation.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import m2i.formation.dao.IJukeboxDao;
import m2i.formation.dao.IUtilisateurDao;
import m2i.formation.model.Administrateur;
import m2i.formation.model.Invite;
import m2i.formation.model.Jukebox;
import m2i.formation.model.Membre;
import m2i.formation.model.TypeEnchere;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/application-context.xml")
public class TestJukebox {
	@Autowired
	IJukeboxDao jukeboxDao;
	@Autowired
	IUtilisateurDao utilisateurDao;
	
	static boolean flag = true;

	@Before
	public void load() {
		
		if(flag) {
			Jukebox jukeboxDisco = new Jukebox(1L, "Le jukebox disco", "54198498", TypeEnchere.GRATUITE);
			Jukebox jukeboxRock = new Jukebox(2L, "Le jukebox rock", "54198498", TypeEnchere.MIXTE);

			jukeboxDao.save(jukeboxDisco);
			jukeboxDao.save(jukeboxRock);

			Administrateur admin = new Administrateur("Admin", 0, "***");

			Membre membre1 = new Membre("membre1", 0, "***");
			Membre membre2 = new Membre("membre2", 0, "***");
			Invite invite = new Invite("invite");

			membre1.setJukebox(jukeboxDisco);
			membre2.setJukebox(jukeboxDisco);
			invite.setJukebox(jukeboxDisco);

			utilisateurDao.save(membre1);
			utilisateurDao.save(membre2);
			utilisateurDao.save(invite);
			utilisateurDao.save(admin);

			jukeboxDisco.setAdministrateur(admin);

			membre1.getJukeboxes().add(jukeboxRock);
			utilisateurDao.save(membre1);

			jukeboxDao.save(jukeboxDisco);
			
			
			flag = false;
		}
		

	}

	@Test
	public void testFindAllConnectes() {
		Assert.assertEquals(3, jukeboxDao.findAllConnectesById(1L).size());
	}

	@Test
	public void testFindAllFansById() {
		Assert.assertEquals(1, jukeboxDao.findAllFansById(2L).size());
	}

}
