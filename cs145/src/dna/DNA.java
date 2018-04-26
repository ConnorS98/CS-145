package dna;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Pattern;
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
	public static double junkMass = 100.000;
	public static int junk = 0;
	public static int minimumCodons = 5;
	public static int percentageCG = 30;
	public static int minCodon = 3;
	public static double[] percent = new double[4];
	public static int[] nucleotides = new int[4];


	public static void main(String[] args) throws FileNotFoundException {

		Scanner console = new Scanner(System.in);
		System.out.print("Input file name? ");
		String filename = console.nextLine();
		Scanner input = new Scanner(new File("dna.txt"));

		PrintStream output = new PrintStream(new File("outputdna.txt"));

		tallyVotes(output, input);

	}
	public static int[] tallyVotes(PrintStream output, Scanner input) { // counts the a, t, c, g 
		int count = 0;
		String[] codons = null;
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
				codons = new String[wordForCodon.length() / 3];

				if (count % 2 == 0) {
					output.print("Nucleotides: " + word + " ");
					for(int j = 0; j < wordForCodon.length() / 3; j ++) { //loop over codons[]
						String codon = "";
						for (int w = j * 3; w <= j * 3 + 2; w++) {
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
					}// ends else if
				} // ends for
				output.println("Nuc. Counts: " + Arrays.toString(nucleotides));
				totalMass(nucleotides, output);
				output.println(Arrays.toString(codons));
				protein(codons, input, output, percent);
				nucleotides = new int[4];
			} // ends outer if
			
	} // ends outer while
		return nucleotides;

} //ends class
	
	
	

		public static void totalMass(int[] nucleotides, PrintStream output) {
			double junkTotal = (junk * junkMass); //mass of junk
			double[] masses = {adenineMass, cytosineMass, guanineMass, thymineMass};
			double total = junkTotal;
			

			for(int i = 0; i < nucleotides.length; i++) {
				percent[i] = (double) (nucleotides[i] * masses[i]);
				total += percent[i]; //adds to the total mass
			}
			
			for(int i = 0; i < nucleotides.length; i++) {
				percent[i] = (100.0 * percent[i]) / total;
				percent[i] = Math.round(percent[i] * 10.0) /10.0;
			}
			
			output.println("Total Mass%: " + Arrays.toString(percent) + " of " + Math.round(total * 10.0) / 10.0);
			junk = 0;
		}
		
		public static boolean protein(String[] codons, Scanner input, PrintStream output, double[] percent) {
			if(!codons[0].equals("ATG")){
				output.println("Is Protein: NO");
				return false;
			} else if(!codons[codons.length - 1].equals("TAA") && !codons[codons.length - 1].equals("TAG") && !codons[codons.length - 1].equals("TGA")) {
				output.println("Is Protein: NO");
				return false;	
			} else if (codons.length < minimumCodons) {
				output.println("Is Protein: NO");
				return false;
			} else if(percent[1] + percent[2] < percentageCG) {
				System.out.println(percent[1] + percent[2]);
				output.println("Is Protein: NO");
				return false;
			} 
			output.println("Is Protein: YES");
			
			return true;
			
		}
}

