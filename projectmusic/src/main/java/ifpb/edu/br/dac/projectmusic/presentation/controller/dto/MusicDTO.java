package ifpb.edu.br.dac.projectmusic.presentation.controller.dto;

import ifpb.edu.br.dac.projectmusic.model.entity.Album;

public class MusicDTO {
	private int id;
	private String nome;
	private float duracao;
	private String artista;
	private Album album;
	
	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public MusicDTO() {

	}

	public MusicDTO(String nome, String artista, float duracao) {
		this.nome = nome;
		this.artista = artista;
		this.duracao = duracao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getDuracao() {
		return duracao;
	}

	public void setDuracao(float duracao) {
		this.duracao = duracao;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}
}
