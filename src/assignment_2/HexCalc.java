package assignment_2;

import java.util.Map;
import java.util.Scanner;

public class HexCalc {
	
	static Map<Character, Integer> hexCodes = Map.of(
			'A' , 10,
			'B' , 11,
			'C' , 12,
			'D' , 13,
			'E' , 14,
			'F' , 15
	);
	
	static String firstNumber;
	static String secondNumber;
	static int numberSystemBase;
	static Scanner sc = new Scanner(System.in);
	
	/**
	 * Input for Mathematical and Logical Operations
	 */
	static void takeOperationalInput() {
		System.out.print("Enter number: ");
        firstNumber = sc.next();
        System.out.print("Enter number: ");
        secondNumber = sc.next();
        System.out.print("Number System Base: ");
        numberSystemBase = sc.nextInt();
	}
	
	/**
	 * Input for Conversion operations
	 */
	static void takeInput() {
		System.out.print("Enter number: ");
		firstNumber = sc.next();
		System.out.println("Number System Base: ");
		numberSystemBase = sc.nextInt();
	}
	
	/**
	 * Convert a given any type of number to decimal number
	 * @param hexNumber  Number in String
	 * @param base       Base of Number System 
	 * @return           String Decimal form of the number and base received
	 */
	static String getDecimal(String hexNumber, int base) {
		int decimal = 0;
		char digit;
		int length = hexNumber.length();
		int numDigit;
		//  123
		for(int i=0; i < hexNumber.length(); i++) {
			digit = hexNumber.charAt(i);
			if(digit >= 'A' && digit <= 'Z') {
				numDigit = hexCodes.get(digit);
			} else {
				numDigit = digit - '0'; // Converting character value to int 
			}
			// deci = A*16^3 + 1*16^2  
			decimal += ( numDigit * ( Math.pow( base, length - ( i + 1 ) ) ) ); // Multiplying with base powers and summation
		}
		return String.valueOf(decimal);
	}
	
	/**
	 * Convert a given decimal number to any other type of number
	 * @param decNumber  Decimal number in String
	 * @param base       Base of Number System
	 * @return           String form of the Decimal number received in other number system base received
	 */
	static String getOtherNumberSystem(String decNumber, int base) {
		String otherNumber = "";
		int remainder;
		int intDecNumber = Integer.parseInt(decNumber);
		while(intDecNumber != 0) {
			remainder = intDecNumber % base;
			if(remainder < 10) {
				// otherNUmber = 652
				otherNumber = remainder + otherNumber;
			} else {
				char hex = (char) ('A' + (remainder - 10)); // TO generate character individual in hexadecimal
				otherNumber = hex + otherNumber;
			}
			intDecNumber /= base;
		}
		return otherNumber;
	}
	
	/**
	 * Perform addition of any type of numbers -> hexNum1 + hexNum2
	 * @param hexNum1  number in String
	 * @param hexNum2  number in String
	 * @param base     base of number system
	 * @return         sum of the parameters received in base number system 
	 */
	static String addNumbers(String hexNum1, String hexNum2, int base) {
		int sum = 0;
		int decNumber1 = Integer.parseInt(getDecimal(hexNum1, base));
		int decNumber2 = Integer.parseInt(getDecimal(hexNum2, base));
		sum = decNumber1 + decNumber2;
		return getOtherNumberSystem(String.valueOf(sum), base);
	}
	
	/**
	 * Perform subtraction of any type of numbers -> hexNum1 - hexNum2
	 * @param hexNum1  number in String
	 * @param hexNum2  number in String
	 * @return         Subtraction of the parameters in base number system
	 */
	static String subtractNumbers(String hexNum1, String hexNum2, int base) {
		int difference = 0;
		int decNumber1 = Integer.parseInt(getDecimal(hexNum1, base));
		int decNumber2 = Integer.parseInt(getDecimal(hexNum2, base));
		if(decNumber1<decNumber2) {
			difference = decNumber2 - decNumber1;
			difference *= (-1); // To make the result negative
		}
		else {
			difference = decNumber1 - decNumber2;
		}
		return getOtherNumberSystem(String.valueOf(difference), base);
	}
	
	/**
	 * Perform multiplication of any type of numbers -> hexNum1 * hexNum2
	 * @param hexNum1  number in String
	 * @param hexNum2  number in String
	 * @return         Product of the parameters in base number system 
	 */
	static String multiplyNumbers(String hexNum1, String hexNum2, int base) {
		int product = 0;
		int decNumber1 = Integer.parseInt(getDecimal(hexNum1, base));
		int decNumber2 = Integer.parseInt(getDecimal(hexNum2, base));
		product = decNumber1 * decNumber2;
		return getOtherNumberSystem(String.valueOf(product), base);
	}
	/**
	 * Perform division of any type of numbers -> hexNum1 / hexNum2
	 * @param hexNum1  number in String
	 * @param hexNum2  number in String
	 * @return         Division of the parameters in base number system
	 */
	static String divideNumbers(String hexNum1, String hexNum2, int base) {
		int quotient = 0;
		int decNumber1 = Integer.parseInt(getDecimal(hexNum1, base));
		int decNumber2 = Integer.parseInt(getDecimal(hexNum2, base));
		quotient = decNumber1 / decNumber2;
		return getOtherNumberSystem(String.valueOf(quotient), base);
	}
	
	/**
	 * Performs comparison between two numbers
	 * @param hexNum1  number in String
	 * @param hexNum2  number in String
	 * @return         'true' if hexNum1 > hexNum2 and 'false' otherwise
	 */
	static boolean isGreater(String hexNum1, String hexNum2) {
		if(hexNum1.length() > hexNum2.length()) {
			return true;
		} else if(hexNum1.length() < hexNum2.length()) {
			return false;
		} else {
			for(int i=0; i<hexNum1.length(); i++) {
				char num1Digit = hexNum1.charAt(i);
				char num2Digit = hexNum2.charAt(i);
				if(num1Digit > num2Digit) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Performs comparison between two numbers
	 * @param hexNum1  number in String
	 * @param hexNum2  number in String
	 * @return         'true' if hexNum1 < hexNum2 and 'false' otherwise
	 */
	static boolean isSmaller(String hexNum1, String hexNum2) {
		if(hexNum1.length() > hexNum2.length()) {
			return false;
		} else if(hexNum1.length() < hexNum2.length()) {
			return true;
		} else {
			for(int i=0; i < hexNum1.length(); i++) {
				char num1Digit = hexNum1.charAt(i);
				char num2Digit = hexNum2.charAt(i);
				if(num2Digit > num1Digit) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Performs equality check on two numbers
	 * @param hexNum1  number in String
	 * @param hexNum2  number in String
	 * @return         'true' if hexNum1 == hexNum2 and 'false' otherwise
	 */
	static boolean isEqual(String hexNum1, String hexNum2) {
		if(hexNum1.length() != hexNum2.length()) {
			return false;
		} else {
			for(int i=0; i<hexNum1.length(); i++) {
				char num1Digit = hexNum1.charAt(i);
				char num2Digit = hexNum2.charAt(i);
				if(num2Digit != num1Digit) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int choice = 0;
		
		while(choice != 10) {
			System.out.println("-----   MAIN OPTIONS   -----");
			System.out.println("1. Add Numbers");
			System.out.println("2. Subtract Numbers");
			System.out.println("3. Multiply Numbers");
			System.out.println("4. Divide Numbers");
			System.out.println("5. Check Equality (a==b)");
			System.out.println("6. Check greater (a>b)");
			System.out.println("7. Check smaller (a<b)");
			System.out.println("8. Get Decimal Number from any number system");
			System.out.println("9. Get other number system from decimal ");
			System.out.println("10. Exit");
			System.out.println();
			System.out.println("Input Choice: ");
			choice = sc.nextInt();
			switch(choice) {
				case 1: takeOperationalInput();
				        System.out.println("Addition Result: " + addNumbers(firstNumber, secondNumber, numberSystemBase));
				        break;
				case 2: takeOperationalInput();
						System.out.println("Subtraction Result: " + subtractNumbers(firstNumber, secondNumber, numberSystemBase));
						break;
				case 3: takeOperationalInput();
						System.out.println("Multiplication Result: " + multiplyNumbers(firstNumber, secondNumber, numberSystemBase));
						break;
				case 4: takeOperationalInput();
						System.out.println("Division Result: " + divideNumbers(firstNumber, secondNumber, numberSystemBase));
						break;
				case 5: takeOperationalInput();
						System.out.println(firstNumber + " == " + secondNumber +" : " + isEqual(firstNumber, secondNumber));
						break;
				case 6: takeOperationalInput();
						System.out.println(firstNumber + " > " + secondNumber +" : " + isGreater(firstNumber, secondNumber));
						break;
				case 7: takeOperationalInput();
						System.out.println(firstNumber + " < " + secondNumber +" : " + isSmaller(firstNumber, secondNumber));
						break;
				case 8: takeInput();
						System.out.println("(" + firstNumber +")" + numberSystemBase + " = (" + getDecimal(firstNumber, numberSystemBase)+")10");
						break;
				case 9: takeInput();
						System.out.println("(" + firstNumber +")10 = (" + getDecimal(firstNumber, numberSystemBase)+")"+numberSystemBase);
						break;
				case 10: System.exit(0);
						 break;
				default: System.out.println("Wrong Choice! Enter Again.");
					
			}
			System.out.println("\n");
		}
	}

}
