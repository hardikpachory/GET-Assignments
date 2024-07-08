package assignment_9;

import java.util.List;

public class Factory {
	/**
	 * The Factory class helps us to implement the Factory Design Pattern
	 * by limiting the creation of objects to this particular class based
	 * on the input from the user.
	 */
	public static Shape createShape(ShapeType shapeType, Point point, List<Integer> dimension) {
		Shape shape;
		if(ShapeType.SQUARE.equals(shapeType)) {
			shape = new Square(point, dimension.get(0));
		} else if(ShapeType.RECTANGLE.equals(shapeType)) {
			shape = new Rectangle(point, dimension.get(0), dimension.get(1));
		}else if(ShapeType.CIRCLE.equals(shapeType)) {
			shape = new Circle(point, dimension.get(0));
		} else if(ShapeType.TRIANGLE.equals(shapeType)) {
			shape = new Triangle(point, dimension.get(0), dimension.get(1));
		} else if(ShapeType.POLYGON.equals(shapeType)) {
			shape = new Polygon(point, dimension.get(0) ,dimension.get(1));
		} else {
			shape = null;
		}
		return shape;
	}
}
