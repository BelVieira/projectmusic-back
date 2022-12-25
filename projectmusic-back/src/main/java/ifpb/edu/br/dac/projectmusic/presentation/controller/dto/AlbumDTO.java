package ifpb.edu.br.dac.projectmusic.presentation.controller.dto;

import java.util.List;

import ifpb.edu.br.dac.projectmusic.model.entity.Music;

public class AlbumDTO {
	private int id;
	private String title;
	private int productionYear;
	private List<Music> musics;
	
	public void setMusics(List<Music> musics) {
		this.musics = musics;
	}
	public List<Music> getMusics() {
		return musics;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getProductionYear() {
		return productionYear;
	}
	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}
	
}
