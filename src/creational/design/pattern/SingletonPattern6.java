package creational.design.pattern;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class Singleton6 {
	private static Singleton6 INSTANCE = null;
	
	private Singleton6() {}
	
	public static Singleton6 getInstance() {
		if(INSTANCE == null)
			INSTANCE = new Singleton6();
		return INSTANCE;
	}
}

//Destroying Singleton using Reflection
public class SingletonPattern6 {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, 
						IllegalArgumentException, InvocationTargetException {
		Singleton6 obj1 = Singleton6.getInstance();
		Singleton6 obj2 = null;
		
		Constructor<?>[] constructors = Singleton6.class.getDeclaredConstructors();
		for(Constructor<?> constructor : constructors) {
			constructor.setAccessible(true);
			Object object = constructor.newInstance();
			obj2 = (Singleton6)object;
		}
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
	}

}
