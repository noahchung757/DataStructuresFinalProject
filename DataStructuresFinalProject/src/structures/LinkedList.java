package structures;

import exceptions.ListEmptyException;
import model.Genre;

/**
 * @author Noah Chung - nmchung
 * CIS175 - Fall 2021
 * Nov 9, 2021
 */

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
	public LinkedList() {
		Genre data = null;
		size = 0;
		head = new Node(data);
	}
	
	public boolean isEmpty() {
		return (size == 0);
	}
	
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
	
	public int size() {
		if (!isEmpty()) {
			return size;
		}
		else {
			return 0;
		}
	}
	
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