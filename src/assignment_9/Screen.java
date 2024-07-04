package assignment_9;

import java.util.LinkedList;
import java.util.List;

public class Screen {
	int Xmax;
	int Ymax;
	List<Shape> shapesOnScreen;
	
	boolean addShape(Point point, Shape shape) {
		return shapesOnScreen.add(shape);
	}

	public Screen(int xmax, int ymax) {
		super();
		Xmax = xmax;
		Ymax = ymax;
		shapesOnScreen = new LinkedList<Shape>();
	}
	
	public void deleteAllShape(ShapeType type) {
		int count = 0;
		for(Shape shape : shapesOnScreen) {
			if(type.equals(shape.getShapeType())) {
				shapesOnScreen.remove(shape);
			}
			count++;
		}
		System.out.println( count+" shapes on screen affected.");
	}
	
	public void deleteShape(Point  point, ShapeType shape) {
		for(Shape shapes :  shapesOnScreen) {
			if(point.equals(shapes.getOrigin()) && shape.equals(shapes.getShapeType())) {
				shapesOnScreen.remove(shapes);
				System.out.println( "Shape on screen affected.");
				return;
			}
		}
		System.out.println("No shape affected.");
		return;
	}
	
	public void shapesByTimestamps() {
		System.out.println("-- My Screen --");
		System.out.println("xMax: " + Xmax + "  |  " +"yMax: "+Ymax);
		for(Shape shape: shapesOnScreen) {
			System.out.println("Shape: " + shape.getShapeType() + "   |   " + "x: " + shape.getOrigin().getXCord() + "  |  " +"yMax: "+shape.getOrigin().getYCord());
		}
	}
	public List<Shape> isEnclosed(Point point){
		List<Shape> figures = new LinkedList<Shape>();
		for(Shape shape: shapesOnScreen) {
			if(shape.isPointEnclosed(point)) {
				figures.add(shape);
				System.out.println(shape.getShapeType() + " | " + shape.getOrigin() + " | " +shape.isPointEnclosed(point));
			}
		}
		return figures;
	}
}
