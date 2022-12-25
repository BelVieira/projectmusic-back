package ifpb.edu.br.dac.projectmusic.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ifpb.edu.br.dac.projectmusic.model.entity.SystemRole;
import ifpb.edu.br.dac.projectmusic.model.entity.User;
import ifpb.edu.br.dac.projectmusic.model.repository.UserRepository;

@Service
public class UserService implements SystemUserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SystemRoleServiceImpl systemRoleServiceImpl;

	@Autowired
	private PasswordEncoderServiceImpl passwordEncorderServiceImpl;

	@Override
	public User save(User user) {
		if (user.getId() != null) {
			throw new IllegalStateException("User exist");
		}
		passwordEncorderServiceImpl.encryptPassword(user);

		List<SystemRole> roles = new ArrayList<>();
		roles.add(systemRoleServiceImpl.findDefault());
		user.setRoles(roles);
		return userRepository.save(user);
	}

	public void delete(Integer id) {
		userRepository.deleteById(id);
	}

	public User update(User user) {
		if (user.getId() == null) {
			throw new IllegalStateException("Id is empty");
		}
		passwordEncorderServiceImpl.encryptPassword(user);
		return userRepository.save(user);
	}

	public List<User> find(User filter) {
		Example<User> example = Example.of(filter,
				ExampleMatcher.matching().withIgnoreCase().withStringMatcher(StringMatcher.CONTAINING));
		return userRepository.findAll(example);
	}

	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException(String.format("Could not find any use with usename %s", username));
		}
		return (UserDetails) user;
	}

	@Override
	public User findById(Integer id) {
		User entity = userRepository.findById(id).get();
		return entity;
	}

	@Override
	public User findByEmail(String email) {
		List<User> user = userRepository.findByEmail(email);
		return (User) user.get(0);
	}

	@Override
	public User findByUsername(String username) {
		List<User> user = userRepository.findByName(username);
		return (User) user.get(0);
	}

}
