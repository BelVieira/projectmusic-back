package ifpb.edu.br.dac.projectmusic.business.service;

import ifpb.edu.br.dac.projectmusic.model.entity.SystemRole;

public interface SystemRoleService {
	
	public enum AVAILABLE_ROLES { ADMIN, USER } 
	
	 public SystemRole findByName(String name);
	 public SystemRole findDefault();
}
