package tests;

import exceptions.ListEmptyException;
import model.Genre;
import structures.LinkedList;

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
