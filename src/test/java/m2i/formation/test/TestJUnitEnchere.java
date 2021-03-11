package m2i.formation.test;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import m2i.formation.dao.IEnchereDao;
import m2i.formation.dao.IJukeboxDao;
import m2i.formation.dao.ITitreDao;
import m2i.formation.dao.IUtilisateurDao;
import m2i.formation.model.EnchereGratuite;
import m2i.formation.model.EncherePayante;
import m2i.formation.model.Jukebox;
import m2i.formation.model.Membre;
import m2i.formation.model.Titre;
import m2i.formation.model.TypeEnchere;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/application-context.xml")
public class TestJUnitEnchere {

	@Autowired
	IEnchereDao enchereDao;
	@Autowired
	IJukeboxDao jukeboxDao;
	@Autowired
	IUtilisateurDao utilisateurDao;
	@Autowired
	ITitreDao titreDao;

	@Before
	public void load() {

		Jukebox j1 = new Jukebox("Bass music Jukebox", "123456789", TypeEnchere.GRATUITE);
		Jukebox j2 = new Jukebox("Rock music Jukebox", "987654321", TypeEnchere.PAYANTE);
		Jukebox j3 = new Jukebox("Metal music Jukebox", "123412341", TypeEnchere.MIXTE);
		jukeboxDao.save(j1);
		jukeboxDao.save(j2);
		jukeboxDao.save(j3);

		Titre t1 = new Titre("Offender", "Dimension", "https://www.youtube.com/watch?v=d2u3BRGd2rs");
		Titre t2 = new Titre("Saviour", "Dimension", "https://www.youtube.com/watch?v=R0ppOs2o-cw");
		Titre t3 = new Titre("Organ", "Dimension", "https://www.youtube.com/watch?v=GJQZrANyNJY");
		titreDao.save(t1);
		titreDao.save(t2);
		titreDao.save(t3);

		Membre m1 = new Membre("Maxime", 10, "test");
		Membre m2 = new Membre("Josse", 15, "test");
		Membre m3 = new Membre("Guillaume", 20, "test");
		utilisateurDao.save(m1);
		utilisateurDao.save(m2);
		utilisateurDao.save(m3);

		EnchereGratuite eg1 = new EnchereGratuite(LocalDateTime.now(), 1);
		EnchereGratuite eg2 = new EnchereGratuite(LocalDateTime.now(), 2);
		EnchereGratuite eg3 = new EnchereGratuite(LocalDateTime.now(), 3);
		EncherePayante ep1 = new EncherePayante(LocalDateTime.now(), 1);
		EncherePayante ep2 = new EncherePayante(LocalDateTime.now(), 2);
		EncherePayante ep3 = new EncherePayante(LocalDateTime.now(), 3);
		eg1.setJukebox(j1);
		eg1.setMembre(m1);
		eg1.setTitre(t1);
		eg2.setJukebox(j1);
		eg2.setMembre(m2);
		eg2.setTitre(t2);

		ep1.setJukebox(j2);
		ep1.setMembre(m1);
		ep1.setTitre(t1);
		ep2.setJukebox(j2);
		ep2.setMembre(m2);
		ep2.setTitre(t2);

		eg3.setJukebox(j3);
		eg3.setMembre(m1);
		eg3.setTitre(t1);
		ep3.setJukebox(j3);
		ep3.setMembre(m3);
		ep3.setTitre(t2);

		enchereDao.save(eg1);
		enchereDao.save(eg2);
		enchereDao.save(eg3);
		enchereDao.save(ep1);
		enchereDao.save(ep2);
		enchereDao.save(ep3);

	}

	@Test
	public void testFindByJukeboxAndTermineeFalse() {
		Assert.assertEquals(2, enchereDao.findByJukeboxAndTermineeFalse(jukeboxDao.findById(1L).orElse(null)).size());
	}
	
	@Test
	public void testFindByJukeboxAndTermineeTrue() {
		Assert.assertEquals(0, enchereDao.findByJukeboxAndTermineeTrue(jukeboxDao.findById(1L).orElse(null)).size());
	}
	
	

}
