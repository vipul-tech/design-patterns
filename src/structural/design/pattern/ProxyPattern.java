package structural.design.pattern;

interface VeryExpensiveProcess {
	public abstract void process();
}

class VeryExpensiveProcessImpl implements VeryExpensiveProcess {

	public VeryExpensiveProcessImpl() {
		heavyInitialConfigurationSetup();
	}
	
	private void heavyInitialConfigurationSetup() {
		System.out.println("Setting up initial configuration");
	}

	@Override
	public void process() {
		System.out.println("Processing is done");
	}
	
}

class VeryExpensiveProcessProxy implements VeryExpensiveProcess {

	private static VeryExpensiveProcess veryExpensiveObject;
	
	@Override
	public void process() {
		if(veryExpensiveObject==null)
			veryExpensiveObject = new VeryExpensiveProcessImpl();
		veryExpensiveObject.process();
	}
	
}

public class ProxyPattern {

	public static void main(String[] args) {
		VeryExpensiveProcess veryExpensiveProcess = new VeryExpensiveProcessProxy();
		veryExpensiveProcess.process();
		veryExpensiveProcess.process();
	}

}
