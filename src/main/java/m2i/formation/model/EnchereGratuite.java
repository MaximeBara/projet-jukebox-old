package m2i.formation.model;

import java.util.Date;

public class EnchereGratuite implements IEnchere {

	private Long id;
	private Date date;
	private int valeur;
	private TypeMonnaie monnaie;
	private Membre membre;
	private Jukebox jukebox;
	private Titre titre;

	public EnchereGratuite() {
	}

	public EnchereGratuite(Date date, int valeur) {
		this.date = date;
		this.valeur = valeur;
		this.monnaie = TypeMonnaie.VOTE;
	}

	public EnchereGratuite(Long id, Date date, int valeur) {
		this.id = id;
		this.date = date;
		this.valeur = valeur;
		this.monnaie = TypeMonnaie.VOTE;
	}

	@Override
	public void encherir() {
		// TODO Auto-generated method stub

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public TypeMonnaie getMonnaie() {
		return monnaie;
	}

	public void setMonnaie(TypeMonnaie monnaie) {
		this.monnaie = monnaie;
	}

	public Membre getMembre() {
		return membre;
	}

	public void setMembre(Membre membre) {
		this.membre = membre;
	}

	public Jukebox getJukebox() {
		return jukebox;
	}

	public void setJukebox(Jukebox jukebox) {
		this.jukebox = jukebox;
	}

	public Titre getTitre() {
		return titre;
	}

	public void setTitre(Titre titre) {
		this.titre = titre;
	}

	@Override
	public String toString() {
		return "EnchereGratuite [id=" + id + ", date=" + date + ", valeur=" + valeur + ", monnaie=" + monnaie
				+ ", membre=" + membre + ", jukebox=" + jukebox + ", titre=" + titre + "]";
	}
	
}
