/*
 * Avery Guething 
 * Lab 2: GUI
 * avery.guething@marquette.edu
 * COSC1020: Gillen
 */
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Problem1 extends JFrame implements ActionListener {

	Label propertyLabel, assessmentLabel, taxLabel;
	TextField propertyValueTF;
	Button calculate;

	public Problem1() {
		// call constructor of base class
		super("Problem 1 Window");
		setSize(300, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new FlowLayout());

		propertyLabel = new Label("Property Value");
		add(propertyLabel);

		propertyValueTF = new TextField(20); // length of text field in parameters
												
		add(propertyValueTF);

		calculate = new Button("Calculate Ass. Value and Tax");
		add(calculate);

		calculate.addActionListener(this);

		assessmentLabel = new Label("Asessment Value");
		add(assessmentLabel);

		taxLabel = new Label("Tax");
		add(taxLabel);

	}

	public static void main(String[] args) {

		Problem1 problem1 = new Problem1(); //create window
		problem1.setVisible(true);

	}

	//actionListener for the button that calculates cost
	public void actionPerformed(ActionEvent e) { 
		
		String text = propertyValueTF.getText(); //sets text to double
		double propertyValue = Double.parseDouble(text);
		
		double assessmentValue = propertyValue * 0.6;
		double tax = assessmentValue * 0.64 /100;
		
		assessmentLabel.setText("Assessment Value is " + assessmentValue); //sets Text as calculations
		taxLabel.setText("Tax is " + tax);
	}

}
