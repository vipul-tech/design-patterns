package behavioral.design.pattern;

import java.util.HashSet;
import java.util.Set;

interface Subject {
	public void register(Observer observer);
	public void unregister(Observer observer);
	public void notifyUpdate(Message message);
}

class MessagePublisher implements Subject {

	private Set<Observer> observers = new HashSet<>();
	
	@Override
	public void register(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void unregister(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyUpdate(Message message) {
		for (Observer observer : observers) {
			observer.updateObserver(message);
		}
	}
	
}

interface Observer {
	public void updateObserver(Message message);
}

class FirstMessageSubscriber implements Observer {

	@Override
	public void updateObserver(Message message) {
		System.out.println("Message for first subscriber :: " + message.getMessage());
	}
	
}

class SecondMessageSubscriber implements Observer {

	@Override
	public void updateObserver(Message message) {
		System.out.println("Message for second subscriber :: " + message.getMessage());
	}
	
}

class ThirdMessageSubscriber implements Observer {

	@Override
	public void updateObserver(Message message) {
		System.out.println("Message for third subscriber :: " + message.getMessage());
	}
	
}

final class Message {
	private String message;

	public Message(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
}

public class ObserverPattern {

	public static void main(String[] args) {
		FirstMessageSubscriber firstMessageSubscriber = new FirstMessageSubscriber();
		SecondMessageSubscriber secondMessageSubscriber = new SecondMessageSubscriber();
		ThirdMessageSubscriber thirdMessageSubscriber = new ThirdMessageSubscriber();
		
		MessagePublisher messagePublisher = new MessagePublisher();
		
		messagePublisher.register(firstMessageSubscriber);
		messagePublisher.register(secondMessageSubscriber);
		
		messagePublisher.notifyUpdate(new Message("This is first message"));
		System.out.println("========================");
		
		messagePublisher.unregister(secondMessageSubscriber);
		messagePublisher.register(thirdMessageSubscriber);
		
		messagePublisher.notifyUpdate(new Message("This is second message"));
	}

}
