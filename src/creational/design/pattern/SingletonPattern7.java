package creational.design.pattern;

enum Singleton7 {
	GETINSTANCE;
	
	public String welcome() {
		return "singleton!!";
	}
}

public class SingletonPattern7 {

	public static void main(String[] args) {
		Singleton7 obj1 = Singleton7.GETINSTANCE;
		Singleton7 obj2 = Singleton7.GETINSTANCE;
		
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
		
		String welcome = obj1.welcome();
		System.out.println(welcome);
	}

}
