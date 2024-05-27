package creational.design.pattern;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Singleton4 {
	private static Singleton4 INSTANCE = null;
	
	private Singleton4() {}
	
	public static Singleton4 getInstance() {
		if(INSTANCE == null) {
			synchronized(Singleton4.class){
				if(INSTANCE == null) {
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					INSTANCE = new Singleton4();
				}
			}
		}
		return INSTANCE;
	}
}

class MyThread implements Runnable {

	@Override
	public void run() {
		Singleton4 singleton = Singleton4.getInstance();
		System.out.println(Thread.currentThread().getName() + " " + singleton.hashCode());
	}
	
}

public class SingletonPattern4 {

	public static void main(String[] args) {
		ExecutorService executorService = null;
		MyThread myThread = new MyThread();
		try {
			executorService =  Executors.newFixedThreadPool(3);
			executorService .execute(myThread);
			executorService .execute(myThread);
			executorService .execute(myThread);
			executorService .execute(myThread);
			executorService .execute(myThread);
			executorService .execute(myThread);
			executorService .execute(myThread);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(executorService!=null)
				executorService.shutdown();
		}
	}

}
