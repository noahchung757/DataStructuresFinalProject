package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import exceptions.ListEmptyException;
import model.Game;
import model.Genre;
import structures.HashMap;
import structures.LinkedList;

/***************************************************************
* Name         : DataStructuresFinalProject
* Author       : Noah Chung
* Created      : 11/9/2021
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

public class MainPanel extends JPanel {
	HashMap map = new HashMap();
	LinkedList list = new LinkedList();
	JPanel storeGamesPanel = new StoreGamesPanel();
	JPanel searchGamesPanel = new SearchGamesPanel();
	JPanel gamesByGenrePanel = new GamesByGenrePanel();
	
	public class StoreGamesPanel extends JPanel {
		private JLabel text = new JLabel("Store more games -");
		
		private JLabel nameText = new JLabel("Name:");
		private JTextField nameField = new JTextField(7);
		
		private JLabel priceText = new JLabel("Price:");
		private JTextField priceField = new JTextField(4);
		
		private JLabel genreText = new JLabel("Genre:");
		private JTextField genreField = new JTextField(7);
		
		private JButton addButton = new JButton("Add");
		
		
		/**
		 * Implements J components for GUI
		 */
		StoreGamesPanel() {
			addListener aL = new addListener();
			addButton.addActionListener(aL);
			
			add(text);
			
			add(nameText);
			add(nameField);
			
			add(priceText);
			add(priceField);
			
			add(genreText);
			add(genreField);
			
			add(addButton);
			
		}
		class addListener implements ActionListener {
			/**
			 * Gets users input for game name, price, and genre input validates
			 * then adds it to the list and map
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText().substring(0, 1).toUpperCase() + nameField.getText().substring(1).toLowerCase();
				String priceString = priceField.getText();
				String genreString = genreField.getText().substring(0, 1).toUpperCase() + genreField.getText().substring(1).toLowerCase();
				double price;
				if (genreString.equals("") || name.equals("")) {
					return;
				}
				try {
					price = Double.parseDouble(priceString);
				} catch (Exception e1) {
					return;
				}
				Genre genre = new Genre(genreString);
				Game game = new Game(name, price);
				for (int i = 0; i < list.size(); i++) {
					try {
						if (list.get(i).getName().equals(genreString)) {
							list.get(i).addGame(name, game);
							resetFields();
							try {
								updatePanel();
							} catch (ListEmptyException e1) {
								System.out.println("Broken");
							}
							return;
						}
					} catch (ListEmptyException e1) {
						System.out.println("Broken");
					}
				}
				genre.addGame(name, game);
				list.add(genre);
				resetFields();
				try {
					updatePanel();
				} catch (ListEmptyException e1) {
					System.out.println("Broken");
				}
			}
			
			/**
			 * Resets the text fields for after the user has entered data 
			 * successfully
			 */
			public void resetFields() {
				nameField.setText("");
				priceField.setText("");
				genreField.setText("");
			}
		}
	}
	
	public class SearchGamesPanel extends JPanel {
		private JLabel searchText = new JLabel("Search for game by title:");
		private JTextField searchField = new JTextField(5);
		private JButton buyButton = new JButton("Buy");
		private JButton exitButton = new JButton("Exit");
		
		/**
		 * 
		 */
		SearchGamesPanel() {
			buyListener bL = new buyListener();
			buyButton.addActionListener(bL);
			
			exitListener eL = new exitListener();
			exitButton.addActionListener(eL);
			
			add(searchText);
			add(searchField);
			add(buyButton);
			add(exitButton);
		}
		
		class buyListener implements ActionListener {
			/**
			 * Gets input from user, input validates then if the game exists it
			 * removes it from whatever genre it exists in.
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				String game = searchField.getText();
				game = game.substring(0, 1).toUpperCase() + game.substring(1).toLowerCase();
				if (game.equals("")) {
					return;
				}
				for (int i = 0; i < list.size(); i++) {
					try {
						if (list.get(i).gameExists(game) == true) {
							list.get(i).removeGame(game);
							searchField.setText("");
							try {
								updatePanel();
							} catch (ListEmptyException e1) {
								System.out.println("Broken");
							}
						}
					} catch (ListEmptyException e1) {
						return;
					}
				}
			}
		}
		
		class exitListener implements ActionListener {
			/**
			 * Generates a string of all the games and genres then adds to file
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				String gameText = "";
				try {
				for (int i = 0; i < list.size(); i++) {
					if (i == 0) {
						gameText = list.get(i).getName() + "\n" + list.get(i).gameListForFile();
					}
					else {
						gameText = gameText + "\n" + list.get(i).getName() + "\n" + list.get(i).gameListForFile();
					}
				}
				} catch (ListEmptyException e1) {
					System.out.println("Broken");
				}

				String fileName = "games.txt";
				try {
					FileWriter writer = new FileWriter(fileName, false); // true to append
					writer.write(gameText);
					writer.close();
				} catch (IOException e1) {
					System.out.println("Broken");
				}
			    
				System.exit(0);
			}
			
		}
	}
	
	public class GamesByGenrePanel extends JPanel {
		String gameText = "Games need to be added";
		JTextArea gamesArea = new JTextArea(gameText, 400, 45);
		
		/**
		 * 
		 */
		GamesByGenrePanel() {
			add(gamesArea);
		}
		
		/**
		 * @throws ListEmptyException
		 * Calls the sort method and updates the text box containing the list of
		 * games and genres
		 */
		public void updateGamesList() throws ListEmptyException {
			insertionSortGenres();
			for (int i = 0; i < list.size(); i++) {
				if (i == 0) {
					gameText = list.get(i).getName() + "\n" + list.get(i).gameList();
				}
				else {
					gameText = gameText + "\n" + list.get(i).getName() + "\n" + list.get(i).gameList();
				}
			}
			gamesArea.setText(gameText);
		}
	}
	
	/**
	 * @throws ListEmptyException
	 * adds the JPanels to the MainPanel, sets the layout, creates a file if
	 * not already created, if file is created reads the games from it.
	 */
	public MainPanel() throws ListEmptyException  {
		setLayout(new BorderLayout());
		
		add(searchGamesPanel, BorderLayout.PAGE_START);
		add(gamesByGenrePanel, BorderLayout.CENTER);
		add(storeGamesPanel, BorderLayout.PAGE_END);
		
		try {
			File gamesFile = new File("games.txt");
			gamesFile.createNewFile();
			
			FileInputStream fis = new FileInputStream(gamesFile);
			InputStreamReader r = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(r);
			String line = br.readLine();
			
			Genre currGenre = null;
			while (line != null) {
				if (line.equals("Games need to be added")) {
					break;
				}
				else if (!line.contains(",")) {
					if (currGenre != null) {
						list.add(currGenre);
					}
					currGenre = new Genre(line);
				}
				else {
					String name;
					double price;
					int quantity;
					String currString = line;
					
					name = currString.substring(0, currString.indexOf(","));
					currString = currString.substring(currString.indexOf(",") + 1);
					price = Double.parseDouble(currString.substring(0, currString.indexOf(",")));
					quantity = Integer.parseInt(currString.substring(currString.indexOf(",") + 1));
					
					currGenre.addGame(name, new Game(name, price, quantity));
				}
				line = br.readLine();
			}
			if (currGenre != null) {
				list.add(currGenre);
			}
			
			if (!list.isEmpty()) {
				updatePanel();
			}
			
			fis.close();
			r.close();
			br.close();
		} 
		catch (IOException e) {
			System.out.println("Broken");
		}
	}
	
	/**
	 * @throws ListEmptyException
	 * Updates the game panel by calling the updateGamesList() and using the
	 * results to change the panel. Removes old panel and adds new panel.
	 */
	public void updatePanel() throws ListEmptyException {
		GamesByGenrePanel test = new GamesByGenrePanel();
		test.updateGamesList();
		gamesByGenrePanel = test;
		remove(gamesByGenrePanel);
		add(gamesByGenrePanel, BorderLayout.CENTER);
		revalidate();
	}
	
	/**
	 * @throws ListEmptyException
	 * Sorts the genres so that they are in alphabetical order
	 */
	public void insertionSortGenres() throws ListEmptyException {
		for (int i = 0; i < list.size(); ++i) {
			Genre key = list.get(i);
			int j = i - 1;
			
			while (j >= 0 && list.get(j).getName().compareTo(key.getName()) > 0) {
				list.replace(j + 1, list.get(j));
				j = j - 1;
			}
			list.replace(j + 1, key);
		}
    }
}
