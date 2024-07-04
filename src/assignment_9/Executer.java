package assignment_9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Executer {
	
	public static void main(String[] args) {
		
		Screen screen = null;
		Factory factory = new Factory();
		Scanner sc = new Scanner(System.in);
		ShapeType type;
		Shape shape;
		boolean execute = true;
		int x;
		int y;
		int choice;
		int shapeChoice;
		List<Integer> inputData = new ArrayList<>();
		
		while(execute) {
			System.out.println(" --- Main Options --- ");
			if(screen == null) {
				System.out.println("1. Add Screen");
				System.out.println("2. Exit");
			} else {
				System.out.println("1. Add Shape");
				System.out.println("2. Delete a Shape");
				System.out.println("3. Delete all Shapes of Particular size");
				System.out.println("4. Point Enclosing");
				System.out.println("5. Exit");
			}
			System.out.print("Enter choice: ");
			choice = sc.nextInt();
			switch(choice) {
				case 1: if(screen == null) {
							System.out.print("Maximum Horizontal Pixels (Xmax): ");
							x = sc.nextInt();
							System.out.print("Maximum Vertical Pixels (Ymax): ");
							y = sc.nextInt();
							screen = new Screen(x, y);
						} else {
							System.out.println("Select Shape - ");
							System.out.println("1. Square");
							System.out.println("2. Rectangle");
							System.out.println("3. Triangle");
							System.out.println("4. Circle");
							System.out.println("5. Regular Polygon");
							System.out.println("Enter Choice: ");
							shapeChoice = sc.nextInt();
							if(shapeChoice==2 || shapeChoice==3) {
								System.out.println("Dimension measure 1: ");
								x = sc.nextInt();
								System.out.println("Dimension measure 2: ");
								y = sc.nextInt();
								inputData.add(x);
								inputData.add(y);
							} else if(shapeChoice==1 || shapeChoice==4) {
								System.out.println("Dimension measure 1: ");
								x = sc.nextInt();
								inputData.add(x);
							} else {
								System.out.println("Number of sides: ");
								x = sc.nextInt();
								System.out.println("Dimension Measure: ");
								y = sc.nextInt();
								inputData.add(x);
								inputData.add(y);
							}
							 System.out.println("X coord: ");
						     x=sc.nextInt();
						     System.out.println("Y coord: ");
						     y=sc.nextInt();
							switch(shapeChoice) {
								case 1: shape = factory.createShape(ShapeType.SQUARE, new Point(x,y), inputData);
										screen.addShape(new Point(x,y), shape);
										break;
								case 2: shape = factory.createShape(ShapeType.RECTANGLE, new Point(x,y), inputData);
										screen.addShape(new Point(x,y), shape);
										break;
								case 3: shape = factory.createShape(ShapeType.TRIANGLE, new Point(x,y), inputData);
										screen.addShape(new Point(x,y), shape);
										break;
								case 4: shape = factory.createShape(ShapeType.CIRCLE, new Point(x,y), inputData);
										screen.addShape(new Point(x,y), shape);
										break;
								case 5: shape = factory.createShape(ShapeType.POLYGON, new Point(x,y), inputData);
										screen.addShape(new Point(x,y), shape);
										break;
							}
						}
						break;
				case 2: System.out.println("X coord: ");
			     		x=sc.nextInt();
			     		System.out.println("Y coord: ");
			     		y=sc.nextInt();
			     		System.out.println("Select Shape - ");
						System.out.println("1. Square");
						System.out.println("2. Rectangle");
						System.out.println("3. Triangle");
						System.out.println("4. Circle");
						System.out.println("5. Regular Polygon");
						System.out.println("Enter Choice: ");
						shapeChoice = sc.nextInt();
						type = (shapeChoice==1)?ShapeType.SQUARE:(
									(shapeChoice==2)?ShapeType.RECTANGLE:(
											(shapeChoice==3)?ShapeType.TRIANGLE:(
													(shapeChoice==4)?ShapeType.CIRCLE:ShapeType.POLYGON)
											)
									);
						screen.deleteShape(new Point(x,y), type);
						break;
				case 4: System.out.println("X coord: ");
	     				x=sc.nextInt();
	     				System.out.println("Y coord: ");
	     				y=sc.nextInt();
	     				screen.isEnclosed(new Point(x,y));
	     				break;
				case 5: sc.close();
						execute = false;
						break;
				default: System.out.println("Invalid Input. Try Again.");
			} //Switch End
		}// While End
		screen.shapesByTimestamps();
	} //psvm End
}// class End
