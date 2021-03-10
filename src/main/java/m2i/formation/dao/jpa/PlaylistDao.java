package m2i.formation.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import m2i.formation.dao.IPlaylistDao;
import m2i.formation.model.Playlist;

@Repository
@Transactional(readOnly = true)
public class PlaylistDao implements IPlaylistDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Playlist> findAll() {
		List<Playlist> playlists = new ArrayList<>();

		TypedQuery<Playlist> query = em.createQuery("select adr from Adresse adr", Playlist.class);

		playlists = query.getResultList();

		return playlists;
	}

	@Override
	public Playlist find(Long id) {
		return em.find(Playlist.class, id);
	}

	@Override
	@Transactional(readOnly = false)
	public void create(Playlist obj) {
		em.persist(obj);
	}

	@Override
	@Transactional(readOnly = false)
	public Playlist update(Playlist obj) {
		return em.merge(obj);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Long id) {
		em.remove(em.find(Playlist.class, id));
	}

}
