package assignment_9;

import java.util.Date;

public class Polygon implements Shape {
	/**
	 * The class Polygon is implementation of the Shape interface that overrides all the 
	 * functions and provides functionality of Polygon as a shape
	 */
	Point origin; // Center Point for Polygons
	Date timestamp;
	double width;
	int numberOfSides;
	
	public Polygon(Point point, int numberOfSides ,double dimension) {
		super();
		width = dimension;
		origin = new Point(point.getXCord(), point.getYCord());
		timestamp = new Date();
	}

	@Override
	public double getArea() {
		double apothem = width/(2*Math.tan(Math.PI/numberOfSides));
		return (getPerimeter()*apothem)/2;
	}

	@Override
	public double getPerimeter() {
		return numberOfSides*width;
	}

	@Override
	public Point getOrigin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isPointEnclosed(Point point) {
		double dx= point.getXCord();
		double dy = point.getYCord();
		double distance = Math.sqrt(dx*dx + dy*dy);
		double radius = width/(2*Math.sin(Math.PI/numberOfSides));
		return distance<=radius;
	}

	@Override
	public ShapeType getShapeType() {
		// TODO Auto-generated method stub
		return null;
	}

}
