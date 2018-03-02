package homework01;

/**
 * Author: Connor Huffman 
 * Date: Mar. 1, 2018 
 * Homework 01 
 * Part B
 * Description: This program uses for loops, methods, and a class constant 
 * to recreate the Space Needle in multiple different sizes by only changing
 * the class constant.
 */

public class SpaceNeedle {

	public static final int FIGURE_SIZE = 4;

	public static void main(String[] args) {

		point();
		stairs();
		line();
		window();
		point();
		trunk();
		stairs();
		line();

	}
/**
 * This method creates the point of Space Needle
 */
	public static void point() {
		for (int i = 1; i <= FIGURE_SIZE; i++) {
			for (int j = 1; j <= FIGURE_SIZE * 3; j++) {
				System.out.print(" ");
			}
			System.out.println("||");
		}

	}
/**
 * This method creates the next portion of the Needle that looks like stairs to me
 */
	public static void stairs() {

		for (int i = 0; i < FIGURE_SIZE; i++) {
			for (int j = 0; j < FIGURE_SIZE * 3 - i * 3 - 3; j++) {
				System.out.print(" ");

			}
			System.out.print("__/");

			for (int j = 0; j < i; j++) {
				System.out.print(":::");

			}
			System.out.print("||");
			for (int j = 0; j < i; j++) {
				System.out.print(":::");
			}
			System.out.print("\\__");

			System.out.println();
		}
	}
/**
 * this method creates the line that separates the two main parts of Space Needle
 */
	public static void line() {
		System.out.print("|");
		for (int j = 1; j <= 6 * FIGURE_SIZE; j++) {
			System.out.print("\"");

		}
		System.out.print("|");
		System.out.println();
	}
/**
 * This method creates the V section, that resembles windows
 */
	public static void window() {
		for (int i = 0; i < FIGURE_SIZE; i++) {
			for (int j = 0; j < i * 2; j++) {
				System.out.print(" ");
			}
			System.out.print("\\_");

			for (int j = 0; j < FIGURE_SIZE * 3 - i * 2 - 1; j++) {
				System.out.print("/\\");

			}
			System.out.print("_/");
			System.out.println();
		}

	}
/**
 * This method creates the main body of the Needle
 */
	public static void trunk() {
		for (int i = 0; i < FIGURE_SIZE * 2; i++) {
			for (int j = 0; j < FIGURE_SIZE * 2 + 1; j++) {
				System.out.print(" ");
			}

			System.out.print("|");
			for (int j = 0; j < FIGURE_SIZE - 2; j++) {
				System.out.print("%");

			}
			System.out.print("||");
			for (int j = 0; j < FIGURE_SIZE - 2; j++) {
				System.out.print("%");
			}
			System.out.println("|");
		}
	}
}