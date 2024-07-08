package assignment_9;

public interface Shape {
	/**
	 * Interface shape that is the high level implementation of various shapes that we will be
	 * dealing with.
	 */
	double getArea();
	double getPerimeter();
	Point getOrigin();
	boolean isPointEnclosed(Point point);
	ShapeType getShapeType();
}
