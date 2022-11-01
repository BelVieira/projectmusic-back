package ifpb.edu.br.dac.projectmusic.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import ifpb.edu.br.dac.projectmusic.model.entity.Album;
import ifpb.edu.br.dac.projectmusic.model.entity.Music;
import ifpb.edu.br.dac.projectmusic.model.repository.MusicRepository;

@Service
public class MusicService {
	
	@Autowired
	private MusicRepository musicRepository;
	
	
	public Music save(Music newMusic) {
		Music music = new Music();
		music.setName(newMusic.getName());
		music.setArtist(newMusic.getArtist());
		music.setDuration(newMusic.getDuration());
		music.setAlbum(newMusic.getAlbum());
		return musicRepository.save(music);
	}

	public Music update(Integer id, String nameNew) {
		Music musica = musicRepository.findById(id).get();
		musica.setName(nameNew);
		return musicRepository.save(musica);
	}

	public void delete(Integer id) {
		musicRepository.deleteById(id);

	}

	public List<Music> find(Music filter) {
		Example example = Example.of(filter,
				ExampleMatcher.matching().withIgnoreCase().withStringMatcher(StringMatcher.CONTAINING));
		return musicRepository.findAll(example);
	}


	public List<Music> list() {
		return (List<Music>) musicRepository.findAll();

	}
}
