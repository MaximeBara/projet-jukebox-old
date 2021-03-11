package m2i.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import m2i.formation.model.Jukebox;

public interface IJukeboxDao extends JpaRepository<Jukebox, Long> {

}
