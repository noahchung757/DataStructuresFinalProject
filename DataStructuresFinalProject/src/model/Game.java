package model;

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

public class Game {
	private String name;
	private double price;
	private int quantity;
	
	/**
	 * 
	 */
	public Game() {
		this.quantity = 1;
	}
	/**
	 * @param name
	 * @param price
	 */
	public Game(String name, double price) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = 1;
	}
	/**
	 * @param name
	 * @param price
	 * @param quantity
	 */
	public Game(String name, double price, int quantity) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
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
	 * @return price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 *
	 */
	@Override
	public String toString() {
		return "Game [name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}
}
