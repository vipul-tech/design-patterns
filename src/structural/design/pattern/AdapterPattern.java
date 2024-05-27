package structural.design.pattern;

interface WallSocket {
	public abstract Volt getVolts();
}

interface MobileAdapter {
	public abstract Volt get3Volt();
}

class Volt {
	private int volts;
	
	public Volt(int volts) {
		this.volts = volts;
	}

	public int getVolts() {
		return volts;
	}

	@Override
	public String toString() {
		return "Volt [volts=" + volts + "]";
	}
	
}

class WallSocketImpl implements WallSocket {

	@Override
	public Volt getVolts() {
		return new Volt(240);
	}
	
}

class MobileAdapterImpl implements MobileAdapter {

	private WallSocket wallSocket;
	
	public MobileAdapterImpl(WallSocket wallSocket) {
		this.wallSocket = wallSocket;
	}

	@Override
	public Volt get3Volt() {
		Volt v240 = wallSocket.getVolts();
		int v3 = v240.getVolts()/80;
		return new Volt(v3);
	}
	
}

public class AdapterPattern {

	public static void main(String[] args) {
		WallSocket wallSocket = new WallSocketImpl();
		Volt v240 = wallSocket.getVolts();
		System.out.println(v240);
		
		MobileAdapter mobileAdapter = new MobileAdapterImpl(wallSocket);
		Volt v3 = mobileAdapter.get3Volt();
		System.out.println(v3);
	}

}
