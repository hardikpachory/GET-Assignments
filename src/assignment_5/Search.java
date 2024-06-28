package assignment_5;

import java.util.Arrays;
import java.util.Scanner;

public class Search {
	int size;
	int arr[];
	int element;
	
	/**
	 * Take input from the user, and execute the required function
	 */
	void takeInputAndExecute() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of Elements: ");
		size = sc.nextInt();
		System.out.println("Enter elements of Array: ");
		for(int i=0; i<size; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.print("Enter Element to search: ");
		element = sc.nextInt();
		System.out.println(" ---- Main Option ----");
		System.out.println("1. Linear Search");
		System.out.println("2. Binary Search");
		System.out.println("Enter Choice: ");
		int choice = sc.nextInt();
		if(choice == 1) {
			linearSearch(arr, element);
		} else if(choice == 2) {
			Arrays.sort(arr);
			binarySearch(arr, element);
		}
		sc.close();
	}
	
	/**
	 * Searches for an element in the array, and return the index if found
	 * @param nums Array of integers, require must not be empty
	 * @param ele  The element that is to be searched in the nums
	 * @return     The index of the element if present, otherwise an invalid index
	 */
	static int linearSearch(int[] nums, int ele) {
		return linearSearchHelper(nums, ele, 0);
	}
	
	/**
	 * Helper function to implement Linear Search recursively
	 * @param nums           Array of integers, require must not be empty
	 * @param ele            The element that is to be searched in the nums
	 * @param currentIndex   The current index being accessed in the recursion 
	 * @return               The index of the element 'ele' if it exists, otherwise an invalid index 
	 */
	private static int linearSearchHelper(int[] nums, int ele, int currentIndex) {
		if(currentIndex == nums.length)
			return -1;
		if(nums[currentIndex] == ele)
			return currentIndex;
		return linearSearchHelper(nums, ele, currentIndex+1);
	}
	
	/**
	 * Searches for an element in the array, and return the index if found
	 * @param nums Array of integers, require must not be empty and in ascending order
	 * @param ele  The element that is to be searched in the nums
	 * @return     The index of the element if it exists, otherwise an invalid index
	 */
	static int binarySearch(int[] nums, int ele) {
		return binarySearchHelper(nums, ele, 0, nums.length);
	}

	/**
	 * Helper function to implement binary search recursively
	 * @param nums   Array of integers, requires must not be empty and in ascending order
	 * @param ele    The element that is to be searched in the nums
	 * @param low    The lower bound of the section of array
	 * @param high   The upper bound of the section of array
	 * @return       The index of the element if it exists, otherwise an invalid index
	 */
	private static int binarySearchHelper(int[] nums, int ele, int low, int high) {
		if (high >= low) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == ele)
                return mid;

            if (nums[mid] > ele)
                return binarySearchHelper(nums, ele, low, mid - 1);

            return binarySearchHelper(nums, ele ,mid + 1, high);
        }
        return -1;
	}
	
	public static void main(String[] args) {
		System.out.println(binarySearch(new int[] { 0, 2, 4, 6, 8, 10, 12, 14, 16 }, 16));
	}
}
