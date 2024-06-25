package assignment_3;

import java.util.Scanner;

public class Marksheet {
	
	static int numberOfStudents; 
	static double[] grades;
	
	static Scanner sc = new Scanner(System.in);
	
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
	
	static String getAvgGrade() {
		double avg = 0;
		for(int i = 0; i < numberOfStudents; i++) {
			avg += grades[i];
		}
		avg /= numberOfStudents;
		return String.format("%.2f", avg);
	}
	
	static String getMaxGrade() {
		double maxGrade = grades[0];
		for(int i = 1; i < numberOfStudents; i++) {
			if( grades[i] > maxGrade )
				maxGrade = grades[i];
		}
		return String.format("%.2f", maxGrade);
	}
	
	static String getMinGrade() {
		double minGrade = grades[0];
		for(int i = 1; i < numberOfStudents; i++) {
			if( grades[i] < minGrade )
				minGrade = grades[i];
		}
		return String.format("%.2f", minGrade);
	}
	
	static String getPassPercentage() {
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
		try {
		getInput();
		} catch(ArithmeticException e) {
			System.out.println("Error Taking Input: " + e.getMessage());
		}
		System.out.println(getAvgGrade());
		System.out.println(getMaxGrade());
		System.out.println(getMinGrade());
		System.out.println(getPassPercentage());
	}

}
