package assignment_9;

import java.util.Date;

public class Square implements Shape {
	/**
	 * The class Square is implementation of the Shape interface that overrides all the 
	 * functions and provides functionality of Square as a shape
	 */
	Point origin;
	Date timestamp;
	double width;

	public Square(Point point, double width) {
		super();
		this.width = width;
		origin = new Point(point.getXCord(), point.getYCord());
		timestamp = new Date();
	}
	
	public double getArea() {
		return width*width;
	}
	
	public double getPerimeter() {
		return 4*width;
	}
	
	public Point getOrigin() {
		return origin;
	}
	
	public boolean isPointEnclosed(Point point) {
		double dx = point.getXCord();
		double dy = point.getYCord();
		double x = origin.getXCord();
		double y = origin.getYCord();
		return dx>=x && dx<=x + width && dy>=y && dy<=y+width;
	}

	public ShapeType getShapeType() {
		return ShapeType.SQUARE;
	}
}
