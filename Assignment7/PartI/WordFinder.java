
import java.io.*;
import javax.swing.*;
import java.util.List;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;

public class WordFinder extends JFrame {

	private static final long serialVersionUID = 1773693320346723944L;
	JFileChooser jFileChooser;
	private JPanel topPanel; // the top line of objects is going to go here
	WordList wordList;
	private JTextField queryField;
	private JTextArea wordsBox = new JTextArea(16, 42); // results of the search go in heer.

	class ClearListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			queryField.setText("");
		}
	}

	public WordFinder() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// set the size correctly
		this.setSize(600, 400);
		jFileChooser = new JFileChooser(".");
		wordList = new WordList();

		JPanel panelForTextFields = new JPanel();
		panelForTextFields.setSize(300, 320);

		// Construct menu
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(createMenus());

		// panel at the top
		topPanel = new JPanel();

		// there should be objects in the top panel
		queryField = new JTextField(15);
		JButton clearButton = new JButton("Clear");

		topPanel.add(new JLabel("Find: ")); // input prompt text
		topPanel.add(queryField);
		topPanel.add(clearButton);

		// There should probably be something passed into the JScrollPane
		wordsBox.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(wordsBox);
		panelForTextFields.add(scrollPane);

		// and of course you will want them to be properly aligned in the frame
		add(topPanel, BorderLayout.NORTH);
		add(panelForTextFields);

		ActionListener clearListener = new ClearListener();
		clearButton.addActionListener(clearListener);

		class QueryListener implements DocumentListener {
			public void changedUpdate(DocumentEvent e) {
				queryAndUpdate(panelForTextFields);
			}

			public void removeUpdate(DocumentEvent e) {
				queryAndUpdate(panelForTextFields);
			}

			public void insertUpdate(DocumentEvent e) {
				queryAndUpdate(panelForTextFields);
			}
		}

		queryField.getDocument().addDocumentListener(new QueryListener());

	}

	private JMenu createMenus() {
		/*
		 * add a "File" menu with: "Open" item which allows you to choose a new file
		 * "Exit" item which ends the process with System.exit(0); Key shortcuts are
		 * optional
		 */

		/* OpenActionListener that will open the file chooser */
		class OpenActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				OpenFileListener myFileListener = new OpenFileListener();
				myFileListener.actionPerformed(e);
			}
		}

		class ExitActionListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		}

		JMenu menu = new JMenu("File");
		JMenuItem MenuItemExit = new JMenuItem("Exit");
		JMenuItem menuItemOpen = new JMenuItem("Open");

		MenuItemExit.addActionListener(new ExitActionListener());
		menuItemOpen.addActionListener(new OpenActionListener());

		menu.add(menuItemOpen);
		menu.add(MenuItemExit);
		return menu;
	}

	private void getQueryResult() {
		String query = queryField.getText();
		List<String> searchResult = wordList.find(query); // figure out from WordList how to get this
		// you're going to want to get the words in the
		// searchResult list and put them in the textbox.
		wordsBox.setText("");
		for (Object word : searchResult) {
			wordsBox.append(word + "\n");
		}
		wordsBox.setCaretPosition(0);
	}

	private void queryAndUpdate(JPanel panel2Repaint) {
		// same as getQueryResult with no argument, but also repaint the input JPanel
		// after result queried.
		getQueryResult();
		panel2Repaint.repaint();
	}

	class OpenFileListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int returnVal = jFileChooser.showOpenDialog(getParent());
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				try {
					System.out.println(
							"You chose to open this file: " + jFileChooser.getSelectedFile().getAbsolutePath());

					InputStream in = new FileInputStream(jFileChooser.getSelectedFile().getAbsolutePath());
					wordList.load(in);

					// invode find method to get query result
					getQueryResult();

				} catch (IOException error) {
					error.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {

		WordFinder wordFinder = new WordFinder();
		wordFinder.setVisible(true);
	}
}
