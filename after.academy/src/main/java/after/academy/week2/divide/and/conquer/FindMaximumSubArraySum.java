package after.academy.week2.divide.and.conquer;

public class FindMaximumSubArraySum {

	/**
	 * brute force approach with TC = O(N^2)
	 * aux space = O(1) and stack space = O(1) 
	 */
	
	private static int findMaxiMumSum0(int array[]) {
		
		if(array == null || array.length == 0) {
			return 0;
		}
		
		if(array.length == 1) {
			return array[0] >=0 ? array[0] : 0;
		}
		
		int sum = 0, maxSum = 0;
		int value = 0;
		for(int i=0;i<array.length;i++) {
			
			for(int j=i;j<array.length;j++) {
				value = array[j];
					sum = sum+value;
					if(sum > maxSum) {
						maxSum = sum;
					}
			}
			sum=0;
		}
		return maxSum;
	}
	
	/**
	 * apply DP here to reduce the TC O(N^2) to O(N) only
	 * aux space = O(1) and stack space O(1)
	 * 
	 *  https://www.youtube.com/watch?v=hPWJNoaI7t8
	 */
	
	private static int findMaxSubArrayDP(int array[]) {
		

		if(array == null || array.length == 0) {
			return 0;
		}
		
		if(array.length == 1) {
			return array[0] >=0 ? array[0] : 0;
		}
		
		int currentSum = 0, maxSum = 0;
		
		for(int j=0;j<array.length;j++) {
			
			currentSum+= array[j];
			
			if(currentSum > maxSum) {
				maxSum = currentSum;
			}
			if(currentSum <0 ) {
				currentSum = 0;
			}
		}
		return maxSum;
	}
	
	/**
	 * divide and conquer approach,,, with TC O(NLOGN)
	 * aux space O(1) and stack space O(LOGN) 
	 */
	private static int findMaxSubArraySumDivideAndConquerApproach(int array[]) {
		
		if(array == null || array.length == 0) {
			return 0;
		}
		
		if(array.length == 1) {
			return array[0] >=0 ? array[0] : 0;
		}
		
		return divideArray(array,0,array.length-1);
	}
	
	private static int divideArray(int array[],int left,int right) {
	
		int lsum = 0 , rsum = 0, midsum = 0;
		if(left < right) {
			
			int mid = (left + right)/2;
			
			lsum = divideArray(array,left,mid);
			rsum = divideArray(array,(mid + 1), right);
			midsum = combineResult(array,left,mid,right);
		}
		return Math.max(midsum,Math.max(lsum,rsum));
	}
	
	private static int combineResult(int array[],int left,int mid,int right) {
		
		int lsum = 0, rsum= 0 ;
		int lmaxSum = Integer.MIN_VALUE, rmaxSum = Integer.MIN_VALUE;
		
		for(int i=mid;i>=left;i--) {
		
			lsum += array[i];
			if(lsum > lmaxSum) {
				lmaxSum = lsum;
			}
		}
		for(int i=(mid+1);i<=right;i++) {
		
			rsum += array[i];
			if(rsum > rmaxSum) {
				rmaxSum = rsum;
			}
		}
		return (lmaxSum+rmaxSum);
	}
	
	
	public static void main(String[] args) {

		//int array[]= {-2,1,-3,4,-1,2,1,-5,4,-10,100};
		//int array[]= {-2,-3,4,-1,-2,1,5,-3};
		//int array[]=  {1,2,-3,-4,2,7,-2,3};
		//int array[]=  {-4,-2,-3,1,-1};
		int array[]=  {3,-2,5,-1};
		//System.out.println(FindMaximumSubArraySum.findMaxiMumSum0(array));
		//System.out.println(FindMaximumSubArraySum.findMaxSubArrayDP(array));
		System.out.println(FindMaximumSubArraySum.findMaxSubArraySumDivideAndConquerApproach(array));
	}
	
	

}
