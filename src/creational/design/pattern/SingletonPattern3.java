package creational.design.pattern;

class Singleton3 {
	private static Singleton3 INSTANCE = null;
	
	private Singleton3() {}
	
	//Lazy initialization
	public static Singleton3 getInstance() {
		//If Instance is null then only instantiate
		if(INSTANCE == null)
			INSTANCE = new Singleton3();
		return INSTANCE;
	}
}

public class SingletonPattern3 {

	public static void main(String[] args) {
		Singleton3 obj1 = Singleton3.getInstance();
		Singleton3 obj2 = Singleton3.getInstance();
		
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
	}

}
