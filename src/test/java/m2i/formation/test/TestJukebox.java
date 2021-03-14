package m2i.formation.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import m2i.formation.dao.IJukeboxDao;
import m2i.formation.dao.IPlaylistDao;
import m2i.formation.dao.IUtilisateurDao;
import m2i.formation.model.Administrateur;
import m2i.formation.model.Invite;
import m2i.formation.model.Jukebox;
import m2i.formation.model.Membre;
import m2i.formation.model.Playlist;
import m2i.formation.model.TypeEnchere;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/application-context.xml")
public class TestJukebox {
	@Autowired
	IJukeboxDao jukeboxDao;
	@Autowired
	IUtilisateurDao utilisateurDao;
	@Autowired
	IPlaylistDao playlistDao;

	@Test
	public void testFindAllConnectes() {
		Jukebox jukeboxDisco = new Jukebox("Le jukebox disco", "54198498", TypeEnchere.GRATUITE);
		jukeboxDao.save(jukeboxDisco);
		int before = jukeboxDao.findAllConnectesById(jukeboxDisco.getId()).size();
		Membre membre = new Membre("membre", 0, "***");
		membre.setJukebox(jukeboxDisco);
		utilisateurDao.save(membre);
		Assert.assertEquals(before + 1, jukeboxDao.findAllConnectesById(jukeboxDisco.getId()).size());
	}

	@Test
	public void testFindAllFansById() {
		Jukebox jukeboxDisco = new Jukebox("Le jukebox disco", "54198498", TypeEnchere.GRATUITE);
		jukeboxDao.save(jukeboxDisco);
		int before = jukeboxDao.findAllFansById(jukeboxDisco.getId()).size();
		Membre membre = new Membre("membre", 0, "***");
		membre.setJukeboxFavoris(jukeboxDisco);
		utilisateurDao.save(membre);
		Assert.assertEquals(before + 1, jukeboxDao.findAllFansById(jukeboxDisco.getId()).size());
	}

	@Test
	public void testFindAdministrateurById() {
		Administrateur admin = new Administrateur("AdminTest", 0, "******");
		utilisateurDao.save(admin);

		Jukebox jukebox = new Jukebox("AdminTest", "19448", TypeEnchere.MIXTE);
		jukebox.setAdministrateur(admin);
		jukeboxDao.save(jukebox);

		Administrateur newAdmin = jukeboxDao.findAdministrateurById(jukebox.getId());
		Assert.assertEquals(admin.getPseudo(), newAdmin.getPseudo());
		Assert.assertEquals(admin.getMotDePasse(), newAdmin.getMotDePasse());
		Assert.assertEquals(admin.getPoint(), newAdmin.getPoint());
	}

	@Test
	public void testfindPlaylistById() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Jukebox jukebox = new Jukebox("AdminTest", "19448", TypeEnchere.MIXTE);
		Playlist playlist = new Playlist("La playlist", sdf.parse("01/03/2021"));
		playlistDao.save(playlist);
		jukebox.setPlaylist(playlist);
		jukeboxDao.save(jukebox);
		
		Playlist newPlaylist = jukeboxDao.findPlaylistById(jukebox.getId());
		
		Assert.assertEquals(playlist.getId(), newPlaylist.getId());
		Assert.assertEquals(playlist.getNom(), newPlaylist.getNom());
		Assert.assertEquals(playlist.getDateCreation(), newPlaylist.getDateCreation());
	}

	@Test
	public void testfindByUtilisateur() {
		Jukebox jukeboxDisco = new Jukebox("Le jukebox disco", "54198498", TypeEnchere.GRATUITE);

		jukeboxDao.save(jukeboxDisco);

		Membre membre = new Membre("membreTest", 0, "***");
		Invite invite = new Invite("inviteTest");

		membre.setJukebox(jukeboxDisco);
		invite.setJukebox(jukeboxDisco);

		utilisateurDao.save(membre);
		utilisateurDao.save(invite);
		
		Jukebox newJukeboxMembre = jukeboxDao.findByUtilisateur(membre);
		Jukebox newJukeboxInvite = jukeboxDao.findByUtilisateur(invite);
		

		Assert.assertEquals(jukeboxDisco.getId(), newJukeboxMembre.getId());
		Assert.assertEquals(jukeboxDisco.getNom(), newJukeboxMembre.getNom());
		Assert.assertEquals(jukeboxDisco.getCode(), newJukeboxMembre.getCode());
		Assert.assertEquals(jukeboxDisco.getTypeEnchere(), newJukeboxMembre.getTypeEnchere());
		
		Assert.assertEquals(jukeboxDisco.getId(), newJukeboxInvite.getId());
		Assert.assertEquals(jukeboxDisco.getNom(), newJukeboxInvite.getNom());
		Assert.assertEquals(jukeboxDisco.getCode(), newJukeboxInvite.getCode());
		Assert.assertEquals(jukeboxDisco.getTypeEnchere(), newJukeboxInvite.getTypeEnchere());
	}

	@Test
	public void testfindAllByMembre() {
		Jukebox jukeboxDisco = new Jukebox("Le jukebox disco", "54198498", TypeEnchere.GRATUITE);
		Jukebox jukeboxRock = new Jukebox("Le jukebox rock", "54198498", TypeEnchere.MIXTE);

		jukeboxDao.save(jukeboxDisco);
		jukeboxDao.save(jukeboxRock);

		Membre membre = new Membre("membreTest", 0, "***");

		membre.getJukeboxFavoris().add(jukeboxDisco);
		membre.getJukeboxFavoris().add(jukeboxRock);

		utilisateurDao.save(membre);

		Assert.assertEquals(2, jukeboxDao.findAllByMembre(membre).size());
	}
}
