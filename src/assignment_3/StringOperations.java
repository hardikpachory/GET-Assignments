package assignment_3;

import java.util.Scanner;

public class StringOperations {
	
	static Scanner sc = new Scanner(System.in);
	
	/**
	 * Check for the equality of two strings
	 * @param firstString   first string to be compared, requires must not be null
	 * @param secondString  second string to be compared, requires must not be null
	 * @return              if strings are equal then 1 otherwise 0
	 */
	static int isEqual(String firstString, String secondString) {
		if(firstString.length() != secondString.length()) {
			return 0;
		} else {
			int length = firstString.length();
			char firstStringChar;
			char secondStringchar;
			for(int i=0; i<length; i++) {
				firstStringChar = firstString.charAt(i);
				secondStringchar = secondString.charAt(i);
				if(firstStringChar != secondStringchar) {
					return 0;
				}
			}
		}
		return 1;
	}
	
	/**
	 * Convert the string into reverse order
	 * @param string The string that is to be reversed, requires must not be null
	 * @return       the string in reverse order
	 */
	static String reverseString(String string) {
		String reversedString = "";
		int lastPosition = string.length()-1; 
		for(int i= lastPosition; i>=0; i--) {
			reversedString += string.charAt(i);
		}
		return reversedString;
	}
	
	/**
	 * Convert the upper case letters of the string to lower case
	 * and lower case letters to upper case
	 * @param string String on which operation is performed, requires must not be null
	 * @return       String in toggled upper and lower cases
	 */
	static String toggleCase(String string) {
		String toggledString = "";
		int length = string.length();
		char stringChar;
		for(int i=0; i<length; i++) {
			stringChar = string.charAt(i);
			if(stringChar>='a' && stringChar <= 'z') {
				toggledString += Character.toUpperCase(stringChar);
			} else if(stringChar>='A' && stringChar <= 'Z') {
				toggledString += Character.toLowerCase(stringChar);
			}
		}
		return toggledString;
	}
	
	/**
	 * Returns the largest word present in the string
	 * @param string String on which operation is performed, requires must not be null
	 * @return       largest/longest word present in the string
	 */
	static String getLargestWord(String string) {
		int largestCount = 0;
		int currentLength = 0;
		int index = 0;
		String largestWord = "";
		int length = string.length();
		int iterate = 0;
		// hardik is sdfhduadfadfdas
		while(iterate<length) {
			while(iterate<length && string.charAt(iterate)!=' ') {
				currentLength++;
				iterate++;
			}
			if(currentLength > largestCount) {
				largestCount = currentLength;
				index = iterate - currentLength;
			}
			currentLength = 0;
			iterate++;
		}
		for(int i=1; i<=largestCount; i++) {
			largestWord += string.charAt(index++);
		}
		return largestWord;
	}
	public static void main(String[] args) {
		String stringOne;
		String stringTwo;
		int choice=0;
		while(choice!=5) {
			System.out.println("----   Main Options   ----");
			System.out.println("1. Compare Strings");
			System.out.println("2. Reverse a String");
			System.out.println("3. Toggle Upper/Lower cases");
			System.out.println("4. Get longest word");
			System.out.println("5. Exit");
			System.out.println("Enter Choice: ");
			choice=sc.nextInt();
			sc.nextLine();
			switch(choice) {
				case 1: System.out.print("Enter first String: ");
						stringOne = sc.nextLine();
						System.out.print("Enter second String: ");
						stringTwo = sc.nextLine();
						System.out.println("Equality Check: " + isEqual(stringOne, stringTwo));
						break;
				case 2:	System.out.print("Enter first String: ");
						stringOne = sc.nextLine();
						stringTwo = reverseString(stringOne);
						System.out.println("Reversed String: " + stringTwo);
						break;
				case 3: System.out.print("Enter String to be toggled: ");
						stringOne = sc.nextLine();
						stringTwo = toggleCase(stringOne);
						System.out.println("Toggled String: " + stringTwo);
						break;
				case 4: System.out.print("Enter String: ");
						stringOne = sc.nextLine();
						stringTwo = getLargestWord(stringOne);
						System.out.println("Longest Word: " + stringTwo);
						break;
				case 5: System.exit(0);
						break;
				default: System.out.println("Invalid choice, enter again");
			}
			System.out.println();
		}
		sc.close();
	}

}
