package m2i.formation.test;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import m2i.formation.dao.IEnchereDao;
import m2i.formation.dao.IJukeboxDao;
import m2i.formation.dao.IUtilisateurDao;
import m2i.formation.model.Enchere;
import m2i.formation.model.EnchereGratuite;
import m2i.formation.model.EncherePayante;

public class TestJUnitEnchere {

	private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
	
	@Before
	public void load() {
		IEnchereDao enchereDao = context.getBean(IEnchereDao.class);
		IJukeboxDao jukeboxDao = context.getBean(IJukeboxDao.class);
		IUtilisateurDao utilisateurDao = context.getBean(IUtilisateurDao.class);

		// Partie enchère
		
		EnchereGratuite eg1 = new EnchereGratuite(LocalDateTime.now(), 1);
		EnchereGratuite eg2 = new EnchereGratuite(LocalDateTime.now(), 2);

		EncherePayante ep1 = new EncherePayante(LocalDateTime.now(), 1);
		EncherePayante ep2 = new EncherePayante(LocalDateTime.now(), 2);
		
		enchereDao.create(eg1);
		enchereDao.create(eg2);
		enchereDao.create(ep1);
		enchereDao.create(ep2);
		
		// Partie jukebox
		
		
		
		// Partie utilisateur
		
		
		
	}
	
	@Test
	public void test() {

		IEnchereDao enchereDao = context.getBean(IEnchereDao.class);

		System.out.println("################");

		for (Enchere enchere : enchereDao.findAll()) {
			System.out.println(enchere.toString());
		}

		System.out.println("################");

		System.out.println(enchereDao.find(1L));
		System.out.println(enchereDao.find(3L));

		System.out.println("################");

		enchereDao.find(1L).setValeur(10);
		enchereDao.update(enchereDao.find(1L));

		System.out.println(enchereDao.find(1L).toString());

		System.out.println("################");

		enchereDao.delete(1L);

		for (Enchere enchere : enchereDao.findAll()) {
			System.out.println(enchere.toString());
		}

		System.out.println("################");
	}

}
