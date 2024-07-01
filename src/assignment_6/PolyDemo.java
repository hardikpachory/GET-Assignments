package assignment_6;

import java.util.LinkedList;
import java.util.List;

public class PolyDemo {
	public static void main(String[] args) {
		List<Integer> coeff = new LinkedList<Integer>(List.of(1,2,4));
		List<Integer> power = new LinkedList<Integer>(List.of(0,1,2));
		
		Poly poly1 = new Poly(coeff, power);
		
		coeff = new LinkedList<Integer>(List.of(5,10,6));
		power = new LinkedList<Integer>(List.of(0,2,3));
		
		Poly poly2 = new Poly(coeff, power);
		
		System.out.println("Poly1 Degree: " + poly1.degree());
		System.out.println("Poly2 Degree: " + poly2.degree());
		System.out.println("Evaluate poly1(3): " + poly1.evaluate(3));
		System.out.println("Evaluate poly2(5): " + poly2.evaluate(5));
		poly1.multiplyPoly(poly2);
		poly1.addPoly(poly2);
		
		// Other Test Cases To try
		System.out.println("-------");
		
		coeff = new LinkedList<Integer>(List.of(1,2,3));
		power = new LinkedList<Integer>(List.of(0,1,2));
		
		poly1 = new Poly(coeff, power);
		
		coeff = new LinkedList<Integer>(List.of(3));
		power = new LinkedList<Integer>(List.of(0));
		
		poly2 = new Poly(coeff, power);
		
		System.out.println("Poly1 Degree: " + poly1.degree());
		System.out.println("Poly2 Degree: " + poly2.degree());
		System.out.println("Evaluate poly1(3): " + poly1.evaluate(3));
		System.out.println("Evaluate poly2(5): " + poly2.evaluate(5));
		poly1.multiplyPoly(poly2);
		poly1.addPoly(poly2);
	}
}
