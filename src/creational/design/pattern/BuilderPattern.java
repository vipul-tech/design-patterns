package creational.design.pattern;

class Laptop1 {

	//Required Fields
	private String ram;
	private String hdd;
	private String cpu;

	//Optional Fields
	private boolean isGraphicsEnabled;
	private boolean isBluetoothEnabled;

	public String getRam() {
		return ram;
	}
	public String getHdd() {
		return hdd;
	}
	public String getCpu() {
		return cpu;
	}
	public boolean isGraphicsEnabled() {
		return isGraphicsEnabled;
	}
	public boolean isBluetoothEnabled() {
		return isBluetoothEnabled;
	}

	/*Make private constructor of Laptop1(outer class)
	 * so that direct object creation can be prevented
	 * and Object can be created only by calling
	 *LaptopBuilder:build()
	 *Initialize all instance variables of 
	 *Laptop1(outer class) from LaptopBuilder
	 */

	private Laptop1(LaptopBuilder builder) {
		this.ram = builder.ram;
		this.hdd = builder.hdd;
		this.cpu = builder.cpu;
		this.isBluetoothEnabled = builder.isBluetoothEnabled;
		this.isGraphicsEnabled = builder.isGraphicsEnabled;
	}

	/**
	 * Internal class LaptopBuilder, which has
	 * public constructor to initializes required/Mandatory fields
	 * and we have setter methods for all Optional fields
	 * which returns LaptopBuilder itself.
	 */

	public static class LaptopBuilder {

		//Required Fields
		private String ram;
		private String hdd;
		private String cpu;

		//Optional Fields
		private boolean isGraphicsEnabled;
		private boolean isBluetoothEnabled;

		public LaptopBuilder(String ram, String hdd, String cpu) {
			super();
			this.ram = ram;
			this.hdd = hdd;
			this.cpu = cpu;
		}

		public LaptopBuilder setGraphicsEnabled(boolean isGraphicsEnabled) {
			this.isGraphicsEnabled = isGraphicsEnabled;
			return this;
		}

		public LaptopBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
			this.isBluetoothEnabled = isBluetoothEnabled;
			return this;
		}

		/*Only one way to create Laptop1 Object
		 * by calling LaptopBuilder:build()
		 */
		public Laptop1 build() {
			return new Laptop1(this);
		}

	}

	@Override
	public String toString() {
		return "Laptop1 [ram=" + ram + ", hdd=" + hdd + ", cpu=" + cpu + ", isGraphicsEnabled=" + isGraphicsEnabled
				+ ", isBluetoothEnabled=" + isBluetoothEnabled + "]";
	}

}

public class BuilderPattern {

	public static void main(String[] args) {
		
		//Create Laptop1 with Required Fields
		Laptop1 laptop1 = new Laptop1.LaptopBuilder("16 GB", "240 GB", "2.56 HZ").build();
		System.out.println("Laptop Config::"+laptop1);

		//Create Laptop1 with Required and Optional Fields
		Laptop1 laptop2 = new Laptop1.LaptopBuilder("32 GB", "1024 GB", "2.56 HZ").setBluetoothEnabled(true).setGraphicsEnabled(false).build();
		System.out.println("Laptop Config::"+laptop2);

		//Create Laptop1 with Required and Optional Fields
		Laptop1 laptop3 = new Laptop1.LaptopBuilder("32 GB", "240 GB", "2.56 HZ").setBluetoothEnabled(true).build();

		System.out.println("Laptop Config::"+laptop3);
		
	}

}
