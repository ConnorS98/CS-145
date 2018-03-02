package homework01;

/**
 * Author: Connor Huffman 
 * Date: Mar. 1, 2018 
 * Homework 01 
 * Part A
 * Description: This program uses for loops and methods to create a small building
 */

public class AsciiArt {
	public static void main(String[] args) {

		top();
		first();
		roof();
		middle();
		indent();
		middle();
		indent();
		middle();
		bottom();

	}
/**
 * createst the point at the top
 */
	public static void top() {
		for (int i = 1; i <= 2; i++) {
			System.out.println("   |");
		}
	}
/**
 * creates teh top part of the building
 */
	public static void first() {
		for (int i = 1; i <= 1; i++) {
			System.out.println("  _|_");
		}
	}
/**
 * creates the top roof of the building
 */
	public static void roof() {
		for (int i = 1; i <= 1; i++) {
			System.out.println(" / _ \\");
		}

	}
/**
 * creates the middle body seciton of the building
 */
	public static void middle() {
		for (int i = 1; i <= 3; i++) {
			System.out.println("| |_| |");
		}
	
		}
/**
 * Creates the indents between the body
 */
	public static void indent() {
		for (int i = 1; i <= 1; i++) {
			System.out.println(" \\   /");
			System.out.println(" / _ \\");
	} 
	
		
	}
/**
 * Creates teh bottom of the bulding
 */
	public static void bottom() {
		for(int i = 1; i <= 1; i++) {
			System.out.println("|_____|");
		}
	}
	
}
