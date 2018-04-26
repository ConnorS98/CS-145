package madLibs;

/**
 * Connor Huffman
 * Date 4/12/2018
 * Homework 04 Mad Libs
 * This assignment focuses on input and output files and Strings 
 */

import java.io.*;
import java.util.Scanner;

public class MadLib {

	public static void main(String[] args) throws FileNotFoundException {

		
		intro();
		options();
		
	}
/**
 * This method pulls the tokens form the file and asks the user for a word
 * to place back into the file
 * @param input the file
 * @param out   the new file created
 */
	public static void wordInput(Scanner input, PrintStream out) {
		Scanner prompt = new Scanner(System.in); // scanner for user input
		String response = "";

		while (input.hasNextLine()) { // while you have lines
			String line = input.nextLine(); // grab line
			Scanner lineScan = new Scanner(line);

			while (lineScan.hasNext()) { // while line has words
				String word = lineScan.next(); // grab word
				if (word.startsWith("<")) {
					word = word.substring(1, word.length() - 1);

					if (word.startsWith("a")) {
						System.out.print("Please type an " + word + ": ");// asks user for a ""
						response = prompt.next();
						out.print(response + " ");
					} else if (word.startsWith("e")) {
						System.out.print("Please type an " + word + ": ");
						response = prompt.next();
						out.print(response + " ");
					} else if (word.startsWith("i")) {
						System.out.print("Please type an " + word + ": ");
						response = prompt.next();
						out.print(response + " ");
					} else if (word.startsWith("o")) {
						System.out.print("Please type an " + word + ": ");
						response = prompt.next();
						out.print(response + " ");
					} else if (word.startsWith("u")) {
						System.out.print("Please type an " + word + ": ");
						response = prompt.next();
						out.print(response + " ");
					} else {
						System.out.print("please type a " + word + ": ");
						response = prompt.next();
						out.print(response + " ");
					}
				} else {
					if (lineScan.hasNext()) {
						out.print(word + " ");
					} else {
						out.print(word + "\n");
					}
				}
			}

		}
		System.out.print("Your Mad-lib has been created!");
	}
/**
 * This method creates the menue bar for the user to navicage what to do
 * @throws FileNotFoundException  helps keep everything running smoothly
 */
	public static void options() throws FileNotFoundException {
		Scanner prompt = new Scanner(System.in);
		String response = "";
		System.out.print("(C)reate mad-lib, (V)iew mad-lib, (Q)uit? ");
		response = prompt.next();
		boolean isSuccessful = false;
		Scanner input = null;

		if (response.startsWith("C") || (response.startsWith("c"))) {
			System.out.print("Input file name: ");
			String fileName = prompt.next();
			PrintStream out = null;
			String outFile = null;
			while (!isSuccessful) {
				try {
					input = new Scanner(new File(fileName));
					isSuccessful = true;
				} catch (FileNotFoundException e) {
					System.out.print("File not found. Try again: ");
					fileName = prompt.next();
				}
			}
			System.out.print("Output file name: ");
			outFile = prompt.next();
			out = new PrintStream(new File(outFile));
			wordInput(input, out);
			
		} else if (response.equals("V") || response.equals("v")) {
			boolean isSuccess = false;
			// feed the view method a file to view
			System.out.print("Input file name: ");
			String outFile = prompt.next();
			while (!isSuccess) {
				try {
					input = new Scanner(new File(outFile));
					isSuccess = true;
				} catch (FileNotFoundException e) {
					System.out.print("File not found. Try again: ");
					outFile = prompt.next();
				}
			}
			view(input);
		} else if (response.equals("Q") || response.equals("q")) {
			System.out.println();
		} else {
			options();
		}

	}
/**
 * This method reads the file and prints it to the console
 * @param file		the file to be read
 * @throws FileNotFoundException  makes sure that things don't die horribly 
 */
	public static void view(Scanner file) throws FileNotFoundException {
		while (file.hasNextLine()) { // while you have lines
			String line = file.nextLine();
			System.out.println(line);
		}
	}
/**
 * This method greats you so you know whats going on here man
 */
	public static void intro() {
		System.out.println("Welcome to the game of Mad Libs.\n" + "I will ask you to provide various words \n"
				+ "and phrases to fill in a story.\n" + "The result will be written to an output file.");
	}
}