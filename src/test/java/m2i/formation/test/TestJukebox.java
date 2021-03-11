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
import m2i.formation.model.Jukebox;
import m2i.formation.model.TypeEnchere;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/application-context.xml")
public class TestJukebox {
	@Autowired
	IJukeboxDao jukeboxDao;
	@Autowired
	IUtilisateurDao utilisateurDao;

	@Before
	public void load() {
		Jukebox jukeboxDisco = new Jukebox("Le jukebox disco", "54198498", TypeEnchere.GRATUITE);
		Jukebox jukeboxRock = new Jukebox("Le jukebox rock", "54198498", TypeEnchere.MIXTE);

		jukeboxDao.save(jukeboxDisco);
		jukeboxDao.save(jukeboxRock);
		
		Administrateur admin = new Administrateur("Admin", 0, "***");
		
		utilisateurDao.save(admin);
		
		jukeboxDisco.setAdministrateur(admin);
		
		jukeboxDao.save(jukeboxDisco);

	}
	
	@Test
	public void testFindAll() {
		Assert.assertEquals(2, jukeboxDao.findAll().size());
	}

}
