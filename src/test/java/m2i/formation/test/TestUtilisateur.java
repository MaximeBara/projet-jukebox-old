package m2i.formation.test;

import java.text.ParseException;

import m2i.formation.model.Administrateur;
import m2i.formation.model.Invite;
import m2i.formation.model.Membre;

public class TestUtilisateur {

	
	public static void main(String[] args) throws ParseException {
		
		Invite invite = new Invite(1l,"toto");
		Administrateur admin = new Administrateur (1l,"toto",1,"motdepasse");
		Membre membre = new Membre (1l,"toto",1,"motdepasse");
		System.out.println("Invite: "+invite);
		System.out.println("admin: "+admin);
		System.out.println("membre: "+membre);
	}
}
