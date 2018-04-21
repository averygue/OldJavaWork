/*
 * Avery Guething
 * Tyler Gillen 1020
 * Lab 13: Review
 */
public class Pizza {
	private String size;
	private int cheeseToppings;
	private int pepperoniToppings;
	private int hamToppings;
	private static double cost;

	//constructors for Pizza object
	public Pizza() {
		size = "small";
		cheeseToppings = 0;
		pepperoniToppings = 0;
		hamToppings = 0;
	}

	public Pizza(String a, int b, int c, int d) {
		size = a;
		cheeseToppings = b;
		pepperoniToppings = c;
		hamToppings = d;
	}

	//getters and setters
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getCheeseToppings() {
		return cheeseToppings;
	}

	public void setCheeseToppings(int cheeseToppings) {
		this.cheeseToppings = cheeseToppings;
	}

	public int getPepperoniToppings() {
		return pepperoniToppings;
	}

	public void setPepperoniToppings(int pepperoniToppings) {
		this.pepperoniToppings = pepperoniToppings;
	}

	public int getHamToppings() {
		return hamToppings;
	}

	public void setHamToppings(int hamToppings) {
		this.hamToppings = hamToppings;
	}

	//calculates Pizza object cost
	public double calcCost() {
		cost = 0;
		if (size.equalsIgnoreCase("small")) {
			cost += 10;
			cost += 2 * pepperoniToppings;
			cost += 2 * hamToppings;
			cost += 2 * cheeseToppings;
			return cost;
		} else if (size.equalsIgnoreCase("medium")) {
			cost += 12;
			cost += 2 * pepperoniToppings;
			cost += 2 * hamToppings;
			cost += 2 * cheeseToppings;
		} else if (size.equalsIgnoreCase("large")) {
			cost += 14;
			cost += 2 * pepperoniToppings;
			cost += 2 * hamToppings;
			cost += 2 * cheeseToppings;
		}
		return cost;
	}

	//toString and gives out description of Pizza
	public String getDescription() {
		return (size + ", " + "Cheese Toppings: " + cheeseToppings + ", " + "Pepperoni Toppings: " + pepperoniToppings
				+ ", " + "Ham Toppings: " + hamToppings + "Cost:" + this.calcCost());
	}
}
