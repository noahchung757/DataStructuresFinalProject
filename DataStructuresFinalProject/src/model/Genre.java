package model;

import exceptions.MapEmptyException;
import structures.HashMap;

/**
 * @author Noah Chung - nmchung
 * CIS175 - Fall 2021
 * Nov 3, 2021
 */

public class Genre {
	private String name;
	private HashMap map = new HashMap();
	
	public Genre() {
	}
	public Genre(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void addGame(String gameName, Game game) {
		map.insertGame(gameName, game);
	}
	
	public void removeGame(String gameName) {
		try {
			map.removeGame(gameName);
		} catch (MapEmptyException e) {
			
		}
	}
	
	public Game getGame(String gameName) {
		try {
			return map.findGame(gameName);
		} catch (MapEmptyException e) {
			return null;
		}
	}
	
	public boolean gameExists(String gameName) {
		return map.hasGame(gameName);
	}
	
	public String gameList() {
		try {
			return map.printGames();
		} catch (MapEmptyException e) {
			return "Must add games";
		}
	}
}
