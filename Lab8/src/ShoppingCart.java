
/*
 * Avery Guething
 * Lab 8: Review
 * Tyler Gillen 1020
 */
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Scanner;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

public class ShoppingCart extends JFrame implements ActionListener {

	// the following creates buttons, labels, listModels, file, and scanner
	private File file;
	private Scanner scn;
	private JList<String> list, shoppingCart;
	private static int BookTotal = 0;
	private double TotalCost = 0.0;

	private JButton remove = new JButton("Remove From Cart");
	private JButton add = new JButton("Add To Cart");
	private JButton clear = new JButton("Clear Cart");
	private JButton checkout = new JButton("Checkout");
	private JLabel Cost = new JLabel("Cost For Books without Tax: " + TotalCost);
	private JLabel BookNumber = new JLabel("Number of Books In Cart: " + BookTotal);
	private JLabel bookNames = new JLabel("Books For Sale: ");
	private JLabel shoppingCartName = new JLabel("Shopping Cart: ");
	DefaultListModel<String> listModel = new DefaultListModel<String>();
	DefaultListModel<String> bookModel = new DefaultListModel<String>();

	public ShoppingCart() {
		// sets up GUI
		setTitle("Welcome to The Book Store!");
		setBounds(300, 200, 650, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		JPanel buttonSetup = new JPanel();
		JPanel middle = new JPanel();
		JPanel left = new JPanel();
		JPanel right = new JPanel();

		// following looks for file and adds them to store list
		try {
			file = new File("book-prices.txt");
			scn = new Scanner(file);

			int i = 0;
			while (scn.hasNextLine()) {
				bookModel.addElement(scn.nextLine());
				i++;
			}
		} catch (Exception ex) {
			System.out.println("File Not Found.");

		}
		// JList setup and options
		list = new JList<String>(bookModel);
		shoppingCart = new JList<String>(listModel);
		DefaultListSelectionModel m = new DefaultListSelectionModel();
		m.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		m.setLeadAnchorNotificationEnabled(false);
		list.setSelectionModel(m);

		// following adds to GUI, layout, and actionlisteners
		buttonSetup.add(add);
		buttonSetup.add(remove);
		buttonSetup.add(clear);
		buttonSetup.add(checkout);
		middle.add(BookNumber);
		middle.add(Cost);

		add(buttonSetup, BorderLayout.NORTH);
		add(left, BorderLayout.WEST);
		add(right, BorderLayout.EAST);
		add(middle, BorderLayout.CENTER);

		left.setLayout(new BorderLayout());
		left.add(list, BorderLayout.CENTER);
		left.add(bookNames, BorderLayout.NORTH);
		right.setLayout(new BorderLayout());
		right.add(shoppingCart, BorderLayout.CENTER);
		right.add(shoppingCartName, BorderLayout.NORTH);
		add.addActionListener(this);
		remove.addActionListener(this);
		clear.addActionListener(this);
		checkout.addActionListener(this);

	}

	public static void main(String[] args) {
		ShoppingCart gui = new ShoppingCart();
		gui.setVisible(true);
	}

	// method for adding an element to the shopping cart
	public void addButton() {
		try {
			listModel.addElement(list.getSelectedValue().toString());
			String x = list.getSelectedValue().toString();
			String b = x.substring(x.indexOf(";") + 1);
			double a = Double.parseDouble(b);
			TotalCost += a;
			BookTotal++;
			Cost.setText("Cost for Books without Tax: " + new DecimalFormat("##.##").format(TotalCost));
			BookNumber.setText("Number of Books In Cart: " + BookTotal);

			list.clearSelection();
		} catch (Exception Ex) {
			JOptionPane.showMessageDialog(null, "No Item Selected");
		}

	}

	// method for removing an element to the shopping cart
	public void removeButton() {
		try {
			String x = shoppingCart.getSelectedValue().toString();
			String b = x.substring(x.indexOf(";") + 1);
			double a = Double.parseDouble(b);
			TotalCost -= a;
			BookTotal = BookTotal - 1;
			Cost.setText("Cost for Books without Tax: " + new DecimalFormat("##.##").format(TotalCost));
			BookNumber.setText("Number of Books In Cart: " + BookTotal);
			listModel.removeElement(shoppingCart.getSelectedValue().toString());

		} catch (Exception Ex) {
			JOptionPane.showMessageDialog(null, "No Item Selected");
		}
	}

	// ActionListener Below
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Add To Cart")) {
			addButton();
		} else if (e.getActionCommand().equals("Remove From Cart")) {
			removeButton();

			// Clear cart, TotalBook cost, and Book Total
		} else if (e.getActionCommand().equals("Clear Cart")) {
			try {
				TotalCost = 0;
				BookTotal = 0;
				Cost.setText("Cost for Books without Tax: " + TotalCost);
				BookNumber.setText("Number of Books In Cart: " + BookTotal);
				listModel.clear();
			} catch (Exception Ex) {
				JOptionPane.showMessageDialog(null, "Cart is Empty");
			}

			// pop up message with final costs with DecimalFormat only allowing
			// two decimal points
		} else if (e.getActionCommand().equals("Checkout")) {
			Double taxCost = (TotalCost * 0.06);
			Double finalCost = taxCost + TotalCost;
			JOptionPane.showMessageDialog(null,
					"SubTotal of Books: " + new DecimalFormat("##.##").format(TotalCost) + "\nSales Tax: "
							+ new DecimalFormat("##.##").format(taxCost) + "\n Total Cost:"
							+ new DecimalFormat("##.##").format(finalCost));
		}
	}

}
