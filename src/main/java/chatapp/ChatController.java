package chatapp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import chatapp.entity.Chat;
import chatapp.entity.Message;
import chatapp.entity.User;

import chatapp.service.ChatAppService;

@RestController
public class ChatController {
	
	@Autowired
	ChatAppService service;

	@CrossOrigin
	@PostMapping ("/insertMessage")
	public void insertMessage (@RequestBody Message message) {
		System.out.println("Inserting Message");
		service.insertMessage(message);
	}
	
	@CrossOrigin
	@PostMapping ("/authenticateUser")
	public Map<String, Boolean> authenticateUser (@RequestBody UserLogin userLogin) {
		
		Map<String, Boolean> map = new HashMap<>();
		
		boolean result = service.authenticateUser(userLogin);
		map.put("result", result);
		
		return map;
	}
	
	@CrossOrigin
	@PostMapping ("/insertUser")
	public void insertUser (@RequestBody User user) {
		System.out.println("Inserting user");
		service.signUpUser(user);
	}
	
	@CrossOrigin
	@PostMapping ("/insertChat")
	public void insertChat (@RequestBody Chat chat) {
		
		Chat chat2 = new Chat(chat.getFriendUser() , chat.getBaseUser());
		
		service.insertChat(chat);
		service.insertChat(chat2);
	}
	
	@CrossOrigin
	@PostMapping ("/retrieveMessage")
	public List<Message> retrieveMessage (@RequestBody Conversation conversation) {
		return service.retrieveMessage(conversation);
	}
	
	@CrossOrigin
	@PostMapping ("/retrieveUsers")
	public List<Chat> retrieveUsers (@RequestBody RetrieveUser retrieveUser) {
		return service.retrieveUsers(retrieveUser);
	}
}
