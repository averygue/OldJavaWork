package memGame;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class memGame extends JFrame {
	
	public static final int WIDTH = 700;
	public static final int LENGTH = 500;
	public static final int startX = 250;
	public static final int startY = 120;
	public static final int waitTime = 1000;
	
	public static final int numButtons = 16;

	public boolean isFirst = true;
	public myButton firstChoice = null;
	
	public memGame() {
		super("Memory Game");
		setSize(WIDTH, LENGTH);
		setLocation(startX, startY);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel l = new JLabel("Mem Game");
		
		int[] answers = new int[numButtons];
		for(int i = 0; i < answers.length; i++) {
			answers[i] = (i+1);
		}
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout((int)Math.sqrt(numButtons), 0));
		
		myButton[] b = new myButton[numButtons];
		for(int i = 0; i < b.length; i++) {
			b[i] = new myButton();
			b[i].setAns(answers[i]);
			b[i].addActionListener(new buttonClick());
			buttons.add(b[i]);
		}
		int answers2[] = new int[numButtons];
		for (int i = 0;i < answers.length; i++) {
			int x = 0;
			int p = 0;
		}
		
		for (int i = 0; i < b.length; i ++)
		
		add(l, BorderLayout.NORTH);
		add(buttons, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		memGame abc = new memGame();
		abc.setVisible(true);
    }
	
	private class myButton extends JButton {
		
		private int answer;
		
		public void setAns(int a) {
			answer = a;
		}
		
		public int getAns() {
			return answer;
		}
		
	}
	
	private class buttonClick implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {        
			Object source = e.getSource();
			//additional commands
			if (source instanceof myButton) {
				myButton b = (myButton)source;
				if(isFirst) {
					firstChoice = b;
					b.setText(""+b.getAns());
					b.setEnabled(false);
					isFirst = false;
				} else {
					b.setText("" + b.getAns());
					b.setEnabled(false);
					if (firstChoice.getAns() == b.getAns()){
						JOptionPane.showMessageDialog(null, "They Match!");
						isFirst = true;
					} else {
						JOptionPane.showMessageDialog(null, "They Don't Match!");
						
					}
				}
			} else {
				System.out.println("Not a Button.");
			}
	    }
	}
	
}
