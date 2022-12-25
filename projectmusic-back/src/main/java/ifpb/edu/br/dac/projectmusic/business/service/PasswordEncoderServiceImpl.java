package ifpb.edu.br.dac.projectmusic.business.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ifpb.edu.br.dac.projectmusic.model.entity.User;

@Service
public class PasswordEncoderServiceImpl extends BCryptPasswordEncoder implements PasswordEncoderService {

	@Override
	public void encryptPassword(User systemUser) {
		if(systemUser.getPassword() != null) {
			String encryptedPassword = encode(systemUser.getPassword());
			systemUser.setPassword(encryptedPassword);
		}
		
	}

}
