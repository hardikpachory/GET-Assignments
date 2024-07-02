package assignment_6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * The class IntSet serves as the set of integers that are immutable in nature.
 * The immutability is performed by:
 * -> declaring class as final to avoid inheritence
 * -> making the data members as private to avoid direct access
 * -> making the data members as final so that their values cannot be changed after
 * 	  creation of the object
 * -> Parameterized construction to provide values to our data members
 * -> No setter function
 */
public final class IntSet {
	
	private final List<Integer> mySet;
	
	public IntSet(List<Integer> inputSet){
		
		mySet = new ArrayList<>();
		
		// Initializing the universal set
		int size = inputSet.size();
		for(int i=0; i<size; i++) {
			if(!mySet.contains(inputSet.get(i)))
				mySet.add(inputSet.get(i));
		}
		System.out.println("Object create [mySet]: " + mySet);
	}
	
	/**
	 * Check whether the given element is present in the set
	 * @param x the required element that is to be searched in the set	
	 * @return  true if element is present, else false  
	 */
	public boolean isMember(int x) {
			if(mySet.contains(x))
				return true;
		return false;
	}
	/**
	 * Returns the number of elements in mySet
	 * @return size of the mySet
	 */
	public int size() {
		return mySet.size();
	}
	
	/**
	 * Check if the object secondSet
	 * @param secondSet
	 * @return
	 */
	public boolean isSubSet(IntSet secondSet) {
		for(int element: secondSet.mySet) {
			if(!mySet.contains(element))
				return false;
		}
		return true;
	}
	
	/**
	 * Get the complement of the current set from universal set
	 * @return The Listof elements of the complement
	 */
	public List<Integer> getComplement(){
		List<Integer> complement = new ArrayList<>();
		for(int i=1; i<=1000; i++) {
			if(!mySet.contains(i)) {
				complement.add(i);
			}
		}
		System.out.println("Complement created: " + complement);
		return complement;
	}
	
	/**
	 * Perform difference of two sets
	 * @param otherSet IntSet object 
	 * @return         IntSet object as the difference of sets  
	 */
	public List<Integer> getDifference(IntSet otherSet){
		List<Integer> difference = new ArrayList<>();
		// adding all the members of mySet to union
		
		//adding non repeating elements of otherSet to union
		for(int ele : mySet) {
			if(!otherSet.isMember(ele))
				difference.add(ele);
		}
		Collections.sort(difference);
		System.out.println("difference created: " + difference);
		return difference;
	}
	
	/**
	 * Perform intersection of two sets
	 * @param otherSet IntSet object
	 * @return         IntSet object as the intersection of objects
	 */
	public List<Integer> getIntersection(IntSet otherSet){
		List<Integer> intersection = new ArrayList<>();
		// adding all the members of mySet to union
		
		//adding non repeating elements of otherSet to union
		for(int ele : mySet) {
			if(otherSet.isMember(ele))
				intersection.add(ele);
		}
		Collections.sort(intersection);
		System.out.println("intersection created: " + intersection);
		return intersection;
	}
	
	/**
	 * Perform union operation of two sets
	 * @param otherSet IntSet object
	 * @return         IntSet object as the union of objects
	 */
	
	//TODO: use size variable rather than function [Completed]
	public List<Integer> getUnion(IntSet otherSet){
		List<Integer> union = new ArrayList<>();
		// adding all the members of mySet to union
		for(int ele: mySet) {
			union.add(ele);
		}
		
		//adding non repeating elements of otherSet to union
		int size = otherSet.size();
		for(int i=0; i<size; i++) { //Not to use .size()
			if(!mySet.contains(otherSet.mySet.get(i)))
				union.add(otherSet.mySet.get(i));
		}
		Collections.sort(union);
		System.out.println("union created: " + union);
		return union;
	}
	
	/**
	 * Function to display the elements of the set
	 */
	public void displayMySet() {
		System.out.println("mySet: " + mySet);
	}
}
