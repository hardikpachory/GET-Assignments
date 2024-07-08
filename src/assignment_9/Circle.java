package assignment_9;

import java.util.Date;

public class Circle implements Shape {
	/**
	 * The class Circle is implementation of the Shape interface that overrides all the 
	 * functions and provides functionality of circle as a shape
	 */
	Point origin;
	double radius;
	Date timestamp;
	
	public Circle(Point point, double radius) {
		super();
		this.radius = radius;
		origin = new Point(point.getXCord(), point.getYCord());
		timestamp = new Date();
	}

	@Override
	public double getArea() {
		return Math.PI*radius*radius;
	}

	@Override
	public double getPerimeter() {
		return 2*Math.PI*radius;
	}

	@Override
	public Point getOrigin() {
		return origin;
	}

	@Override
	public boolean isPointEnclosed(Point point) {
		double dx = point.getXCord();
		double dy = point.getYCord();
		return (Math.pow(dx-origin.getXCord(), 2) + Math.pow(dy-origin.getYCord(), 2) <= radius*radius);
	}

	@Override
	public ShapeType getShapeType() {
		return ShapeType.CIRCLE;
	}

}
