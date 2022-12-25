package ifpb.edu.br.dac.projectmusic.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import ifpb.edu.br.dac.projectmusic.business.service.SystemUserService;
import ifpb.edu.br.dac.projectmusic.business.service.TokenService;
import ifpb.edu.br.dac.projectmusic.model.entity.User;

public class TokenFilter extends OncePerRequestFilter {
	
	private TokenService tokenService;
	
    private SystemUserService systemUserService;

	public TokenFilter(TokenService tokenService, SystemUserService systemUserService) {
	      super();
	        this.tokenService = tokenService;
	        this.systemUserService = systemUserService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = tokenService.get(request);
        boolean valid = tokenService.isValid(token);
        if(valid){
            authenticate(token);
        }
        filterChain.doFilter(request, response);
    }

    private void authenticate(String token){
        Integer userId = tokenService.getUserId(token);
        User user = systemUserService.findById(userId);
        UsernamePasswordAuthenticationToken authentication = 
        new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
		
}