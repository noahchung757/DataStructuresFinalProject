package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

/**
 * @author Noah Chung - nmchung
 * CIS175 - Fall 2021
 * Nov 9, 2021
 */
public class MainPanel extends JPanel {
	JPanel storeGamesPanel = new StoreGamesPanel();
	JPanel searchGamesPanel = new SearchGamesPanel();
	JPanel gamesByGenrePanel = new GamesByGenrePanel();
	JPanel panelTest = new JPanel();
	
	MainPanel()  {
		setLayout(new BorderLayout());
		
		add(searchGamesPanel, BorderLayout.PAGE_START);
		add(gamesByGenrePanel, BorderLayout.CENTER);
		add(storeGamesPanel, BorderLayout.PAGE_END);
	}
}
