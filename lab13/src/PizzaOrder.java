/*
 * Avery Guething
 * Tyler Gillen 1020
 * Lab 13: Review
 */
public class PizzaOrder {
	private int numberOfPizzas;
	private double totalCost = 0;
	private Pizza pizza1;
	private Pizza pizza2;
	private Pizza pizza3;
	
	
	//sets number of pizzas
	public void setNumPizzas(int numPizzas) {
		if (numPizzas <= 3 && numPizzas >= 1) {
			numberOfPizzas = numPizzas;
		} else {
			System.out.println("Too many or too little pizzas");
		}
	}

	//constructor for pizzaOrder
	public PizzaOrder(int num) {
		numberOfPizzas = num;
		if (numberOfPizzas == 1) {
			pizza1 = new Pizza();
		} else if (numberOfPizzas == 2) {
			pizza1 = new Pizza();
			pizza2 = new Pizza();
		} else if (numberOfPizzas == 3) {
			pizza1 = new Pizza();
			pizza2 = new Pizza();
			pizza3 = new Pizza();
		}
	}

	//sets each pizza
	public void setPizza1(Pizza pizza1) {
		this.pizza1 = pizza1;
	}

	public void setPizza2(Pizza pizza2) {
		this.pizza2 = pizza2;
		
	}

	public void setPizza3(Pizza pizza3) {
		this.pizza3 = pizza3;
	}

	//calculates order total
	public double calcTotal() {
		totalCost = 0;
		if (numberOfPizzas == 1) {
			totalCost += pizza1.calcCost();
		}
		else if(numberOfPizzas == 2) {
			totalCost = pizza1.calcCost() + pizza2.calcCost();
		}
		else if(numberOfPizzas == 3) {
			totalCost += pizza1.calcCost();
			totalCost += pizza2.calcCost();
			totalCost += pizza3.calcCost();
		}
		return totalCost;
	}
	//prints out total order / receipt
	public void printReceipt() {
		System.out.println("Pizzas Order:");
		if (numberOfPizzas == 1) {
			System.out.println("Pizza 1: " + pizza1.getDescription());
		}
		else if (numberOfPizzas == 2) {
			System.out.println("Pizza 1: " + pizza1.getDescription());
			System.out.println("Pizza 2: " + pizza2.getDescription());
		}
		else if (numberOfPizzas == 3) {
			System.out.println("Pizza 1: " + pizza1.getDescription());
			System.out.println("Pizza 2: " + pizza2.getDescription());
			System.out.println("Pizza 3: " + pizza3.getDescription());
		}
		System.out.println("Total Cost: " + totalCost);
	}
}
