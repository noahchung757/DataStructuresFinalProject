package view;

import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * @author Noah Chung - nmchung
 * CIS175 - Fall 2021
 * Nov 9, 2021
 */
public class GamesByGenrePanel extends JPanel {
	String gameText = "Games:\nTest";
	JTextArea gamesArea = new JTextArea(gameText, 400, 45);
	
	GamesByGenrePanel() {
		add(gamesArea);
	}
}
