import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTable;

import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/* Zaynab Hassan, Nathan Ireland
 * GUI team
 */

public class battleShip200 extends JFrame implements ActionListener
{
	public static final int WIDTH = 600;
    public static final int HEIGHT = 450;
    public static int hitCount = 22;

    JTextField text =null;
    JTable board = null;
    JButton fire = null;

    JLabel numMisses = null;
    JLabel numHits = null;
    JLabel shipsSunk = null;
    
    PrintWriter outPutStream = null;

    public static String[][] boardWithShips = new String[11][11];


    //Nathan Ireland, et al.
    //Gui Team

    public battleShip200( )
    {
       	setTitle("Battle Ship");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);

        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(0,1));

        JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		JMenuItem restart = new JMenuItem("restart");
		restart.addActionListener(this);
		JMenuItem Load = new JMenuItem("Load");
		Load.addActionListener(this);
		JMenuItem save = new JMenuItem("Save");
		save.addActionListener(this);
		menu.add(restart);
		menu.add(Load);
		menuBar.add(menu);
		menu.add(save);
        JMenuItem menuItem = new JMenuItem();

        this.setJMenuBar(menuBar);

        board = new JTable(11, 11);
        board.setGridColor(Color.CYAN);

         for(int i = 0; i < board.getColumnCount() - 1; i++){
          	board.setValueAt((char)((int)('A') + i), 0, i + 1);
         }
         for(int i = 1; i < board.getRowCount(); i++){
           	board.setValueAt(i, i, 0);
         }

         panel.add(board);

         JPanel panel1 = new JPanel();
         panel1.setLayout(new FlowLayout());

         JLabel numMisses = new JLabel("Number of Misses: 0");
         JLabel numHits = new JLabel("Number of Hits: 0");
         JLabel shipsSunk = new JLabel("Number of Ships Sunk: 0");
         panel1.add(numMisses);
         panel1.add(numHits);
         panel1.add(shipsSunk);

         JLabel instructions = new JLabel("To hit a point on the grid, input column, then row. Ex: B4");
         instructions.setPreferredSize(new Dimension(400, 100));
         panel1.add(instructions);

         JPanel panel2 = new JPanel();
         panel2.setLayout(new GridLayout(0,1));

         text = new JTextField();
         text.setPreferredSize(new Dimension(100, 20));
         panel2.add(text);

         fire = new JButton("Fire!");
         fire.addActionListener(this);
         panel2.add(fire);

         panel1.add(panel2);

         JLabel numMoves = new JLabel("Number of Moves: 0");
         panel1.add(numMoves);

         panel.add(panel1);

         add(panel, BorderLayout.CENTER);

         setUpBoard();
    }


    /*
     * Avery Guething, Amy Harrigan, Hannah Kari, Ashvini Patel, Andy Strungs, Jennifer Walter, Caroline Waltmin
     * Group 4: Handle input
     * changes the user input into two integer variables: row and column
     */

    public void actionPerformed(ActionEvent e) {
    	if(e.getActionCommand() == "Load"){
    		Load();
    	}
    	String str = text.getText(); //puts user input into String
    	String inputStr = str.toUpperCase();
    	int row = 0, column = 0;
    	try {
	    	if (inputStr.length() == 3) {
	    		if (inputStr.substring(1, 3).equals("10") && Character.isLetter(inputStr.charAt(0))) {
	    			row = 10;
	    			column = (int)inputStr.charAt(0) - (int)'A' + 1;
	    		} else {
	    			throw new Exception();
	    		}
	    	} else if (inputStr.length() != 2) {
	    		throw new Exception();
	    	} else if (Character.isDigit(inputStr.charAt(1)) && Character.isLetter(inputStr.charAt(0))) { //if input is column then row
				row = Integer.parseInt(inputStr.substring(1, 2)); //turn digit character into integer with ParseInt
				column = (int)inputStr.charAt(0) - (int)'A' + 1; //turns character into digit with typecasting
			} else {
				throw new Exception();
			}
	    	if(row > 10 || column > 10) {
	    		throw new Exception();
	    	}
	    	HitOrMiss hom = new HitOrMiss();
	    	hom.Hit_Miss(row, column, boardWithShips);
    	} catch(Exception ee) {
    		JOptionPane.showMessageDialog(null, "Invalid Input. You entered \"" + str + ".\" Please enter the column, then row. (ex: B4)");
    	}
    }

	public static void main(String[] args)
    {
		battleShip200 gmWindow = new battleShip200( );
		gmWindow.setVisible(true);
    }

	public void setShips(int size, String name){
    	int randomRow;
        int randomCol;
        
        boolean vertical = getRandomBoolean(); // calls method to make vertical(orientation) true or false
        
        boolean occupied = false; // initialize occupied to false
       
        if(vertical){  // if the orientation is vertical
        	do{
        		occupied = false;
        		randomRow = ((int)Math.floor(Math.random()*10) + 1); // generate a random starting row
                randomCol = ((int)Math.floor(Math.random()*10) + 1); // generate a random starting column
        		
                // ensures that the ship won't run off the board
                while(randomRow + size > 10){
            		randomRow--; 
        		}
            	
                // checks to see if two ships will overlap
            	for(int i = 0; i < size; i++){
            		if(boardWithShips[randomRow][randomCol] != null) // if the next space for the ship is occupied
            			occupied = true; // change occupied to true
            		randomRow++; // increment the row value (because vertical)
            	}
            	randomRow -= size; // reset the row to the starting point
        	}while(occupied); // if one of the spots is occupied, restarts with new starting point

        	// sets the correct number of values in the array to the name of the ship
        	for(int i = 0; i < size; i++){
        		boardWithShips[randomRow][randomCol] = name; // adds to array
        		//COMMENT OUT THIS LINE TO HIDE VALUES
        		board.setValueAt(name, randomRow, randomCol); // prints to the table to check values
        		randomRow++; // increment the row
        	}
        }
        
        // exact same code for horizontal orientation; increment the columns instead of the rows
        else{
        	do{
        		occupied = false;
        		randomRow = ((int)Math.floor(Math.random()*10) + 1);
                randomCol = ((int)Math.floor(Math.random()*10) + 1);
                while(randomCol + size > 10){
            		randomCol--; 
        		}
            	for(int i = 0; i < size; i++){
            		if(boardWithShips[randomRow][randomCol] != null)
            			occupied = true;
            		randomCol++;
            	}
            	randomCol -= size;
        	}while(occupied);

        	for(int i = 0; i < size; i++){
        		boardWithShips[randomRow][randomCol] = name;
        		//COMMENT OUT THIS LINE TO HIDE VALUES
        		board.setValueAt(name, randomRow, randomCol);
        		randomCol++;
        	}
        }
	}
	
    public boolean getRandomBoolean(){
    	return Math.random() < .5; // random number between 0 and 1, returns true or false randomly
    }

    public void setUpBoard(){
    	for (int i =0; i < boardWithShips.length; i++){
    		for(int j = 0; j < boardWithShips[i].length; j++)
    			boardWithShips[i][j] = null;
    	}

    	setShips(3, "Cruiser");
        setShips(3, "Submarine");
        setShips(4, "Battleship");
        setShips(5, "Carrier");
        setShips(2, "Destroyer");

    }

	public static void isOver(){

		if (hitCount != 22){
			return;
		}

		else{
		JFrame victoryWindow = new JFrame();
		JButton vButton1 = new JButton("Yes.");
		vButton1.setSize(150,150);
		JButton vButton2 = new JButton("No.");
		vButton2.setSize(150,150);
		JPanel victoryPanel = new JPanel();
		JLabel victoryLabel = new JLabel("Want to play again?");


		victoryWindow.setSize(300,100);
		victoryWindow.setVisible(true);
		victoryWindow.setLocation(400, 400);
		victoryWindow.setLayout(new BorderLayout());

		victoryWindow.add(victoryLabel, BorderLayout.NORTH);

		victoryWindow.add(victoryPanel, BorderLayout.CENTER);

		victoryPanel.setLayout(new GridLayout());
		victoryPanel.add(vButton1);
		victoryPanel.add(vButton2);
		}

	}

	public void Load(){
		String fileName;
		boolean invalidInput = true;
		do{
			invalidInput = false;
			fileName = JOptionPane.showInputDialog("Please input the file you would like to load from(exclude '.txt'):");
			fileName = "src/" + fileName + ".txt";
			
			try{
				File file = new File(fileName);
				Scanner scn = new Scanner(file);
			}
			catch(Exception e){
				if(fileName.equals("src/null.txt")){}
				else{
					JOptionPane.showMessageDialog(null, "The file name " + fileName + " is invalid."); // additional pop up window with error message	
					invalidInput = true;
				}
			}
			
		}while(invalidInput);	
	}

	public void save(){	   

		  String x = JOptionPane.showInputDialog(null,"Enter the file name. Do not enter .bs");
		  x = "src/" + x + ".bs";

		  File savedGame = new File(x);
	   
		  try {

			 PrintWriter outPutStream = new PrintWriter(savedGame);
			
			
			 for (int i =0; i < boardWithShips.length; i++){
		    		for(int j = 0; j < boardWithShips[i].length; j++)
		    			if(boardWithShips[i][j] == null) {
		    				
		    			}
		    			else {
		    			}
		    	}
			 outPutStream.flush();
			 outPutStream.close();
			 

			  } catch (FileNotFoundException e) {

			  // TODO Auto-generated catch block

			  e.printStackTrace();

			  System.out.println(e.getMessage());

			  }
	}
}
