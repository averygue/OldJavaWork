
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class PianoMan extends JFrame implements KeyListener, ActionListener {
	private static final int WIDTH = 800;
	private static final int HEIGHT = 400;
	private static final int NUMBER_OF_LINES = 10;
	private static final int NUMBER_OF_NOTES = 10;
	private static final int NOTE_TIME = 500;

	private Sequencer sequencer = null;

	private int octave = 5;

	// private variables
	private boolean keyPressed = false;
	private boolean writing = true;
	private int currentLength = 0;
	private int currentLines = 0;
	private boolean recording = false;
	private boolean incorrectKey = false;
	private String recordingStr = "";
	private File file;
	private Scanner scn;
	private PrintWriter pw;
	private String name = "";

	// creates buttons, octave label and input, textArea, etc
	JButton reset = new JButton("Reset");
	JButton play = new JButton("Play");
	JButton record = new JButton("Record");
	JButton set = new JButton("Set");
	JLabel result = new JLabel("Welcome to the Piano! Set Octave?");
	JTextArea sheetMusic = new JTextArea();
	JLabel octaveLabel = new JLabel("Octave: ");
	JTextField octaveInput = new JTextField("5", 2);
	public int noteRef = 0;

	public static void main(String[] args) { // main window
		PianoMan gui = new PianoMan();
		gui.setVisible(true);

	}

	public PianoMan() {
		setTitle("Piano Man");
		setBounds(300, 200, WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		JPanel buttonSetup = new JPanel(); // two panels for buttons and octave
											// input
		JPanel octaveLayout2 = new JPanel();
		buttonSetup.setLayout(new GridLayout(1, 3));
		octaveLayout2.setLayout(new FlowLayout());

		JMenuBar bar = new JMenuBar();
		JMenu menu = new JMenu("File");
		JMenuItem load = new JMenuItem("Load");
		JMenuItem save = new JMenuItem("Save");
		menu.add(load);
		menu.add(save);
		load.addActionListener(this);
		save.addActionListener(this);
		bar.add(menu);

		this.setJMenuBar(bar);

		// adds elements to panel
		buttonSetup.add(play);
		buttonSetup.add(record);
		buttonSetup.add(reset);

		octaveLayout2.add(octaveLabel);
		octaveLayout2.add(octaveInput);
		octaveLayout2.add(set);
		octaveLayout2.add(result);
		set.addActionListener(this);
		play.addActionListener(this);
		record.addActionListener(this);
		reset.addActionListener(this);

		// sets layout with BorderLayout
		add(octaveLayout2, BorderLayout.NORTH);
		add(buttonSetup, BorderLayout.SOUTH);
		add(sheetMusic, BorderLayout.CENTER);
		sheetMusic.setEditable(false);
		sheetMusic.addKeyListener(this);

		try {
			sequencer = MidiSystem.getSequencer();
			sequencer.open();
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error creating sequencer.");
			System.out.println("Error creating sequencer.");
			System.exit(0);
		}
		sheetMusic.requestFocus();

	}

	public String codeToNote(int code) {
		String x = "";
		// each detects home key and sets X to be the note, changes label to note name
		// noteRef is integer value associated with octave
		try {
			if (code == 65) {
				x = "C";
				noteRef = (0 + 12 * octave);
				result.setText("Key A pressed = Note C, " + noteRef);
			} else if (code == 83) {
				x = "C#";
				noteRef = (1 + 12 * octave);
				result.setText("Key S pressed = Note C#, " + noteRef);
			} else if (code == 68) {
				noteRef = (2 + 12 * octave);
				x = "D";
				result.setText("Key D pressed = Note D, " + noteRef);
			} else if (code == 70) {
				noteRef = (3 + 12 * octave);
				x = "D#";
				result.setText("Key F pressed = Note D#, " + noteRef);
			} else if (code == 71) {
				noteRef = (4 + 12 * octave);
				x = "E";
				result.setText("Key G pressed = Note E, " + noteRef);
			} else if (code == 72) {
				noteRef = (5 + 12 * octave);
				x = "F";
				result.setText("Key H pressed = Note F, " + noteRef);
			} else if (code == 74) {
				noteRef = (6 + 12 * octave);
				x = "F#";
				result.setText("Key J pressed = Note F#, " + noteRef);
			} else if (code == 75) {
				noteRef = (7 + 12 * octave);
				x = "G";
				result.setText("Key K pressed = Note G, " + noteRef);
			} else if (code == 76) {
				noteRef = (8 + 12 * octave);
				x = "G#";
				result.setText("Key L pressed = Note G#, " + noteRef);
			} else if (code == 59) {
				noteRef = (9 + 12 * octave);
				x = "A";
				result.setText("Key (SemiColon) pressed = Note A, " + noteRef);
			} else if (code == 222) {
				noteRef = (10 + 12 * octave);
				x = "A#";
				result.setText("Key (Quote) pressed = Note A#, " + noteRef);
			} else if (code == 10) {
				noteRef = (11 + 12 * octave);
				x = "B";
				result.setText("Key (Enter) pressed = Note B, " + noteRef);
			} else { // if not one of the home key, throw exception with value
				throw new BoundException(code);
			}
			incorrectKey = false;
		} catch (BoundException exe) {
			result.setText(exe.getMessage());
			incorrectKey = true; // see keyPressed for action
		}
		return x;

	}

	private void playNote(int note) throws Exception {
		Sequence sequence = new Sequence(Sequence.PPQ, 4);
		Track track = sequence.createTrack();

		ShortMessage sm1 = new ShortMessage(144, 1, note, 100);
		MidiEvent noteOn = new MidiEvent(sm1, 1);
		track.add(noteOn);

		ShortMessage sm2 = new ShortMessage(128, 1, note, 100);
		MidiEvent noteOff = new MidiEvent(sm2, 16);
		track.add(noteOff);

		sequencer.setSequence(sequence);
		sequencer.start();
		waitForNote();
	}

	private void waitForNote() {
		long start = System.currentTimeMillis();
		while ((System.currentTimeMillis() - start) < NOTE_TIME) {
		}
		return;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// main code
		try {
			String key;
			int keyCode = e.getKeyCode();
			String temp = codeToNote(keyCode);
			// if incorrect key is pressed, don't play sound
			if (incorrectKey == true) {
				throw new Exception();
			}
			if (currentLength >= NUMBER_OF_NOTES) {
				sheetMusic.setText(sheetMusic.getText() + "\n");
				currentLength = 0;
				currentLines++;
			}
			currentLength++; // increase for note length ref
			if (currentLines >= NUMBER_OF_LINES) {
				throw new capacityException(11);
			}
			sheetMusic.setText(sheetMusic.getText() + temp);
			try {
				playNote(noteRef); // play sound for Note
			} catch (Exception ex) {
				result.setText(ex.getMessage());
			}
			// if recording, create a string with values
			if (recording) {
				recordingStr += temp;
			}

		} catch (capacityException exe) { // if cap reached, throw CapException
			result.setText(exe.getMessage());
		} catch (Exception ee) {

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keyPressed = false;
	}

	public void setFileName() {
		name = JOptionPane.showInputDialog(null, "Insert Name for Save File: ", "Save?", JOptionPane.QUESTION_MESSAGE);
	}

	public String getFileName() {
		return name;
	}

	public void saveMethod() {
		// asks for file name, sends file name to printwriter
		setFileName();
		String fileName = getFileName();
		try {
			// creats file from sheetMusic text
			pw = new PrintWriter("/Users/AveryGueth/Desktop/Workspace/HW3_Guething/src/" + fileName + ".txt");
			pw.write(sheetMusic.getText());
			pw.flush();
			pw.close();
			result.setText("Successful Save!");
		} catch (Exception ee) {
			JOptionPane.showMessageDialog(null, "Unable to Write File to Disk.");
		}
	}

	public void loadMethod() {
		try {
			// asks user for file name, loads file from src foloder
			String loadName = JOptionPane.showInputDialog(null, "What file would you like to load? ", "Load?",
					JOptionPane.QUESTION_MESSAGE);
			file = new File("/Users/AveryGueth/Desktop/Workspace/HW3_Guething/src/" + loadName + ".txt");
			recordingStr = "";
			Scanner scn = new Scanner(file);
			sheetMusic.setText("");
			// inserts music to sheetMusic field
			while (scn.hasNextLine()) {
				String noteRef2 = scn.nextLine();
				sheetMusic.setText(sheetMusic.getText() + noteRef2 + "\n");
				recordingStr += noteRef2;
			}
			result.setText("Successful Load!");
			scn.close();
		} catch (Exception ee) {
			JOptionPane.showMessageDialog(null, "Unable to Locate File.");
		}
	}

	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		// if set is pressed, do followiing
		if (e.getSource() == set) {
			try {
				// changes to int value and sees if it's between 1 and 9
				int octaveSet = Integer.parseInt(octaveInput.getText());
				if (octaveSet < 1 || octaveSet > 9) {
					throw new BoundException(1, 9);
				}
				octave = octaveSet;
				result.setText("Octave Set!");
			} catch (BoundException ex) {
				result.setText(ex.getMessage());
			} catch (Exception ee) {
				result.setText("Octave must be integer");
			}
			// if record is pressed
		} else if (e.getSource() == record) {
			result.setText("Recording Mode Entered");
			recording = true;

			// if play is pressed
		} else if (e.getSource() == play) {
			recording = false;
			String input = recordingStr;

			// following reads first letter and then cuts substring, starts again
			// until there is nothing left in 'input'
			while (input.length() > 0) {
				if (input.startsWith("C#")) {
					codeToNote(83); // code for S
					input = input.substring(2);
				} else if (input.startsWith("D#")) {
					codeToNote(70);
					input = input.substring(2);
				} else if (input.startsWith("F#")) {
					codeToNote(74);
					input = input.substring(2);
				} else if (input.startsWith("G#")) {
					codeToNote(76);
					input = input.substring(2);
				} else if (input.startsWith("A#")) {
					codeToNote(222);
					input = input.substring(2);
				} else if (input.startsWith("A")) {
					codeToNote(59);
					input = input.substring(1);
				} else if (input.startsWith("B")) {
					codeToNote(10);
					input = input.substring(1);
				} else if (input.startsWith("C")) {
					codeToNote(65);
					input = input.substring(1);
				} else if (input.startsWith("D")) {
					codeToNote(68);
					input = input.substring(1);
				} else if (input.startsWith("E")) {
					codeToNote(71);
					input = input.substring(1);
				} else if (input.startsWith("F")) {
					codeToNote(72);
					input = input.substring(1);
				} else if (input.startsWith("G")) {
					codeToNote(75);
					input = input.substring(1);
				}
				try {
					playNote(noteRef);
				} catch (Exception ex) {
					result.setText(ex.getMessage());
				}
			}

			// if reset is pressed, clear textArea and stop Recording
		} else if (e.getSource() == reset) {
			sheetMusic.setText("");
			currentLength = 0;
			currentLines = 0;
			recordingStr = "";

		} else if ("Save".equals(e.getActionCommand())) {
			saveMethod();
		} else if (e.getActionCommand().equals("Load")) {
			loadMethod();
		}
	}

}