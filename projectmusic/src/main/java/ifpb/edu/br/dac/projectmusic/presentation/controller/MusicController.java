package ifpb.edu.br.dac.projectmusic.presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ifpb.edu.br.dac.projectmusic.business.service.ConverterService;
import ifpb.edu.br.dac.projectmusic.business.service.MusicService;
import ifpb.edu.br.dac.projectmusic.model.entity.Album;
import ifpb.edu.br.dac.projectmusic.model.entity.Music;
import ifpb.edu.br.dac.projectmusic.presentation.controller.dto.MusicDTO;

@RestController
@RequestMapping("/api/music")
public class MusicController {

	@Autowired
	private MusicService musicService;

	@Autowired
	private ConverterService converterService;

	public MusicController() {

	}

	@PostMapping
	public ResponseEntity save(@RequestBody MusicDTO dto) {
		try {
			Music entity = converterService.dtoToMusic(dto);
			entity = musicService.save(entity);
			dto = converterService.musicToDTO(entity);
			return new ResponseEntity(dto, HttpStatus.CREATED);

		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

	public void create(String nome, String artista, float duracao, Album album) {
		musicService.create(nome, artista, duracao, album);
	}

	@PutMapping("{id}")
	public ResponseEntity update(@PathVariable("id") Integer id, @RequestBody MusicDTO dto) {
		try {
			dto.setId(dto.getId());
			Music entity = converterService.dtoToMusic(dto);
			entity = musicService.update(id, dto.getNome());
			dto = converterService.musicToDTO(entity);
			return ResponseEntity.ok(dto);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping("{id}")
	public ResponseEntity delete(Integer id) {
		try {
			musicService.delete(id);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

	@GetMapping
	public ResponseEntity find(@RequestParam(value = "id", required = false) int id

	) {
		try {
			Music music = new Music();
			music.setId(id);
			List<Music> musics = (List<Music>) musicService.find(music.getId());
			List<MusicDTO> dtos = converterService.musicToDTO(musics);
			return ResponseEntity.ok(dtos);

		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());

		}
	}

	public List<Music> list() {
		return musicService.list();

	}
}
