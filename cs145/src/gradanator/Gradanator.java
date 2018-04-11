package gradanator;

/**
 *  Author: Connor Huffman 
 * Date: Mar. 13, 2018 
 * Homework 02
 * Description: This program uses if/else statements returns and 
 * scanner values.  It computes a students course grade using their
 * midterm, final, and homework grades.
 * 
 */

import java.util.Scanner;

public class Gradanator {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		description();
		double midtermScore = midterm("Midterm:", input);
		double finalScore = midterm("Final:", input);
		double homeworkScore = homework(input);

		grade(midtermScore, finalScore, homeworkScore);
	}
/**
 * This method calculates the midterm and final grade
 * @param word		will allow distinction between midterm and final
 * @param input		the input form the user for scores
 * @return			returns their weighted grade to calculate thier total grade
 */
	public static double midterm(String word, Scanner input) {

		System.out.println();

		System.out.println(word);
		System.out.print("Weight (0-100)? ");
		int jj = input.nextInt();

		int weight = jj;

		System.out.print("Score earned? ");
		jj = input.nextInt();

		int score = jj;

		System.out.print("Were scores shifted (1=yes, 2=no)? ");

		int shift = 0;

		jj = input.nextInt();
		if (jj == 1) {
			System.out.print("Shift amount? ");
			jj = input.nextInt();
			shift = jj;
		} else if (jj == 2) {
			System.out.print("");
		}

		int total = shift + score;
		if (total > 100) {
			total = 100;
		}

		System.out.println("Total points = " + total + " / 100");

		double weighted = weight * total / 100.0;

		System.out.printf("Weighted score = %.1f / %d", weighted, weight);

		System.out.println();

		return weighted;

	}
/**
 * This method calculates the homework grade
 * @param input		the users input for their grades
 * @return			returns the weighted grade for homework
 */
	public static double homework(Scanner input) {

		System.out.println();
		System.out.println("Homework:");
		System.out.print("Weight (0-100)? ");
		int jj = input.nextInt();

		int weight = jj;

		System.out.print("Number of assignents? ");
		int kk = input.nextInt();

		int one = 0;
		int two = 0;

		for (int i = 1; i <= kk; i++) {
			System.out.print("Assignment " + i + " score and max? ");
			int hh = input.nextInt();
			int ll = input.nextInt();

			one += hh;
			two += ll;
		}

		System.out.print("How many sections did you attened? ");
		jj = input.nextInt();

		int section = jj * 5;
		if (section > 30) {
			section = 30;
		}

		System.out.println("Section points = " + section + " / " + 30);

		int total = one + section;
		int over = two + 30;
		if (total > over) {
			total = over;
		}

		System.out.println("Total points = " + total + " / " + over);

		double weighted = 1.0 * weight * total / over;

		System.out.printf("Weighted score = %.1f / %d", weighted, weight);

		System.out.println();

		return weighted;
	}
/**
 * Calculates their over all grade for the class
 * @param midtermScore	the score they received on their midterm
 * @param finalScore	the score they received on their final
 * @param homeworkScore	the score they received on their homework
 * @return
 */
	public static double grade(double midtermScore, double finalScore, double homeworkScore) {

		double gpa = 0.0;
		double grade = midtermScore + finalScore + homeworkScore;
		if (grade >= 85) {
			gpa = 3.0;
		} else if (grade >= 75 && grade < 84.99) {
			gpa = 2.0;
		} else if (grade >= 60 && grade < 74.99) {
			gpa = 1.0;
		} else if (grade < 60) {
			gpa = 0.0;
		}
		String a = "";
		if (gpa == 3.0) {
			a = ("Yay for you, good job!");
		} else if (gpa == 2.0) {
			a = ("Not too bad, keep up the good work!");
		} else if (gpa == 1.0) {
			a = ("Don't worry, you'll get it eventually");
		} else if (gpa == 0.0) {
			a = ("Grades are only a letter, maybe next time.");
		}
		System.out.println();

		System.out.printf("Overall percentage =  %.1f", grade);

		System.out.println();

		System.out.println("Your grade will be at least: " + gpa);
		System.out.print(a);
		return grade;
	}
/**
 * the opening statement setting up the rest of the the program
 */
	public static void description() {
		System.out.println("This program reads exam/homeword scores \n" + "and reports your overall course grade");
	}
}