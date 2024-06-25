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
	
	public static void main(String[] args) {
		
	}

}
