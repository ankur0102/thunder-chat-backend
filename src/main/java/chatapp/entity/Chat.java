package chatapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Chat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String baseUser;
	
	private String friendUser;
	
	public Chat () {
		
	}
	
	public Chat (String baseUser, String friendUser) {
		
		this.baseUser = baseUser;
		this.friendUser = friendUser;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBaseUser() {
		return baseUser;
	}

	public void setBaseUser(String baseUser) {
		this.baseUser = baseUser;
	}

	public String getFriendUser() {
		return friendUser;
	}

	public void setFriendUser(String friendUser) {
		this.friendUser = friendUser;
	}
}
