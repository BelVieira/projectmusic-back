package ifpb.edu.br.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ifpb.edu.br.application.model.Album;
import ifpb.edu.br.application.service.AlbumService;

@Controller
public class AlbumController {

		@Autowired
		private AlbumService albumService;

		public AlbumController() {

		}

		public void create(String title, String productionYear) {
			albumService.create(title,productionYear);
		}

		public void update(Integer id, String newTitle) {
			albumService.update(id, newTitle);
		}

		public void delete(Integer id) {
			albumService.delete(id);

		}

		public Album find(Integer id) {
			return albumService.find(id);
		}

		public List<Album> list() {
			return albumService.list();

		}
}
