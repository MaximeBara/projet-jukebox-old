package m2i.formation.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import m2i.formation.dao.IEnchereDao;
import m2i.formation.model.Enchere;

@Repository
@Transactional(readOnly = true)
public class EnchereDao implements IEnchereDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Enchere> findAll() {
		List<Enchere> encheres = new ArrayList<Enchere>();

		TypedQuery<Enchere> query = em.createQuery("select e from Enchere e", Enchere.class);

		encheres = query.getResultList();

		return encheres;
	}

	@Override
	public Enchere find(Long id) {
		return em.find(Enchere.class, id);
	}

	@Override
	@Transactional(readOnly = false)
	public void create(Enchere obj) {
		em.persist(obj);
	}

	@Override
	@Transactional(readOnly = false)
	public Enchere update(Enchere obj) {
		return em.merge(obj);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Long id) {
		em.remove(em.find(Enchere.class, id));
	}

}
