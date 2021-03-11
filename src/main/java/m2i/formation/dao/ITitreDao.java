package m2i.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import m2i.formation.model.Titre;

public interface ITitreDao extends JpaRepository<Titre, Long> {

}
