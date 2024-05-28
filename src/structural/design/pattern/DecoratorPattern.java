package structural.design.pattern;

interface Bike {
	public abstract void assembleBike();
}

class BasicBike implements Bike {

	@Override
	public void assembleBike() {
		System.out.println("Basic Bike..");
	}

}

class DecoratorBike implements Bike {

	private Bike bike;

	public DecoratorBike(Bike bike) {
		super();
		this.bike = bike;
	}

	@Override
	public void assembleBike() {
		bike.assembleBike();
	}

}

class SportsBike extends DecoratorBike {

	public SportsBike(Bike bike) {
		super(bike);
	}

	@Override
	public void assembleBike() {
		super.assembleBike();
		System.out.println("Adding features of Sports Bike..");
	}
}

class LuxuryBike extends DecoratorBike {

	public LuxuryBike(Bike bike) {
		super(bike);
	}

	@Override
	public void assembleBike() {
		super.assembleBike();
		System.out.println("Adding features of Luxury Bike..");
	}
}

public class DecoratorPattern {

	public static void main(String[] args) {
		//Assemble Basic Bike
		System.out.println("-----------Assemble Basic Bike-------------");
		Bike basicBike = new BasicBike();
		basicBike.assembleBike();

		//Decorate BasicBike with Luxury Feature
		System.out.println("-----------Decorate BasicBike with Luxury Feature------------");
		Bike luxuryBike = new LuxuryBike(new BasicBike());
		luxuryBike.assembleBike();

		/*Decorate BasicBike with Luxury
				and Sports Features*/
		System.out.println("------Decorate BasicBike with Luxury and Sports Features-----");
		Bike sportsLuxuryBike = new SportsBike(new LuxuryBike(new BasicBike()));
		sportsLuxuryBike.assembleBike();
	}

}
