package model;

import exceptions.MapEmptyException;
import structures.HashMap;

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

public class Genre {
	private String name;
	private HashMap map = new HashMap();
	
	/**
	 * 
	 */
	public Genre() {
	}
	/**
	 * @param name
	 */
	public Genre(String name) {
		super();
		this.name = name;
	}
	
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @param gameName
	 * @param game
	 */
	public void addGame(String gameName, Game game) {
		map.insertGame(gameName, game);
	}
	
	/**
	 * @param gameName
	 */
	public void removeGame(String gameName) {
		try {
			map.removeGame(gameName);
		} catch (MapEmptyException e) {
			
		}
	}
	
	/**
	 * @param gameName
	 * @return map.findGame(gameName) or null
	 */
	public Game getGame(String gameName) {
		try {
			return map.findGame(gameName);
		} catch (MapEmptyException e) {
			return null;
		}
	}
	
	/**
	 * @param gameName
	 * @return map.hasGame(gameName)
	 */
	public boolean gameExists(String gameName) {
		return map.hasGame(gameName);
	}
	
	/**
	 * @return map.printGames or "Must add games"
	 */
	public String gameList() {
		try {
			return map.printGames();
		} catch (MapEmptyException e) {
			return "Must add games";
		}
	}
	
	/**
	 * @return map.printGamesForFile or "Must add games"
	 */
	public String gameListForFile() {
		try {
			return map.printGamesForFile();
		} catch (MapEmptyException e) {
			return "Must add games";
		}
	}
}
