package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.ListEmptyException;
import exceptions.MapEmptyException;
import model.Game;
import model.Genre;
import structures.HashMap;
import structures.LinkedList;

/***************************************************************
* Name         : DataStructuresFinalProject
* Author       : Noah Chung
* Created      : 11/30/2021
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

public class UnitTests  {
	Genre genre =  new Genre("Fighting Game");
	Genre genre2 =  new Genre("Rpg");
	Game game = new Game("Smash Brothers Ultimate", 59.99, 3);
	Game game2 = new Game("Injustice 2", 29.99);
	
	// Test if the LinkedList can add properly
	@Test
	public void testListAdd() throws ListEmptyException {
		LinkedList list = new LinkedList();
		list.add(genre);
		Genre expected = genre;
		Genre actual = list.get(0);
		assertEquals(expected, actual);
	}
	
	// Tests if the LinkedList is empty
	@Test
	public void testListIsEmpty() {
		LinkedList list = new LinkedList();
		assertTrue(list.isEmpty());
		list.add(genre);
		assertFalse(list.isEmpty());
	}
	
	// Tests if the LinkedList deletes element
	@Test
	public void testListDelete() throws ListEmptyException {
		LinkedList list = new LinkedList();
		list.add(genre);
		list.delete();
		assertTrue(list.isEmpty());
		list.add(genre);
		list.add(genre2);
		list.deleteAt(0);
		assertEquals(genre2, list.get(0));
	}
	
	// Tests if LinkedList returns proper size
	@Test
	public void testListSize() throws ListEmptyException {
		LinkedList list = new LinkedList();
		int expected, actual;
		expected = 0;
		actual = list.size();
		assertEquals(expected, actual);
		list.add(genre);
		expected = 1;
		actual = list.size();
		assertEquals(expected, actual);
		list.add(genre2);
		expected = 2;
		actual = list.size();
		assertEquals(expected, actual);
		list.delete();
		list.delete();
		expected = 0;
		actual = list.size();
		assertEquals(expected, actual);
	}
	
	// Tests if the LinkedList prints properly
	@Test
	public void testListPrint() throws ListEmptyException {
		LinkedList list = new LinkedList();
		genre.addGame("Smash Brothers Ultimate", game);
		genre.addGame("Injustice 2", game2);
		list.add(genre);
		String expected = "Smash Brothers Ultimate: Price: $59.99 - Quantity: 3\nInjustice 2: Price: $29.99 - Quantity: 1\n";
		String actual = list.print();
		assertEquals(expected, actual);
		// also tests Genre's print because gameList() method and HashMap's
		// print game method because they are called in the list.print() method
	}
	
	// Tests if the HashMap returns correctly if empty or not empty
	@Test
	public void testMapIsEmpty() {
		HashMap map = new HashMap();
		assertTrue(map.isEmpty());
		map.insertGame("Smash Brothers Ultimate", game);
		assertFalse(map.isEmpty());
	}
	
	// Tests if the HashMap finds the game properly
	@Test
	public void testMapFind() throws MapEmptyException {
		HashMap map = new HashMap();
		map.insertGame("Smash Brothers Ultimate", game);
		Game expected = game;
		Game actual =  map.findGame("Smash Brothers Ultimate");
		assertEquals(expected, actual);
	}
	
	// Tests if the HashMap removes games properly
	@Test
	public void testMapRemove() throws MapEmptyException {
		HashMap map = new HashMap();
		map.insertGame("Smash Brothers Ultimate", game);
		map.insertGame("Injustice 2", game2);
		Game actual = game2;
		Game expected = map.findGame("Injustice 2");
		assertEquals(expected, actual);
		map.removeGame("Injustice 2");
		actual = null;
		expected = map.findGame("Injustice 2");
		assertEquals(expected, actual);
	}
	
	// Tests if the HashMap returns the correct size
	@Test
	public void testMapSize() throws MapEmptyException {
		HashMap map = new HashMap();
		int expected = 0;
		int actual = map.size();
		assertEquals(expected, actual);
		map.insertGame("Smash Brothers Ultimate", game);
		expected = 1;
		actual = map.size();
		assertEquals(expected, actual);
		map.insertGame("Injustice 2", game2);
		expected = 2;
		actual = map.size();
		assertEquals(expected, actual);
		map.removeGame("Smash Brothers Ultimate");
		map.removeGame("Injustice 2");
		expected = 0;
		actual = map.size();
		assertEquals(expected, actual);
	}
	
	// Tests if the HashMap returns properly for hasGame()
	@Test
	public void testMapHasGame() throws MapEmptyException {
		HashMap map = new HashMap();
		map.insertGame("Injustice 2", game2);
		assertTrue(map.hasGame("Injustice 2"));
		map.removeGame("Injustice 2");
		assertFalse(map.hasGame("Injustice 2"));
	}
	
	// Tests if the HashMap quantity goes up by 1 if a game with the same name is added
	@Test
	public void testQunatity() throws MapEmptyException {
		HashMap map = new HashMap();
		map.insertGame("Injustice 2", game2);
		int expected = 1;
		int actual = map.findGame("Injustice 2").getQuantity();
		assertEquals(expected, actual);
		map.insertGame("Injustice 2", game2);
		expected = 2;
		actual = map.findGame("Injustice 2").getQuantity();
		assertEquals(expected, actual);
	}
	
	// Tests if the print returns properly formated for the file
	@Test
	public void testPrintForFile() {
		genre.addGame("Smash Brothers Ultimate", game);
		genre.addGame("Injustice 2", game2);
		String expected = "Smash Brothers Ultimate,59.99,3\nInjustice 2,29.99,1";
		String actual = genre.gameListForFile();
		assertEquals(expected, actual);
		// also tests for the HashMap because that is called in Genre's
		// gameListForFile() method
	}
}
