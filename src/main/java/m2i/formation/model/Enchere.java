package m2i.formation.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public abstract class Enchere {

	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "date")
	private Date date;
	@Column(name = "valeur")
	private int valeur;
	@Enumerated(EnumType.STRING)
	@Column(name = "monnaie")
	private TypeMonnaie monnaie;
	@ManyToOne
	@JoinColumn(name = "membre_id")
	private Membre membre;
	@ManyToOne
	@JoinColumn(name = "jukebox_id")
	private Jukebox jukebox;
	@ManyToOne
	@JoinColumn(name = "titre_id")
	private Titre titre;

	public Enchere() {
		super();
	}

	public Enchere(Date date, int valeur, TypeMonnaie monnaie) {
		this.date = date;
		this.valeur = valeur;
		this.monnaie = monnaie;
	}

	public Enchere(Long id, Date date, int valeur, TypeMonnaie monnaie) {
		this.id = id;
		this.date = date;
		this.valeur = valeur;
		this.monnaie = monnaie;
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