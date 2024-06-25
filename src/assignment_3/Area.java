package assignment_3;

public class Area {
	
	static double areaTriangle(double width, double height) {
		if(width <= 0 || height <= 0) {
			throw new ArithmeticException("Should be more than zero");
		}
		double area = (width * height)/2;
		return area;
	}
	
	static double areaRectangle(double length, double width) {
		if(width <= 0 || length <= 0) {
			throw new ArithmeticException("Should be more than zero");
		}
		double area = width*length;
		return area;
	}
	
	static double areaSquare(double width) {
		if(width <= 0) {
			throw new ArithmeticException("Should be more than zero");
		}
		double area = width * width;
		return area;
	}
	
	static double areaCircle(double radius) {
		if(radius <= 0) {
			throw new ArithmeticException("Should be more than zero");
		}
		final double PI = 3.14159;
		double area = PI * radius * radius;
		return area;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
