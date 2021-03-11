package m2i.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import m2i.formation.model.Titre;

public interface ITitreDao extends JpaRepository<Titre, Long> {

	@Query("select t from Titre t")
	public List<Titre> findAll();
}
