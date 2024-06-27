package assignment_4;

/**
 * This class performs various Array operation methods like - splitArray,
 * countClumps, fixXY and maxMirror. 
 */

public class ArrOperation {
	
	/**
	 * Returns the index, of array such that the sum of its elements
	 * on its right and left is equal
	 * @param arr               array of integers, requires must not be empty
	 * @return                  the required index if exists, else -1
	 * @throws AssertionError   if the array provided is empty
	 */
	static int splitArray(int[] arr) throws AssertionError {
		if(arr.length == 0) {
			throw new AssertionError("Empty array provided");
		}
		int totalSum = 0;
		int leftSum = 0;
		for(int element: arr) {
			totalSum += element;
		}
		int lastIndex = arr.length - 1;
		for( int i = lastIndex; i>=0; i--) {
			leftSum += arr[i];
			totalSum -= arr[i];
			if(leftSum == totalSum) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Returns the array after moving Y element , next to X element
	 * @param arr                array of integers, requires must not be empty
	 * @param X                  the element that will be fixed
	 * @param Y                  the element that can be moved
	 * @return                   array after moving Y next to X 
	 * @throws AssertionError    1.)  If the array is empty
	 *                           2.) If X is in the end of Array
	 *                           3.) If numbers of X and Y are unequal
	 *                           4.) If two X are adjacent
	 */
	static int[] fixXY(int[] arr, int X, int Y) throws AssertionError {
		if( arr.length == 0 ) {
			throw new AssertionError("Empty input array provided");
		}
		if( arr[arr.length-1] == X) {
			throw new AssertionError("X present at last index in input array");
		}
		int countX = 0;
		int countY = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]==X)
				countX++;
			else if(arr[i]==Y)
				countY++;
		}
		if(countX != countY) {
			throw new AssertionError("Unequal numbers of X and Y in Input array");
		}
		int temp;
		int settleIndex=-1;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == X && arr[i+1]!=Y) {
				if(arr[i+1] == X) {
					throw new AssertionError("Two X are together in input array");
				}
				if(i!=0 && arr[i-1]==Y && (i-1)!=settleIndex) {
					temp = arr[i+1];
					arr[i+1] = arr[i-1];
					arr[i-1] = temp;
					i++;
					settleIndex = i;
				} else if( (i+2) < arr.length && arr[i+2]==Y) {
					temp = arr[i+2];
					arr[i+2] = arr[i+1];
					arr[i+1] = temp;
					i+=2;
				}
			}
		}
		return arr;
	}
	
	/**
	 * Returns the number of common adjacent elements like {1,2,2,3,4,4} -> 2
	 * @param arr               array of integers, requires must not be empty
	 * @return                  number of clumps(adjacent numbers set) present
	 * @throws AssertionError   if the array is empty
	 */
	static int countClumps(int[] arr) throws AssertionError {
		if(arr.length == 0) {
			throw new AssertionError("Empty array provided");
		}
		int totalClumps = 0;
		int iterator = 0;
		int size = arr.length;
		int nextIndex;
		while(iterator < size) {
			nextIndex = iterator + 1;
			if(nextIndex < size && arr[nextIndex] == arr[iterator]) {
				totalClumps++;
				while(nextIndex < size && arr[nextIndex] == arr[iterator]) {
					nextIndex++;
					iterator++;;
				}
				iterator--;
			}
			iterator++;
		}
		return totalClumps;
	}
	
	/**
	 * Helper function to return the last occurrence of an element
	 * @param arr  array of integers, requires must not be empty
	 * @param ele  an integer that is to be searched
	 * @return     the last index of element, else -1
	 */
	static int getNextIndex(int[] arr, int ele) { //Helper function to get the last index of an element
		for(int i=arr.length -1; i>=0; i--) {
			if(arr[i]==ele)
				return i;
		}
		return -1;
	}
	
	/**
	 * Return the maximum length of mirror available in array
	 * @param arr               array of integers, requires must not be empty
	 * @return                  maximum length of mirror available
	 * @throws AssertionError   if the array is empty
	 */
	static int maxMirror(int[] arr) throws AssertionError {
		if(arr.length == 0) {
			throw new AssertionError("Empty array provided");
		}
		int maxMirror = 0;
		int currMirror = 0;
		int currIndex;
		int nextIndex = 0;
		for(int i=0; i < arr.length; i++) {
			nextIndex = getNextIndex(arr, arr[i]);
			if(nextIndex>i) {
				currIndex = i;
				if(nextIndex - i == 2) {
					currMirror = 3;  // Such as ["1, 2, 1," 3]
					maxMirror = (currMirror > maxMirror) ? currIndex : maxMirror;
				} else {
					currMirror = 0;
					while(currIndex<=nextIndex && arr[currIndex]==arr[nextIndex]) {
						currMirror++;
						if(currIndex == nextIndex) {
							currMirror = (2 * currMirror) - 1;
						}
						else if(currIndex+1 == nextIndex) {
							currMirror *= 2 ;
						}
						currIndex ++;
						nextIndex--;
					}
				}
				maxMirror = (currMirror > maxMirror) ? currMirror : maxMirror;
			}
		}
		return maxMirror;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public static void main(String[] args) {
////		int[] arr = {1,4,5,3,5,4,1};
////		System.out.println(maxMirror(arr));
//		int[] arr = {};
//		System.out.println(splitArray(arr));
//	}

}
