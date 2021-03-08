package m2i.formation.test;

import java.time.LocalDateTime;

import m2i.formation.Application;
import m2i.formation.dao.IEnchereDao;
import m2i.formation.model.Enchere;
import m2i.formation.model.EnchereGratuite;
import m2i.formation.model.EncherePayante;

public class TestEnchere {

	public static void main(String[] args) {

		IEnchereDao enchereDao = Application.getInstance().getEnchereDao();

		EnchereGratuite eg1 = new EnchereGratuite(LocalDateTime.now(), 1);
		EnchereGratuite eg2 = new EnchereGratuite(LocalDateTime.now(), 2);

		EncherePayante ep1 = new EncherePayante(LocalDateTime.now(), 1);
		EncherePayante ep2 = new EncherePayante(LocalDateTime.now(), 2);

		enchereDao.create(eg1);
		enchereDao.create(eg2);

		enchereDao.create(ep1);
		enchereDao.create(ep2);

		System.out.println("################");

		for (Enchere enchere : enchereDao.findAll()) {
			System.out.println(enchere.toString());
		}

		System.out.println("################");

	}

}
