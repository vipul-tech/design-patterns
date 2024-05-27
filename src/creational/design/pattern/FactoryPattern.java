package creational.design.pattern;

interface Computer {
	public abstract String ram();
	public abstract String hdd();
	public abstract String cpu();
	
	public boolean isGraphicsEnabled();
	public boolean isBluetoothEnabled();
}

class PC implements Computer {
	private String ram, hdd, cpu;
	private boolean isGraphicsEnabled;
	private boolean isBluetoothEnabled;
	public PC(String ram, String hdd, String cpu, boolean isGraphicsEnabled, boolean isBluetoothEnabled) {
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

class Server implements Computer {
	private String ram, hdd, cpu;
	private boolean isGraphicsEnabled;
	private boolean isBluetoothEnabled;
	public Server(String ram, String hdd, String cpu, boolean isGraphicsEnabled, boolean isBluetoothEnabled) {
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

class Laptop implements Computer {
	private String ram, hdd, cpu;
	private boolean isGraphicsEnabled;
	private boolean isBluetoothEnabled;
	public Laptop(String ram, String hdd, String cpu, boolean isGraphicsEnabled, boolean isBluetoothEnabled) {
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

enum ComputerType {
	PC, LAPTOP, SERVER
}

class ComputerFactory {
	private ComputerFactory() {}
	
	public static Computer getComputer(ComputerType computerType, String ram, String hdd, String cpu, boolean isGraphicsEnabled, boolean isBluetoothEnabled) {
		switch (computerType) {
		case PC: 
			return new PC(ram, hdd, cpu, isBluetoothEnabled, isBluetoothEnabled);
		case LAPTOP: 
			return new Laptop(ram, hdd, cpu, isBluetoothEnabled, isBluetoothEnabled);
		case SERVER: 
			return new Server(ram, hdd, cpu, isBluetoothEnabled, isBluetoothEnabled);
		default:
			throw new IllegalArgumentException("Invalid Computer Type!!");
		}
	}
}

public class FactoryPattern {

	public static void main(String[] args) {
		Computer pc = ComputerFactory.getComputer(ComputerType.PC, "16 GB", "120 GB", "2,23 HGZ", true, true);
		System.out.println("PC Config::"+pc);
		
		Computer server = ComputerFactory.getComputer(ComputerType.SERVER, "32 GB", "320 GB", "2,29 HGZ", true, true);
		System.out.println("Server Config::"+server);
		
		Computer laptop = ComputerFactory.getComputer(ComputerType.LAPTOP, "16 GB", "140 GB", "2,23 HGZ", true, true);
		System.out.println("Laptop Config::"+laptop);
	}

}
