import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Problem2 extends JFrame implements ActionListener {
	// adds 8 buttons for each option
	Button minuteOption1, minuteOption2, minuteOption3, model100, model110, model200, option1, option2;
	// adds labels
	Label priceListed1, priceListed2, priceListed3;

	public Problem2() {
		// call constructor of base class
		super("Problem 2 Window");
		//sets size and layout below
		setSize(500, 400); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		minuteOption1 = new Button("300 Minutes Per Month"); // creates and adds each button 
		add(minuteOption1);
		minuteOption1.addActionListener(this);

		minuteOption2 = new Button("800 Minutes Per Month");
		add(minuteOption2);
		minuteOption2.addActionListener(this);

		minuteOption3 = new Button("1500 Minutes Per Month");
		add(minuteOption3);
		minuteOption3.addActionListener(this);

		model100 = new Button("Model 100");
		add(model100);
		model100.addActionListener(this);

		model110 = new Button("Model 110");
		add(model110);
		model110.addActionListener(this);

		model200 = new Button("Model 200");
		add(model200);
		model200.addActionListener(this);

		option1 = new Button("Voice mail");
		add(option1);
		option1.addActionListener(this);

		option2 = new Button("Text messaging");
		add(option2);
		option2.addActionListener(this);

		priceListed1 = new Label("Price for Minute Package is: "); //creates 3 labels
		add(priceListed1);
		
		priceListed2 = new Label("Price for Model is: ");
		add(priceListed2);
		
		priceListed3 = new Label("Price for services is: ");
		add(priceListed3);

	}

	public static void main(String[] args) {
		Problem2 problem2 = new Problem2(); // create window
		problem2.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("300 Minutes Per Month")) { //if minute option selected, change price label
			priceListed1.setText("Price for Minute Package is $45.00 per month"); }
		if(e.getActionCommand().equals("800 Minutes Per Month")) {
			priceListed1.setText("Price for Minute Package $65.00 per month"); }
		if(e.getActionCommand().equals("1500 Minutes Per Month")) {
			priceListed1.setText("Price for Minute Package $99.00 per month"); }
		
		if(e.getActionCommand().equals("Model 100")) { //if model option is selected, change priceListed2 label to new price
			priceListed2.setText("Price for Model is $29.95"); }
		if(e.getActionCommand().equals("Model 110")) {
			priceListed2.setText("Price for Model is $49.95"); }
		if(e.getActionCommand().equals("Model 200")) {
			priceListed2.setText("Price for Model is $99.95"); }
		 
		
		if(e.getActionCommand().equals("Voice mail")) { // if services is selected, changes pricelisted 3 label to price
			priceListed3.setText("Price is Services is $5.00 per month"); }
		if(e.getActionCommand().equals("Text messaging")) {
			priceListed3.setText("Price is Services is $10.00 per month"); }
		}
	}

