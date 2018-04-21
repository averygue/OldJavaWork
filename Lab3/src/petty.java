
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

public class petty extends JFrame {
	public JLabel m; 
	public petty() {
	super("Petty");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JOptionPane.showConfirmDialog(null, "Did they add me back on snapchat");
	JOptionPane.showMessageDialog(null, "They Petty as Hell");
	JOptionPane.showMessageDialog(null, "Lowkey pissed");
	JOptionPane.showMessageDialog(null, "R.I.P");
	}
	
	public static void main(String[] args) {
		petty abc = new petty();
		abc.setVisible(true);
    }
}
