package behavioral.design.pattern;

interface Item {
	public abstract double accept(ShoppingCartVisitor visitor);
}

interface ShoppingCartVisitor {
	public abstract double visit(Book book);
	public abstract double visit(Fruit fruit);
}

class Book implements Item {

	private String name;
	private String isbnNumber;
	private double price;

	public Book(String name, String isbnNumber, double price) {
		super();
		this.name = name;
		this.isbnNumber = isbnNumber;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public String getIsbnNumber() {
		return isbnNumber;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public double accept(ShoppingCartVisitor visitor) {
		return visitor.visit(this);
	}

}

class Fruit implements Item {

	private String name;
	private int weight;
	private double pricePerKg;

	public Fruit(String name, int weight, double pricePerKg) {
		super();
		this.name = name;
		this.weight = weight;
		this.pricePerKg = pricePerKg;
	}

	public String getName() {
		return name;
	}

	public int getWeight() {
		return weight;
	}

	public double getPricePerKg() {
		return pricePerKg;
	}

	@Override
	public double accept(ShoppingCartVisitor visitor) {
		return visitor.visit(this);
	}

}

class ShoppingCartVisitorImpl implements ShoppingCartVisitor {

	@Override
	public double visit(Book book) {
		double cost = 0.0;
		if(book.getPrice() > 500) {
			cost = book.getPrice()-100;
		}else {
			cost = book.getPrice();
		}
		System.out.println("BooK:"+book.getName() +", Book ISBN:"+book.getIsbnNumber()+", Cost :"+cost);
		return cost;
	}

	@Override
	public double visit(Fruit fruit) {
		double cost = fruit.getPricePerKg()*fruit.getWeight();
		System.out.println("Fruit :"+fruit.getName()  + ", cost :"+cost);
		return cost;
	}

}

public class VisitorPattern {

	public static void main(String[] args) {
		//Add as much as Items you want
		Item items[] =  new Item[] {
				new Book("Core Java", "8989898", 450.0),
				new Book("Hibernate", "8980998", 700.0),
				new Fruit("Mango", 2, 100.0),
				new Fruit("Apple", 3, 200.0)
		};

		//Calculate total cost of all Items
		double totalCost = calculateTotalCost(items);

		//Display total cost
		System.out.println("Total Cost ::"+totalCost);

	}

	private static double calculateTotalCost(Item[] items) {
		ShoppingCartVisitor shoppingCartVisitor = new ShoppingCartVisitorImpl();
		double totalCost = 0.0;
		for (Item item : items) {
			totalCost += item.accept(shoppingCartVisitor);
		}
		return totalCost;
	}
}
