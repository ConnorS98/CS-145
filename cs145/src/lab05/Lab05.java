package lab05;

import java.util.*;

public class Lab05 {

	public static void main(String[] args) {

		Scanner console = new Scanner(System.in);

		System.out.println("Task00");
		pay(5.50, 6);
		pay(4.00, 11);

		System.out.println();

		 System.out.println("Task01");
		 longestName(console, 6);
		
		 System.out.println();

		System.out.println("Task02");
		wordCount("hello");
		wordCount("how are you?");
		wordCount("  this string  has  wide  spaces  ");
		wordCount(" ");

		 System.out.println();
		
		 System.out.println("Task03");
		 printLetters(console);
		
		 System.out.println();
		 System.out.println();

		 System.out.println("Task04");
		 quadrant(console);

		 System.out.println();

		 System.out.println("Task05");
		 isAllVowels("jerry");
		 isAllVowels("aeiou");
		 isAllVowels("aei");
		 isAllVowels("");
		 

		 System.out.println();

		 askForWords(console);
	}
/**
 * this method figures a persons salary
 * @param salary how much they make
 * @param hours  how much they worked
 * @return the amount the are to be paied
 */
	public static double pay(double salary, int hours) {

		double money = 0;
		if (hours <= 8) {
			money = salary * hours;
			System.out.println("pay: " + money);
		} else {
			double overtime = hours - 8;
			double overpay = salary * 1.5;
			money = overtime * overpay + salary * 8;
			System.out.println("pay: " + money);

		}
		return money;
	}
/**
 * this method figures out the person a longest name
 * @param console  the users input of names
 * @param n  the amount of names to be entered
 */
	public static void longestName(Scanner console, int n) {
		int oldLength = 0;
		String max = "";
		int num = 0;
		if (n > 0) {
			for (int i = 1; i <= n; i++) {
				System.out.print("Name # " + i + "? ");
				String name = console.next();

				int newLength = name.length();
				if (newLength > oldLength) {
					oldLength = newLength;
					max = name;
					num = newLength;
				}
			}
			String name = max.toLowerCase();
			String firstLetter = name.substring(0, 1);
			String firstLetterCap = firstLetter.toUpperCase();
			String secondPart = name.substring(1, num);
			System.out.println(firstLetterCap + secondPart + "'s name is the longest");
		} else {
			System.out.println();
		}
	}
/**
 * this method counts words in the string
 * @param word  the users choice of words
 * @return  the amount of words in the string
 */
	public static int wordCount(String word) {
		int count = 0;
		
		for(int i = 0; i < word.length() - 1; i++) {
			
			if((word.charAt(i) == ' ') && (word.charAt(i + 1) != ' ')) {
				
				count++;
			} 

		}
		if(word.charAt(0) != ' ') {
			count++;
		}
		System.out.println(count);
		return count;
	}

	

	
/**
 * this method puts a comma between each letter
 * @param console  input of word form user
 * @return	the user input with commas in between
 */
	public static String printLetters(Scanner console) {
	
	 
		System.out.print("Enter a word: ");
		String s = console.next();
		System.out.print(s.charAt(0));
		for(int i = 1; i < s.length(); i++) {
			System.out.print(", " + s.charAt(i));
			
		}
		
	
	
		return s;
	}
/**
 * this method tells the quadrent of a point 
 * @param console    user inputs a point
 * @return		the quadrent the point is in
 */
	public static int quadrant(Scanner console) {
		System.out.print("Coordinate?");
		double jj = console.nextDouble();
		double kk = console.nextDouble();
		int num = 0;
		
		if (jj > 0 && kk > 0) {
			num = 1;
		} else if ( jj > 0 && kk < 0) {
			num = 4;
		} else if ( jj < 0 && kk < 0) {
			num = 3;
		} else if ( jj < 0 && kk > 0) {
			num = 2;
		} 
		
		System.out.println("Quadrant: " + num);
		
		return num;
	}
/**
 * this method accpets words that are only vowels
 * @param word	the input form the user
 * @return  true or false until only vowels are in the input
 */
	public static boolean isAllVowels(String word) {
		
		char a = 'a';
		char e = 'e';
		char i = 'i';
		char o = 'o';
		char u = 'u';
		
		if (word.isEmpty()) {
			return true;
		}
		
		for(int j = 0; j < word.length(); j++) {
			
			if ((word.charAt(j) != a) && (word.charAt(j) != e) && ( word.charAt(j) != i) && (word.charAt(j) != o) && (word.charAt(j) != u)) {
				return false;
 			} 
		}
		return true;
	}

	public static void askForWords(Scanner console) {
	
		System.out.print("Enter a word: ");
		String word = console.next();
		String lWord = word.toLowerCase();
		while(!isAllVowels(lWord)) {
			System.out.println();
			System.out.print("Enter a word: ");
			word = console.next();
			lWord = word.toLowerCase();
		}
		
		System.out.println("Finally all vowels, we are done.");
	}
	

}