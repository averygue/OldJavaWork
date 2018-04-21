/*
 * Avery Guething
 * COSC 1020 w/ Professor Gillen
 * Homework2: Tic-Tac-Toe
 * Feb. 2017
 */
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class TicTacToe extends JFrame implements ActionListener {
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9; //creates buttons, turn variable, and other important variables
	boolean gameStatus = false;
	public int turn = 1;
	public String letterOption = "X";
	myButton[] b = new myButton[9];
	public JLabel l = new JLabel();

	public TicTacToe() {
		super("Tic Tac Toe");
		setSize(500, 500); //sets window size, location, close operation
		setLocation(450, 150);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		l.setText("Player X's turn");

		JPanel buttonSetup = new JPanel();
		buttonSetup.setLayout(new GridLayout(3, 3)); //creates layout for buttons and label

		myButton[] bArray= new myButton[9];

		for (int i = 0; i < bArray.length; i++) { //creates buttons
			bArray[i] = new myButton(); 
			bArray[i].addActionListener(this);
			buttonSetup.add(bArray[i]);
		}

		b = bArray; //bArray into myButtons

		add(l, BorderLayout.NORTH);
		add(buttonSetup, BorderLayout.CENTER);

	}

	public static void main(String[] args) {

		TicTacToe board = new TicTacToe(); // creates window
		board.setVisible(true);
	}

	private class myButton extends JButton { //myButton class, sets and gets letter for each button

		private String letter = " ";

		public void setLetter(String a) {
			letter = a;
		}

		public String getLetter() {
			return letter;
		}

	}

	public void actionPerformed(ActionEvent e) { //actionPerformer method

		Object source = e.getSource();
		if (source instanceof JButton) { //if button clicked, disable and set the letter for whose turn it is
			myButton c = (myButton) source;

			c.setLetter(letterOption);
			c.setText(c.getLetter());
			c.setEnabled(false);

			
			// the following checks to see if someone has won
			if (b[0].getLetter().equals(letterOption) && b[1].getLetter().equals(letterOption)
					&& b[2].getLetter().equals(letterOption)) { // horizontal -- 3 situations
				
				gameStatus = true;
				
			} else if (b[3].getLetter().equals(letterOption) && b[4].getLetter().equals(letterOption)
					&& b[5].getLetter().equals(letterOption)) {
				
				gameStatus = true;
				
			} else if (b[6].getLetter().equals(letterOption) && b[7].getLetter().equals(letterOption)
					&& b[8].getLetter().equals(letterOption)) {
				
				gameStatus = true;
				
			} else if (b[0].getLetter().equals(letterOption) && b[3].getLetter().equals(letterOption)
					&& b[6].getLetter().equals(letterOption)) { // vertical wins
				
				gameStatus = true;
				
			} else if (b[1].getLetter().equals(letterOption) && b[4].getLetter().equals(letterOption)
					&& b[7].getLetter().equals(letterOption)) {
				
				gameStatus = true;
				
			} else if (b[2].getLetter().equals(letterOption) && b[5].getLetter().equals(letterOption)
					&& b[8].getLetter().equals(letterOption)) {
				
				gameStatus = true;
				
			} else if (b[0].getLetter().equals(letterOption) && b[4].getLetter().equals(letterOption)
					&& b[8].getLetter().equals(letterOption)) { // diagonal win
	
				gameStatus = true;
						
			} else if (b[2].getLetter().equals(letterOption) && b[4].getLetter().equals(letterOption)
					&& b[6].getLetter().equals(letterOption)) {
				
				gameStatus = true;
				
			} else { //no one wins situation
				l.setText("All buttons used & no one wins.");
				JOptionPane.showMessageDialog(null, "Game won!");
			}

			if (gameStatus == true) { //if someone has won, disable all buttons and change label
				for (int z = 0; z < b.length; z++) {
					b[z].setEnabled(false);
				}
				l.setText("Player " + letterOption + " wins!");
				JOptionPane.showMessageDialog(null, "Game won!");
				
				
			} else { //otherwise another turn occurs...
				turn++;
				if (turn == 3 || turn == 5 || turn == 7 || turn == 9) {
					l.setText("Player X's turn");
					letterOption = "X";
				} else if (turn == 2 || turn == 4 || turn == 6 || turn == 8) {
					l.setText("Player O's turn");
					letterOption = "O";
				}
			}
		}

	}

}
