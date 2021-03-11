package m2i.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import m2i.formation.model.Jukebox;
import m2i.formation.model.Membre;
import m2i.formation.model.Utilisateur;

public interface IJukeboxDao extends JpaRepository<Jukebox, Long> {

	@Query("select u from Utilisateur u where u.jukebox.id = :id")
	public List<Utilisateur> findAllConnectesById(@Param("id") Long id);
	
	@Query("select m from Membre m left join m.jukeboxes j where j.id = :id")
	public List<Membre> findAllFansById(@Param("id") Long id);
}
