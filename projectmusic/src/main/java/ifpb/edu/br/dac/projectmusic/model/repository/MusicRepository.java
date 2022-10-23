package ifpb.edu.br.dac.projectmusic.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ifpb.edu.br.dac.projectmusic.model.entity.Music;

@Repository
public interface MusicRepository extends JpaRepository<Music, Integer> {

}