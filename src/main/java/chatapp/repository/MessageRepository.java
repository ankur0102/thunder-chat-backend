package chatapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import chatapp.entity.Message;

public interface MessageRepository extends CrudRepository<Message, Integer>{
	
	@Query("from Message where (fromUser=:fromUser and toUser=:toUser) or (fromUser=:toUser and toUser=:fromUser)")
	public List<Message> findAllMessagesByUser (@Param("fromUser")String fromUser, @Param("toUser") String toUser);

}
