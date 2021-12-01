package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.ListEmptyException;
import exceptions.MapEmptyException;
import model.Game;
import model.Genre;
import structures.HashMap;
import structures.LinkedList;

/**
 * @author Noah Chung - nmchung
 * CIS175 - Fall 2021
 * Nov 30, 2021
 */
public class UnitTests  {
	Genre genre =  new Genre("Fighting Game");
	Genre genre2 =  new Genre("Rpg");
	Game game = new Game("Smash Brothers Ultimate", 59.99, 3);
	Game game2 = new Game("Injustice 2", 29.99);
	//Game game3 = new Game("Mass Effect", 29.99);
	//Game game4 = new Game("Knights of the Old Republic", 19.99, 1);
	
	@Test
	public void testListAdd() throws ListEmptyException {
		LinkedList list = new LinkedList();
		list.add(genre);
		assertEquals(genre, list.get(0));
	}
	
	@Test
	public void testListIsEmpty() {
		LinkedList list = new LinkedList();
		assertTrue(list.isEmpty());
		list.add(genre);
		assertFalse(list.isEmpty());
	}
	
	@Test 
	public void testListGet() throws ListEmptyException {
		LinkedList list = new LinkedList();
		list.add(genre);
		list.add(genre2);
		assertEquals(list.get(0), genre);
		assertEquals(list.get(1), genre2);
	}
	
	@Test
	public void testListSize() {
		LinkedList list = new LinkedList();
		assertEquals(list.size(), 0);
		list.add(genre);
		assertEquals(list.size(), 1);
		list.add(genre2);
		assertEquals(list.size(), 2);
	}
	
	@Test
	public void testListDelete() throws ListEmptyException {
		LinkedList list = new LinkedList();
		list.add(genre);
		list.delete();
		assertTrue(list.isEmpty());
		list.add(genre);
		list.add(genre2);
		list.deleteAt(0);
		assertEquals(list.get(0), genre2);
	}
	
	@Test
	public void testListPrint() throws ListEmptyException {
		LinkedList list = new LinkedList();
		genre.addGame("Smash Brothers Ultimate", game);
		genre.addGame("Injustice 2", game2);
		list.add(genre);
		String expected = "Smash Brothers Ultimate: Price: $59.99 - Quantity: 3\nInjustice 2: Price: $29.99 - Quantity: 1\n";
		assertEquals(list.print(), expected);
	}
	
	@Test
	public void testMapInsert() throws MapEmptyException {
		HashMap map = new HashMap();
		map.insertGame("Smash Brothers Ultimate", game);;
		assertEquals(map.findGame("Smash Brothers Ultimate"), game);
	}
	
	@Test
	public void testMapIsEmpty() {
		HashMap map = new HashMap();
		assertTrue(map.isEmpty());
		map.insertGame("Smash Brothers Ultimate", game);
		assertFalse(map.isEmpty());
	}
	
	@Test
	public void testMapFind() throws MapEmptyException {
		HashMap map = new HashMap();
		map.insertGame("Smash Brothers Ultimate", game);
		assertEquals(map.findGame("Smash Brothers Ultimate"), game);
	}
	
	// Test size
	
	// Test remove
	
	// Test has game
	
	// Test repeat game added quantity goes up
	
	// Test print list
	
	// Test print list for file
	
	// Genre print tests
	
	// Game quantity tests
}
