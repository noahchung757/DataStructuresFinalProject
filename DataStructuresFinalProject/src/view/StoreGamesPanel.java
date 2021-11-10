package view;
import java.awt.BorderLayout;

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
public class StoreGamesPanel extends JPanel {
	private JLabel text = new JLabel("Store more games -");
	
	private JLabel nameText = new JLabel("Name:");
	private JTextField nameField = new JTextField(7);
	
	private JLabel priceText = new JLabel("Price:");
	private JTextField priceField = new JTextField(4);
	
	private JLabel genreText = new JLabel("Genre:");
	private JTextField genreField = new JTextField(7);
	
	private JButton addButton = new JButton("Add");
	
	
	StoreGamesPanel() {
		add(text);
		
		add(nameText);
		add(nameField);
		
		add(priceText);
		add(priceField);
		
		add(genreText);
		add(genreField);
		
		add(addButton);
		
	}
}
