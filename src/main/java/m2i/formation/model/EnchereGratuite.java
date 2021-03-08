package m2i.formation.model;

import java.util.Date;

public class EnchereGratuite extends Enchere {

	public EnchereGratuite() {
		super();
	}

	public EnchereGratuite(Date date, int valeur) {
		super(date, valeur, TypeMonnaie.VOTE);
	}

	public EnchereGratuite(Long id, Date date, int valeur) {
		super(id, date, valeur, TypeMonnaie.VOTE);
	}

}
