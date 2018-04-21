/*
 * Avery Guething
 * Tyler Gillen 1020
 * Final Lab 14: Review
 */

//contact class with getters, setters, and constructors
public class Contact {
	
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String emailAddress;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Contact(String a, String b, String c, String d) {
		firstName = a;
		lastName = b;
		phoneNumber = c;
		emailAddress = d;
	}
	
	public Contact() {
		firstName = "";
		lastName = "";
		phoneNumber = "";
		emailAddress = "";
	}
	
	//toString method
	public String toString() {
		return "Contact: \n First Name: " + firstName + "\n Last Name: "  + lastName + "\n phone Number: " + phoneNumber
				+ "\n email Address: " + emailAddress;
	}
	
}
