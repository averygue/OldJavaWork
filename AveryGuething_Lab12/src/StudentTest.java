/*
 * Avery Guething
 * Lab 12: Testing
 * Tyler Gillen 1020
 */
import static org.junit.Assert.*;
import org.junit.Test;

public class StudentTest {
	@Test
	public void testSetId() {
		Student student1 = new Student("123456", "Avery", "Computer Science");
		student1.setId("12345");
		assertEquals("12345", student1.getId());

	}

	@Test
	public void testSetName() {
		Student student1 = new Student("123456", "Avery", "Computer Science");
		student1.setName("Susan");
		assertEquals("Susan", student1.getName());
	}

	@Test
	public void testSetDepartment() {
		Student student1 = new Student("123456", "Avery", "Computer Science");
		student1.setDepartment("Mathematics");
		assertEquals("Mathematics", student1.getDepartment());
	}

	@Test
	public void testGetId() {
		Student student1 = new Student("123456", "Avery", "Computer Science");
		assertEquals("123456", student1.getId());
	}

	@Test
	public void testGetName() {
		Student student1 = new Student("123456", "Avery", "Computer Science");
		assertEquals("Avery", student1.getName());
	}

	@Test
	public void testGetDepartment() {
		Student student1 = new Student("123456", "Avery", "Computer Science");
		assertEquals("Computer Science", student1.getDepartment());
	}

	@Test
	public void testStudentString() {

		Student student1 = new Student("Avery");

		assertTrue(student1 != null);
		assertTrue(student1.getName().equals("Avery"));

	}

	@Test
	public void testStudentStringStringString() {

		Student student1 = new Student("123456", "Avery", "Computer Science");

		assertTrue(student1 != null);
		assertEquals("123456", student1.getId());
		assertEquals("Avery", student1.getName());
		assertEquals("Computer Science", student1.getDepartment());
	}

	@Test
	public void testEqualsStudent() {
		Student student1 = new Student("123456", "Avery", "Computer Science");
		Student student2 = new Student("123456", "Avery", "Computer Science");
		Student student3 = new Student("123457", "Susan", "Mathematics");

		assertEquals(true, student1.equals(student2));
		assertEquals(false, student1.equals(student3));

	}

	@Test
	public void testToString() {
		Student student1 = new Student("123456", "Avery", "Computer Science");

		assertTrue(student1.toString().equals("ID: 123456,Name: Avery,Department: Computer Science"));

	}

}
