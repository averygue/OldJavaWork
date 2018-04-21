/*
 * Avery Guething
 * Lab 3: Problem 1
 * 1/31/2017
 * avery.guething@marquette.edu
 */
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Problem1 extends JFrame {

	private final int WIDTH = 300; //creates initial values so one can change bulleyes to own desired values
	private final int HEIGHT = 300;
	
	private final int INTERVAL = 40;
	
	private int x = 50;
	private int y = 50;
	
	public static void main(String[] args) {
		Problem1 p1 = new Problem1(); //creates window and sets size
		p1.setSize(400,400);
		p1.setVisible(true);
		p1.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	
	public void paint(Graphics g) {
		g.setColor(Color.BLACK); //creates each circle on top of each other
		g.fillOval(x, y, WIDTH, HEIGHT);
		g.setColor(Color.WHITE);
		g.fillOval(x + INTERVAL, y + INTERVAL, WIDTH - 2*INTERVAL, HEIGHT - 2*INTERVAL);
		g.setColor(Color.BLACK);
		g.fillOval(x + 2* INTERVAL, y + 2* INTERVAL, WIDTH - 4*INTERVAL, HEIGHT - 4*INTERVAL);
		g.setColor(Color.WHITE);
		g.fillOval(x + 3*INTERVAL, y + 3* INTERVAL, WIDTH - 6*INTERVAL, HEIGHT - 6*INTERVAL);
		g.setColor(Color.BLACK);
		g.fillOval(x + 4*INTERVAL, y + 4* INTERVAL, WIDTH - 8*INTERVAL, HEIGHT - 8*INTERVAL);
		g.setColor(Color.WHITE);
		g.fillOval(x + 5* INTERVAL, y + 5*INTERVAL, WIDTH - 10*INTERVAL, HEIGHT - 10*INTERVAL);
		g.setColor(Color.BLACK);
		g.fillOval(x + 6*INTERVAL, y + 6*INTERVAL, WIDTH - 12*INTERVAL, HEIGHT - 12*INTERVAL);
	}

}
