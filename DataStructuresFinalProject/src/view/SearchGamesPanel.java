package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Noah Chung - nmchung
 * CIS175 - Fall 2021
 * Nov 9, 2021
 */
public class SearchGamesPanel extends JPanel {
	private JLabel searchText = new JLabel("Search for game by title:");
	private JTextField searchField = new JTextField(5);
	private JButton buyButton = new JButton("Buy");
	
	SearchGamesPanel() {
		add(searchText);
		add(searchField);
		add(buyButton);
	}
}
