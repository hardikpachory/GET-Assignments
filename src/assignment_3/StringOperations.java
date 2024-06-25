package assignment_3;

public class StringOperations {

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
	
	public static void main(String[] args) {
		System.out.println(isEqual("abc", "def"));
		System.out.println(isEqual("abc", "de"));
		System.out.println(isEqual("ab", "def"));
		System.out.println(isEqual("abc", "abc"));
	}

}
