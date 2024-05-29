package behavioral.design.pattern;

interface State {
	public abstract void doAction();
}

class ACStartState implements State {

	@Override
	public void doAction() {
		System.out.println("AC is turned ON");
	}
	
}

class ACStopState implements State {

	@Override
	public void doAction() {
		System.out.println("AC is turned OFF");
	}
	
}

class ACContect implements State {
	
	private State state;
	
	public void setState(State state) {
		this.state = state;
	}

	public State getState() {
		return state;
	}
	
	@Override
	public void doAction() {
		state.doAction();
	}
	
}

public class StatePattern {

	public static void main(String[] args) {
		ACContect acContect = new ACContect();
		State state = new ACStartState();
		acContect.setState(state);
		acContect.doAction();
		
		System.out.println("==========================");
		
		state = new ACStopState();
		acContect.setState(state);
		acContect.doAction();
	}

}
