package labo5;
/**
* Connor Huffman 
* Date: 2/19/2018 
* Lab05
* using returns, methods, scanners, while loops, and if/else statements
*/

import java.util.*;

public class Lab05 {

	public static void main(String[] args) {

		Scanner console = new Scanner(System.in);
		
		System.out.println("Task 0");
		String a = withoutString("Mississippi" , "IS");
		System.out.println(a);
		String b = withoutString("Heather" , "He");
		System.out.println(b);
		String c = withoutString("Xxxxx" , "xx");
		System.out.println(c);
		String d = withoutString("Hello there", "X");
		System.out.println(d);
		
		System.out.println();
		
		System.out.println("Task 1");
		int q = digitSum(5555);
		System.out.println(q);
		int w = digitSum(12345);
		System.out.println(w);
		int e = digitSum(0);
		System.out.println(e);
		int r = digitSum(-1313);
		System.out.println(r);
		askUntilSumIsGreaterThan30(console);
		
		System.out.println();
		
		System.out.println("Task 2");
		System.out.println(hasAnOddDigit(1115));
		System.out.println(hasAnOddDigit(894));
		System.out.println(hasAnOddDigit(4268));
		System.out.println(hasAnOddDigit(0));
		lookingFor2IntsWithAnOddDigit(console);
	}
	/**
	 * This method replaces chars in a string with new chars
	 * @param base		The initial string
	 * @param remove	The chars to replace it with
	 * @return			The String with the new chars
	 */
	public static String withoutString(String base, String remove) {
		
		return base.toLowerCase().replace(remove.toLowerCase(), "");
		
	}
	public static int digitSum(int x) {
		
		x = Math.abs(x);
		int sum = 0;
		while(x > 0) {
			sum = sum +(x%10);
			x= x/10;
		}
		return sum;
	}
	/**
	 * This method tells you if int's added together are equal to or less than 30
	 * @param console	the input from the user
	 */
	public static void askUntilSumIsGreaterThan30(Scanner console) {
		
		int kk = 0;
		digitSum(kk);
			while(digitSum(kk) <= 30) {
				System.out.print("Enter an integer: ");
				int jj = console.nextInt();
				kk = jj;
			}
			
			System.out.println("Finally digits greater than 30.");
	}
	/**
	 * This is a helper method that tells me if a number has odd int's in it
	 * @param number	the number to be checked
	 * @return			returns true if the # has a odd int in it fails otherwise
	 */
	public static boolean hasAnOddDigit(int number) {
		
		
		while (number != 0) {
			if (number %2 != 0) {
				return true;
			}
			number = number / 10;
		}
		return false;
	}
	/**
	 * This method requires two numbers to have odd int's to pass
	 * @param console	the input form the user, a int
	 * @return			true once two numbers have been passed with odd int's
	 */
	public static boolean lookingFor2IntsWithAnOddDigit(Scanner console) {
		
		int count = 0;
		while (count < 2) {
			System.out.print("Enter an integer: ");
			int number = console.nextInt();
			if (hasAnOddDigit(number)) {
				count++;
			}
		}
		System.out.println("You have finally entered two integers that have at least one odd digit in them.");
		return true;
		
	
		
	}
}