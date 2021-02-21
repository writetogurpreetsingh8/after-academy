package after.academy.week1.fundamentals.of.algos;

/**
 * time complexity O(n) space complexity O(1)
 * stack space O(1)... ARRAYS MUST BE OF SAME SIZE and SORTED as well
 * ARRAY CAN BE EITHER ODD or EVEN...........
 * */
public class FindMedianOfTwoSortedArrays {

	private static double findMedian(int array1[],int array2[],int n) {
		
		
		if( (array1 == null || array2 == null) || (array1.length == 0 || array2.length == 0)) {
			 System.out.println("invalid arrays.......");
			 return -1;
		 }
		/*
		 * if(array1.length != array2.length) {
		 * System.out.println("invalid arrays , the lenght of arrays must be same...");
		 * return -1; }
		 */
		/*
		 * if ( array1[n-1] < array2[0] ) return ( array1[n-1] + array2[0]) / 2; //
		 * corner cases applies
		 * 
		 * else if ( array2[n-1] < array1[0] ) return ( array1[0] + array2[n-1]) / 2; //
		 * corner cases
		 */		 else {
			  int i=0, j=0, k=0;
			  int m1=0 , m2=0;
			  while(k < n-1){
				  if (array1[i]<array2[j]) {
					  i++;
				  }
				  else {
					  j++;
				  }
				  k++;
			  }
			  if (array1[i] > array2[j]) {
				  m1=array2[j];
				  j++;
			  }
			  else {
				  m1=array1[i];
				  i++;
			  }
			  if (array1[i] > array2[j]) {
				  m2=array2[j];
			  }
			  else {
				  m2=array1[i];
			  }
			  System.out.println("m1 is  "+m1+" and m2 is "+m2);
			  return ((double)m1+(double)m2)/2;
		 }
	}
	
	public static void main(String[] args) {

		//int array1[]= {1,2,3,5,7,8,10,101};
		//int array2[]= {4,6,9,11,12,50,100,102};
		
		int array1[]= {1,3,5,7,9,10};
		int array2[]= {2,4,6,8};
		
		System.out.println(FindMedianOfTwoSortedArrays.findMedian(array1, array2, array1.length));
	}

}
