package after.academy.week1.fundamentals.of.algos;

// space complexity is O(1)
// stack complexity is O(1)
// time complexity is O(logN)

public class FindMinInSortedAndRotatedArray {

	
	private int findMin(int array[]) {
		
		if(array == null || array.length == 0 ) {
			return -1;
		}
		return findMin0(array,0,array.length-1);
	}
	
	private int findMin0(int array[],int l,int h) {
		
		if(l > h) {
			return array[0]; // base case for safer side.......
		}
		
		if(l == h) {
			return array[l]; // base case
		}
		
		int mid = (l+h)/2;
		
		
		 if(mid > l && array[mid] < array[mid-1]) {
			 return array[mid]; 
		}
		 if(mid < h && array[mid] > array[mid+1]) { 
			 return array[mid+1]; 
		}
		 
		if(array[mid] < array[h]) {
			return findMin0(array,l,(mid-1));
		}
		else {
			return findMin0(array,(mid+1),h);
		}
	}
	
	public static void main(String[] args) {

		FindMinInSortedAndRotatedArray instance = new FindMinInSortedAndRotatedArray();
		int array[]= {6,7,8,9,0,0,1,-1,2,3,4};
		System.out.println(instance.findMin(array));
	}

}
