package ifpb.edu.br.dac.projectmusic.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ifpb.edu.br.dac.projectmusic.model.entity.Album;
import ifpb.edu.br.dac.projectmusic.model.entity.Music;
import ifpb.edu.br.dac.projectmusic.presentation.controller.dto.AlbumDTO;
import ifpb.edu.br.dac.projectmusic.presentation.controller.dto.MusicDTO;

@Service
public class ConverterService {
	
	public ConverterService() {
		
	}
	public List<AlbumDTO> albumToDTO(List<Album> album){
		List<AlbumDTO> dtos = new ArrayList();
		for (Album dto : album) {
			AlbumDTO a = albumToDTO(dto);
			dtos.add(a);
		}
		return dtos;
	}
	
	public List<MusicDTO> musicToDTO(List<Music> music){
		List<MusicDTO> dtos = new ArrayList();
		for (Music dto : music) {
			MusicDTO m = musicToDTO(dto);
			dtos.add(m);
		}
		return dtos;
	}

	public Album dtoToAlbum (AlbumDTO dto) {
		Album entity = new Album();
		entity.setId(dto.getId());
		entity.setTitle(dto.getTitle());
		entity.setProductionYear(dto.getProductionYear());
		return entity;
	}
	public AlbumDTO albumToDTO (Album entity) {
		AlbumDTO dto = new AlbumDTO();
		dto.setId(entity.getId());
		dto.setTitle(entity.getTitle());
		dto.setProductionYear(entity.getProductionYear());
		return dto;
	}
	
	public MusicDTO musicToDTO (Music entity) {
		MusicDTO dto = new MusicDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setArtist(entity.getArtist());
		dto.setDuration(entity.getDuration());
		dto.setAlbum(entity.getAlbum());
		return dto;
	}
	public Music dtoToMusic (MusicDTO dto) {
		Music entity = new Music();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setArtist(dto.getArtist());
		entity.setDuration(dto.getDuration());
		entity.setAlbum(dto.getAlbum());
		return entity;
	}
	
}
