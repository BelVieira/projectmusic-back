package ifpb.edu.br.application.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ifpb.edu.br.application.model.Album;
import ifpb.edu.br.application.model.Music;
import ifpb.edu.br.application.service.MusicService;


@Controller
public class MusicController {

	@Autowired
	private MusicService musicService;

	public MusicController() {

	}

	public void create(String nome, String artista, float duracao, Album album) {
		musicService.create(nome, artista, duracao, album);
	}

	public void update(Integer id, String nameNew) {
		musicService.update(id, nameNew);
	}

	public void delete(Integer id) {
		musicService.delete(id);

	}

	public Music find(Integer id) {
		return musicService.find(id);
	}

	public List<Music> list() {
		return musicService.list();

	}
}
