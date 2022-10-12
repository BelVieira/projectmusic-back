package ifpb.edu.br.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifpb.edu.br.application.model.Album;
import ifpb.edu.br.application.model.Music;
import ifpb.edu.br.application.repository.MusicRepository;

@Service
public class MusicService {
	
	@Autowired
	private MusicRepository musicRepository;
	
	public void create(String nome, String artista, float duracao, Album album) {
		Music music = new Music();
		music.setNome(nome);
		music.setArtista(artista);
		music.setDuração(duracao);
		music.setAlbum(album);
		musicRepository.save(music);	
		
	}

	public void update(Integer id, String nameNew) {
		Music musica = musicRepository.findById(id).get();
		musica.setNome(nameNew);
		musicRepository.save(musica);
	}

	public void delete(Integer id) {
		musicRepository.deleteById(id);

	}

	public Music find(Integer id) {
		return musicRepository.findById(id).get();
	}

	public List<Music> list() {
		return (List<Music>) musicRepository.findAll();

	}
}
