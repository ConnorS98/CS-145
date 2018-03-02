package homework00;

/**
 * Author: Connor Huffman 
 * Date: Feb. 7, 2018 
 * Homework 00 
 * Description: This program works on recognizing redundancy
 * It prints out the song "There was an old lady who swallowed a fly". * 
 */

public class Song {

	public static void main(String[] args) {

		firstnotrepeat();
		firstlinerepeat();

		secondnotrepeat();
		secondlinerepeat();
		firstlinerepeat();

		thirdnotrepeat();
		thirdlinerepeat();
		secondlinerepeat();
		firstlinerepeat();

		fourthnotrepeat();
		fourthlinerepeat();
		thirdlinerepeat();
		secondlinerepeat();
		firstlinerepeat();

		fifthnotrepeat();
		fifthlinerepeat();
		fourthlinerepeat();
		thirdlinerepeat();
		secondlinerepeat();
		firstlinerepeat();

		sixthnotrepeat();
		sixthlinerepeat();
		fifthlinerepeat();
		fourthlinerepeat();
		thirdlinerepeat();
		secondlinerepeat();
		firstlinerepeat();

		seventhnotrepeat();

	}

	/**
	 * Prints out the first repeated line of the song.
	 */
	public static void firstlinerepeat() {
		System.out.println("I dont't know why she swallowed that fly,");
		System.out.println("Perhaps she'll die.");
		System.out.println();
	}

	/**
	 * Prints out the second repeated line of the song.
	 */
	public static void secondlinerepeat() {
		System.out.println("She swallowed the spider to catch the fly,");

	}

	/**
	 * Prints out the third repeated line of the song.
	 */
	public static void thirdlinerepeat() {
		System.out.println("She swallowed teh cat to catch the bird,");

	}

	/**
	 * Prints out the fourth repeated line of the song.
	 */
	public static void fourthlinerepeat() {
		System.out.println("She swallowed the cat to catch the bird,");

	}

	/**
	 * Prints out the fifth repeated line of the song.
	 */
	public static void fifthlinerepeat() {
		System.out.println("She swallowed the dog to catch the cat,");

	}

	/**
	 * Prints out the sixth repeated line of the song.
	 */
	public static void sixthlinerepeat() {
		System.out.println("She swallowed the frog to catch the dog,");
	}

	/**
	 * Prints out the first line that is not repeated of the song.
	 */
	public static void firstnotrepeat() {
		System.out.println("There was an old woman who swallowd a fly");

	}

	/**
	 * Prints out the second line that is not repeated of the song.
	 */
	public static void secondnotrepeat() {
		System.out.println("There was an old woman who swallowed a spider,");
		System.out.println("That wriggled and iggled and jiggled insider her.");

	}

	/**
	 * Prints out the third line that is not repeated of the song.
	 */
	public static void thirdnotrepeat() {
		System.out.println("There was an old woman whoswallowed a bird,");

	}

	/**
	 * Prints out the fourth line that is not repeated of the song.
	 */
	public static void fourthnotrepeat() {
		System.out.println("There was an old woman who swallowed a cat,");
		System.out.println("Imagine that to swallow a cat.");
	}

	/**
	 * Prints out the fifth line that is not repeated of the song.
	 */
	public static void fifthnotrepeat() {
		System.out.println("There was an old woman who swallowed a dog,");
		System.out.println("What a hog to swallow a dog.");
	}

	/**
	 * Prints out the sixth line that is not repeated of the song.
	 */
	public static void sixthnotrepeat() {
		System.out.println("There was an old woman who swallowed a hog,");
		System.out.println("It chased the dog and down went hog.");
	}

	/**
	 * Prints out the seventh line that is not repeated of the song.
	 */
	public static void seventhnotrepeat() {
		System.out.println("There was an old woman who swallowed a horse,");
		System.out.println("She died of course.");
	}
}
