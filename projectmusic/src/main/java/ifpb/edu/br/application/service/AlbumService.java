package ifpb.edu.br.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifpb.edu.br.application.model.Album;
import ifpb.edu.br.application.model.Music;
import ifpb.edu.br.application.repository.AlbumRepository;

@Service
public class AlbumService {
	
	@Autowired
	private AlbumRepository albumRepository;

	public void create(String title, String productionYear) {
		Album album = new Album();
		Music music = new Music();
		album.setTitle(title);
		album.setProductionYear(productionYear);
		albumRepository.save(album);
		album.getMusics().add(music);
		
	}

	public void update(Integer id, String newTitle) {
		Album album = albumRepository.findById(id).get();
		album.setTitle(newTitle);
		albumRepository.save(album);
	}

	public void delete(Integer id) {
		albumRepository.deleteById(id);

	}

	public Album find(Integer id) {
		return albumRepository.findById(id).get();
	}

	public List<Album> list() {
		return (List<Album>) albumRepository.findAll();

	}
}
