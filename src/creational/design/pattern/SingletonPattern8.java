package creational.design.pattern;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Singleton8 implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private static Singleton8 INSTANCE = null;
	
	private Singleton8() {}
	
	public static Singleton8 getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Singleton8();
		}
		return INSTANCE;
	}
	
	public Object readResolve() {
		return getInstance();
	}
}

public class SingletonPattern8 {

	public static void main(String[] args) throws IOException {
		ObjectOutput objectOutput = null;
		Singleton8 obj1 = Singleton8.getInstance();
		Singleton8 obj2 = null;
		
		try {
			objectOutput = new ObjectOutputStream(new FileOutputStream("Ma.txt"));
			objectOutput.writeObject(obj1);
			objectOutput.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(objectOutput!=null)
				objectOutput.close();
		}
		
		ObjectInput objectInput = null;
		
		try {
			objectInput = new ObjectInputStream(new FileInputStream("Ma.txt"));
			Object readObject = objectInput.readObject();
			obj2 = (Singleton8)readObject;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(objectInput!=null)
				objectInput.close();
		}
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
	}

}
