package m2i.formation.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import m2i.formation.dao.IJukeboxDao;
import m2i.formation.model.Jukebox;

@Repository
@Transactional(readOnly = true)
public class JukeboxDao implements IJukeboxDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Jukebox> findAll() {
		List<Jukebox> jukeboxes = new ArrayList<>();

		TypedQuery<Jukebox> query = em.createQuery("select adr from Adresse adr", Jukebox.class);

		jukeboxes = query.getResultList();

		return jukeboxes;
	}

	@Override
	public Jukebox find(Long id) {
		return em.find(Jukebox.class, id);
	}

	@Override
	@Transactional(readOnly = false)
	public void create(Jukebox obj) {

		em.persist(obj);

	}

	@Override
	@Transactional(readOnly = false)
	public Jukebox update(Jukebox obj) {
		return em.merge(obj);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Long id) {
		em.remove(em.find(Jukebox.class, id));
	}

}
