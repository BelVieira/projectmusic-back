package ifpb.edu.br.dac.projectmusic.business.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifpb.edu.br.dac.projectmusic.model.entity.SystemRole;
import ifpb.edu.br.dac.projectmusic.model.repository.SystemRoleRepository;

@Service
public class SystemRoleServiceImpl implements SystemRoleService {
	
	@Autowired
	private SystemRoleRepository repository;

	@Override
	public void createDefaultValues() {
		for (AVAILABLE_ROLES availableRole : AVAILABLE_ROLES.values()) {
			SystemRole role = findByName(availableRole.name());
			if (role == null) {
				role = new SystemRole();
				role.setName(availableRole.name());
				repository.save(role);
			}
		}
	}

	@Override
	public SystemRole findByName(String name) {
		if (name == null) {
			throw new IllegalStateException("Name Cannot be null");
		}
		Optional<SystemRole> optional = repository.findByName(name);
		return optional.isPresent() ? optional.get() : null;
	}

	@Override
	public SystemRole findDefault() {
		return findByName(AVAILABLE_ROLES.USER.name());
	}
}