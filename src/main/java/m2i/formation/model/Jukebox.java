package m2i.formation.model;

import java.util.ArrayList;
import java.util.List;

public class Jukebox {
	private Long id;
	private String nom;
	private String code;
	private TypeEnchere typeEnchere;

	private List<Utilisateur> connectes = new ArrayList<>();
	private List<Membre> fans = new ArrayList<>();
	private Administrateur administrateur;
	private Playlist playlist;
	private List<IEnchere> encheres = new ArrayList<>();

	public Jukebox() {
	}

	public Jukebox(String nom, String code, TypeEnchere typeEnchere) {
		this.nom = nom;
		this.code = code;
		this.typeEnchere = typeEnchere;
	}

	public Jukebox(Long id, String nom, String code, TypeEnchere typeEnchere) {
		this.id = id;
		this.nom = nom;
		this.code = code;
		this.typeEnchere = typeEnchere;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public TypeEnchere getTypeEnchere() {
		return typeEnchere;
	}

	public void setTypeEnchere(TypeEnchere typeEnchere) {
		this.typeEnchere = typeEnchere;
	}

	public List<Utilisateur> getConnectes() {
		return connectes;
	}

	public void setConnectes(List<Utilisateur> connectes) {
		this.connectes = connectes;
	}

	public List<Membre> getFans() {
		return fans;
	}

	public void setFans(List<Membre> fans) {
		this.fans = fans;
	}

	public Administrateur getAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(Administrateur administrateur) {
		this.administrateur = administrateur;
	}

	public Playlist getPlaylist() {
		return playlist;
	}

	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
	}

	public List<IEnchere> getEncheres() {
		return encheres;
	}

	public void setEncheres(List<IEnchere> encheres) {
		this.encheres = encheres;
	}

	@Override
	public String toString() {
		return "Jukebox [id=" + id + ", nom=" + nom + ", code=" + code + ", typeEnchere=" + typeEnchere + "]";
	}

}
