package after.academy.week1.fundamentals.of.algos;

public class RotateArrayByGivenValue {

	private static int gcd(int a, int b) 
    { 
        if (b == 0) 
            return a; 
        else
            return gcd(b, a % b); 
    }
	
	 
	 private static void rotate(int arr[],int k, int n) {
		 
		 
		 int i, j, d, temp; 
	        int g_c_d = gcd(k, n); 
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
	  
	public static void main(String[] args) {
		
		int array[]= {7,4,3,2};
		RotateArrayByGivenValue.rotate(array, 3, array.length);
		
		for (int i = 0; i < array.length; i++) 
            System.out.print(array[i] + " ");

	}

}
