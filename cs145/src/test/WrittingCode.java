package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class WrittingCode {

	public static void main(String[] args) throws FileNotFoundException{
		
		Scanner input = new Scanner(new File("pizza.txt"));
		
		String[] a = {"four", "score", "and", "seven", "years", "ago"};
//		String[] a = {"to", "be", "or", "not", "to", "be", "hamlet"};
		swapPairs(a);
		
//	countWords(input);

	}
	public static void countWords(Scanner input) {
		
		int lineCount = 0;
		int wordCount = 0;
		
		
		while (input.hasNextLine()) { // while you have lines
			String line = input.nextLine(); // grab line
			lineCount++;
			
			Scanner lineScan = new Scanner(line);
			while (lineScan.hasNext()) { // while line has words
				String word = lineScan.next(); // grab word
				wordCount++;
			}
		}
		System.out.println("Total lines = " + lineCount);
		System.out.println("Total words = " + wordCount);
		System.out.printf("Average words per line = %.3f \n", 1.0 * +wordCount/lineCount);
		
	}
	public static void swapPairs(String[] a) {
		for(int i = 0; i < a.length - 1; i++) {
			String temp = a[i];
			a[i] = a[i+1 ];
			a[i+1] = temp;
			i++;
		}
		System.out.println(Arrays.toString(a));
	}

}
