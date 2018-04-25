package dna;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Connor Huffman Date 4/12/2018 Homework 04 Mad Libs This assignment focuses on
 * using arrays
 */

public class DNA {

	public static double adenineMass = 135.128;
	public static double cytosineMass = 111.103;
	public static double guanineMass = 151.128;
	public static double thymineMass = 125.107;
	public static double junk = 100.000;

	public static void main(String[] args) throws FileNotFoundException {

		Scanner console = new Scanner(System.in);
		System.out.print("Input file name? ");
		String filename = console.nextLine();
		Scanner input = new Scanner(new File("dna.txt"));

		PrintStream output = new PrintStream(new File("outputdna.txt"));

//		tallyVotes(output, input);
		totalMass(output, input);

	}
	public static int[] tallyVotes(PrintStream output, Scanner input) {
		int count = 0;
		int[] nucleotides = new int[4];
		while (input.hasNextLine()) { // while you have lines
			String line = input.nextLine(); // grab line
			count++;
			Scanner lineScan = new Scanner(line);
			if (count % 2 != 0) { // odd lines
				output.print("Region Name: ");
			}
			while (lineScan.hasNext()) { // while line has words
				String word = lineScan.next(); // grab word
				if (count % 2 == 0) {
					output.print("Nucleotides: " + word + " ");
				} else {
					output.print(word + " ");
				}
			}
			output.println();
			if (count % 2 == 0) { // even lines
				for (int i = 0; i < line.length(); i++) {
					if (line.charAt(i) == 'a' || line.charAt(i) == 'A') {
						nucleotides[0]++;
					} else if (line.charAt(i) == 'c' || line.charAt(i) == 'C') {
						nucleotides[1]++;
					} else if (line.charAt(i) == 'g' || line.charAt(i) == 'G') {
						nucleotides[2]++;
					} else if (line.charAt(i) == 't' || line.charAt(i) == 'T') {
						nucleotides[3]++;
					} // ends else if
				} // ends for
				output.println("Nuc. Counts: " + Arrays.toString(nucleotides));
			} // ends outer if
			
	} // ends outer while
//		System.out.println(Arrays.toString(nucleotides));
		return nucleotides;

} //ends class
	
	
	

		public static int[] totalMass(PrintStream output, Scanner input) {
			int[] nucleotides = new int[4];
			nucleotides = tallyVotes(output, input);
//			System.out.println(Arrays.toString(nucleotides));
			double[] masses = {adenineMass, cytosineMass, guanineMass, thymineMass};
			for(int i = 0; i < nucleotides.length; i++) {
				masses[i] = (double) (nucleotides[i] * masses[i]);
			}
			
			output.print("Total Mass%: " + Arrays.toString(masses));	

			return null;
	
		}
}
