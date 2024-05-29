package behavioral.design.pattern;

interface Expression {
	public abstract int interpret(InterpreterEngine interpreterEngine);
}

class InterpreterEngine {

	public int addition(String inputData) {
		String[] tokens = interpret(inputData);
		int number1 = Integer.parseInt(tokens[0]);
		int number2 = Integer.parseInt(tokens[1]);
		return number1+number2;
	}

	public int substraction(String inputData) {
		String[] tokens = interpret(inputData);
		int number1 = Integer.parseInt(tokens[0]);
		int number2 = Integer.parseInt(tokens[1]);
		return number2-number1;
	}

	public String[] interpret(String inputData) {
		String tempInputData = inputData.replaceAll("[^0-9]", " ");
		tempInputData = tempInputData.replaceAll("( )+", " ").trim();
		String[] inputDataTokens = tempInputData.split(" ");
		return inputDataTokens;
	}
}

class AdditionExpression implements Expression {

	private String expression;

	public AdditionExpression(String expression) {
		this.expression = expression;
	}

	@Override
	public int interpret(InterpreterEngine interpreterEngine) {
		return interpreterEngine.addition(expression);
	}

}

class SubstractionExpression implements Expression {

	private String expression;

	public SubstractionExpression(String expression) {
		this.expression = expression;
	}

	@Override
	public int interpret(InterpreterEngine interpreterEngine) {
		return interpreterEngine.substraction(expression);
	}

}

class InterpreterClient {
	private InterpreterEngine interpreterEngine;

	public InterpreterClient(InterpreterEngine interpreterEngine) {
		this.interpreterEngine = interpreterEngine;
	}

	public int interpret(String inputData) {
		Expression expression = null;
		if(inputData.contains("add"))
			expression = new AdditionExpression(inputData);
		else if(inputData.contains("subtract"))
			expression = new SubstractionExpression(inputData);
		else
			throw new RuntimeException(inputData + " is not a valid expression!!");
		
		int result = expression.interpret(interpreterEngine);
		System.out.println(inputData);
		
		return result;
	}
}

public class InterpreterPattern {

	public static void main(String[] args) {
		InterpreterEngine interpreterEngine = new InterpreterEngine();
		InterpreterClient interpreterClient = new InterpreterClient(interpreterEngine);
		
		System.out.println("Addition of both number is :: " + interpreterClient.interpret("add 200 and 175"));
		System.out.println("=======================================");
		System.out.println("Substraction of number is :: " + interpreterClient.interpret("subtract 40 from 100"));
	}

}
