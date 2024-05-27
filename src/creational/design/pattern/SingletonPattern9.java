package creational.design.pattern;

class Singleton9 implements Cloneable{
	private static Singleton9 INSTANCE = null;
	
	private Singleton9() {}
	
	public static Singleton9 getInstance() {
		if(INSTANCE==null)
			INSTANCE = new Singleton9();
		return INSTANCE;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("You cannot create object of singleton!!");
		//return super.clone();
	}
}

public class SingletonPattern9 {

	public static void main(String[] args) throws CloneNotSupportedException {
		Singleton9 obj1 = Singleton9.getInstance();
		Singleton9 obj2 = (Singleton9) obj1.clone();
		
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
	}

}
