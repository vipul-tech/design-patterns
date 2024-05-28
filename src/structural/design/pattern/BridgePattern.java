package structural.design.pattern;

interface Color {
	public abstract String fill();
}

abstract class Shape {
	protected Color color;

	public Shape(Color color) {
		this.color = color;
	}
	
	public abstract String draw();
}

class Blue implements Color {

	@Override
	public String fill() {
		return "Color is blue";
	}
	
}

class Red implements Color {

	@Override
	public String fill() {
		return "Color is red";
	}
	
}

class Square extends Shape {
	public Square(Color color) {
		super(color);
	}
	@Override
	public String draw() {
		return "Square is drawn " + color.fill();
	}
}

class Rectangle extends Shape {
	public Rectangle(Color color) {
		super(color);
	}
	@Override
	public String draw() {
		return "Rectangle is drawn " + color.fill();
	}
}

public class BridgePattern {

	public static void main(String[] args) {
		Shape shape1 = new Square(new Blue());
		String blueSquare = shape1.draw();
		System.out.println(blueSquare);
		
		System.out.println("-----------------------");
		
		Shape shape2 = new Rectangle(new Red());
		String redRectangle = shape2.draw();
		System.out.println(redRectangle);
	}

}
