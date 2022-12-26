package ifpb.edu.br.dac.projectmusic.presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ifpb.edu.br.dac.projectmusic.business.service.ConverterService;
import ifpb.edu.br.dac.projectmusic.business.service.UserService;
import ifpb.edu.br.dac.projectmusic.model.entity.User;

import ifpb.edu.br.dac.projectmusic.presentation.controller.dto.UserDTO;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private ConverterService converterService;
	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity save(@RequestBody UserDTO dto) {
		try {
			User entity = converterService.dtoToUser(dto);
			userService.save(entity);
			dto = converterService.userToDTO(entity);
			return new ResponseEntity(dto, HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PutMapping("{id}")
	public ResponseEntity update(@PathVariable("id") Integer id, @RequestBody UserDTO dto) {
		try {
			dto.setId(id);
			User entity = converterService.dtoToUser(dto);
			userService.update(entity);
			dto = converterService.userToDTO(entity);

			return ResponseEntity.ok(dto);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

	@DeleteMapping("{id}")
	public ResponseEntity delete(@PathVariable("id") Integer id) {
		try {
			userService.delete(id);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

	@GetMapping
	public ResponseEntity find(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "licencePlate", required = false) String name,
			@RequestParam(value = "licencePlate", required = false) String email) {

		try {
			User filter = new User();
			filter.setId(id);
			filter.setName(name);
			filter.setEmail(email);

			List<User> entities = userService.find(filter);
			List<UserDTO> dtos = converterService.userToDTO(entities);
			return ResponseEntity.ok(dtos);

		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

	@GetMapping({ "id" })
	public ResponseEntity findFilter(@RequestParam(value = "id", required = false) Integer id) {

		try {
			User filter = new User();
			filter.setId(id);

			List<User> entities = userService.find(filter);
			List<UserDTO> dtos = converterService.userToDTO(entities);
			return ResponseEntity.ok(dtos);

		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}
}
