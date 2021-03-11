package m2i.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import m2i.formation.model.Playlist;

public interface IPlaylistDao extends JpaRepository<Playlist, Long> {

}
