package ifpb.edu.br.dac.projectmusic.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import ifpb.edu.br.dac.projectmusic.model.entity.User;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

	@Autowired
	private SystemUserService systemUserService;
	
	@Autowired
	private ConverterService converterService;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Override
	public String login(String username, String password) {
		Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		User user = systemUserService.findByEmail(username);
		return tokenService.generate(user);
	}

	@Override
	public User getLoggedUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return (User)(authentication.getPrincipal());
	}
	
	private String localLogin(String username, String password) {
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		
		User user = systemUserService.findByUsername(username);
		return tokenService.generate(user);
	}

}
