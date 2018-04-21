/*
 * Avery Guething
 * Tyler Gillen 1020
 * Lab 13: Review
 */
import junit.framework.TestCase;

public class PizzaOrder_Test extends TestCase {

	//test cases for TotalCost for 1,2, or 3 pizzas
	public void testCalcTotal() {
		PizzaOrder po = new PizzaOrder(1);
		Pizza pizza1 = new Pizza("small", 0, 0, 0);
		po.setPizza1(pizza1);

		assertTrue(po.calcTotal() == 10.0);
	}

	public void testCalcTotal2() {
		PizzaOrder po = new PizzaOrder(2);
		Pizza pizza1 = new Pizza("small", 0, 0, 0);
		Pizza pizza2 = new Pizza("medium", 0, 0, 0);
		po.setPizza1(pizza1);
		po.setPizza2(pizza2);

		assertTrue(po.calcTotal() == 22.0);
	}
	public void testCalcTotal3() {
		PizzaOrder po = new PizzaOrder(3);
		Pizza pizza1 = new Pizza("small", 0, 0, 0);
		Pizza pizza2 = new Pizza("medium", 0, 0, 0);
		Pizza pizza3 = new Pizza("large", 0, 0, 0);
		
		
		po.setPizza1(pizza1);
		po.setPizza2(pizza2);
		po.setPizza3(pizza3);

		assertTrue(po.calcTotal() == 36.0);
	}

}
