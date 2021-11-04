package view;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Noah Chung - nmchung
 * CIS175 - Fall 2021
 * Nov 3, 2021
 */
public class Viewer {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new Panel();
		
		frame.add(panel);
		frame.setSize(1250, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
