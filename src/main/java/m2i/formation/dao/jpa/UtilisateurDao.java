package m2i.formation.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import m2i.formation.dao.IUtilisateurDao;
import m2i.formation.model.Utilisateur;

@Repository
@Transactional(readOnly = true)
public class UtilisateurDao implements IUtilisateurDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Utilisateur> findAll() {

		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();

		TypedQuery<Utilisateur> query = em.createQuery("select user from utilisateur user", Utilisateur.class);

		utilisateurs = query.getResultList();

		return utilisateurs;
	}

	@Override
	public Utilisateur find(Long id) {
		return em.find(Utilisateur.class, id);
	}

	@Override
	@Transactional(readOnly = false)
	public void create(Utilisateur obj) {
		em.persist(obj);
	}

	@Override
	@Transactional(readOnly = false)
	public Utilisateur update(Utilisateur obj) {
		return em.merge(obj);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Long id) {

		em.remove(em.find(Utilisateur.class, id));

	}

}
