package structures;

import java.text.DecimalFormat;

import exceptions.MapEmptyException;
import model.Game;

/***************************************************************
* Name         : DataStructuresFinalProject
* Author       : Noah Chung
* Created      : 11/16/2021
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

public class HashMap {
	private Node head;
	private int size;
	
	static class Node {
		String gameName;
		Game game;
		Node next;
		
		/**
		 * @param userGameName
		 * @param userGame
		 */
		Node(String userGameName, Game userGame) {
			gameName = userGameName;
			game = userGame;
			next = null;
		}
	}
	/**
	 * 
	 */
	public HashMap() {
		size = 0;
		head = null;
	}
	
	/**
	 * @return if the game is empty
	 */
	public boolean isEmpty() {
		return (head == null);
	}
	
	/**
	 * @param gameName
	 * @return if game is in the map
	 */
	public boolean hasGame(String gameName) {
		if (isEmpty()) {
			return false;
		}
		Node currNode = head;
		while (currNode != null) {
			if (currNode.gameName.equals(gameName)) {
				return true;
			}
			currNode = currNode.next;
		}
		return false;
	}
	
	/**
	 * @param gameName
	 * @return the game if it is found
	 * @throws MapEmptyException
	 */
	public Game findGame(String gameName) throws MapEmptyException {
		if (isEmpty()) {
			throw new MapEmptyException();
		}
		Node currNode = head;
		while (currNode != null) {
			if (currNode.gameName.equals(gameName)) {
				return currNode.game;
			}
			currNode = currNode.next;
		}
		return null;
	}
	
	/**
	 * @param gameName
	 * @param game
	 * Inserts game into map
	 */
	public void insertGame(String gameName, Game game) {
		Node newNode = new Node(gameName, game);
		Node currNode = head;
		size++;
		if (!isEmpty()) {
			if (hasGame(gameName)) {
				while (currNode != null) {
					if (currNode.gameName.equals(gameName)) {
						currNode.game.setQuantity(currNode.game.getQuantity() + 1);
						currNode.game.setPrice(game.getPrice());
						return;
					}
					currNode = currNode.next;
				}
			}
			else {
				while (currNode.next != null) {
					currNode = currNode.next;
				}
				currNode.next = newNode;
			}
		}
		else {
			head = newNode;
		}
	}
	
	/**
	 * @param gameName
	 * @throws MapEmptyException
	 * Removes game from map
	 */
	public void removeGame(String gameName) throws MapEmptyException {
		if (isEmpty()) {
			throw new MapEmptyException();
		}
		if (hasGame(gameName)) {
			size--;
			Node currNode = head;
			Node nodeAhead = null;
			Node nodeBehind = null;
			if (currNode.gameName.equals(gameName)) {
				if (currNode.game.getQuantity() > 1) {
					currNode.game.setQuantity(currNode.game.getQuantity() - 1);
					return;
				}
				head = currNode.next;
			}
			else if (currNode.next != null) {
				while (currNode.next != null) {
					nodeBehind = currNode;
					currNode = currNode.next;
					nodeAhead = currNode.next;
					if (currNode.gameName.equals(gameName)) {
						if (currNode.game.getQuantity() > 1) {
							currNode.game.setQuantity(currNode.game.getQuantity() - 1);
							return;
						}
						break;
					}
				}
				nodeBehind.next = nodeAhead;
			}
			else {
				if (head.game.getQuantity() > 1) {
					head.game.setQuantity(head.game.getQuantity() - 1);
					return;
				}
				head = null;
			}
		}
	}
	
	/**
	 * @return size
	 */
	public int size() {
		return size;
	}
	
	/**
	 * @return a formated string to print the games
	 * @throws MapEmptyException
	 */
	public String printGames() throws MapEmptyException {
		if (isEmpty()) {
			throw new MapEmptyException();
		}
		String gameString = "";
		DecimalFormat df = new DecimalFormat("0.00");
		Node currNode = head;
		while (currNode != null) {
			if (currNode.next == null) {
				gameString = gameString + currNode.gameName + ": Price: $" + df.format(currNode.game.getPrice()) + " - Quantity: " + currNode.game.getQuantity();
			}
			else {
				gameString = gameString + currNode.gameName + ": Price: $" + df.format(currNode.game.getPrice()) + " - Quantity: " + currNode.game.getQuantity() + "\n";
			}
			currNode = currNode.next;
		}
		
		return gameString;
	}
	
	/**
	 * @return a formated string to print games to file
	 * @throws MapEmptyException
	 */
	public String printGamesForFile() throws MapEmptyException {
		if (isEmpty()) {
			throw new MapEmptyException();
		}
		String gameString = "";
		DecimalFormat df = new DecimalFormat("0.00");
		Node currNode = head;
		while (currNode != null) {
			if (currNode.next == null) {
				gameString = gameString + currNode.gameName + "," + df.format(currNode.game.getPrice()) + "," + currNode.game.getQuantity();
			}
			else {
				gameString = gameString + currNode.gameName + "," + df.format(currNode.game.getPrice()) + "," + currNode.game.getQuantity() + "\n";
			}
			currNode = currNode.next;
		}
		
		return gameString;
	}
}
