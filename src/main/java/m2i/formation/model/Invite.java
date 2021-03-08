package m2i.formation.model;

public class Invite extends Utilisateur {

	
	public Invite() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Invite(Long id, String pseudo) {
		super(id, pseudo);
		// TODO Auto-generated constructor stub
	}

	public Invite(String pseudo) {
		super(pseudo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Invite [getId()=" + getId() + ", getPseudo()=" + getPseudo() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	
}
