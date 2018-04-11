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

		System.out.println("Welcome to the game of Mad Libs.\n" + " I will ask you to provide various words \n"
				+ " and phrases to fill in a story.\n" + " The result will be written to an output file.");

		
		
		Scanner input = new Scanner(new File("simple.txt"));
		PrintStream out = new PrintStream(new File("simply.txt"));
		wordInput(input, out);
//		options(input);
//		wordInput(input);
	}

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
						out.println(response);
					} else if (word.startsWith("e")) {
						System.out.print("Please type an " + word + ": ");
						response = prompt.next();
						out.println(response);
					} else if (word.startsWith("i")) {
						System.out.print("Please type an " + word + ": ");
						response = prompt.next();
						out.println(response);
					} else if (word.startsWith("o")) {
						System.out.print("Please type an " + word + ": ");
						response = prompt.next();
						out.println(response);
					} else if (word.startsWith("u")) {
						System.out.print("Please type an " + word + ": ");
						response = prompt.next();
						out.println(response);
					} else
						System.out.print("please type a " + word + ": ");
						response = prompt.next();
						out.println(response);
				} else {
					out.print(word);
				}
			}
			
		}
		out.println("Your Mad-lib has been created!");
	}
	public static void options(Scanner input) {
		Scanner prompt = new Scanner(System.in);
		String response = "";
		System.out.println("(C)reate mad-lib, (V)iew mad-lib, (Q)uit?");
		response = prompt.next();
			if (response)
		
		
			
			
			
		
	}
}
