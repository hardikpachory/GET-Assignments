package assignment_9;

public interface Shape {
	double getArea();
	double getPerimeter();
	Point getOrigin();
	boolean isPointEnclosed(Point point);
	ShapeType getShapeType();
}
