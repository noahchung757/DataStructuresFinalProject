package structures;

import java.text.DecimalFormat;

import exceptions.MapEmptyException;
import model.Game;

/**
 * @author Noah Chung - nmchung
 * CIS175 - Fall 2021
 * Nov 16, 2021
 */
public class HashMap {
	private Node head;
	
	static class Node {
		String gameName;
		Game game;
		Node next;
		
		Node(String userGameName, Game userGame) {
			gameName = userGameName;
			game = userGame;
			next = null;
		}
	}
	public HashMap() {
		head = null;
	}
	
	public boolean isEmpty() {
		return (head == null);
	}
	
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
	
	public void insertGame(String gameName, Game game) {
		Node newNode = new Node(gameName, game);
		Node currNode = head;
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
	
	public void removeGame(String gameName) throws MapEmptyException {
		if (isEmpty()) {
			throw new MapEmptyException();
		}
		if (hasGame(gameName)) {
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
