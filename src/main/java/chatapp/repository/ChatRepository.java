package chatapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import chatapp.entity.Chat;

public interface ChatRepository extends CrudRepository<Chat, Integer> {
	
	public List<Chat> findByBaseUser(String baseUser);
}
