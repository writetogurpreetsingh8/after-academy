package after.academy.week3.fundamentals.of.data.structures;

/**
 * 
 * TC O(N) , stack O(1), aux O(1)
 * https://www.youtube.com/watch?v=6KHW7ZQwtCA
 * In the below algo array must have only 1 missing element and no need to sort the array....
 */
public class FindMissingNumber {

	private static int findMissingNumber(int array[]) {
		
		if(array == null || array.length == 0) {
			return -1;
		}
		if(array.length == 1) {
			return array[0];
		}
		
		int xor1 = array[0];
		int xor2 = 1;
		
		for(int i=1;i<array.length;i++) {
			
			xor1^=array[i];
		}
		
		for(int i=2;i<=array.length+1;i++) {
			
			xor2^=i;
		}
		return (xor1 ^ xor2);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = {1,2,3,5,6};
		System.out.println(FindMissingNumber.findMissingNumber(array));	
	}

}
