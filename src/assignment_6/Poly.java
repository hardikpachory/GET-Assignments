package assignment_6;

import java.util.LinkedList;
import java.util.List;

public final class Poly {
	
	// Polynomial : 7x3 + 3x2 + 13x + 4
	// Power: 3 2 1 0    ->  0  1 2 3  [Array Representation]
	// Coeff: 7 3 13 4   ->  4 13 3 7  [Array Representation]
	
	private final List<Integer> coeff;
	private final List<Integer> power;
	
	public Poly(List<Integer> coeff, List<Integer> power) {
		this.coeff = coeff;
		this.power = power;
		getPoly();
	}
	
	public void getPoly() {
		String str = "";
		System.out.print("Polynomial: ");
		for(int i=0; i<=this.degree(); i++) {
			if(this.containsPower(i)) {
				if(i==0)
					str = "(" + coeff.get( power.indexOf(i) )+"x"+i+") " + str;
				else
					str = "(" + coeff.get( power.indexOf(i) )+"x"+i+") + " + str;
			}
		}
		System.out.println(str);
	}
	public int degree() {
		return power.get(power.size() - 1);
	}
	
	public boolean containsPower(int x) {
		if(power.contains(x))
			return true;
		return false;
	}
	
	public int getCoeff(int x) {
		return coeff.get(power.indexOf(x));
	}
	
	public float evaluate(float x) {
		float evaluation = 0;
		int index = 0;
		for(int i=0; i<=this.degree(); i++) {
			if(power.contains(i)) {
				evaluation += Math.pow(coeff.get(index++), i); 
			}
		}		
		return evaluation;
	}
	
	public Poly addPoly(Poly otherPoly) {
		
		List<Integer> coeff = new LinkedList<Integer>();
		List<Integer> power = new LinkedList<Integer>();
		
		int maxDegree = (this.degree() >= otherPoly.degree()) ? this.degree() : otherPoly.degree();
		for(int i=0; i<=maxDegree; i++) {
			if( this.containsPower(i) && otherPoly.containsPower(i) ){
				power.add(i);
				coeff.add( this.getCoeff(i) + otherPoly.getCoeff(i) );
			} else if(this.containsPower(i)) {
				power.add(i);
				coeff.add( this.getCoeff(i) );
			} else if(otherPoly.containsPower(i)) {
				power.add(i);
				coeff.add( otherPoly.getCoeff(i) );
			}
		}
		Poly addResult = new Poly(coeff, power);
		return addResult;
	}
	
	public Poly multiplyPoly(Poly otherPoly) {
		
		List<Integer> coeff = new LinkedList<Integer>();
		List<Integer> power = new LinkedList<Integer>();
		
		for(int i=0; i<=this.degree(); i++) { // thisPolynomial
			for(int j=0; j<=otherPoly.degree(); j++) { // otherPoly polynomial
				
				if( this.containsPower(i) && otherPoly.containsPower(j) ){
					if(!power.contains(i+j)) {
						power.add(i+j);
						coeff.add( this.getCoeff(i) * otherPoly.getCoeff(j) );
					} else {
						coeff.add(power.indexOf(i+j), 
								  coeff.get(power.indexOf(i+j)) + (this.getCoeff(i) * otherPoly.getCoeff(j))
								);
					}
				}
			}
		}
		Poly product = new Poly(coeff, power);
		return product;
	}

	@Override
	public String toString() {
		return "Poly [coeff=" + coeff + ", power=" + power + "]";
	}
	
}
