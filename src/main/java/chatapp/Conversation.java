package chatapp;

public class Conversation {

	private String fromUser;
	
	private String toUser;
	
	public Conversation (String fromUser, String toUser) {
		this.fromUser = fromUser;
		this.toUser = toUser;
	}

	public String getFromUser() {
		return fromUser;
	}

	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}

	public String getToUser() {
		return toUser;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}
	
	
}
