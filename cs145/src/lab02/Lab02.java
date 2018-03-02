package lab02;
/**
 * Author: Connor Huffman 
 * Date: Feb 21, 2018 
 * Lab 02 
 * This labs uses the basics of methods and parameters
 */
public class Lab02 {

	public static void main(String[] args) {

		System.out.println("Task0");
		printStrings("Ned", 4);
		printStrings("Oswald", 2);
		printStrings("Geoff", 0);
		printStrings("Alfred", 7);

		System.out.println();

		System.out.println("Task01");
		printPowersOfN(4, 3);
		printPowersOfN(5, 6);
		printPowersOfN(-2, 8);

		System.out.println();

		System.out.println("Task02");
		printSquare(3, 6);
		printSquare(6, 3);

		System.out.println();

		System.out.println("Task03");
		quadratic(1, -7, 12);

		System.out.println();

		System.out.println("Task04");
		vertical("hey you");

		System.out.println();

		System.out.println("Task05");
		padString("hello", 8);
		padString("congratulations", 15);

	}

	/**
	 * This method has names repeat x amount of times 
	 * @param s		the name to be repeated
	 * @param n		the int that repeats the name x amount of times
	 */
	public static void printStrings(String s, int n) {
		for (int i = 1; i <= n; i++) {
			System.out.print(s);
		}
		System.out.println();
	}

	/**
	 * This method raises numbers to a power 
	 * @param base	the int to be raised to a power
	 * @param exp 	the int that raises the base to the x power
	 */
	public static void printPowersOfN(int base, int exp) {
		for (int i = 0; i <= exp; i++) {
			System.out.print((int) Math.pow(base, i));
			System.out.print(" ");

		}
		System.out.println();
	}

	/**
	 * This method creates a pattern with numbers form min to max
	 * @param min	sets the lowest number
	 * @param max 	sets the highest number
	 */
	public static void printSquare(int min, int max) {
		for (int i = min; i <= max; i++) {

			for (int j = i; j <= max; j++) {
				System.out.print(j);

			}

			for (int k = min; k < i; k++) {
				System.out.print(k);
			}
			System.out.println();

		}

	}

	/**
	 * This method creates the quadratic formula
	 * @param a		creates the first int
	 * @param b		creates the second int
	 * @param c		creates the third int
	 */
	public static void quadratic(int a, int b, int c) {
		double squar = (b * b - 4 * a * c);
		double rootone = ((-b + squar) / 2);
		double roottwo = ((-b - squar) / 2);
		System.out.println("First root = " + rootone);
		System.out.println("Second root = " + roottwo);
	}

	/**
	 * This method creates words that are spelt vertically
	 * @param s		the word that is to be spelt
	 */
	public static void vertical(String s) {
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			System.out.println(c);
		}
		System.out.println();
	}

	/**
	 * This method uses ints to create spaces in front of words
	 * @param s		the word that is to be displayed
	 * @param n		the int that determines the amount of spaces
	 */
	public static void padString(String s, int n) {
		String spaces = "";
		for (int i = 1; i <= (n - s.length()); i++) {
			spaces += " ";
		}
		System.out.println(spaces + s);
	}
}
