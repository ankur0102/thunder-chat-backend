package chatapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatApp implements CommandLineRunner {
	
//	@Autowired
//	ChatRepository chatRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ChatApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println ("Application Started .... ");
		
	}
}
