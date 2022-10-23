package ifpb.edu.br.dac.projectmusic.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifpb.edu.br.dac.projectmusic.model.entity.Album;
import ifpb.edu.br.dac.projectmusic.model.entity.Music;
import ifpb.edu.br.dac.projectmusic.model.repository.MusicRepository;

@Service
public class MusicService {
	
	@Autowired
	private MusicRepository musicRepository;
	
	public void create(String nome, String artista, float duracao, Album album) {
		Music music = new Music();
		music.setNome(nome);
		music.setArtista(artista);
		music.setDuracao(duracao);
		music.setAlbum(album);
		musicRepository.save(music);	
		
	}
	public Music save(Music music) {
		Music music2 = new Music();
		music2.setId(music.getId());
		music2.setNome(music.getNome());
		music2.setArtista(music.getArtista());
		return musicRepository.save(music2);
	}

	public Music update(Integer id, String nameNew) {
		Music musica = musicRepository.findById(id).get();
		musica.setNome(nameNew);
		return musicRepository.save(musica);
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
