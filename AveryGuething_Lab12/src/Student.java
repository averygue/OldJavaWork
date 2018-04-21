/*
 * Avery Guething
 * Lab 12: Testing
 * Tyler Gillen 1020
 */
public class Student {
	//instance variables
	private String id;
	private String name;
	private String department;

	//mutators and accessors
	public void setId(String a) {
		id = a;
	}

	public void setName(String a) {
		name = a;
	}

	public void setDepartment(String a) {
		department = a;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	//two constructors
	public Student(String name) {
		this.name = name;
	}

	public Student(String id, String name, String department) {
		this.id = id;
		this.name = name;
		this.department = department;
	}
	
	//compares two student objects
	public boolean equals(Student anotherStudent) {
		if (anotherStudent.id.equals(this.id) && anotherStudent.name.equals(this.name)
				&& anotherStudent.department.equals(this.department)) {
			return true;
		} else {
			return false;
		}

	}
	//toString method
	public String toString() {
		String x = "ID: " + id +",Name: " + name + ",Department: " + department;
		return x;
	}

}
