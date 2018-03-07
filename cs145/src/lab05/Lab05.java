package lab05;

import java.util.*;

public class Lab05 {

	public static void main(String[] args) {

		Scanner console = new Scanner(System.in);

		System.out.println("Task00");
		pay(5.50, 6);
		pay(4.00, 11);

		System.out.println();

		// System.out.println("Task01");
		// longestName(console, 5);
		//
		// System.out.println();

		System.out.println("Task02");
		wordCount("hello");
		wordCount("how are you?");
		wordCount("  this string  has  wide  spaces  ");
		wordCount(" ");

		// System.out.println();
		//
		// System.out.println("Task03");
		// printLetters(console);
		//
		// System.out.println();

		// System.out.println("Task04");
		// quadrant(console);

		// System.out.println();

		// System.out.println("Task05");
		// isAllVowels("jerry");

		// System.out.println();

		// askForWords(console);
	}

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

	

	

	public static String printLetters(Scanner console) {
	
	 
		System.out.print("Enter a word: ");
		String s = console.next();
		System.out.print(s.charAt(0));
		for(int i = 1; i < s.length(); i++) {
			System.out.print(", " + s.charAt(i));
			
		}
		
	
	
		return s;
	}

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

	public static boolean isAllVowels(String word) {
		
		String a = "a";
		String e = "e";
		String i = "i";
		String o = "o";
		String u = "u";
		
		
		if (word.contains(a) && word.contains(e) && word.contains(i) && word.contains(o) && word.contains(u)) {
			return true;
		}else if (word.isEmpty()){
			return true;
		}
		return false;
		
	}

	public static void askForWords(Scanner console) {
	
		System.out.print("Enter a word: ");
		String word = console.next();
		while(!isAllVowels(word)) {
			System.out.print("Enter a word: ");
			word = console.next();
		}
		
		System.out.println("Finally all vowels, we are done.");
	}

}