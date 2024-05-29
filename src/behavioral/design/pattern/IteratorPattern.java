package behavioral.design.pattern;

interface Iterator {
	public abstract boolean hasNext();
	public abstract Object next();
}

interface Collection {
	public abstract Iterator getIterator();
}

class CollectionImpl implements Collection {
	
	String[] inputArray = {"Mangal", "Sonam", "Ankit", "Vipul", "Riya", "Ananya"};

	@Override
	public Iterator getIterator() {
		return new Itr();
	}
	
	class Itr implements Iterator {
		
		int index = 0;

		@Override
		public boolean hasNext() {
			if(index<inputArray.length)
				return true;
			return false;
		}

		@Override
		public Object next() {
			if(this.hasNext())
				return inputArray[index++];
			return null;
		}
		
	}
	
}

public class IteratorPattern {

	public static void main(String[] args) {
		CollectionImpl collectionImpl = new CollectionImpl();
		Iterator iterator = collectionImpl.getIterator();
		
		while(iterator.hasNext()) {
			Object object = iterator.next();
			String name = (String)object;
			System.out.println("Name::" + name);
		}
	}

}
