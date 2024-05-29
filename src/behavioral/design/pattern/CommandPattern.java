package behavioral.design.pattern;

import java.util.ArrayList;
import java.util.List;

interface Order {
	public abstract void execute();
}

class BuyOrder implements Order {
	private Stock stock;

	public BuyOrder(Stock stock) {
		this.stock = stock;
	}

	@Override
	public void execute() {
		stock.buyStock();
	}
	
}

class SellOrder implements Order {
	private Stock stock;

	public SellOrder(Stock stock) {
		this.stock = stock;
	}

	@Override
	public void execute() {
		stock.sellStock();
	}
	
}

class Stock {
	private String stockName = "Google share";
	private int stockQuantity = 20;
	public void buyStock() {
		System.out.println("Stock name : " + stockName + " and Quantity : " + stockQuantity + " bought.");
	}
	public void sellStock() {
		System.out.println("Stock name : " + stockName + " and Quantity : " + stockQuantity + "sold");
	}
}

class StockBroker {
	private List<Order> orderList = new ArrayList<Order>();
	
	public void placeOrder(Order order) {
		orderList.add(order);
	}
	
	public void executeOrders() {
		for (Order order : orderList) {
			order.execute();
		}
		orderList.clear();
	}
}

public class CommandPattern {

	public static void main(String[] args) {
		Stock stock = new Stock();
		
		BuyOrder buyOrder = new BuyOrder(stock);
		SellOrder sellOrder = new SellOrder(stock);
		
		StockBroker stockBroker = new StockBroker();
		stockBroker.placeOrder(buyOrder);
		stockBroker.placeOrder(sellOrder);
		
		stockBroker.executeOrders();
	}

}
