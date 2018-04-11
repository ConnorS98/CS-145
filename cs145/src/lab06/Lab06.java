package lab06;

/**
* Connor Huffman 
* Date: 2/26/2018 
* Lab06
* importing acn changing files and stuff
*/

import java.util.*;
import java.io.*;

public class Lab06 {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner input = new Scanner(new File("wordCount.txt"));
		printDuplicates(input);
		Scanner input2 = new Scanner(new File("headsOrTails.txt"));
		coinFlip(input2);
		Scanner in = new Scanner(new File("leetIn.txt"));
		PrintStream out = new PrintStream(new File("leetOut.txt"));
		leetSpeak(in, out);
	}
/**
 * This method takes in a file and counts if you win
 * @param input2 accepts the file of headsOrTails.txt
 */
	public static void coinFlip(Scanner input2) {
		
		while (input2.hasNextLine()) {
			String line = input2.nextLine();
			Scanner lineScan = new Scanner(line);
			int countH = 0;
			int countT = 0;
			while (lineScan.hasNext()) {
				String token = lineScan.next();
				if (token.equalsIgnoreCase("t")) {
					countT++;
				} else if (token.equalsIgnoreCase("h")) {
					countH++;
				}
				

			}// end of loop over each line
				double percent = 100.0 * countH / (countH + countT);
				System.out.printf("%d heads (%.1f%%) \n", countH, percent);
				System.out.println();
				if (countH > countT) {
					System.out.println("you win!");
					System.out.println();
				} 
		}// end of loop over file contents
	}

	/**
	 * This task counts how many times a word is repeated in a row
	 * @param input the file
	 */
	public static void printDuplicates(Scanner input) {
		while (input.hasNextLine()) { // while you have lines
			String line = input.nextLine(); // grab line
			Scanner lineScan = new Scanner(line);
			String token = lineScan.next(); // grab word
			int count = 1;
			while (lineScan.hasNext()) { // while there are tokens
				String token2 = lineScan.next(); // grab the next token to right
				if (token.equals(token2)) {
					count++;
				}
				if (count > 1 && (!lineScan.hasNext() || !token.equals(token2))) {
					// if you are last word in the line or the token to right not same
					System.out.print(token + "*" + count + " ");
					count = 1;
				}
				token = token2;
			} // ends inner while loop
			System.out.println();
		} // outer while
		
	}
	/**
	 * this method accepts a file and creates a new file with differences
	 * @param in 	a file with words
	 * @param out	a file that changes some of the characters
	 */
	public static void leetSpeak(Scanner in, PrintStream out) {
		while (in.hasNextLine()) { // while you have lines
			String line = in.nextLine(); // grab line
			Scanner lineScan = new Scanner(line);
			while(lineScan.hasNext()) { //while line has words
				String word = lineScan.next(); // grab word
				out.print("(");
				for (int ii = 0; ii < word.length(); ii++) { // iterate over chars in word
					char ch = word.charAt(ii);
					if (ch == 'o') {
						out.print('0');	
					} else if (ch == 'l') {
						out.print('1');
					} else if (ch == 'e') {
						out.print('3');
					} else if (ch == 'a') {
						out.print('4');
					} else if (ch == 't') {
						out.print('7');
					} else if (ch == 's' && ii == word.length() - 1) {
						out.print('Z');	
					} else {
						out.print(ch);
					}
				}

				out.print(") ");
			} // end word
			out.print("\n");

		} // end line

	} // end leetSpeak()
	
	
}