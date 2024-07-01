package assignment_6;

import java.util.LinkedList;
import java.util.List;

public class PolyDemo {
	public static void main(String[] args) {
//		List<Integer> coeff = new LinkedList<Integer>(List.of(1,2,4));
//		List<Integer> power = new LinkedList<Integer>(List.of(0,1,2));
		
		List<Integer> coeff = new LinkedList<Integer>(List.of(1,2,3));
		List<Integer> power = new LinkedList<Integer>(List.of(0,1,2));
		
		Poly poly1 = new Poly(coeff, power);
		
		coeff = new LinkedList<Integer>(List.of(3));
		power = new LinkedList<Integer>(List.of(0));
		
//		coeff = new LinkedList<Integer>(List.of(5,10,6));
//		power = new LinkedList<Integer>(List.of(0,2,3));
		
		Poly poly2 = new Poly(coeff, power);
		
		poly1.multiplyPoly(poly2);
	}
}
