package assignment_3;

public class StringOperations {
	
	static String string;
	
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
	
	static String reverseString(String string) {
		String reversedString = "";
		int lastPosition = string.length()-1; 
		for(int i= lastPosition; i>=0; i--) {
			reversedString += string.charAt(i);
		}
		return reversedString;
	}
	
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
	
	static String getLargestWord(String string) {
		int largestCount = 0;
		int currentLength = 0;
		int index = 0;
		String largestWord = "";
		int length = string.length();
		int iterate = 0;
		System.out.println(string);
		while(iterate<length) {
			while(iterate<length && string.charAt(iterate)!=' ') {
				currentLength++;
				iterate++;
			}
			if(currentLength > largestCount) {
				largestCount = currentLength;
				index = iterate - currentLength;
			}
			System.out.println(currentLength + "   " + iterate + "   " + index);
			currentLength = 0;
			iterate++;
		}
		for(int i=1; i<=largestCount; i++) {
			largestWord += string.charAt(index++);
		}
		return largestWord;
	}
	public static void main(String[] args) {
		System.out.println(getLargestWord("Hello my name is Hardik and ROLLOVERPARTY"));
	}

}
