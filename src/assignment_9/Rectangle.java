package assignment_9;

import java.util.Date;

public class Rectangle implements Shape {
	Point origin;
	Date timestamp;
	double length;
	double width;
	
	public Rectangle(Point point, Integer length, Integer width) {
		super();
		this.width = width;
		this.length = length;
		origin = new Point( point.getXCord(), point.getYCord());
		timestamp = new Date();
	}

	@Override
	public double getArea() {
		return length*width;
	}

	@Override
	public double getPerimeter() {
		return 2*(length+width);
	}

	@Override
	public Point getOrigin() {
		return origin;
	}

	@Override
	public boolean isPointEnclosed(Point point) {
		double dx = point.getXCord();
		double dy = point.getYCord();
		double x = origin.getXCord();
		double y = origin.getYCord();
		return dx>=x && dx<=x + width && dy>=y && dy<=y+length;
	}

	@Override
	public ShapeType getShapeType() {
		return ShapeType.RECTANGLE;
	}

}
