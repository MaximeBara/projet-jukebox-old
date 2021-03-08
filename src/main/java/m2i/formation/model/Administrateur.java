package m2i.formation.model;

public class Administrateur extends Membre {



	public Administrateur() {
		super();
	}

	public Administrateur(Long id, String pseudo, int point, String motDePasse) {
		super(id, pseudo, point, motDePasse);
	}

	public Administrateur(String pseudo, int point, String motDePasse) {
		super(pseudo, point, motDePasse);
	}

	@Override
	public String toString() {
		return "Administrateur [getMotDePasse()=" + getMotDePasse() + ", getPoint()=" + getPoint() + ", toString()="
				+ super.toString() + ", getId()=" + getId() + ", getPseudo()=" + getPseudo() + ", getClass()="
				+ getClass() + "]";
	}
	
	
}
