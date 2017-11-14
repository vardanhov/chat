package model.message;

import model.user.User;

public class Message {
	private User userFrom;
	private User userTo;
	private String message;
	
	public Message(User userFrom, User userTo, String message) {
		this.userFrom = userFrom;
		this.userTo = userTo;
		this.message = message;
	}
	public User getUserFrom() {
		return userFrom;
	}
	public User getUserTo() {
		return userTo;
	}
	public String getMessage() {
		return message;
	}
}