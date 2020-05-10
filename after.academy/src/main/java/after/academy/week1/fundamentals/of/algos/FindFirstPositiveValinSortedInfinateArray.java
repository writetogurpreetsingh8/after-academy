package after.academy.week1.fundamentals.of.algos;

/**
 * @author 91783
  *having a sorted infinate array ( lenght/size is unknown (can't use lenght property of array)) some few values of 
  array is -val after that all are +post find the first position of +val
  i.e [-10,-7,-4,-2,-1,0,1,2,3,4,6,8,9,10,20] ans 0
  i.e [-10,-7,-4,-2,-1,1,2,3,4,6,8,9,10,20] ans 1
  
   all the elements are sorted in order ascending order
 *  
 *  stack and space complexity is O(1)
 *  time complexity would be = time taken to find the interval + perform binary-searching on that interval
 *  										O(logi)				+		O(logi)
 * total TC would be 2logi So O(logi)
 * 
 */

public class FindFirstPositiveValinSortedInfinateArray {

	private static int findFirstPositiveVal(int array[]) {
	
		if(array == null) {
			return -1;
		}
		
		int lower = 0,end = 0;
		int interval = 6; // value of interval could be any +val
		end = interval;
		
		while(array[end] < 0) {
			
			lower = end + 1;
			end = (end * 2);
		}
		// perform binary-searching on the located interval
		return binarySearching(array,lower,end);
	}
	
	private static int binarySearching(int array[], int lower,int end) {
		
		if(array[lower] >= 0 || array[end] == 0 || array[end - 1] == 0) {
			return array[lower];
		}
		int mid = 0;
		
		while(lower <= end) {
			
			mid = (lower + end) / 2;
			
			if(array[mid] == 0) {
				return array[mid];
			}
			if(array[mid + 1] >=0 && array[mid] < 0) {
				return array[mid + 1];
			}
			if(array[mid - 1] == 0 && array[mid] > 0) {
				return array[mid - 1];
			}
			
			if(array[mid] > 0) {
				end = mid - 1;
			}
			else {
				lower = mid + 1;
			}
		}
		return Integer.MIN_VALUE;
	}
	
	public static void main(String[] args) {
		
		int array[]= {-10,-9,-7,-5,-3,-2,-1,3,4,6,8,9,10,20};
		System.out.println(FindFirstPositiveValinSortedInfinateArray.findFirstPositiveVal(array));
		
	}

}
