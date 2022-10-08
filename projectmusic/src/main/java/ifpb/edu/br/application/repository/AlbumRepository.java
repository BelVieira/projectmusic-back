package ifpb.edu.br.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ifpb.edu.br.application.model.Album;

public interface AlbumRepository extends JpaRepository<Album, Integer> {

}
