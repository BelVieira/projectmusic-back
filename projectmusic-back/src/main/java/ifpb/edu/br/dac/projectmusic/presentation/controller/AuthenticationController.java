package ifpb.edu.br.dac.projectmusic.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import ifpb.edu.br.dac.projectmusic.business.service.AuthenticationService;
import ifpb.edu.br.dac.projectmusic.business.service.ConverterService;
import ifpb.edu.br.dac.projectmusic.business.service.SystemUserService;
import ifpb.edu.br.dac.projectmusic.business.service.TokenService;
import ifpb.edu.br.dac.projectmusic.business.service.UserService;
import ifpb.edu.br.dac.projectmusic.model.entity.User;
import ifpb.edu.br.dac.projectmusic.presentation.controller.dto.LoginDTO;
import ifpb.edu.br.dac.projectmusic.presentation.controller.dto.TokenDTO;
import ifpb.edu.br.dac.projectmusic.presentation.controller.dto.UserDTO;

@RestController
@RequestMapping("/api")
@Scope(value = WebApplicationContext.SCOPE_APPLICATION)
public class AuthenticationController {

    @Autowired
    private SystemUserService userService;
    @Autowired
    private ConverterService converterService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private AuthenticationService authService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDTO dto){
        try {
            String token = authService.login(dto.getUsername(), dto.getPassword());
            User entity = userService.findByEmail(dto.getUsername());
            UserDTO userDTO = converterService.userToDTO(entity);

            TokenDTO tokenDTO = new TokenDTO(token,userDTO);
            
            return new ResponseEntity(tokenDTO, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/isTokenValid")
    public ResponseEntity isTokenValid(@RequestBody TokenDTO dto){
        try {
            boolean isTokenValid = tokenService.isValid(dto.getToken());
            
            return new ResponseEntity(isTokenValid, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}