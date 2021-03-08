package m2i.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Membre extends Utilisateur {

	@Column(length= 15)
	private String motDePasse;
	
	private int point;

	public Membre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Membre(Long id, String pseudo, int point, String motDePasse) {
		super(id, pseudo);
		this.motDePasse = motDePasse;
		this.point = point;
	}

	public Membre(String pseudo, int point, String motDePasse) {
		super(pseudo);
		this.motDePasse = motDePasse;
		this.point = point;

	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "Membre [motDePasse=" + motDePasse + ", point=" + point + ", getId()=" + getId() + ", getPseudo()="
				+ getPseudo() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + "]";
	}

}
