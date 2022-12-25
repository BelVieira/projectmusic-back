package ifpb.edu.br.dac.projectmusic.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ifpb.edu.br.dac.projectmusic.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	Optional<User> findById (Integer id);
	
	List<User> findByName(String name);

    List<User> findByEmail(String email);
}
