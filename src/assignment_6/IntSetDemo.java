package assignment_6;

import java.util.List;

public class IntSetDemo {
	public static void main(String[] args) {
		IntSet set = new IntSet(List.of(1,4,5,6,7));
		set.getComplement();
		System.out.println("----------------------------------  ");
		IntSet otherSet = new IntSet(List.of(2, 5,11, 13, 15, 19, 123, 456, 709));
		set.getUnion(otherSet);
		set.getIntersection(otherSet);
		set.getDifference(otherSet);
		System.out.println("----------------------------------  ");
		System.out.println("mySet.isMember(15) : " + set.isMember(15));
		System.out.println("otherSet.isMember(15) : " + otherSet.isMember(15));
		System.out.println("----------------------------------  ");
		System.out.println("set.isSubSet(OtherSet): " + set.isSubSet(otherSet));
		System.out.println("set.isSubSet(set): " + set.isSubSet(set));
		System.out.println("----------------------------------  ");
		System.out.println("set.size(): " + set.size());
		System.out.println("otheSet.size(): " + otherSet.size());
		
	}
}
