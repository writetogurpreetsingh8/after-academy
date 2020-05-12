package after.academy.week2.divide.and.conquer;

public class InversionCountOfArray {

	/**
	 *
	 * brute force approach 
	 * TC O(N^2)
	 * try to improve our solution with divide and conquer approach
	 */
	
	private static int count = 0;
	private static void inversionOfDistinctArray(int array[]) {
		
		if(array == null || array.length <=2 ) {
			
			System.out.println("invalid array");
			return;
		}
		for(int i=0;i<array.length-1;i++) {
			
			for(int j=i+1;j<array.length;j++) {
				
				if( (i<j) && (array[i] > array[j]) ) {
					count++;
					System.out.println("inversion found at index of ( "+i+","+j+" ) with values of ( "+array[i]+","+array[j]+" )");
				}
			}
		}
	}
	
	/**
	 * customized merge sort to find inversion count into array
	 * TC is O(NLOGN). aux space is O(N) and stack space is O(LOGN) in case of recursive call only
	 */
	
	private static int inversionCount(int array[],int lower,int mid,int upper) {
		
			int i = lower;
			int j = mid + 1;
			int k = 0;
			int q = mid+1;
			int icount1=0;
			
			int size = ((mid - lower) + (upper - mid) + 1);
			int tempArray[] = new int[size];
			
			while( i <= mid && j <= upper) {
				
				if(array[i] <= array[j]) {
					tempArray[k] = array[i];
					i++;
				}
				else {
					tempArray[k] = array[j];
					icount1 = icount1 + (q-i);
					j++;
				}
				k++;
			}
			// coping remaining element from Ith list into temp Kth array
			while( i<= mid) {
					tempArray[k] = array[i];
					k++;
					i++;
			}
			// coping remaining element from Jth list into temp Kth array
			while(j <= upper) {
				tempArray[k] = array[j];
				j++;k++;
			}
			
			//copy  temp array into actual array;
			
			for(int l=0; l<tempArray.length;l++) {
				array[lower] = tempArray[l];
				lower++;
			}
			
			return icount1;
	}
	

	private static int mergeSort(int array[], int lower,int upper) {
		
		int mid = 0;
		int icount1=0, icount2=0, icount3=0;
		
		if(lower < upper) {
			mid = (lower + upper) / 2;
			icount1 = mergeSort(array,lower,mid);
			icount2 = mergeSort(array,mid+1,upper);
			icount3 = inversionCount(array,lower,mid,upper);
		}
		return (icount1 + icount2 + icount3);
	}
	
	public static void main(String[] args) {
		
		int array[]= {5,6,0,1,2,4};
		
		System.out.println(InversionCountOfArray.mergeSort(array,0,array.length-1));
		//System.out.println(count);
	}

}
