import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ContactOptions extends JFrame implements ActionListener {

	// gui setup
	private JPanel top = new JPanel();

	private JButton add = new JButton("Add");
	private JButton remove = new JButton("Remove");
	private JButton save = new JButton("Save");
	private JButton load = new JButton("Load");
	private JButton showAll = new JButton("Show All");
	private JButton search = new JButton("Search");
	private JButton exit = new JButton("Exit");
	JTextArea field = new JTextArea();

	// arrayList
	ArrayList<Contact> contactList = new ArrayList<Contact>();

	// if file exists, then load from it, otherwise creating file when saving
	public ContactOptions() {
		File file;
		file = new File("contacts.txt");
		if (file.exists()) {
			try {
				contactList.clear();
				Scanner sc = new Scanner("contacts.txt");
				while (sc.hasNextLine()) {
					Contact newCont = new Contact();
					newCont.setFirstName(sc.nextLine());
					newCont.setLastName(sc.nextLine());
					newCont.setPhoneNumber(sc.nextLine());
					newCont.setEmailAddress(sc.nextLine());
					sc.nextLine();
				}
			} catch (Exception xx) {
				JOptionPane.showMessageDialog(null, "No File Found");
			}
		}

		// more gui
		field.setEditable(false);
		setTitle("Contact Search");
		setBounds(500, 150, 700, 400);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLayout(new BorderLayout());

		add.addActionListener(this);
		remove.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
		showAll.addActionListener(this);
		search.addActionListener(this);
		exit.addActionListener(this);
		top.setLayout(new FlowLayout());
		top.add(add);
		top.add(remove);
		top.add(save);
		top.add(load);
		top.add(showAll);
		top.add(search);
		top.add(exit);
		add(top, BorderLayout.NORTH);
		add(field, BorderLayout.CENTER);

	}

	public static void main(String[] args) {
		ContactOptions screen = new ContactOptions();
		screen.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

		// add button, adds new contact
		if (e.getActionCommand().equals("Add")) {
			Contact test = new Contact();
			try {
				String name = JOptionPane.showInputDialog("Please Enter First Name");
				if (name.isEmpty()) {
					throw new Exception();
				}
				test.setFirstName(name);

				String name2 = JOptionPane.showInputDialog("Please Enter Last Name");
				if (name2.isEmpty()) {
					throw new Exception();
				}
				test.setLastName(name2);

				String number = JOptionPane.showInputDialog("Please Enter Phone Number");
				if (number.isEmpty()) {
					throw new Exception();
				}
				test.setPhoneNumber(number);

				String email = JOptionPane.showInputDialog("Please Enter Email Address");
				if (email.isEmpty()) {
					throw new Exception();
				}
				test.setEmailAddress(email);

				contactList.add(test);
				field.setText("Contact Added!");
			} catch (Exception eee) {
				JOptionPane.showMessageDialog(null, "Contact not created");
			}

			// remove contact based on search input
		} else if (e.getActionCommand().equals("Remove")) {
			String search = JOptionPane.showInputDialog("Name/PhoneNumber/Email that you would like to remove");

			try {
				boolean found = false;

				for (int i = 0; i < contactList.size(); i++) {
					Contact temp = contactList.get(i);
					if (temp.getEmailAddress().equals(search) || temp.getFirstName().equals(search)
							|| temp.getLastName().equals(search) || temp.getPhoneNumber().equals(search)) {
						contactList.remove(i);
					}

					if (!found) {
						JOptionPane.showMessageDialog(null, "No Contact Found");
					}

				}
				field.setText("Contact Removed");
			} catch (Exception ee) {
				JOptionPane.showMessageDialog(null, "No Contact Found");
			}

		}

		// saves all contacts
		else if (e.getActionCommand().equals("Save")) {
			try {
				PrintWriter pw = new PrintWriter("contacts.txt");
				for (int i = 0; i < contactList.size(); i++) {
					pw.println(contactList.get(i).getFirstName());
					pw.println(contactList.get(i).getLastName());
					pw.println(contactList.get(i).getPhoneNumber());
					pw.println(contactList.get(i).getEmailAddress());

				}
				pw.close();
				field.setText("Contacts Saved!");
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Problem Saving");
			}

		// loads all contacts
		} else if (e.getActionCommand().equals("Load")) {
			try {
				contactList.clear();
				 Scanner sc = new Scanner("contacts.txt");
				while (sc.hasNextLine()) {
					Contact newCont = new Contact();
					newCont.setFirstName(sc.nextLine());
					newCont.setLastName(sc.nextLine());
					newCont.setPhoneNumber(sc.nextLine());
					newCont.setEmailAddress(sc.nextLine());
					sc.nextLine();
				}
			} catch (Exception xx) {
				JOptionPane.showMessageDialog(null, "No File Found");
			}

		//shows all contacts
		} else if (e.getActionCommand().equals("Show All")) {
			field.setText("");
			for (int i = 0; i < contactList.size(); i++) {
				field.setText(field.getText() + contactList.get(i).toString() + "\n");
			}
		//searches for specific part of contact
		} else if (e.getActionCommand().equals("Search")) {
			field.setText("");
			String search = JOptionPane.showInputDialog("Name/PhoneNumber/Email that you would like to find");

			boolean found = false;

			try {
				for (int i = 0; i < contactList.size(); i++) {
					Contact temp = contactList.get(i);
					if (temp.getEmailAddress().equals(search) || temp.getFirstName().equals(search)
							|| temp.getLastName().equals(search) || temp.getPhoneNumber().equals(search)) {
						field.setText(contactList.get(i).toString());
						found = true;
					}
				}

				if (!found) {
					JOptionPane.showMessageDialog(null, "No Contact Found");
				}

			} catch (Exception ee) {
				JOptionPane.showMessageDialog(null, "No Contact Found");
			}
			
			
		//on exit, creates file and saves all contacts to file
		} else if (e.getActionCommand().equals("Exit")) {
			try {
				PrintWriter pw = new PrintWriter("contacts.txt");
				for (int i = 0; i < contactList.size(); i++) {
					pw.println(contactList.get(i).getFirstName());
					pw.println(contactList.get(i).getLastName());
					pw.println(contactList.get(i).getPhoneNumber());
					pw.println(contactList.get(i).getEmailAddress());

				}
				pw.close();
				field.setText("Contacts Saved!");
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Problem Saving");
			} finally {
				System.exit(0);
			}
		}
	}

}
