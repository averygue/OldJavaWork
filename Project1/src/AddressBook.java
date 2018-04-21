
/*
 * Avery Guething
 * Assignment 1
 * September 2017
 * COSC 2100
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.Scanner;


public class AddressBook {
	Contact[] contactList;

	// constructor for addressbook
	public AddressBook(int a) {
		contactList = new Contact[a];
	}

	// imports Contacts from CVS file
	public boolean importContacts(String fileName) throws IOException {
		File file;
		file = new File(fileName + ".CSV");
		BufferedReader cvsReader = null;
		// if the file exists then add each variable, split by comma, to
		// contactList
		if (file.exists()) {
			cvsReader = new BufferedReader(new FileReader(file));
			int count = 0;
			String emptyString;
			System.out.println("Contacts Imported:");
			while ((emptyString = cvsReader.readLine()) != null) {
				Contact newContact = new Contact();
				String[] array1 = emptyString.split(",");
				System.out.println(emptyString);
				newContact.setFirstName(array1[0]);
				newContact.setLastName(array1[1]);
				newContact.setAddress(array1[2]);
				newContact.setCity(array1[3]);
				newContact.setState(array1[4]);
				newContact.setZip(array1[5]);
				newContact.setPhoneNumber(array1[6]);
				newContact.setEmailAddress(array1[7]);
				contactList[count] = newContact;
				count++;
			}

			System.out.println("Import Complete");
			cvsReader.close();

		} else {
			// if contact does not exist, return false
			System.out.println("Import Not complete");
			return false;
		}
		return true;
	}

	// exports contacts to CSV
	public boolean export(String outputFileName) throws FileNotFoundException {
		File file;
		String output1 = (outputFileName + ".CSV");
		file = new File(output1);
		if (contactList == null) {
			System.out.println("No Contacts Found");
		}
		// if the file exists, ask to overwrite, then print to file
		if (file.exists()) {
			System.out.println("File Exists. Would you like to overwite? Yes or No");
			Scanner input = new Scanner(System.in);
			String a = input.nextLine().toLowerCase();
			if (a.equals("yes")) {
				try {
					PrintWriter pw = new PrintWriter(output1);
					for (int i = 0; i < contactList.length; i++) {
						if (contactList[i] != null) {
							pw.print(contactList[i].getFirstName() + ",");
							pw.print(contactList[i].getLastName() + ",");
							pw.print(contactList[i].getAddress() + ",");
							pw.print(contactList[i].getCity() + ",");
							pw.print(contactList[i].getState() + ",");
							pw.print(contactList[i].getZip() + ",");
							pw.print(contactList[i].getPhoneNumber() + ",");
							pw.print(contactList[i].getEmailAddress());
							pw.println();
						}

					}
					pw.close();
					System.out.println("Export Complete");
				} catch (Exception ele) {
					System.out.println(ele);
					return false;
				}
			} else {
				System.out.println("Did not overwrite.");
				return false;
			}
			return true;
		} else {
			// if contact does not exist, create and write to file
			try {
				PrintWriter pw = new PrintWriter(output1);
				for (int i = 0; i < contactList.length; i++) {
					if (contactList[i] != null) {
						pw.print(contactList[i].getFirstName() + ",");
						pw.print(contactList[i].getLastName() + ",");
						pw.print(contactList[i].getAddress() + ",");
						pw.print(contactList[i].getCity() + ",");
						pw.print(contactList[i].getState() + ",");
						pw.print(contactList[i].getZip() + ",");
						pw.print(contactList[i].getPhoneNumber() + ",");
						pw.print(contactList[i].getEmailAddress() + ",");
						pw.println();
					} else {
						contactList[i] = null;
					}
				}
				pw.close();
				System.out.println("Export Complete");
			} catch (Exception exe) {
				System.out.println(exe);
				return false;
			}
		}
		return true;
	}

	// searches for specific name, case insensitive
	public void search(String name) {
		String search = name.toLowerCase();
		// goes through array and searches for value
		boolean result = false;
		for (int i = 0; i < contactList.length; i++) {
			Contact temp = contactList[i];
			if (temp == null) {
				continue;
			} else if (temp.getFirstName().toLowerCase().equals(search)
					|| temp.getLastName().toLowerCase().equals(search)) {
				System.out.println("Contact Found: \n" + temp.toString());
				System.out.println("Position in Address Book: " + i);
				result = true;
			}
		}
		if (result == false)
			System.out.println("Search complete. Did not find any contacts.");
	}

	// adds a contact to the nearest empty spot
	public boolean add() {
		for (int b = 0; b < contactList.length; b++) {
			if (contactList[b] == null) {
				System.out.println("Empty Address spot found: What is the first name of the Contact?");
				Contact newContact = new Contact();
				Scanner input = new Scanner(System.in);
				String firstName = input.nextLine();
				newContact.setFirstName(firstName);
				System.out.println("What is the last name of the new Contact?");
				String lastName = input.nextLine();
				newContact.setLastName(lastName);
				System.out.println("What is the address of the new Contact");
				newContact.setAddress(input.nextLine());
				System.out.println("What is the city of the new Contact");
				newContact.setCity(input.nextLine());
				System.out.println("What is the state of the new Contact");
				newContact.setState(input.nextLine());
				System.out.println("What is the zip of the new Contact");
				newContact.setZip(input.nextLine());
				System.out.println("What is the phone number of the new Contact");
				newContact.setPhoneNumber(input.nextLine());
				System.out.println("What is the email address of the new Contact");
				newContact.setEmailAddress(input.nextLine());
				contactList[b] = newContact;
				System.out.println("Contact added.");
			} else if (b == contactList.length) {
				System.out.println("No Space Found.");
				return false;
			}

		}
		return true;
	}
	// removes a contact
	public boolean remove(int id) {
		try {
			// goes through array, finds contact, asks to remove,
			for (int i = 0; i < contactList.length; i++) {
				if (i == id) {
					System.out.println("Contact to Remove: \n" + contactList[i].toString());
					System.out.println("Is it okay to remove this contact?");
					Scanner input = new Scanner(System.in);
					String a = input.nextLine().toLowerCase();
					if (a.equals("yes")) {
						contactList[i] = null;
						System.out.println("Contact Removed!");
					} else {
						System.out.println("Contact not removed");
					}
				}
			}
		} catch (Exception ee) {
			System.out.println("Error: Parameter is invalid");
			return false;
		}
		return true;
	}
	//main method
	public static void main(String[] args) throws IOException {
		AddressBook myAddressBook;
		if (args.length >= 1)
			myAddressBook = new AddressBook(Integer.parseInt(args[0]));
		else
			myAddressBook = new AddressBook(100);
		if (args.length >= 2)
			myAddressBook.importContacts(args[1]);
		else {
			myAddressBook.importContacts("contacts");
		}
		//myAddressBook.export("Export_Test");
//		myAddressBook.search("Henry");
//		myAddressBook.search("Amanda");
//		myAddressBook.remove(2);
//		myAddressBook.add();
//		myAddressBook.export("Export_Test2");
	}
}
