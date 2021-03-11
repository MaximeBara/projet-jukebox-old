package m2i.formation.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import m2i.formation.dao.ITitreDao;
import m2i.formation.model.Titre;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/application-context.xml")
public class TestTitre {
	@Autowired
	ITitreDao titreDao;


	@Before
	public void load() {
		Titre playlist1 = new Titre("La titre Rock", "RockMan", "youtube.fr/rock");
		titreDao.save(playlist1);
		Titre playlist2 = new Titre("La titre Rap", "RapMan", "youtube.fr/rap");
		titreDao.save(playlist2);
		Titre playlist3 = new Titre("La titre Jazz", "JazzMan", "youtube.fr/jazz");
		titreDao.save(playlist3);

	}
	
	@Test
	public void testFindAll() {
		Assert.assertEquals(3, titreDao.findAll().size());
	}

}
