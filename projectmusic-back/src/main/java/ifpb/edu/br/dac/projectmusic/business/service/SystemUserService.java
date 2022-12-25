package ifpb.edu.br.dac.projectmusic.business.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import ifpb.edu.br.dac.projectmusic.model.entity.User;

public interface SystemUserService extends UserDetailsService{
	
	public User save(User systemUser);
	
	public User update(User systemUser);
	
	public void delete(Integer id);
	
	public User findById(Integer id);
	
	public User findByEmail(String email);
	
	public User findByUsername(String username);
	
	public Iterable<User> findAll();
	
	public List<User> find(User filter);
	
}
