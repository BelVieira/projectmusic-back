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

import ifpb.edu.br.dac.projectmusic.business.service.AlbumService;
import ifpb.edu.br.dac.projectmusic.business.service.ConverterService;
import ifpb.edu.br.dac.projectmusic.model.entity.Album;
import ifpb.edu.br.dac.projectmusic.model.entity.Music;
import ifpb.edu.br.dac.projectmusic.presentation.controller.dto.AlbumDTO;
import ifpb.edu.br.dac.projectmusic.presentation.controller.dto.MusicDTO;

@RestController
@RequestMapping("/api/album")
public class AlbumController {

	@Autowired
	private AlbumService albumService;

	@Autowired
	private ConverterService converterService;

	public AlbumController() {

	}

	@PostMapping
	public ResponseEntity save(@RequestBody AlbumDTO dto) {
		try {
			Album entity = converterService.dtoToAlbum(dto);
			entity = albumService.save(entity);
			dto = converterService.albumToDTO(entity);
			return new ResponseEntity(dto, HttpStatus.CREATED);

		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

	public void create(String title, int productionYear) {
		albumService.create(title, productionYear);
	}

	@PutMapping("{id}")
	public ResponseEntity update(@PathVariable("id") Integer id, @RequestBody AlbumDTO dto) {
		try {
			dto.setId(id);
			Album entity = converterService.dtoToAlbum(dto);
			entity = albumService.update(entity);
			dto = converterService.albumToDTO(entity);
			return ResponseEntity.ok(dto);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping("{id}")
	public ResponseEntity delete(@PathVariable("id") Integer id) {
		try {
			albumService.delete(id);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping
	public ResponseEntity find(
			@RequestParam(value = "id", required = false) int id,
			@RequestParam(value = "title", required = false) String title,
			@RequestParam(value = "productionYear", required = false) int productionYear
	) {
		try {
			Album album = new Album();
			album.setId(id);
			album.setTitle(title);
			album.setProductionYear(productionYear);
			
			List<Album> albuns = (List<Album>) albumService.find(album);
			List<AlbumDTO> dtos = converterService.albumToDTO(albuns);
			return ResponseEntity.ok(dtos);

		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());

		}
	}

	public List<Album> list() {
		return albumService.list();

	}
}
