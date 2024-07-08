package assignment_9;

import java.util.Date;

public class Triangle implements Shape {
	/**
	 * The class Triangle is implementation of the Shape interface that overrides all the 
	 * functions and provides functionality of Triangle as a shape
	 */
	Point origin;
	double width;
	double height;
	Date timestamp;
	
	public Triangle(Point point, double width, double height) {
		super();
		this.width = width;
		this.height = height;
		origin = new Point(point.getXCord(), point.getYCord());
		timestamp = new Date();
	}
	
	@Override
	public double getArea() {
		return (width*height)/2;
	}

	@Override
	public double getPerimeter() {
		return width + Math.sqrt((4*height*height)+(width*width));
	}

	@Override
	public Point getOrigin() {
		return origin;
	}

	@Override
	public boolean isPointEnclosed(Point point) {
		double dx = point.getXCord() - origin.getXCord();
		double dy = point.getYCord() - origin.getYCord();
		double distance = Math.sqrt(dx*dx + dy*dy);
		double radius = (Math.sqrt(3)/3)*width;
		return distance<=radius;
	}

	@Override
	public ShapeType getShapeType() {
		// TODO Auto-generated method stub
		return null;
	}

}
