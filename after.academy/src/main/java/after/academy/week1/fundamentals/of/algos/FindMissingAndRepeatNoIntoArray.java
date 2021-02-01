package after.academy.week1.fundamentals.of.algos;

/**
 * 
 * TC O(N), stack stace (1) and aux space O(1)
 */

public class FindMissingAndRepeatNoIntoArray {

	static void missingAndRepeart(int arr[]) {
	
		int i;
		System.out.print("The repeating element is ");
		for (i = 0; i < arr.length; i++) { 
            
			int abs_val = Math.abs(arr[i]);
            
            if(abs_val < arr.length) {
            	if(arr[abs_val] > 0) {
            		arr[abs_val] = -arr[abs_val];
            	}else {
            		System.out.println(abs_val);
            	}
            }
            else {
            	arr[0] = -Math.abs(arr[0]); 
            }
        }
		
		  System.out.print("And the missing element is "); 
	        for (i = 0; i < arr.length; i++) { 
	            if (arr[i] >=0) 
	                System.out.println(i); 
	        }
		
	}

	
	public static void main(String[] args) {
		
		int arry[]= {2,2,0,1,4};
		FindMissingAndRepeatNoIntoArray.missingAndRepeart(arry);
	}

}
