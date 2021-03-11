package m2i.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import m2i.formation.model.Enchere;

public interface IEnchereDao extends JpaRepository<Enchere, Long> {

//	List<Enchere> findAllByJukebox(Long id);
//	List<Enchere> findAllByMembre(Long id);
//	List<Enchere> findAllByTitreAndJukebox(Long idTitre, Long idJukebox);

}