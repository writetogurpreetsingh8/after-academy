package after.academy.week2.divide.and.conquer;

public class FindSqrRoot {

	/**
	 * 
	 * @param n
	 * @return
	 * find sqr-rooot of given number with brute-force approach
	 * TC is O(sq-root N) aux space and stack space O(1)
	 */
	
	private static int findSqrRoot(int n) {
		
		if(n<=1) {
			return n;
		}
		
		int value =0;
		int result = 0;
		
		while(result<=n) {
			value = value + 1;
			result = value * value;
		}
		return value-1;
	}
	
	static int oldValue=0;
	
	/**
	 * 
	 * @param n
	 * @return
	 * divide and conquer approach... 
	 * TC O(LOGN) aux sapce O(1) and stack space O(LOGN)
	 */
	private static int findSquareRoot(int n) {
		
		FindSqrRoot.oldValue = n;
		
		if(n<=1) {
			return n;
		}
		
		return findSquareRoot0(1,n,0);
		
	}

	/**
	 * 
	 * @param n
	 * @return
	 * divide and conquer approach... 
	 * TC O(LOGN) aux sapce O(1) and stack space O(LOGN)
	 */
	private static int findSquareRoot0(int l,int h,int value) {
		
		if(l>=h) {
			return value;
		}
		int mid = (l+h)/2;
		
		if((mid * mid) == FindSqrRoot.oldValue) {
			return mid;
		}
		
		if((mid * mid) > FindSqrRoot.oldValue) {
			h = mid-1;
			return findSquareRoot0(l,h,value);
		}
		else {
			l = mid+1;
			value = mid;
			return findSquareRoot0(l,h,value);
		}
	}
	
	public static void main(String[] args) {
		//System.out.println(FindSqrRoot.findSqrRoot(50));
		System.out.println(FindSqrRoot.findSquareRoot(65536));

	}

}
