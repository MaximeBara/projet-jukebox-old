package m2i.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import m2i.formation.model.Jukebox;

public interface IJukeboxDao extends JpaRepository<Jukebox, Long> {
	@Query("select j from Jukebox j")
	public List<Jukebox> findAll();
}
