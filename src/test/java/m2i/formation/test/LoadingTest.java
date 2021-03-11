package m2i.formation.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import m2i.formation.dao.IEnchereDao;
import m2i.formation.dao.IJukeboxDao;
import m2i.formation.dao.IUtilisateurDao;

public class LoadingTest {

	private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

	@Test
	public void load() {
		IEnchereDao enchereDao = context.getBean(IEnchereDao.class);
		IJukeboxDao jukeboxDao = context.getBean(IJukeboxDao.class);
		IUtilisateurDao utilisateurDao = context.getBean(IUtilisateurDao.class);

		// JEU DE DONNES A METTRE ICI POUR TOUS LES DAOS

	}
}
