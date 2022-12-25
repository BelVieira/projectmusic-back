package ifpb.edu.br.dac.projectmusic.business.service;

import org.springframework.stereotype.Service;

import ifpb.edu.br.dac.projectmusic.model.entity.User;

@Service
public interface AuthenticationService {
	
	public String login(String email, String password);
	public User getLoggedUser();

}
