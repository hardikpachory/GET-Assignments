package assignment_5;

import java.util.Scanner;

public class MathsHcfAndLcm {
	static int x;
	static int y;
	
	/**
	 * Take input from the user, and execute the required function
	 */
	static void getInputAndExecute() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter value of X: ");
		x = sc.nextInt();
		System.out.println("Enter value of Y: ");
		y = sc.nextInt();
		System.out.println(" --- Main Options --- ");
		System.out.println("1. LCM");
		System.out.println("2. HCF");
		System.out.println("3. Both");
		System.out.println("Enter choice: ");
		int choice = sc.nextInt();
		if(choice == 1) {
			System.out.println("HCF(X, Y) : " + getHCF(x, y));
		} else if(choice == 2) {
			System.out.println("LCM(X,Y) : " + getLCM(x, y));
		} else if(choice == 3) {
			System.out.println("HCF(X, Y) : " + getHCF(x, y));
			System.out.println("LCM(X,Y) : " + getLCM(x, y));
		}
		sc.close();
	}
	
	/**
	 * Returns the Highest Common Factor of two numbers
	 * @param a An integer, requires a must be smaller
	 * @param b An integer, require b must be greater
	 * @return The HCF of the two numbers
	 */
	static int getHCF(int a, int b) {
		if(a>b) { //Swapping the numbers if a>b
			int c = a;
			a=b;
			b=c;
		}
		return ((b%a) == 0) ? a : getHCF(b%a, a);
	}
	
	/**
	 * Returns the Lowest Common Multiple of two numbers
	 * @param a An integer, requires a must be smaller
	 * @param b An integer, requires b must be greater
	 * @return  The LCM of the two numbers
	 */
	static int getLCM(int a, int b) {
		if(a>b) { //Swapping the numbers if a>b
			int c = a;
			a=b;
			b=c;
		}
		int HCF = getHCF(a,b);
		return (a*b)/HCF;
	}
	
	public static void main(String[] args) {
		getInputAndExecute();
	}
	
}
