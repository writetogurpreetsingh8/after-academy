package after.academy.week1.fundamentals.of.algos;

/**
 * time complexity O(LOGN) space complexity O(1)
 * stack space O(1)... ARRAYS MAY BE OF SAME SIZE OR DIFFERENT In Size
 * ARRAY CAN BE EITHER ODD or EVEN...........but must be SORTED as well
 * https://www.youtube.com/watch?v=LPFhl65R7ww&t=1027s
 */

public class FindingMedianIntoSortedButDifferentSizeArrays {

	static double findingMediean(int array1[],int array2[]) {
		
		if( (array1 == null || array2 == null)) {
			return -1;// invalid arrays
		}
		if( (array1.length == 0 && array2.length == 0)) {
			return -1;// invalid arrays
		}
		
		if( (array1.length == array2.length) && (array1.length == 1) ) {
			return ((double)array1[0] + (double)array2[0] / 2);
		}
		if( (array1.length == array2.length) && (array1.length == 2) ) {
			return ((Double.max((double)array1[0],(double)array2[0]) + Double.min((double)array1[1], (double)array2[1])) / 2);
		}
		
		if(array1.length > array2.length) {
			return findingMediean(array2,array1);
		}
		
		if(array1.length == 0 && array2.length == 1) {
			return (double) array2[0];
		}
		
		if(array1.length == 1 && array2.length == 2) {
			if(array1[0] > array2[1]) {
				return (double)array2[1];
			}
			if(array1[0] >= array2[0]) {
				return (double)array1[0];
			}
			if(array1[0] <= array2[0]) {
				return (double)array2[1];
			}
			
		}
		
		int start = 0, end = array1.length-1;
		int end1 = array2.length;
		int array1LeftValue = 0,array1RightValue = 0,array2LeftValue,array2RightValue;
		int array1Partition = 0, array2Partition = 0;
		
		while(start <= end) {
			
			array1Partition = (start + end) / 2;
			
			array1LeftValue = array1Partition <= 0 ? Integer.MIN_VALUE : array1[array1Partition-1];
			array1RightValue = array1Partition >= end ? Integer.MAX_VALUE : array1[array1Partition];
			
			array2Partition = ((((array1.length) + (array2.length) + 1) / 2) - array1Partition);
			

			array2LeftValue = array2Partition <= 0 ? Integer.MIN_VALUE : array2[array2Partition-1];
			array2RightValue = array2Partition >= end1 ? Integer.MAX_VALUE : array2[array2Partition];
			
			if( (array1LeftValue <= array2RightValue) && (array2LeftValue <= array1RightValue) ) {
				
				if( ((array1.length + array2.length) % 2) == 0) {
					return (Double.max((double)array1LeftValue, (double)array2LeftValue) 
							+ Double.min((double)array1RightValue, (double)array2RightValue) ) / 2;   
				}else {
					return Double.max((double)array1LeftValue, (double)array2LeftValue);
				}
			}
			else if(array2LeftValue > array1RightValue) {
				start = array1Partition + 1;
			}else {
				end = array1Partition - 1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		
		//int array1[]= {1,2,3,5,7,8,10,101};
		//int array2[]= {4,6,9,11,12,50,100,102};
		
		//int array1[]= {1,3,4,7};
		//int array2[]= {2,5,8,10,20};
		
		int array1[]= {1,3};
		int array2[]= {2};
		
		//int array1[]= {2,3};
		//int array2[]= {};
		
		//int array1[]= {1,3};
		//int array2[]= {};
				
		//int array1[]= {1};
		//int array2[]= {};
		
		//int array1[]= {};
		//int array2[]= {};
		
		//int array1[]= {1,3};
		//int array2[]= {2};
		
		//int array1[]= {1,2};
		//int array2[]= {3,4};
		
		//int array1[]= {1,2,3,6};
		//int array2[]= {4,5};
		
		
		System.out.println(FindingMedianIntoSortedButDifferentSizeArrays.findingMediean(array1, array2));

	}

}
