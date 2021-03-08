package m2i.formation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Playlist {
	private Long id;
	private String nom;
	private Date dateCreation;

	private Membre createur;
	private List<Titre> titres = new ArrayList<>();
	private List<Jukebox> jukeboxes = new ArrayList<>();

	public Playlist() {
	}

	public Playlist(String nom, Date dateCreation) {
		this.nom = nom;
		this.dateCreation = dateCreation;
	}

	public Playlist(Long id, String nom, Date dateCreation) {
		this.id = id;
		this.nom = nom;
		this.dateCreation = dateCreation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Membre getCreateur() {
		return createur;
	}

	public void setCreateur(Membre createur) {
		this.createur = createur;
	}

	public List<Titre> getTitres() {
		return titres;
	}

	public void setTitres(List<Titre> titres) {
		this.titres = titres;
	}

	public List<Jukebox> getJukeboxes() {
		return jukeboxes;
	}

	public void setJukeboxes(List<Jukebox> jukeboxes) {
		this.jukeboxes = jukeboxes;
	}

	@Override
	public String toString() {
		return "Playlist [id=" + id + ", nom=" + nom + ", dateCreation=" + dateCreation + ", createur=" + createur
				+ ", titres=" + titres + ", jukeboxes=" + jukeboxes + "]";
	}

}
