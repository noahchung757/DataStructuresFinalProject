package structures;

import exceptions.ListEmptyException;
import model.Genre;

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

public class LinkedList {
	private Node head;
	private int size;
	
	static class Node {
		Genre data;
		Node next;
		
		Node(Genre d) {
			data = d;
			next = null;
		}
	}
	/**
	 * Default constructor
	 */
	public LinkedList() {
		Genre data = null;
		size = 0;
		head = new Node(data);
	}
	
	/**
	 * @return if the LinkedList is empty
	 */
	public boolean isEmpty() {
		return (size == 0);
	}
	
	/**
	 * @param item
	 * Adds Genre to list
	 */
	public void add(Genre item) {
		Node dataNode = new Node(item);
		
		if (isEmpty()) {
			head = dataNode;
		}
		else {
			Node nextNode = head;
			while (nextNode.next != null) {
				nextNode = nextNode.next;
			}
			nextNode.next = dataNode;
		}
		size = size + 1;
	}
	
	/**
	 * @param index
	 * @param item
	 * @throws ListEmptyException
	 * Replaces a Genre at the given index with a new Genre/item
	 */
	public void replace(int index, Genre item) throws ListEmptyException {
		if (isEmpty()) {
			throw new ListEmptyException();
		}
		else if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		else {
			Node replaceNode = head;
			if (index == 0) {
				head.data = item;
			}
			else {
				for (int i = 0; i < (index); i++) {
					replaceNode = replaceNode.next;
				}
				replaceNode.data = item;
			}
		}
	}
	
	/**
	 * @throws ListEmptyException
	 * Deletes the end element from the list
	 */
	public void delete() throws ListEmptyException {
		if (isEmpty()) {
			throw new ListEmptyException();
		}
		else {
			if (size == 1) {
				head.data = null;
			}
			else {
				Node lastNode = head;
				
				for (int i = 0; i < (size - 2); i++) {
					lastNode = lastNode.next;
				}
				lastNode.next = null;
			}
			size = size - 1;
		}
	}
	
	/**
	 * @param index
	 * @throws ListEmptyException
	 * Deletes element at specified index
	 */
	public void deleteAt(int index) throws ListEmptyException {
		if (isEmpty()) {
			throw new ListEmptyException();
		}
		else if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		else {
			Node removeNext = head;
			Node afterRemoved = head;
			if (index == 0) {
				head = head.next;
			} 
			else {
				for (int i = 0; i < (index - 1); i++) {
					removeNext = removeNext.next;
				}
				for (int i = 0; i < (index + 1); i++) {
					afterRemoved = afterRemoved.next;
				}
				removeNext.next = afterRemoved;
			}
		}
		size = size - 1;
	}
	
	/**
	 * @param index
	 * @return the Genre at the desired index
	 * @throws ListEmptyException
	 */
	public Genre get(int index) throws ListEmptyException {
		if (isEmpty()) {
			throw new ListEmptyException();
		}
		else if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		else {
			Node getGenre = head;
			for (int i = 0; i < index; i++) {
				getGenre = getGenre.next;
			}
			return getGenre.data;
		}
	}
	
	/**
	 * @return size
	 */
	public int size() {
		return size;
	}
	
	/**
	 * @return a formated string for printing
	 * @throws ListEmptyException
	 */
	public String print() throws ListEmptyException {
		Node stringNode = head;
		String listString = "";
		
		if (!isEmpty()) {
			while (stringNode != null) {
				listString = listString + stringNode.data.gameList() + "\n";
				stringNode = stringNode.next;
			}
			return listString;
		}
		else {
			throw new ListEmptyException();
		}
	}
}