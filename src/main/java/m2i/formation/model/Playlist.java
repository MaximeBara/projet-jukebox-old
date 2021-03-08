package m2i.formation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PLAYLIST")
public class Playlist {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "nom", length = 20)
	private String nom;
	@Temporal(TemporalType.DATE)
	@Column(name = "dateCreation")
	private Date dateCreation;

	@ManyToOne()
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
