package behavioral.design.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Contract to Adding new User and 
 * sending message in group chat.
 */
interface ChattingMediator {
	public abstract void sendMessage(String message, User user);
	public abstract void addUser(User user);
}

/**
 *Implelementation of ChattingMediator
 *which add users in group chat and
 *send message by user in group
 * 
 */

class ChattingMediatorImpl implements ChattingMediator {

	private List<User> userList;

	public ChattingMediatorImpl() {
		userList = new ArrayList<>();
	}

	@Override
	public void sendMessage(String message, User user) {
		for (User u : userList) {
			if(!u.getUserName().equalsIgnoreCase(user.getUserName())) {
				u.receiveMessage(message);
			}
		}
	}

	@Override
	public void addUser(User user) {
		userList.add(user);
	}

}

/**
 *This class initializes ChattingMediator &
 *userName in constructor so that subclass of this class
 *has to pass these values from their constructor
 *and implementation of methods sendMessage() & receiveMessage()
 *left on sub classes
 */

abstract class User {

	private ChattingMediator chattingMediator;
	private String userName;

	public User(ChattingMediator chattingMediator, String userName) {
		super();
		this.chattingMediator = chattingMediator;
		this.userName = userName;
	}

	public ChattingMediator getChattingMediator() {
		return chattingMediator;
	}

	public String getUserName() {
		return userName;
	}

	public abstract void sendMessage(String message);
	public abstract void receiveMessage(String message);

}

/**
 *This class passing values of instance chattingMediator
 *& userName to super class User and overridden 
 * methods sendMessage & receiveMessage
 * to fulfill.
 * Method sendMessage -- > Send message in group chat
 * Method receiveMessage -- > receive message by every user in group chat
 */

class UserImpl extends User {

	private ChattingMediator chattingMediator;
	private  String userName;

	public UserImpl(ChattingMediator chattingMediator, String userName) {
		super(chattingMediator, userName);
		this.chattingMediator = chattingMediator;
		this.userName = userName;
	}

	@Override
	public void sendMessage(String message) {
		System.out.println(userName + " sending message = "+message);
		chattingMediator.sendMessage(message, this);
	}

	@Override
	public void receiveMessage(String message) {
		System.out.println(userName + " received message = "+message);
	}

}

/**
 *Client program which shows how Mediator
 *Design Pattern we use in Group Chat Application.
 */

public class MediatorPattern {

	public static void main(String[] args) {
		ChattingMediator  chattingMediator = new ChattingMediatorImpl();

		//Created few Users
		User user1 = new UserImpl(chattingMediator, "KK");
		User user2 = new UserImpl(chattingMediator, "PK");
		User user3 = new UserImpl(chattingMediator, "MK");
		User user4 = new UserImpl(chattingMediator, "SK");
		User user5 = new UserImpl(chattingMediator, "VK");

		//Adding many users in Group Chat
		chattingMediator.addUser(user1);
		chattingMediator.addUser(user2);
		chattingMediator.addUser(user3);
		chattingMediator.addUser(user4);
		chattingMediator.addUser(user5);

		//User PK sending message in Group Chat.
		user2.sendMessage("Hi,All");
	}

}
