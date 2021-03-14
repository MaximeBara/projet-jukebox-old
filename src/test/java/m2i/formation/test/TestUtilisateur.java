package m2i.formation.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import m2i.formation.dao.IUtilisateurDao;
import m2i.formation.model.Administrateur;
import m2i.formation.model.Invite;
import m2i.formation.model.Jukebox;
import m2i.formation.model.Membre;
import m2i.formation.model.TypeEnchere;
import m2i.formation.model.Utilisateur;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/application-context.xml")
public class TestUtilisateur {

	@Autowired
	private IUtilisateurDao utilisateurDao;

	@Before
	public void utilisateurDaoCreate() {
		Utilisateur utilisateur = new Invite("josse");
		utilisateurDao.save(utilisateur);
		Utilisateur utilisateur2 = new Membre("lilo", 8, "member");
		utilisateurDao.save(utilisateur2);
		Utilisateur utilisateur3 = new Administrateur("superlilo", 2, "root");
		utilisateurDao.save(utilisateur3);

	}

	@Test
	public void testFindAll() {
		Assert.assertEquals(7, utilisateurDao.findAll().size());
	}

	@Test
	public void membreUpdatePoint() {
		// A - Arrange
		Membre utilisateur = new Membre("superlilo", 2, "root");
		Jukebox jukeboxDisco1 = new Jukebox(1L, "Le jukebox disco", "54198498", TypeEnchere.GRATUITE);

		// utilisateur.setJukeboxFavoris(jukeboxDisco1);

		utilisateurDao.save(utilisateur);
		// jukeboxDao.save(jukeboxDisco1);
		// -----------

		// A - Act
		Membre membreFind = utilisateurDao.findByID(utilisateur.getId());

		membreFind.setPoint(3);

		// A - Assert
		membreFind = (Membre) utilisateurDao.findByID(membreFind.getId());

		Assert.assertEquals("superlilo", membreFind.getPseudo());
		Assert.assertEquals(3, membreFind.getPoint());
		Assert.assertEquals("root", membreFind.getMotDePasse());
		// -----------
	}
}
