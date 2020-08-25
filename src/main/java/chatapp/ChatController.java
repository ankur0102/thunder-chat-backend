package chatapp;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {
	@Autowired
	ChatRepository chatRepository;
	
	@GetMapping ("/messages")
	public List<Message>  getAllMessages () {
		return Arrays.asList(new Message ("Hello there"));
	}
	
	@CrossOrigin
	@PostMapping ("/postMessage")
	public void postMessage (@RequestBody Message message) {
		chatRepository.insert(message);
	}
}
