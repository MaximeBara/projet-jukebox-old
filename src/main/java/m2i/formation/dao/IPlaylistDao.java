package m2i.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import m2i.formation.model.Playlist;

public interface IPlaylistDao extends JpaRepository<Playlist, Long> {

	@Query("select p from Playlist p")
	public List<Playlist> findAll();
}
