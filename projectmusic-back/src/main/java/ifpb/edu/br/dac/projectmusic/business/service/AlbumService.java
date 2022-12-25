package ifpb.edu.br.dac.projectmusic.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import ifpb.edu.br.dac.projectmusic.model.entity.Album;
import ifpb.edu.br.dac.projectmusic.model.repository.AlbumRepository;

@Service
public class AlbumService {

	@Autowired
	private AlbumRepository albumRepository;

	public Album save(Album newAlbum) {
		return albumRepository.save(newAlbum);
	}

	public Album update(Album a) {
		Album album = albumRepository.findById(a.getId()).get();
		album.setTitle(a.getTitle());
		album.setProductionYear(a.getProductionYear());
		return albumRepository.save(album);
	}

	public void delete(Integer id) {
		albumRepository.deleteById(id);

	}

	public List<Album> find(Album filter) {
		Example example = Example.of(filter,
				ExampleMatcher.matching().withIgnoreCase().withStringMatcher(StringMatcher.CONTAINING));
		return albumRepository.findAll(example);
	}

	public List<Album> list() {
		return (List<Album>) albumRepository.findAll();

	}
}
