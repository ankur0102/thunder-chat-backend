package chatapp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class ChatRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public Message insertMessage (Message message) {
		return entityManager.merge (message);
	}
	
	@Transactional
	public User insertUser (User user) {
		return entityManager.merge(user);
	}
	
	public boolean authenticateUser (String userName, String password) {
		
		String stringQuery = "select * from user where user_name=?1 and password=?2";
		Query query = entityManager.createNativeQuery(stringQuery, User.class);
		
		@SuppressWarnings("unchecked")
		List<User> result = query.setParameter(1, userName)
									.setParameter(2, password)
									.getResultList();
		
		if (result.size() == 0) return false;
		return true;
		
	}
	
	@Transactional
	public Chat insertChat (Chat chat) {
		return entityManager.merge(chat);
	}
	
	@Transactional
	public List<Message> retrieveMessage (String fromUserName, String toUserName) {
		
		String stringQuery = "Select * from message where (from_user = ?1 and to_user = ?2) or (from_user = ?2 and to_user = ?1)";
		Query query = entityManager.createNativeQuery (stringQuery, Message.class);

		@SuppressWarnings("unchecked")
		List<Message> result = query.setParameter(1, fromUserName)
										.setParameter(2,  toUserName)
										.getResultList();
		
		return result;
		
	}
	
	@Transactional
	public List<RetrieveUser> retrieveUsers (String userName) {
		
		System.out.println("Inside repository");
		
		String stringQuery = "Select * from chat where base_user = ?1";
		Query query = entityManager.createNativeQuery(stringQuery, Chat.class);
		
		@SuppressWarnings("unchecked")
		List<Chat> chats = query.setParameter(1,  userName)
								.getResultList();

		List<RetrieveUser> result = new ArrayList<>();

		for (Chat chat: chats) {
			RetrieveUser user = new RetrieveUser(chat.getFriendUser());
			result.add(user);
		}

		return result;
	}
}
