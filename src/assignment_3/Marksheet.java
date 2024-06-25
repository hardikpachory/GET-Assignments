package assignment_3;

import java.util.Scanner;

public class Marksheet {
	
	static int numberOfStudents; 
	static double[] grades;
	
	static Scanner sc = new Scanner(System.in);
	
	/**
	 * Takes input of numberOfStudents and their grades
	 * @throws ArithmeticException
	 */
	static void getInput() throws ArithmeticException {
		System.out.println("Number of Students: ");
		numberOfStudents = sc.nextInt();
		if(numberOfStudents <= 0) {
			throw new ArithmeticException("Number of Students must be greater than zero");
		}
		grades = new double[numberOfStudents];
		System.out.println("Enter Grades - ");
		double grade;
		for(int i=0; i < numberOfStudents; i++) {
			grade = sc.nextDouble();
			if(grade<0 || grade>100) {
				throw new ArithmeticException("Grade must be between 0 and 100");
			}
			grades[i] = grade;
		}
	}
	
	/**
	 * Calculates the average of Grades
	 * @return Average grade of the students in double
	 * @throws ArithmeticException
	 */
	static String getAvgGrade() throws ArithmeticException {
		if(numberOfStudents <= 0) {
			throw new ArithmeticException("Number of Students not initialized");
		}
		double avg = 0;
		for(int i = 0; i < numberOfStudents; i++) {
			avg += grades[i];
		}
		avg /= numberOfStudents;
		return String.format("%.2f", avg);
	}
	
	/**
	 * Provide the maximum grade of the student
	 * @return maximum value of grade in double
	 * @throws ArithmeticException
	 */
	static String getMaxGrade() throws ArithmeticException {
		if(numberOfStudents <= 0) {
			throw new ArithmeticException("Number of Students not initialized");
		}
		double maxGrade = grades[0];
		for(int i = 1; i < numberOfStudents; i++) {
			if( grades[i] > maxGrade )
				maxGrade = grades[i];
		}
		return String.format("%.2f", maxGrade);
	}
	
	/**
	 * Provide the minimum grade of the student
	 * @return minimum value of the grade in double
	 * @throws ArithmeticException
	 */
	static String getMinGrade() throws ArithmeticException {
		if(numberOfStudents <= 0) {
			throw new ArithmeticException("Number of Students not initialized");
		}
		double minGrade = grades[0];
		for(int i = 1; i < numberOfStudents; i++) {
			if( grades[i] < minGrade )
				minGrade = grades[i];
		}
		return String.format("%.2f", minGrade);
	}
	
	/**
	 * Provide the passing percentage of the students
	 * @return passing percent of students in double
	 * @throws ArithmeticException
	 */
	static String getPassPercentage() throws ArithmeticException {
		if(numberOfStudents <= 0) {
			throw new ArithmeticException("Number of Students not initialized");
		}
		int passTotal = 0;
		double passPercent;
		double passingMarks = 40;
		for(int i = 0; i < numberOfStudents; i++) {
			if( grades[i] >= passingMarks )
				passTotal++;
		}
		passPercent = (passTotal*100)/numberOfStudents;
		return String.format("%.2f" , passPercent);
	}

	public static void main(String[] args) {
		int choice = 0;
		while(choice!=6) {
			System.out.println("-----   MAIN OPTIONS   -----");
			System.out.println("1. Add Student and Grade Details");
			System.out.println("2. Average Grades");
			System.out.println("3. Maximum Grade");
			System.out.println("4. Minimum Grade");
			System.out.println("5. Pass Percentage");
			System.out.println("6. Exit");
			System.out.println("Enter choice: ");
			choice = sc.nextInt();
			switch(choice) {
				case 1: try {
							getInput();
						} catch (ArithmeticException e) {
							System.out.println("Arithmetic Exception Occured: " + e.getMessage());
						}
						break;
				case 2: try {
							System.out.println("Average Grades: " + getAvgGrade());
						} catch (Exception e) {
							System.out.println("Arithmetic Exception Occured: " + e.getMessage());
						}
						break;
				case 3: try {
							System.out.println("Maximum Grade: " + getMaxGrade());
						} catch (Exception e) {
							System.out.println("Arithmetic Exception Occured: " + e.getMessage());
						}
						break;
				case 4: try {
							System.out.println("Minimum Grade: " + getMinGrade());
						} catch (Exception e) {
							System.out.println("Arithmetic Exception Occured: " + e.getMessage());
						}
						break;
				case 5: try {
							System.out.println("Pass Percentage: " + getPassPercentage());
						} catch (Exception e) {
							System.out.println("Arithmetic Exception Occured: " + e.getMessage());
						}
						break;
				case 6: System.exit(0);
						break;
				default: System.out.println("Invalid choice. Enter again.");
			}
			System.out.println();
		}
		sc.close();
	}

}
