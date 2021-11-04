package view;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 * @author Noah Chung - nmchung
 * CIS175 - Fall 2021
 * Nov 3, 2021
 */
public class Panel extends JPanel {
	private JLabel text = new JLabel("Store more games");
	
	private JLabel nameText = new JLabel("Name:");
	private JTextField nameField = new JTextField(5);
	
	private JLabel priceText = new JLabel("Price:");
	private JTextField priceField = new JTextField(5);
	
	private JLabel genreText = new JLabel("Genre:");
	private JTextField genreField = new JTextField(5);
	
	private JButton addButton = new JButton("Add");
	
	private JLabel searchText = new JLabel("Search for game by title:");
	private JTextField searchField = new JTextField(5);
	private JButton buyButton = new JButton("Buy");
	
	String gameText = "Games:\nTest";
	JTextArea gamesArea = new JTextArea(gameText);
	
	Panel() {
		add(text).setLocation(100, 50);;
		
		add(nameText);
		add(nameField);
		
		add(priceText);
		add(priceField);
		
		add(genreText);
		add(genreField);
		
		add(addButton);
		
		add(searchText);
		add(searchField);
		add(buyButton);
		
		add(gamesArea);
	}
}
