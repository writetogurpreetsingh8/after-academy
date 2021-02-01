package after.academy.week1.fundamentals.of.algos;

public class RotateArrayByGivenValue {

	private static int gcd(int a, int b) 
    { 
        if (b == 0) 
            return a; 
        else
            return gcd(b, a % b); 
    }

	//https://www.youtube.com/watch?v=utE_1ppU5DY&t=779s
	// not very good solution.........
	private static void rotate(int arr[],int k, int n) {
		 		 //GCD(a,b)
		 int i, j, d, temp;
	        int g_c_d = gcd(k, n); //O(LOGB)
	        for (i = 0; i < g_c_d; i++) { 
	            /* move i-th values of blocks */
	            temp = arr[i]; 
	            j = i; 
	            while (true) { 
	              
	            	d = (j+k)%n; 
	                if (d == i) 
	                    break; 
	                arr[j] = arr[d]; 
	                j = d; 
	            } 
	            arr[j] = temp; 
	        }
		 
	 }
	 
	 //https://www.youtube.com/watch?v=ENcnXXiRT6E
	 //clock wise rotation
	 private static void rotateArrayByGiveValue1(int array[],int rotation) {

		 rotation = rotation % array.length;
		 reverseArray(array,0,array.length-rotation-1); //n-2 = n  50  n 
		 reverseArray(array,array.length-rotation,array.length-1); // 1 50 n  
		 reverseArray(array,0,array.length-1); // n  100 n 
	 }
	 
	 
	 // = n+n/2+n/2 
	 	// n+n = 2n = O(N)
	 private static void reverseArray(int array[], int start,int end) {
		 int temp = 0;
		 while(start<end) { // n 
			 temp = array[start];
			 array[start] = array[end];
			 array[end] = temp;
			 end--;
			 start++;
		 }
	 }
	  
	public static void main(String[] args) {
		
		int array[]= {7,4,3,2,1};
		RotateArrayByGivenValue.rotate(array, 1, array.length);
		
		for (int i = 0; i < array.length; i++) 
            System.out.print(array[i] + " ");
		
		System.out.println();
		int array1[]= {7,4,3,2,1};
		RotateArrayByGivenValue.rotateArrayByGiveValue1(array1, 1);
		
		for (int i = 0; i < array.length; i++) 
            System.out.print(array[i] + " ");
		

	}

}
