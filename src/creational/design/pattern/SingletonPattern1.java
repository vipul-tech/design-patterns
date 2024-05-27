package creational.design.pattern;

class Singleton1 {
	//Eager initialization
	private static final Singleton1 INSTANCE = new Singleton1();
	
	/*
	 * private constructor so that
	 * preventing instance creation from other class
	 */
	private Singleton1() {}
	
	/**
	 * This method has global access to return
	 * Single instance within JVM
	 * @return Singleton Instance
	 */
	public static Singleton1 getInstance() {
		return INSTANCE;
	}
}

public class SingletonPattern1 {

	public static void main(String[] args) {
		Singleton1 obj1 = Singleton1.getInstance();
		Singleton1 obj2 = Singleton1.getInstance();
		
		/*if hashcode of both obj1 & obj2 are same 
			then both are the same object
		*/
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
	}

}
