package after.academy.week4.dynamic.programming;

/**
 * 
 *   @author Tony.Stark
 *	This is bounded or 0-1 knapsack recursive problem with DP(Bottom-UP Approch / Tabulization) ..
 *below are 4 different methods having same TC , aux and stack
 *but the only difference is the way how I wrote the code!!!!
 *	TC is O(N^2) , Aux Space is O(N*C) and Stack Space is O(1)....
 *https://www.youtube.com/watch?v=ntCGbPMeqgg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=5
 *table filing machanisam = https://www.youtube.com/watch?v=nLmhmB6NzcM&list=PLDN4rrl48XKpZkf03iYFl-O29szjTrs_O&index=55&t=0s
 */
public class BoundedKnapsackDPWithBottomUp {
	
	private static int boundedKnapsack(int items[],int price[],int capacity){
		
		if( (items == null || price == null) || (items.length == 0 || price.length == 0) ) {
			System.out.println("invalid arrays either items/pirce or both...");
			return -1;
		}
		
		if( (items.length != price.length) ) {
			System.out.println("invalid arrays , the length of price array must be as same as length of items array...");
			return -1;
		}
		
		if(capacity <= 0 ) {
			System.out.println("invalid given capacity .....");
			return -1;
		}
		// having only 1 item & having valid capacity then just reutrn the price directly 
		// no need to call bounded knapsack recurive method.....
		if( (items.length == 1 && price.length == 1) && (capacity >= items[0]) ) {
			return price[0];
		}
		
		Integer t[][] = new Integer [price.length+1][capacity+1];
		return boundedKnapsack(items,price,items.length,capacity,t);
		
	}
	private static int boundedKnapsack(int items[],int price[],int n,int capacity,Integer t[][]){
		
		for(int i=0;i<n+1;i++) {
			
			for(int j=0;j<capacity+1;j++) {
				
				if(i==0 || j==0 ) {
					t[i][j] = 0;
				}
				else if(items[i-1] > j) {
					t[i][j] = t[i-1][j];
				}
				else {
					int value = price[i-1];
					int itemAdded = t[i-1][j-items[i-1]];
					int sum = value + itemAdded;
					int itemNotAdded = t[i-1][j];
					int finalValue = Math.max(sum,itemNotAdded);
					t[i][j] = finalValue;
				}
			}
		}
		return t[n][capacity];
	}

	public static void main(String[] args) {
		
		int items[]= {1,3,4,5};
		int price[]= {1,4,5,7};
		int capacity = 7;
		System.out.println(BoundedKnapsackDPWithBottomUp.boundedKnapsack(items,price,capacity));
	}

}
