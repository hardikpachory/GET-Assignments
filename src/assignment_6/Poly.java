package assignment_6;

import java.util.LinkedList;
import java.util.List;

/**
 * The class Poly serves as a way to represent mathematical single variable polynomials
 * in an immutable manner. The class uses list of coefficients and their powers to 
 * represent a polynomial. 
 * The immutability is obtained by:
 * -> declaring class as final to avoid inheritence
 * -> making the data members as private to avoid direct access
 * -> making the data members as final so that their values cannot be changed after
 * 	  creation of the object
 * -> Parameterized construction to provide values to our data members
 * -> No setter function
 */
public final class Poly {
	
	// Polynomial : 9x5 +7x3 + 3x2 + 13x + 4
	// Power: 3 2 1 0    ->  0  1 2 3 5  [Array Representation]
	// Coeff: 7 3 13 4   ->  4 13 3 7 9  [Array Representation]
	
	private final List<Integer> coeff;
	private final List<Integer> power;
	
	/**
	 * Parameterized constructor to initialize our  immutable object. The coefficien is
	 * mapped to its power by the use of index.
	 * @param coeff List of coefficients of polynomial
	 * @param power List of powers of the polynomial
	 */
	public Poly(List<Integer> coeff, List<Integer> power) {
		this.coeff = coeff;
		this.power = power;
		getPoly();
	}
	
	/**
	 * Generate the polynomial mathematically using the array of coefficients
	 */
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
	
	/**
	 * Generate the degree of the polynomial i.e. the highest power of the variable
	 * @return degree of the polynomial
	 */
	public int degree() {
		return power.get(power.size() - 1);
	}
	
	/**
	 * Check if the given number exists as a power of the polynomial
	 * @param x number to check for power
	 * @return  true if the number x exists, otherwise false
	 */
	public boolean containsPower(int x) {
		if(power.contains(x))
			return true;
		return false;
	}
	
	/**
	 * To get the coefficient of a particular power
	 * @param x The power of the polynomial
	 * @return  The respective coefficient of that power
	 */
	public int getCoeff(int x) {
		return coeff.get(power.indexOf(x));
	}
	
	/**
	 * Evaluates the polynomial expression for variable value x
	 * @param x The value of variable
	 * @return  The evaluated value of the polynomial
	 */
	// Power: 3 2 1 0    ->  0  1 2 3 5  [Array Representation]
	// Coeff: 7 3 13 4   ->  4 13 3 7 9  [Array Representation]
	// X = 2				eva: 4 + (13 * 2^1) + (3* 2^2) + (3*7^7) + 5(9 * 2^5) 
	public float evaluate(float x) {
		float evaluation = 0;
		for(int i=0; i<=this.degree(); i++) {
			if(this.containsPower(i)) {
				evaluation += (this.getCoeff(i)*Math.pow(x, i)); 
			}
		}		
		return evaluation;
	}
	
	/**
	 * Performs addition of two polynomials
	 * @param otherPoly Polynomial object
	 * @return          Polynomial object as the sum of two polynomials
	 */
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
	
	/**
	 * Perform multiplication of two polynomials
	 * @param otherPoly Polynomial object
	 * @return          Polynomial object as the product of two polynomials
	 */
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
						coeff.set(power.indexOf(i+j), 
								  coeff.get(power.indexOf(i+j)) + (this.getCoeff(i) * otherPoly.getCoeff(j))
								);
					}
				} 
			}
		
		}
		Poly product = new Poly(coeff, power);
		return product;
	}
	
	/**
	 * toString method to print the Polynomial Object
	 */
	@Override
	public String toString() {
		return "Poly [coeff=" + coeff + ", power=" + power + "]";
	}
	
}
