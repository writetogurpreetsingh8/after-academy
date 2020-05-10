package after.academy.week2.divide.and.conquer;

/**
 * 
 * @author 91783
 * having two different size / same size sorted array find kth smallest number
 * TC would be O(LOGN) by implemening divide and conquer technica
 * aux space O(1) and stack space O(LOGN) we can reduce stack space
 * if we go with the iterative approach...........
 *
 */
public class FindKthSmallestElementIntoTwoSortedArray {

	private static int findKthSmallestElement(int arrayA[],int arrayB[],int k) {
		
		if(arrayA == null || arrayB == null 
				|| (arrayA.length == 0 && arrayB.length == 0)) {
			
			return -1; // invalid arrays;
		}
		if(k> (arrayA.length + arrayB.length) || k<=0) {
			return -1;// invalid kth element;
		}
			
		if(arrayA.length == 1 && arrayB.length == 0) {
			return arrayA[0]; // default case;
		}
		if(arrayA.length == 0 && arrayB.length == 1) {
			return arrayB[0]; // default case;
		}
		if(arrayA.length == 1 && arrayB.length == 1) {
			return Math.min(arrayA[0],arrayB[0]); // default case;
		}
		if(arrayA[0] >= arrayB[arrayB.length-1]) {
			return arrayB[k-1]; // default case;
		}
		if(arrayB[0] >= arrayA[arrayA.length-1]) {
			return arrayA[k-1]; // default case;
		}
		
		return findKthSmallestElement(arrayA,arrayB,0,0,arrayA.length,arrayB.length,k);
		
	}
	
	private static int findKthSmallestElement(int arrayA[],int arrayB[],int la,int lb,int ra,int rb, int k) {
	
		
		  if(la >= ra) {
			  return arrayB[k-1]; 
		  } 
		  if(lb >= rb) { 
			  return arrayA[k-1]; 
		  }
		 
		if(k == 1) {
			return Math.min(arrayA[la], arrayB[lb]);
		}
		
		int midA = Math.min(ra, k/2);
		int midB = Math.min(rb, k/2);
		
		int ia = (la + midA) > ra ? ra : (la + midA);
		int ib = (lb + midB) > rb ? rb : (lb + midB);
		
		if(arrayA[ia - 1] > arrayB[ib - 1]) {
			
			return findKthSmallestElement(arrayA,arrayB,la, (lb+midB),ra,rb,k-midB);
		}
		else {
			return findKthSmallestElement(arrayA,arrayB,(la+midA),lb,ra,rb,k-midA);
		}
		
	}
		
	
	public static void main(String[] args) {

		int arr1[] = { 1,2,5,7,9,10 }; 
				int arr2[] = { 0,3,4,6,8 };
				
				//int arr1[] = {2,3,7,10,15 }; 
				//int arr2[] = { 0,1,4,5,6,8,9,11,12};
				
				System.out.println(FindKthSmallestElementIntoTwoSortedArray.findKthSmallestElement(arr1,arr2,11));
				
	}

}
