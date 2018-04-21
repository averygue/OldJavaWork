/*
 * Avery Guething
 * Homework 5: WayPoint
 * Tyler Gillen 1020
 * March 28, 2017
 */
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GUI extends JFrame implements ActionListener {

	// creates buttons and arraylist
	private JButton addWayPoint = new JButton("Add Way Point");
	private JButton reset = new JButton("Reset");
	private JButton totals = new JButton("Totals");
	//private JTextArea listBox = new JTextArea();
	List<wayPT> wayPointList = new ArrayList<wayPT>();
	JList list;
	DefaultListModel listModel;
	Container contentpane;

	public GUI() {
		// creates GUI window
		setTitle("Tracking System Version 1.0");
		setBounds(300, 200, 500, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		JPanel buttonSetup = new JPanel();
		//istBox.setEditable(false);
	

		// adds to GUI window
		buttonSetup.setLayout(new FlowLayout());
		buttonSetup.add(addWayPoint);
		buttonSetup.add(reset);
		buttonSetup.add(totals);
		add(buttonSetup,BorderLayout.NORTH);	
		
		//add(listBox, BorderLayout.CENTER);
		contentpane = getContentPane();
		contentpane.setLayout(new FlowLayout());
		listModel = new DefaultListModel();
		list = new JList(listModel);
		contentpane.add(new JScrollPane(list));

		// adds actionListener
		addWayPoint.addActionListener(this);
		reset.addActionListener(this);
		totals.addActionListener(this);

	}

	public static void main(String[] args) {
		GUI screen = new GUI();
		screen.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Add Way Point")) {

			try {
				// asks for indidivual waypoint values through prompts and
				// parses to int or double
				String xPositionString = JOptionPane.showInputDialog(null,
						"For your waypoint, what is your x-position?", "X Position",
						JOptionPane.PLAIN_MESSAGE);
				Double xPosition = Double.parseDouble(xPositionString);
				String yPositionString = JOptionPane.showInputDialog(null,
						"For your waypoint, what is your y-position?", "Y Position",
						JOptionPane.PLAIN_MESSAGE);
				Double yPosition = Double.parseDouble(yPositionString);
				
				Integer timeValueInt = -2;
				boolean test = true;
				
				while (test == true) {
					String timeValue = JOptionPane.showInputDialog(null, "Time Value? (Positive Number & Greater than previous)", "Time Value", JOptionPane.PLAIN_MESSAGE);
					 timeValueInt = Integer.parseInt(timeValue);
					 if (timeValueInt < 0) {
						 test = true;
					 }
					 else if(wayPointList.isEmpty()) {
						 test = false;
					 }
					 else if(timeValueInt < wayPointList.get(wayPointList.size()-1).getTime()) {
						 test = true;
					 }
					 else {
						 test = false;
					 }
				}
					

				
				//if user does not cancel out, create object, confirm waypoint, and add to box
				if (xPosition != null && yPosition != null && timeValueInt != null) {
					wayPT object1 = new wayPT(xPosition, yPosition, timeValueInt);
					if (JOptionPane.showConfirmDialog(null, "Your waypoint is: " + object1.toString() + " ?",
							"Confirmation", JOptionPane.WARNING_MESSAGE) != 2) {
						wayPointList.add(object1);
						listModel.addElement(object1.toString());
					} else
						throw new Exception();
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "WayPoint Not Created");
			}
			
		//resets all information
		} else if (e.getActionCommand().equals("Reset")) {
			listModel.removeAllElements();
			wayPointList.clear();

		//following creates prompt for total time, distance traveled, average speed
		} else if (e.getActionCommand().equals("Totals")) {
			try {
				
				//totalDistance
				double totalDistance = 0;
				
				for (int i = 0; i < wayPointList.size()-1; i++) {
					totalDistance += wayPointList.get(i).findDist(wayPointList.get(i+1));
				}
				totalDistance = Math.round(totalDistance * 100.0) / 100.0;
				
				//total time by last time - first time
				int totalTime = wayPointList.get(wayPointList.size() - 1).getTime() - wayPointList.get(0).getTime();
				
				//average speed
				double averageSpeed = totalDistance / totalTime;
				averageSpeed = Math.round(averageSpeed * 100.0) / 100.0;
				
				if (totalTime == 0) {
					averageSpeed = 0;
				}

				
				JOptionPane.showMessageDialog(null,
						("Total Distance Traveled: " + totalDistance + " miles" + "\nTotal Time Taken: " + totalTime
								+ " seconds" + "\nAverage Speed: " + averageSpeed + " miles/sec"),
						"Total Values", JOptionPane.PLAIN_MESSAGE);
			} catch (Exception ee) {
				JOptionPane.showMessageDialog(null, "No Data Found", "Errror", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
