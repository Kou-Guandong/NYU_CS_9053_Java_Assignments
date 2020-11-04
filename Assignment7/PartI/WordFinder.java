
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WordFinder extends JFrame {

	JFileChooser jFileChooser;
	private JPanel topPanel; // the top line of objects is going to go here
	WordList wordList;
	JList list;
	private JTextArea wordsBox; // results of the search go in heer.
	

	public WordFinder() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// set the size correctly
		this.setSize(500, 300);
		jFileChooser = new JFileChooser(".");
		wordList = new WordList();

		JPanel panelForTextFields = new JPanel();
		panelForTextFields.setSize(400, 180);


		//panel at the top
		topPanel = new JPanel();
		
		// there should be objects in the top panel
		
		// There should probably be something passed into the JScrollPane

		model = new DefaultListModel();
		list = new JList(model);

		// and of course you will want them to be properly aligned in the frame
		

	}
	
	private void createMenus() {
		/* add a "File" menu with:
		 * "Open" item which allows you to choose a new file
		 * "Exit" item which ends the process with System.exit(0);
		 * Key shortcuts are optional
		 */
		
		/* OpenActionListener that will open the file chooser */
		class OpenActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				OpenFileListener myFileListener = new OpenFileListener();
				myFileListener.actionPerformed(e);
			}
		}
		
	}

	private void find(){
		List searchResult = null; // figure out from WordList how to get this

		// you're going to want to get the words in the
		// searchResult list and put them in the textbox.
	}
	
	class OpenFileListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int returnVal = jFileChooser.showOpenDialog(getParent());
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				try {
					System.out.println("You chose to open this file: " + jFileChooser.getSelectedFile().getAbsolutePath());

					InputStream in = new FileInputStream(jFileChooser.getSelectedFile().getAbsolutePath());
					wordList.load(in);

					List searchResult = null; // figure out from WordList how to get this
					// because you will load in a wordlist and there
					// might be data in the search box

				} catch (IOException error){
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
