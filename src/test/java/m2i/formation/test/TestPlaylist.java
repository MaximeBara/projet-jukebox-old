package m2i.formation.test;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import m2i.formation.dao.IPlaylistDao;
import m2i.formation.model.Playlist;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/application-context.xml")
public class TestPlaylist {
	@Autowired
	IPlaylistDao playlistDao;


	@Before
	public void load() {
		Playlist playlist1 = new Playlist("La playlist Rock", new Date());
		playlistDao.save(playlist1);
		Playlist playlist2 = new Playlist("La playlist Rap", new Date());
		playlistDao.save(playlist2);
		Playlist playlist3 = new Playlist("La playlist Jazz", new Date());
		playlistDao.save(playlist3);

	}
	
	@Test
	public void testFindAll() {
		Assert.assertEquals(3, playlistDao.findAll().size());
	}

}
