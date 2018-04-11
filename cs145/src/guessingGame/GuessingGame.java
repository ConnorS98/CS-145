package guessingGame;

import java.util.*;

/**
* Connor Huffman 
* Date: 3/27/2018 
* Homework 03: Guessing Game
* This assignment focuses on while loops and random numbers.
*/


public class GuessingGame {

	public static final int maxnumber = 100;
	public static int totalGames = 0;
	public static int totalGuesses = 0;
	public static int bestGame = 1000000;

	public static void main(String[] args) {
		
		Scanner console = new Scanner(System.in);

		System.out.println("here is a puzzle \ntry if you may to solve me \nbut i bet you won't");

		System.out.println();
		
		playgame(console);
		playagain(console);
		stats();
	}
/**
 * plays the game
 * @param console	you guess
 */
	public static void playgame(Scanner console) {
		
		Random rand = new Random();
		int randomNumber = rand.nextInt(maxnumber) + 1;
		
		int i = 0;
		System.out.println("I'm thinking of a number between 1 and " + maxnumber);
		
		int count = 0;
		
		while (i != randomNumber) {
			System.out.print("Your guess? ");
			int guess = console.nextInt();
				if (guess > randomNumber) {
					System.out.println("It's lower.");
					count++;
					totalGuesses++;
				} else if ( guess < randomNumber) {
						System.out.println("It's higher.");
						count++;
						totalGuesses++;
					} else if (guess == randomNumber){
							i = randomNumber;
							count++;
							totalGuesses++;
						}
		}
		
		if (bestGame > count) {
			bestGame = count;
		}
		System.out.println("You got it right in " + count + " guesses!");
		totalGames++;
				
	}
	/**
	 * Asks to play again
	 * @param console	reads if you say "y" or "n"
	 */
	public static void playagain(Scanner console) {
		
		System.out.print("Do you want to play again? ");
		String answer = console.next();
		System.out.println();
			while (answer.startsWith("y") || answer.startsWith("Y")) {
					playgame(console);
					System.out.print("Do you want to play again? ");
					answer = console.next();
					System.out.println();
			}
				
	}
	/**
	 * This method prints out the statistics 
	 */
	public static void stats() {
		System.out.println("Overall results: ");
		System.out.println("Total games   = " + totalGames);
		System.out.println("Total guesses = " + totalGuesses);
		
		double gperg = (totalGuesses * 1.0) / totalGames;
		System.out.printf("Guesses/Game  = %.1f \n", gperg);
		System.out.println("Best Game     = " + bestGame);
	}
}