package tests;

import exceptions.ListEmptyException;
import model.Genre;
import structures.LinkedList;

/**
 * @author Noah Chung - nmchung
 * CIS175 - Fall 2021
 * Nov 9, 2021
 */
public class FinalProjectTester {
	public static void main(String[] args) throws ListEmptyException {
		LinkedList genres = new LinkedList();
		
		Genre genre1 = new Genre("RPG");
		Genre genre2 = new Genre("RTS");
		Genre genre3 = new Genre("Fighting Games");
		
		genres.add(genre1);
		genres.add(genre2);
		genres.add(genre3);
		
		System.out.println(genres.get(0).getName());
		System.out.println(genres.get(1).getName());
		System.out.println(genres.get(2).getName());
	}
}
