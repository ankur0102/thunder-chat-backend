package chatapp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

	@Autowired
	ChatRepository chatRepository;
		
	@CrossOrigin
	@PostMapping ("/insertMessage")
	public void insertMessage (@RequestBody Message message) {
		chatRepository.insertMessage(message);
	}
	
	@CrossOrigin
	@PostMapping ("/authenticateUser")
	public Map<String, Boolean> authenticateUser (@RequestBody UserLogin userLogin) {
		
		Map<String, Boolean> map = new HashMap<>();
		
		boolean result = chatRepository.authenticateUser(userLogin.getUserName(), userLogin.getPassword());
		map.put("result", result);
		
		return map;
	}
	
	@CrossOrigin
	@PostMapping ("/insertUser")
	public void insertUser (@RequestBody User user) {
		chatRepository.insertUser(user);
	}
	
	@CrossOrigin
	@PostMapping ("/insertChat")
	public void insertChat (@RequestBody Chat chat) {
		
		Chat chat2 = new Chat(chat.getFriendUser() , chat.getBaseUser());
		
		chatRepository.insertChat(chat);
		chatRepository.insertChat(chat2);
	}
	
	@CrossOrigin
	@PostMapping ("/retrieveMessage")
	public List<Message> retrieveMessage (@RequestBody Conversation conversation) {
		return chatRepository.retrieveMessage(conversation.getFromUser(), conversation.getToUser());
	}
	
	@CrossOrigin
	@PostMapping ("/retrieveUsers")
	public List<RetrieveUser> retrieveUsers (@RequestBody RetrieveUser retrieveUser) {
		return chatRepository.retrieveUsers(retrieveUser.getUserName());
	}
}
