package after.academy.week1.fundamentals.of.algos;

/**
 * time complexity O(LOGN) space complexity O(1)
 * stack space O(1)... ARRAYS MUST BE OF SAME SIZE and SORTED as well
 * ARRAY CAN BE EITHER ODD or EVEN...........
 */
 public class FindMedianOfTwoSortedArrays1 {

	
	private static double findMedian(int array1[],int array2[],int n) {
		
			 if( (array1 == null || array2 == null) || (array1.length == 0 || array2.length == 0)) {
				 System.out.println("invalid arrays.......");
				 return -1;
			 }
			 if(array1.length != array2.length) {
				 System.out.println("invalid arrays , the lenght of arrays must be same...");
				 return -1;
			 }
			 
			 if(n == 1) {
				 return (array1[0] + array2[0]) / 2;
			 }
			 
			 int start1 = 0, start2 = 0, end1 = n, end2 = n;
			 int mid1 = 0,mid2=0;
			 int elementCount = 0;
			 
			 while(start1 < end1) {
			
				 if((end1 - start1) == 1) {
					 return (Math.max((double)array1[start1], (double)array2[start2]) 
							 + Math.min((double)array1[end1], (double)array2[end2])) / 2; 
				 }
				 
				 mid1 = findMedian(array1,start1,end1);
				 mid2 = findMedian(array2,start2,end2);
				 
				 //in case of there is one 1 unit of difference b/w both the mid's
				 //might be in case of ascending or descending array
				 /*if(Math.abs((mid1 - mid2)) == 1) {
					 System.out.println("abs..................");
					 return ((double)mid1 + (double)mid2) / 2;
				 }*/
				 if(mid1 == mid2) {
					 System.out.println("............................");
					 return (double)mid1;
				 }
				 elementCount = countElements(start1,end1);
				 if(elementCount % 2 == 0) {
					 if( mid1 < mid2 ) {
						 start1 = ( ( (end1+start1) -1 ) / 2);
						 end2 = ( ( (end2+start2) + 1 ) /2);
					 }else {
						 start2 = ( ( (end2+start2) -1 ) /2);
						 end1 = ( ( (end1+start1) + 1) /2);
					 }
				 }else {
					 if( mid1 < mid2 ) {
						 start1 = (start1+end1)/2;
						 end2 = (start2+end2)/2;
					 }else {
						 start2 = (start2+end2)/2;
						 end1 = (start1+end1)/2;
					 }
				 }
			 }
			 return -1;
	}
	
	private static int findMedian(int[] array,int start, int end) {
		
		int n = countElements(start,end);
		if( n % 2 == 0) {
			
			return (array[(start + (n/2))] + array[(start + (n/2 - 1))]) / 2;
		}else {
			return array[(start + n/2)];
		}
	}
	
	private static int countElements(int start,int end) {
		return (end - start + 1);
	}
	
	public static void main(String[] args) {

		int array1[]= {1,2,3,5,7,8,10,101};
		int array2[]= {4,6,9,11,12,50,100,102};
		
		//int array1[]= {1,3,5,7};
		//int array2[]= {2,4,6,8};
		
		System.out.println(FindMedianOfTwoSortedArrays1.findMedian(array1, array2, array1.length-1));
	}

}
