package m2i.formation.model;

import java.util.Date;

public class EncherePayante extends Enchere {

	public EncherePayante() {
		super();
	}

	public EncherePayante(Date date, int valeur) {
		super(date, valeur, TypeMonnaie.POINT);
	}

	public EncherePayante(Long id, Date date, int valeur) {
		super(id, date, valeur, TypeMonnaie.POINT);
	}

}
