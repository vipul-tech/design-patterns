package creational.design.pattern;

class Singleton5 {
	private Singleton5() {}
	
	private static class SingletonHolder {
		private static final Singleton5 INSTANCE = new Singleton5();
	}
	
	public static Singleton5 getInstance() {
		return SingletonHolder.INSTANCE;
	}
}

public class SingletonPattern5 {

	public static void main(String[] args) {
		Singleton5 obj1 = Singleton5.getInstance();
		Singleton5 obj2 = Singleton5.getInstance();
		
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
		
	}

}
