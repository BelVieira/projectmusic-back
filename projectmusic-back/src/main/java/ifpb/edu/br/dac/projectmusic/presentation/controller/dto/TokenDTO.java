package ifpb.edu.br.dac.projectmusic.presentation.controller.dto;

public class TokenDTO {

	private String token;
	private UserDTO userDTO;

	public TokenDTO(String token, UserDTO userDTO) {
		this.token = token;
		this.userDTO = userDTO;

	}
	public TokenDTO() {
		
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

}
