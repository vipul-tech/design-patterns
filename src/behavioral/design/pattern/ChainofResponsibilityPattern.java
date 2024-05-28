package behavioral.design.pattern;

import java.util.Scanner;

/**
 * Contract to process request in chain and 
 * dispense
 */
interface MoneyDispenseChain {
	public abstract void setNextChain(MoneyDispenseChain moneyDispenseChain);
	public abstract void dispense(Currency currency);
}

class Currency {

	private int amount;

	public Currency(int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}
}

/**
 * Filter in the chain responsible to process Rs 100 note 
 */
class Rupees100DispenseChain implements MoneyDispenseChain {

	private MoneyDispenseChain moneyDispenseChain;
	@Override
	public void setNextChain(MoneyDispenseChain moneyDispenseChain) {
		this.moneyDispenseChain = moneyDispenseChain;
	}

	@Override
	public void dispense(Currency currency) {

		if(currency.getAmount() >=100) {
			int numberOfNotes = currency.getAmount()/100;
			int remainder = currency.getAmount() % 100;
			System.out.println("Depensing " + numberOfNotes  +" Notes of Rs 100");
			if(remainder !=0) {
				moneyDispenseChain.dispense(new Currency(remainder));
			}

		}else {
			moneyDispenseChain.dispense(currency);
		}

	}

}

/**
 *Filter in the chain responsible to process Rs 200 note
 */
class Rupees200DispenseChain implements MoneyDispenseChain {

	private MoneyDispenseChain moneyDispenseChain;

	@Override
	public void setNextChain(MoneyDispenseChain moneyDispenseChain) {
		this.moneyDispenseChain = moneyDispenseChain;
	}

	@Override
	public void dispense(Currency currency) {

		if(currency.getAmount() >=200) {
			int numberOfNotes = currency.getAmount()/200;
			int remainder = currency.getAmount() % 200;
			System.out.println("Depensing " + numberOfNotes  +" Notes of Rs 200");
			if(remainder !=0) {
				moneyDispenseChain.dispense(new Currency(remainder));
			}

		}else {
			moneyDispenseChain.dispense(currency);
		}

	}
}

/**
 *Filter in the chain responsible to process Rs 500 note
 */
class Rupees500DispenseChain implements MoneyDispenseChain {

	private MoneyDispenseChain moneyDispenseChain;

	@Override
	public void setNextChain(MoneyDispenseChain moneyDispenseChain) {
		this.moneyDispenseChain = moneyDispenseChain;
	}

	@Override
	public void dispense(Currency currency) {

		if(currency.getAmount() >=500) {
			int numberOfNotes = currency.getAmount()/500;
			int remainder = currency.getAmount() % 500;
			System.out.println("Depensing " + numberOfNotes  +" Notes of Rs 500");
			if(remainder !=0) {
				moneyDispenseChain.dispense(new Currency(remainder));
			}

		}else {
			moneyDispenseChain.dispense(currency);
		}

	}

}

/**
 *Filter in the chain responsible to process Rs 2000 note
 */
class Rupees2000DispenseChain implements MoneyDispenseChain {

	private MoneyDispenseChain moneyDispenseChain;

	@Override
	public void setNextChain(MoneyDispenseChain moneyDispenseChain) {
		this.moneyDispenseChain = moneyDispenseChain;
	}

	@Override
	public void dispense(Currency currency) {

		if(currency.getAmount() >=2000) {
			int numberOfNotes = currency.getAmount()/2000;
			int remainder = currency.getAmount() % 2000;
			System.out.println("Depensing " + numberOfNotes  +" Notes of Rs 2000");
			if(remainder !=0) {
				moneyDispenseChain.dispense(new Currency(remainder));
			}

		}else {
			moneyDispenseChain.dispense(currency);
		}
	}

}

/**
 *Every object in the chain will have to process the request,
 *either complete or partial,or to send it to the next object in the chain.
 */
class ATMMachineDispenseChain {

	private MoneyDispenseChain moneyDispenseChain1;

	public ATMMachineDispenseChain() {
		moneyDispenseChain1 = new Rupees2000DispenseChain();
		MoneyDispenseChain moneyDispenseChain2 = new Rupees500DispenseChain();
		MoneyDispenseChain moneyDispenseChain3 = new Rupees200DispenseChain();
		MoneyDispenseChain moneyDispenseChain4 = new Rupees100DispenseChain();

		moneyDispenseChain1.setNextChain(moneyDispenseChain2);
		moneyDispenseChain2.setNextChain(moneyDispenseChain3);
		moneyDispenseChain3.setNextChain(moneyDispenseChain4);
	}

	public MoneyDispenseChain getMoneyDispenseChain1() {
		return moneyDispenseChain1;
	}
}

public class ChainofResponsibilityPattern {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ATMMachineDispenseChain  atmMachineDispenseChain = new ATMMachineDispenseChain();

		Scanner scanner = null;
		while (true) {
			int amout = 0;
			try {
				System.out.println("Please enter amout to despense:");
				scanner = new Scanner(System.in);
				amout= scanner.nextInt();

				if(amout %100 !=0) {
					System.out.println("Amount should be multiple of Rs 100");
					return;
				}else {
					atmMachineDispenseChain.getMoneyDispenseChain1().dispense(new Currency(amout));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
