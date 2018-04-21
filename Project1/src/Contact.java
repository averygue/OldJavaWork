/*
 * Avery Guething
 * Assignment 1
 * September 2017
 * COSC 2100
 */
public class Contact {
	//private instance variables
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phoneNumber;
	private String emailAddress;
	
	//Following are the get and setters for the private instance variables
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
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

	//default constructor for contact
	public Contact() {
		firstName = "";
		lastName = "";
		address = "";
		city = "";
		state = "";
		zip = "";
		phoneNumber = "";
		emailAddress = "";
	}
	//constructor with all variables given for contact
	public Contact(String a, String b, String c, String d, String e, String f, String g, String h) {
		firstName = a;
		lastName = b;
		address = c;
		city = d;
		state = e;
		zip = f;
		phoneNumber = g;
		emailAddress = h;
	}
	//to String Method
	public String toString() {
		return firstName + " "+ lastName + ", " + address + ", " + city
				+ ", " + state + ", " + zip + ", " + phoneNumber + ", "
				+ emailAddress;
	}
	
	
}
