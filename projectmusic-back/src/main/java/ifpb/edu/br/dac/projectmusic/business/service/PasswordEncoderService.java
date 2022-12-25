package ifpb.edu.br.dac.projectmusic.business.service;

import org.springframework.security.crypto.password.PasswordEncoder;

import ifpb.edu.br.dac.projectmusic.model.entity.User;

public interface PasswordEncoderService extends PasswordEncoder {
	void encryptPassword(User systemUser);
}
