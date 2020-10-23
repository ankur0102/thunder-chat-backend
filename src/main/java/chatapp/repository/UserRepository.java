package chatapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import chatapp.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	public List<User> findByUserNameAndPassword(String userName, String password);
}
