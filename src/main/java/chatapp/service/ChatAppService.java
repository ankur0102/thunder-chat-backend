package chatapp.service;

import java.util.List;

import chatapp.Conversation;
import chatapp.RetrieveUser;
import chatapp.UserLogin;
import chatapp.entity.Chat;
import chatapp.entity.Message;
import chatapp.entity.User;

public interface ChatAppService {

	public		User					signUpUser			(User user);

	public		Message					insertMessage		(Message message);

	public		boolean					authenticateUser	(UserLogin userLogin);

	public		Chat					insertChat			(Chat chat);

	public		List<Message>			retrieveMessage		(Conversation conversation);

	public		List<Chat> 				retrieveUsers		(RetrieveUser user);

}
