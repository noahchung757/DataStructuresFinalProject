package view;
import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import exceptions.ListEmptyException;

/***************************************************************
* Name         : DataStructuresFinalProject
* Author       : Noah Chung
* Created      : 11/3/2021
* Course       : CIS 152 - Data Structures
* Version      : 1.0
* OS           : Windows 10
* IDE          : Eclipse Enterprise Edition
* Copyright    : This is my own original work based on
*                      specifications issued by our instructor
* Description  : This program creates an inventory system using GUI,
* 					for games. It uses the HashMap and LinkedList Data 
* 					Structures, a file to read and write to, for the 
* 					games to be stored. The two classes are Games and
* 					Genre. Through the GUI a user can add and remove
* 					games as they buy or sell them.
*                      Input : Game name, price, and genre for storing.
*                      			Game name for selling/removing.
*                      Output: List of games by genre.
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or
* unmodified. I have not given other fellow student(s) access
* to my program. 
***************************************************************/

public class Viewer {
	/**
	 * Adds JFrame, JPanels, and layout and configures some conditions for the
	 * GUI
	 * @param args
	 * @throws ListEmptyException
	 */
	public static void main(String[] args) throws ListEmptyException {
		JFrame frame = new JFrame();
		JPanel panel = new MainPanel();
		frame.setLayout(new BorderLayout());
		
		frame.add(panel);
		frame.setSize(550, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
