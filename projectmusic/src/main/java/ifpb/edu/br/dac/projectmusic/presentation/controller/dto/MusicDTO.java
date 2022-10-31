package ifpb.edu.br.dac.projectmusic.presentation.controller.dto;

import ifpb.edu.br.dac.projectmusic.model.entity.Album;

public class MusicDTO {
	private int id;
	private String name;
	private String artist;
	private float duration;
	private Album album_id;
	
	public Album getAlbum() {
		return album_id;
	}

	public void setAlbum(Album album) {
		this.album_id = album;
	}

	public MusicDTO() {

	}

	public MusicDTO(String name, String artist, float duration) {
		this.name = name;
		this.artist = artist;
		this.duration = duration;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getDuration() {
		return duration;
	}

	public void setDuration(float duration) {
		this.duration = duration;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
}
