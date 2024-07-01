package assignment_6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class IntSet {
	
	private final List<Integer> mySet;
	
	public IntSet(List<Integer> inputSet){
		
		mySet = new ArrayList<>();
		
		// Initializing the universal set
		for(int i=0; i<inputSet.size(); i++) {
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
	
	public List<Integer> getComplement(){
		List<Integer> complement = new ArrayList<>();
		for(int i=1; i<=100; i++) {
			if(!mySet.contains(i)) {
				complement.add(i);
			}
		}
		System.out.println("Complement created: " + complement);
		return complement;
	}
	
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
	
	public List<Integer> getUnion(IntSet otherSet){
		List<Integer> union = new ArrayList<>();
		// adding all the members of mySet to union
		for(int ele: mySet) {
			union.add(ele);
		}
		
		//adding non repeating elements of otherSet to union
		for(int i=0; i<otherSet.mySet.size(); i++) {
			if(!mySet.contains(otherSet.mySet.get(i)))
				union.add(otherSet.mySet.get(i));
		}
		Collections.sort(union);
		System.out.println("union created: " + union);
		return union;
	}
	
	public void displayMySet() {
		System.out.println("mySet: " + mySet);
	}
}
