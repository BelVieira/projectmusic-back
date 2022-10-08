package ifpb.edu.br.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ifpb.edu.br.application.model.Music;

@Repository
public interface MusicRepository extends JpaRepository<Music, Integer> {

}