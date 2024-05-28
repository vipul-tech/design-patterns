package behavioral.design.pattern;

abstract class PizzaTemplate {
	
	public final void preparePizza() {
		selectBread();
		addingIngredients();
		cooking();
		addingCheese();
		addingToppings();
	}
	
	public abstract void selectBread();
	public abstract void addingIngredients();
	
	public void cooking() {
		System.out.println("Cooking Pizza for 15 minutes!");
	}
	
	public final void addingCheese() {
		System.out.println("Adding Cheese in Pizza");
	}
	
	public void addingToppings() {
		System.out.println("Adding Topinngs in Pizza");
	}
	
}

class VegPizza extends PizzaTemplate {

	@Override
	public void selectBread() {
		System.out.println("Choosing Bread for Veg-Pizza!!");
	}

	@Override
	public void addingIngredients() {
		System.out.println("Adding ingredients in Veg-Pizza!!");
	}
	
}

class NonVegPizza extends PizzaTemplate {

	@Override
	public void selectBread() {
		System.out.println("Choosing Bread for NonVeg-Pizza!!");
	}

	@Override
	public void addingIngredients() {
		System.out.println("Adding ingredients in NonVeg-Pizza!!");
	}
	
}

public class TemplatePattern {

	public static void main(String[] args) {
		PizzaTemplate pizzaTemplate = new VegPizza();
		pizzaTemplate.preparePizza();
		
		System.out.println("================================");
		
		pizzaTemplate = new NonVegPizza();
		pizzaTemplate.preparePizza();
	}

}
