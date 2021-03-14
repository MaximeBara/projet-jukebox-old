package m2i.formation.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import m2i.formation.dao.IPlaylistDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/application-context.xml")
public class TestPlaylist {
	@Autowired
	IPlaylistDao playlistDao;

	@Test
	public void testFindAllByMembre() {
		// TODO
	}
	
	@Test
	public void testFindAllByTitre() {
		// TODO
	}
	
	

}
