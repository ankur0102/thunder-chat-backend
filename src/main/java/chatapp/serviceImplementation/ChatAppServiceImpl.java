package chatapp.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chatapp.Conversation;
import chatapp.RetrieveUser;
import chatapp.UserLogin;
import chatapp.entity.Chat;
import chatapp.entity.Message;
import chatapp.entity.User;
import chatapp.repository.ChatRepository;
import chatapp.repository.MessageRepository;
import chatapp.repository.UserRepository;
import chatapp.service.ChatAppService;

@Service
public class ChatAppServiceImpl implements ChatAppService {
	
	@Autowired
	ChatRepository chatRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	MessageRepository messageRepository;

	@Override
	public User signUpUser (User user) {

		return userRepository.save(user);
	}

	@Override
	public Message insertMessage (Message message) {

		return messageRepository.save(message);
	}

	@Override
	public boolean authenticateUser (UserLogin userLogin) {

		List<User> result = userRepository.findByUserNameAndPassword(userLogin.getUserName(), userLogin.getPassword());
		
		if (result.size() == 0) return false;
		return true;		
	}

	@Override
	public Chat insertChat (Chat chat) {

		return chatRepository.save(chat);
	}

	@Override
	public List<Message> retrieveMessage (Conversation conversation) {

		return messageRepository.findAllMessagesByUser(conversation.getFromUser(), conversation.getToUser());
	}

	@Override
	public List<Chat> retrieveUsers(RetrieveUser user) {

		return chatRepository.findByBaseUser(user.getUserName());
	}
}
