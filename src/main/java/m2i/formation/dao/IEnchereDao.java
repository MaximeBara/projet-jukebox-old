package m2i.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import m2i.formation.model.Enchere;
import m2i.formation.model.Jukebox;

public interface IEnchereDao extends JpaRepository<Enchere, Long> {

	List<Enchere> findByJukeboxAndTermineeFalse(Jukebox jukebox);

	List<Enchere> findByJukeboxAndTermineeTrue(Jukebox jukebox);

//	List<Enchere> findByMembreAndTerminee(Membre membre);
//
//	List<Enchere> findByTitreAndJukebox(Titre titre, Jukebox jukebox);

}