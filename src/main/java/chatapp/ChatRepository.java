package chatapp;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class ChatRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public Message insert (Message message) {
		return entityManager.merge (message);
	}	
}
