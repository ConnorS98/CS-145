package dna;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.Arrays;

/**
 * Connor Huffman Date: April 26, 2018 Homework DNA Description: This program
 * focuses on the use of arrays. Storing, modifying, and changing arrays, so
 * that we can read the from an input file some good old DNA.
 */

public class DNA {

	public static double adenineMass = 135.128;
	public static double cytosineMass = 111.103;
	public static double guanineMass = 151.128;
	public static double thymineMass = 125.107;
	public static double junkMass = 100.000;
	public static int junk = 0;
	public static int minimumCodons = 5;
	public static int percentageCG = 30;
	public static int minCodon = 3;
	public static double[] percent = new double[4];
	public static int[] nucleotides = new int[4];
	public static String[] codons = null;

	public static void main(String[] args) throws FileNotFoundException {

		Scanner console = new Scanner(System.in);
		System.out.print("Input file name? ");
		String filename = console.nextLine();
		Scanner input = new Scanner(new File("dna.txt"));

		PrintStream output = new PrintStream(new File("outputdna.txt"));

		tallyVotes(output, input);
	}

	/**
	 * This method determines if a line requires a region name, prints out the
	 * Nucleotide sequence, and the Codons list.
	 * @param output output to the file
	 * @param input the input from the file
	 * @return returns the array nucleotides to reset it
	 */
	public static int[] tallyVotes(PrintStream output, Scanner input) { // counts the a, t, c, g
		int count = 0;
		while (input.hasNextLine()) { // while you have lines
			String line = input.nextLine(); // grab line
			count++;
			Scanner lineScan = new Scanner(line);
			if (count % 2 != 0) { // odd lines
				output.print("Region Name: ");
			}
			while (lineScan.hasNext()) { // while line has words
				String word = lineScan.next(); // grab word
				String wordForCodon = word.replaceAll(Pattern.quote("-"), "");
				wordForCodon = wordForCodon.toUpperCase();
				codons = new String[wordForCodon.length() / minCodon];

				if (count % 2 == 0) {
					output.print("Nucleotides: " + word + " ");
					for (int j = 0; j < wordForCodon.length() / minCodon; j++) { // loop over codons[]
						String codon = "";
						for (int w = j * minCodon; w <= j * minCodon + 2; w++) {
							codon += wordForCodon.charAt(w);
						}
						codons[j] = codon;
					}
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
					} else if (line.charAt(i) == '-') {
						junk++;
					} // ends else if
				} // ends for
				printToFile(output, codons, input);
				output.println();
				nucleotides = new int[4];
			} // ends outer if
		} // ends outer while
		return nucleotides;
	} // ends method

	/**
	 * This method calls all of the other methods to keep them in one area
	 * @param output to the file
	 * @param codons the array to be called
	 * @param input input form the file being read
	 */
	public static void printToFile(PrintStream output, String[] codons, Scanner input) {
		output.println("Nuc. Counts: " + Arrays.toString(nucleotides));
		totalMass(nucleotides, output);
		output.println("Codons List: " + Arrays.toString(codons));
		protein(codons, input, output, percent);
	}

	/**
	 * This method calculates the Total Mass% and total Mass of the Codons
	 * @param nucleotides the array with the nuc counts
	 * @param output to the file
	 */
	public static void totalMass(int[] nucleotides, PrintStream output) {
		double junkTotal = (junk * junkMass); // mass of junk
		double[] masses = { adenineMass, cytosineMass, guanineMass, thymineMass };
		double total = junkTotal;

		for (int i = 0; i < nucleotides.length; i++) {
			percent[i] = (double) (nucleotides[i] * masses[i]);
			total += percent[i]; // adds to the total mass
		}
		for (int i = 0; i < nucleotides.length; i++) {
			percent[i] = (100.0 * percent[i]) / total;
			percent[i] = Math.round(percent[i] * 10.0) / 10.0;
		}
		output.println("Total Mass%: " + Arrays.toString(percent) + " of " + Math.round(total * 10.0) / 10.0);
		junk = 0;
	}

	/**
	 * This method determines if it is a protein or not.
	 * 
	 * @param codons the array that is used for the codons of three
	 * @param input from the file
	 * @param output to the file
	 * @param percent the array that has the masses stored
	 * @return returns false if it fails horribly in a pit of doom and despair
	 */
	public static boolean protein(String[] codons, Scanner input, PrintStream output, double[] percent) {
		if (!codons[0].equals("ATG")) {
			output.println("Is Protein: NO");
			return false;
		} else if (!codons[codons.length - 1].equals("TAA") && !codons[codons.length - 1].equals("TAG")
				&& !codons[codons.length - 1].equals("TGA")) {
			output.println("Is Protein: NO");
			return false;
		} else if (codons.length < minimumCodons) {
			output.println("Is Protein: NO");
			return false;
		} else if (percent[1] + percent[2] < percentageCG) {
			output.println("Is Protein: NO");
			return false;
		}
		output.println("Is  Protein: YES");
		return true;
	}
}
