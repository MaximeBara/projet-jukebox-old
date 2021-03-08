package m2i.formation.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TITRE")
public class Titre {
	@Id
	private Long id;
	private String nom;
	private String artiste;
	private String lien;

	private List<Playlist> playlists = new ArrayList<>();

	public Titre() {
	}

	public Titre(String nom, String artiste, String lien) {
		this.nom = nom;
		this.artiste = artiste;
		this.lien = lien;
	}

	public Titre(Long id, String nom, String artiste, String lien) {
		this.id = id;
		this.nom = nom;
		this.artiste = artiste;
		this.lien = lien;
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

	public String getArtiste() {
		return artiste;
	}

	public void setArtiste(String artiste) {
		this.artiste = artiste;
	}

	public String getLien() {
		return lien;
	}

	public void setLien(String lien) {
		this.lien = lien;
	}

	public List<Playlist> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(List<Playlist> playlists) {
		this.playlists = playlists;
	}

	@Override
	public String toString() {
		return "Titre [id=" + id + ", nom=" + nom + ", artiste=" + artiste + ", lien=" + lien + ", playlists="
				+ playlists + "]";
	}

}
