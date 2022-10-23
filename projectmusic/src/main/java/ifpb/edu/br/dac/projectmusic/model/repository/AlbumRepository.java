package ifpb.edu.br.dac.projectmusic.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ifpb.edu.br.dac.projectmusic.model.entity.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {

}
