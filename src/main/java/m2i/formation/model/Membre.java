package m2i.formation.model;

public class Membre extends Utilisateur {

	private String motDePasse ;
	private int point ;
	
	
	public Membre() {
		super();
		
	}
	
	public Membre(String motDePasse, int point) {
		super();
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
				+ getPseudo() + ", toString()=" + super.toString() + ", getClass()=" + getClass() +"]";
	}
	
	
}
