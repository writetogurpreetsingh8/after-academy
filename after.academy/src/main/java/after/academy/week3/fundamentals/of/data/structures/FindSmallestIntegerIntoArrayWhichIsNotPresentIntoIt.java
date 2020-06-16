package after.academy.week3.fundamentals.of.data.structures;

import java.util.Arrays;

/**
 * 
 *https://stackoverflow.com/questions/51719848/find-the-smallest-positive-integer-that-does-not-occur-in-a-given-sequence
 * Given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
	For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
	Given A = [1, 2, 3], the function should return 4.
	Given A = [−1, −3], the function should return 1.
	
	https://www.youtube.com/watch?v=2QugZILS_Q8&t=645s
 *
 */

public class FindSmallestIntegerIntoArrayWhichIsNotPresentIntoIt {

	/**
	 * TC O(NLOGN) overall time complexity 
	 * Stack space if perform recursively then O(LOG), else O(1)
	 * aux space O(1)
	 */
	private static int findSmallestIntegerIntoArrayWhichIsNotPresentIntoIt(int array[]) {
		
		if(array == null || array.length <1) {
			return 1;
		}
		if(array.length == 1 && array[0] == 1) {
			return 1;
		}
		if(array.length == 1 && array[0] != 1) {
			return 1+array[0];
		}
		Arrays.sort(array); // merge sort // O(NLOGN)
		
		if(array[array.length-1] <=0) {
			return 1;
		}
		if(array[0] > 1) {
			return 1;
		}
		
		int smallestValue = 1;
		
		for(int i=0;i<array.length;i++) {
		
			if(array[i] == smallestValue) {
				smallestValue++;
			}
		}
		return smallestValue;
	}
	
	/**
	 * with-out applying sorting the data...
	 * TC O(N+K)
	 * stack space O(1)
	 * aux space (K)
	 * use count sort to  get the result...........
	 */
	private static int findSmallestIntegerIntoArrayWhichIsNotPresentIntoIt1(int array[]) {
		
		if(array == null || array.length < 1) {
			return 1;
		}
		if(array.length == 1 && array[0] == 1) {
			return 1;
		}
		if(array.length == 1 && array[0] != 1) {
			return 1+array[0];
		}
		
		int max = getMaxValue(array);
		int tempArray[] = new int [max+1];
		boolean isArrayNegtive = true;
		
		for(int i=0;i<array.length;i++) {
		
			if(array[i] >0) {
				tempArray[array[i]]++;
				isArrayNegtive = false;
			}
		}
		
		if(isArrayNegtive) {
			return 1;
		}
		int i;
		for(i=1;i<tempArray.length;i++) {
			
			if(tempArray[i] == 0) {
				return i;
			}
		}
	
		return i;
	}
	
	private static int findSmallestIntegerIntoArrayWhichIsNotPresentIntoIt2(int nums[]) {
	
	int n = nums.length;
    boolean oneExist = false;
    for(int o : nums){
        if(o == 1) oneExist = true;
    }
    if(!oneExist) return 1;
    
    //making sure we will never see a number in the 
    //array apart from 1...n
    for(int i = 0; i < nums.length; i++){
        if(nums[i] <= 0 || nums[i] > n) {
        	nums[i] = 1;
        }
    }
    
    for(int i = 0; i < nums.length; i++){
        int v = Math.abs(nums[i]);
        
        
        //simply invalidating an index v and it's content
        //because we found a value v
        if(v == n){
            nums[0] = -1 * Math.abs(nums[0]);
        }else{
            nums[v] = -1* Math.abs(nums[v]);
        }
    }
    
    for(int i = 1; i < n; i++){
        if(nums[i] > 0) {
        	return i;
        }
    }
    
    if(nums[0] > 0) {
    	return n;
    }
    return n + 1;
}
	
	private static int getMaxValue(int array[]) {
		
		int max = Integer.MIN_VALUE;
		
		for(int i=0;i<array.length;i++) {
		
			if(array[i] > max) {
				max = array[i];
			}
		}
		return max;	
	}
	public static void main(String[] args) {

		int array[] = {1,3,6,4,1,2};
		//int array[] = {1,2,3};
		//int array[] = {-3,-1};
		
		System.out.println(FindSmallestIntegerIntoArrayWhichIsNotPresentIntoIt
				.findSmallestIntegerIntoArrayWhichIsNotPresentIntoIt(array));
		
		System.out.println(FindSmallestIntegerIntoArrayWhichIsNotPresentIntoIt
				.findSmallestIntegerIntoArrayWhichIsNotPresentIntoIt1(array));
		
		System.out.println(FindSmallestIntegerIntoArrayWhichIsNotPresentIntoIt
				.findSmallestIntegerIntoArrayWhichIsNotPresentIntoIt2(array));
	}

}
