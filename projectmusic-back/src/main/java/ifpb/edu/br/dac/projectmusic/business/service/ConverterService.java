package ifpb.edu.br.dac.projectmusic.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ifpb.edu.br.dac.projectmusic.model.entity.Album;
import ifpb.edu.br.dac.projectmusic.model.entity.Music;
import ifpb.edu.br.dac.projectmusic.model.entity.User;
import ifpb.edu.br.dac.projectmusic.presentation.controller.dto.AlbumDTO;
import ifpb.edu.br.dac.projectmusic.presentation.controller.dto.MusicDTO;
import ifpb.edu.br.dac.projectmusic.presentation.controller.dto.UserDTO;

@Service
public class ConverterService {

	public ConverterService() {

	}

	public List<UserDTO> userToDTO(List<User> user2) {
		List<UserDTO> dtos = new ArrayList();
		for (User dto : user2) {
			UserDTO u = userToDTO(dto);
			dtos.add(u);
		}
		return dtos;
	}
	public UserDTO userToDTO(User entity) {
		UserDTO dto = new UserDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setEmail(entity.getEmail());
		return dto;
	}

	public User dtoToUser(UserDTO dto) {
		User entity = new User();
	
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setPassword(dto.getPassword());
		return entity;
	}

	public Album dtoToAlbum(AlbumDTO dto) {
		Album entity = new Album();
		entity.setId(dto.getId());
		entity.setTitle(dto.getTitle());
		entity.setProductionYear(dto.getProductionYear());
		entity.setMusics(dto.getMusics());
		return entity;
	}

	public AlbumDTO albumToDTO(Album entity) {
		AlbumDTO dto = new AlbumDTO();
		dto.setId(entity.getId());
		dto.setTitle(entity.getTitle());
		dto.setProductionYear(entity.getProductionYear());
		dto.setMusics(entity.getMusics());
		return dto;
	}

	public List<AlbumDTO> albumToDTO(List<Album> album) {
		List<AlbumDTO> dtos = new ArrayList();
		for (Album dto : album) {
			AlbumDTO a = albumToDTO(dto);
			dtos.add(a);
		}
		return dtos;
	}

	public List<MusicDTO> musicToDTO(List<Music> music) {
		List<MusicDTO> dtos = new ArrayList();
		for (Music dto : music) {
			MusicDTO m = musicToDTO(dto);
			dtos.add(m);
		}
		return dtos;
	}

	public MusicDTO musicToDTO(Music entity) {
		MusicDTO dto = new MusicDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setArtist(entity.getArtist());
		dto.setDuration(entity.getDuration());
		return dto;
	}

	public Music dtoToMusic(MusicDTO dto) {
		Music entity = new Music();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setArtist(dto.getArtist());
		entity.setDuration(dto.getDuration());
		return entity;
	}

}
