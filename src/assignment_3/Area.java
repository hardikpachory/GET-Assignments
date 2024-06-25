package assignment_3;

import java.util.Scanner;

public class Area {
	
	static Scanner sc = new Scanner(System.in);
	
	/**
	 * Calculate and return the area of a triangle
	 * @param width width or the base of a triangle
	 * @param height height of the triangle
	 * @return the area of triangle as double
	 * @throws ArithmeticException
	 */
	static double areaTriangle(double width, double height) throws ArithmeticException {
		if(width <= 0 || height <= 0) {
			throw new ArithmeticException("Dimension should be more than zero");
		}
		double area = (width * height)/2;
		return area;
	}
	
	/**
	 * Calculate and returns the area of a rectangle
	 * @param length length of the rectangle
	 * @param width  breadth or the width of the rectangle
	 * @return       the area of the rectangle in double
	 * @throws ArithmeticException
	 */
	static double areaRectangle(double length, double width) throws ArithmeticException {
		if(width <= 0 || length <= 0) {
			throw new ArithmeticException("Dimension should be more than zero");
		}
		double area = width*length;
		return area;
	}
	
	/**
	 * Calculate and returns the area of square
	 * @param  width width or the side of the square
	 * @return the area of the square in square
	 * @throws ArithmeticException
	 */
	static double areaSquare(double width) throws ArithmeticException {
		if(width <= 0) {
			throw new ArithmeticException("Dimension should be more than zero");
		}
		double area = width * width;
		return area;
	}
	
	/**
	 * Calculate and returns the area of a circle
	 * @param radius radius of the circle
	 * @return       the area of the square
	 * @throws ArithmeticException
	 */
	static double areaCircle(double radius) throws ArithmeticException {
		if(radius <= 0) {
			throw new ArithmeticException("Dimension should be more than zero");
		}
		final double PI = 3.14159;
		double area = PI * radius * radius;
		return area;
	}

	public static void main(String[] args) {
		int choice = 0;
		double dimensionOne;
		double dimensionTwo;
		while(choice!=5) {
			System.out.println("-----  Main Options  -----");
			System.out.println("1. Triangle");
			System.out.println("2. Rectangle");
			System.out.println("3. Square");
			System.out.println("4. Circle");
			System.out.println("5. Exit");
			System.out.println("Enter Choice: ");
			choice = sc.nextInt();
			switch(choice) {
				case 1: System.out.print("Enter triangle width: ");
						dimensionOne = sc.nextDouble();
						System.out.print("Enter triangle height: ");
						dimensionTwo = sc.nextDouble();
						try {
							System.out.println("Area of Triangle: " + areaTriangle(dimensionOne, dimensionTwo));
						} catch (ArithmeticException e) {
							System.out.println("Arithmetic Exception: " + e.getMessage());
						}
						break;
				case 2: System.out.println("Enter Rectangle width: ");
						dimensionOne = sc.nextDouble();
						System.out.print("Enter Rectangle length: ");
						dimensionTwo = sc.nextDouble();
						try {
							System.out.println("Area of Rectangle: " + areaRectangle(dimensionOne, dimensionTwo));
						} catch (ArithmeticException e) {
							System.out.println("Arithmetic Exception: " + e.getMessage());
						}
						break;
				case 3: System.out.println("Enter Square width: ");
						dimensionOne = sc.nextDouble();
						try {
							System.out.println("Area of Square: " + areaSquare(dimensionOne));
						} catch (ArithmeticException e) {
							System.out.println("Arithmetic Exception: " + e.getMessage());
						}
						break;
				case 4: System.out.println("Enter Circle radius: ");
						dimensionOne = sc.nextDouble();
						try {
							System.out.println("Area of Circle: " + areaCircle(dimensionOne));
						} catch (ArithmeticException e) {
							System.out.println("Arithmetic Exception: " + e.getMessage());
						}
						break;
				case 5: System.exit(0);
						break;
				default: System.out.println("Invalid Choice, Enter again!");
			}
			System.out.println();
		}
		sc.close();
	}

}
