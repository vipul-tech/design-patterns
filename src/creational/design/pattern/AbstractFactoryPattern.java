package creational.design.pattern;

interface Computer2 {
	public abstract String ram();
	public abstract String hdd();
	public abstract String cpu();
	
	public boolean isGraphicsEnabled();
	public boolean isBluetoothEnabled();
}

class PC2 implements Computer2 {
	private String ram, hdd, cpu;
	private boolean isGraphicsEnabled;
	private boolean isBluetoothEnabled;
	public PC2(String ram, String hdd, String cpu, boolean isGraphicsEnabled, boolean isBluetoothEnabled) {
		super();
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
		this.isGraphicsEnabled = isGraphicsEnabled;
		this.isBluetoothEnabled = isBluetoothEnabled;
	}
	@Override
	public String ram() {
		return this.ram;
	}
	@Override
	public String hdd() {
		return this.hdd;
	}
	@Override
	public String cpu() {
		return this.cpu;
	}
	@Override
	public boolean isGraphicsEnabled() {
		return this.isGraphicsEnabled;
	}
	@Override
	public boolean isBluetoothEnabled() {
		return this.isBluetoothEnabled;
	}
	@Override
	public String toString() {
		return "PC [ram=" + ram + ", hdd=" + hdd + ", cpu=" + cpu + ", isGraphicsEnabled=" + isGraphicsEnabled
				+ ", isBluetoothEnabled=" + isBluetoothEnabled + "]";
	}
}

class Server2 implements Computer2 {
	private String ram, hdd, cpu;
	private boolean isGraphicsEnabled;
	private boolean isBluetoothEnabled;
	public Server2(String ram, String hdd, String cpu, boolean isGraphicsEnabled, boolean isBluetoothEnabled) {
		super();
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
		this.isGraphicsEnabled = isGraphicsEnabled;
		this.isBluetoothEnabled = isBluetoothEnabled;
	}
	@Override
	public String ram() {
		return this.ram;
	}
	@Override
	public String hdd() {
		return this.hdd;
	}
	@Override
	public String cpu() {
		return this.cpu;
	}
	@Override
	public boolean isGraphicsEnabled() {
		return this.isGraphicsEnabled;
	}
	@Override
	public boolean isBluetoothEnabled() {
		return this.isBluetoothEnabled;
	}
	@Override
	public String toString() {
		return "Server [ram=" + ram + ", hdd=" + hdd + ", cpu=" + cpu + ", isGraphicsEnabled=" + isGraphicsEnabled
				+ ", isBluetoothEnabled=" + isBluetoothEnabled + "]";
	}
}

class Laptop2 implements Computer2 {
	private String ram, hdd, cpu;
	private boolean isGraphicsEnabled;
	private boolean isBluetoothEnabled;
	public Laptop2(String ram, String hdd, String cpu, boolean isGraphicsEnabled, boolean isBluetoothEnabled) {
		super();
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
		this.isGraphicsEnabled = isGraphicsEnabled;
		this.isBluetoothEnabled = isBluetoothEnabled;
	}
	@Override
	public String ram() {
		return this.ram;
	}
	@Override
	public String hdd() {
		return this.hdd;
	}
	@Override
	public String cpu() {
		return this.cpu;
	}
	@Override
	public boolean isGraphicsEnabled() {
		return this.isGraphicsEnabled;
	}
	@Override
	public boolean isBluetoothEnabled() {
		return this.isBluetoothEnabled;
	}
	@Override
	public String toString() {
		return "Laptop [ram=" + ram + ", hdd=" + hdd + ", cpu=" + cpu + ", isGraphicsEnabled=" + isGraphicsEnabled
				+ ", isBluetoothEnabled=" + isBluetoothEnabled + "]";
	}
}

interface AbstractComputerFactory {
	public abstract Computer2 createComputer();
}

class PCFactory implements AbstractComputerFactory {

	private String ram;
	private String hdd;
	private String cpu;
	private boolean isGraphicsEnabled;
	private boolean isBluetoothEnabled;
	
	public PCFactory(String ram, String hdd, String cpu, boolean isGraphicsEnabled, boolean isBluetoothEnabled) {
		super();
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
		this.isGraphicsEnabled = isGraphicsEnabled;
		this.isBluetoothEnabled = isBluetoothEnabled;
	}
	
	@Override
	public Computer2 createComputer() {
		return new PC2(ram, hdd, cpu, isGraphicsEnabled, isBluetoothEnabled);
	}
	
}

class LaptopFactory implements AbstractComputerFactory {

	private String ram;
	private String hdd;
	private String cpu;
	private boolean isGraphicsEnabled;
	private boolean isBluetoothEnabled;
	
	public LaptopFactory(String ram, String hdd, String cpu, boolean isGraphicsEnabled, boolean isBluetoothEnabled) {
		super();
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
		this.isGraphicsEnabled = isGraphicsEnabled;
		this.isBluetoothEnabled = isBluetoothEnabled;
	}
	
	@Override
	public Computer2 createComputer() {
		return new Laptop2(ram, hdd, cpu, isGraphicsEnabled, isBluetoothEnabled);
	}
	
}

class ServerFactory implements AbstractComputerFactory {

	private String ram;
	private String hdd;
	private String cpu;
	private boolean isGraphicsEnabled;
	private boolean isBluetoothEnabled;
	
	public ServerFactory(String ram, String hdd, String cpu, boolean isGraphicsEnabled, boolean isBluetoothEnabled) {
		super();
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
		this.isGraphicsEnabled = isGraphicsEnabled;
		this.isBluetoothEnabled = isBluetoothEnabled;
	}

	@Override
	public Computer2 createComputer() {
		return new Server2(ram, hdd, cpu, isGraphicsEnabled, isBluetoothEnabled);
	}
	
}

class ComputerFactory2 {
	 
	private ComputerFactory2() {}
	
	public static Computer2 getComputer(AbstractComputerFactory abstractComputerFactory) {
		return abstractComputerFactory.createComputer();
	}
}

public class AbstractFactoryPattern {

	public static void main(String[] args) {
		Computer2 pc = ComputerFactory2.getComputer(new PCFactory("16 GB", "120 GB", "2,23 HGZ", true, true));
		System.out.println("PC Config::"+pc);
		
		Computer2 server = ComputerFactory2.getComputer(new ServerFactory("32 GB", "320 GB", "2,29 HGZ", true, true));
		System.out.println("Server Config::"+server);
		
		Computer2 laptop = ComputerFactory2.getComputer(new LaptopFactory("16 GB", "140 GB", "2,23 HGZ", true, true));
		System.out.println("Laptop Config::"+laptop);
	}

}
