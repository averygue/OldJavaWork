/*
 * Avery Guething
 * Tyler Gillen 1020
 * Lab 13: Review
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class Pizza_TestCast {

	// test methods for various get and set methods
	@Test
	public void testGetSize() {
		Pizza pizza1 = new Pizza("medium", 1, 2, 3);
		assertEquals("medium", pizza1.getSize());
	}

	@Test
	public void testSetSize() {
		Pizza pizza1 = new Pizza();
		pizza1.setSize("small");
		assertEquals("small", pizza1.getSize());
	}

	@Test
	public void testSetCheeseToppings() {
		Pizza pizza1 = new Pizza();
		pizza1.setCheeseToppings(1);
		assertEquals(1, pizza1.getCheeseToppings());
	}

	@Test
	public void testGetPepperoniToppings() {
		Pizza pizza1 = new Pizza("small", 1, 2, 3);
		assertEquals(2, pizza1.getPepperoniToppings());
	}

	@Test
	public void testSetHamToppings() {
		Pizza pizza1 = new Pizza();
		pizza1.setHamToppings(1);
		assertEquals(1, pizza1.getHamToppings());
	}

	@Test
	// test method for constructor
	public void testPizzaStringIntIntInt() {
		Pizza pizza1 = new Pizza("small", 1, 2, 3);
		assertTrue(pizza1 != null);
		assertEquals("small", pizza1.getSize());
		assertEquals(1, pizza1.getCheeseToppings());
		assertEquals(2, pizza1.getPepperoniToppings());
		assertEquals(3, pizza1.getHamToppings());
	}

	@Test
	// test method for calcCost for one pizza
	public void testCalcCost() {
		Pizza pizza1 = new Pizza("small", 1, 0, 0);
		assertTrue(pizza1.calcCost() == 12.0);
	}

}
