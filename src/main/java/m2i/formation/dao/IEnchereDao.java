package m2i.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import m2i.formation.model.Enchere;
import m2i.formation.model.Jukebox;

public interface IEnchereDao extends JpaRepository<Enchere, Long> {

	@Query("SELECT e FROM Enchere e JOIN e.jukebox j WHERE j = :leJukebox AND e.terminee = false")
	List<Enchere> findAllEnchereNotTermineeByJukebox(@Param("leJukebox") Jukebox jukebox);

	@Query("SELECT e FROM Enchere e JOIN e.jukebox j WHERE j = :leJukebox AND e.terminee = true")
	List<Enchere> findAllEnchereTermineeByJukebox(@Param("leJukebox") Jukebox jukebox);
//
//	List<Enchere> findByMembreAndTerminee(Membre membre);
//
//	List<Enchere> findByTitreAndJukebox(Titre titre, Jukebox jukebox);

}