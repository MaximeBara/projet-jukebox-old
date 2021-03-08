package m2i.formation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity
public abstract class Utilisateur {

	/*@Id
	@GeneratedValue*/
	private Long id ;
	private String pseudo ;

	public Utilisateur(){
		super();
	}
	
	public Utilisateur(String pseudo){
		super();
		this.pseudo = pseudo;
	}

	public Utilisateur(Long id, String pseudo){
		super();
		this.id = id;
		this.pseudo = pseudo;
	}
	
	public void estMembre() {
		
	}
	
	public void estInvite() {
		
	}

	public void estAdministrateur() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", pseudo=" + pseudo + ", getClass()=" + getClass() 
		+ ", toString()=" + super.toString() + "]";
	}
	
	
}
