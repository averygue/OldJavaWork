/*
 * Avery Guething
 * Lab 3: Problem 2: Creating a house
 * avery.guething@marquette.edu
 */

import java.awt.Graphics;
import javax.swing.JFrame;
public class Problem2 extends JFrame {

	public static void main(String[] args) {
		Problem2 p2 = new Problem2(); //creates window
		p2.setSize(400,400);
		p2.setVisible(true);
		p2.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	public void paint(Graphics g) {
		g.drawRect(125, 150, 150, 150); //creates rectangle for house
		g.drawRect(150, 240, 40, 60); //creates door
		g.drawRect(215, 240, 35, 25); //creates window
		
		//creates roof
		g.drawLine(125, 150, 200,50);
		g.drawLine(200, 50, 275,150);
		
	}
	
}
