package test;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		
		int x = 1;
		int[] a = new int[4];
		
		x++;
		a[x - 1] = 3;
		mystery(x,a);
		System.out.println(x + " " + Arrays.toString(a));
		
		x++;
		a[x - 1] = 2;
		mystery(x,a);
		System.out.println(x + " " + Arrays.toString(a));
		
		
//		int[] a = {5,5,5,6,5,5,5};
//		arrayMystery(a);
	}
	
	public static void mystery(int x, int[] a) {
		a[x]++;
		x--;
		a[x - 1] = a[x + 1];
		System.out.println(x + " " + Arrays.toString(a));
	}
	
	
	public static void arrayMystery(int[] a) {
			for(int i = a.length - 1; i >= 0; i--) {
			if (a[i] == a[a.length - i - 1]) {
				a[i]++;
				a[a.length - i - 1]++;

			}
		}
			System.out.print(Arrays.toString(a));
	}

}
