package creational.design.pattern;

class Singleton2 {
	private static Singleton2 INSTANCE = null;
	
	private Singleton2() {}
	
	// static block initialization
	static {
		try {
			if(INSTANCE == null)
				INSTANCE = new Singleton2();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Singleton2 getInstance() {
		return INSTANCE;
	}
}

public class SingletonPattern2 {

	public static void main(String[] args) {
		Singleton2 obj1 = Singleton2.getInstance();
		Singleton2 obj2 = Singleton2.getInstance();
		
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
	}

}
