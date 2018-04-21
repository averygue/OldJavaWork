import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class Browser extends JFrame implements ActionListener, HyperlinkListener {

	// creates GUI interface components
	private JTextField URL = new JTextField(20);
	private JEditorPane jPane = new JEditorPane();
	private JButton browse = new JButton("Browse");
	private JPanel top = new JPanel();

	Browser() {
		setTitle("Web Browser");
		URL.setText("www.java.com/");
		top.add(URL);
		top.add(browse);

		// adds listeners to the button, URL, and a hyperLinkListener to
		// JEditorPane
		browse.addActionListener(this);
		jPane.addHyperlinkListener(this);
		URL.addActionListener(this);

		// jPane cannot be edited in run time
		jPane.setEditable(false);

		// layout and bounds
		add(top, BorderLayout.NORTH);
		add(new JScrollPane(jPane));
		setBounds(300, 200, 600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		Browser screen = new Browser();
		screen.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {

		try {
			// takes the URL adds http and sets the page to Jpane
			String fullURL = "http://" + URL.getText();
			jPane.setPage(fullURL);

			// following prints out code from the URL searched to console
			URL website = new URL(fullURL);
			InputStreamReader printWebsiteReader = new InputStreamReader(website.openStream());
			Scanner inputStream = new Scanner(printWebsiteReader);
			String x = "";

			while (inputStream.hasNextLine()) {
				String temp = inputStream.nextLine();
				x = x + temp;
			}
			System.out.println(x);
			inputStream.close();
			printWebsiteReader.close();
		} catch (IOException ee) {
			JOptionPane.showMessageDialog(null, "Invalid URL");
		}
	}

	public void hyperlinkUpdate(HyperlinkEvent exe) {
		// if hyperLink is pressed,set Page to URL and put url in webaddressbox
		if (exe.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
			if (exe instanceof HyperlinkEvent) {
				try {
					jPane.setPage(exe.getURL());
					String s = exe.getURL().toString();
					URL.setText(s);

					// prints out html code to console
					InputStreamReader printWebsiteReader = new InputStreamReader(exe.getURL().openStream());
					Scanner inputStream = new Scanner(printWebsiteReader);

					String x = "";
					while (inputStream.hasNextLine()) {
						String temp = inputStream.nextLine();
						x = x + temp;
					}
					System.out.println(x);
					inputStream.close();
					printWebsiteReader.close();
				} catch (IOException eee) {
					JOptionPane.showMessageDialog(null, "Error In HyperLink");
				}
			}

		}

	}
}
