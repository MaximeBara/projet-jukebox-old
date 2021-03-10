package m2i.formation.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import m2i.formation.dao.ITitreDao;
import m2i.formation.model.Titre;

@Repository
@Transactional(readOnly = true)
public class TitreDao implements ITitreDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Titre> findAll() {
		List<Titre> titres = new ArrayList<>();

		TypedQuery<Titre> query = em.createQuery("select adr from Adresse adr", Titre.class);

		titres = query.getResultList();

		return titres;
	}

	@Override
	public Titre find(Long id) {
		return em.find(Titre.class, id);
	}

	@Override
	@Transactional(readOnly = false)
	public void create(Titre obj) {
		em.persist(obj);
	}

	@Override
	@Transactional(readOnly = false)
	public Titre update(Titre obj) {
		return em.merge(obj);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Long id) {
		em.remove(em.find(Titre.class, id));
	}

}
