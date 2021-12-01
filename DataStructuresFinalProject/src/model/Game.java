package model;

/**
 * @author Noah Chung - nmchung
 * CIS175 - Fall 2021
 * Nov 3, 2021
 */
public class Game {
	private String name;
	private double price;
	private int quantity;
	
	public Game() {
		this.quantity = 1;
	}
	public Game(String name, double price) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = 1;
	}
	public Game(String name, double price, int quantity) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "Game [name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}
}
