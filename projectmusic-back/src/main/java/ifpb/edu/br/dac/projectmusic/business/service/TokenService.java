package ifpb.edu.br.dac.projectmusic.business.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import ifpb.edu.br.dac.projectmusic.model.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;

@Service
public interface TokenService {
	String generate (User user);
	
	Claims getClaims(String token) throws ExpiredJwtException;

	boolean isValid(String token);
	
	String getUsername(String token);
	
	Integer getUserId(String token);
	
	String get(HttpServletRequest request);
	
}
