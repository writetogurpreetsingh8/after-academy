package after.academy.week4.dynamic.programming;

/**
 * 
 *   @author Tony.Stark
 *	This is bounded or 0-1 knapsack recursive problem with DP(TOP-DOWN Approch / memoization) ..
 *below are 4 different methods having same TC , aux and stack
 *but the only difference is the way how I wrote the code!!!!
 *	TC is O(N^2) , Aux Space is O(N*C) and Stack Space is O(N)....
 *https://www.youtube.com/watch?v=fJbIuhs24zQ&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=4
 */
public class BoundedKnapsackDPWithTopDown {
	
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
		
		Integer t[][] = new Integer[price.length+1][capacity+1];
		return boundedKnapsack(items,price,items.length,capacity,0,t);
		//return boundedKnapsack(items,price,items.length,capacity,t);
		//return boundedKnapsackConcise(items,price,items.length,capacity,t);
		//boundedKnapsackWithLoop(items,price,items.length,capacity,t);
		
	}
	private static int boundedKnapsack(int items[],int price[],int n,int capacity,int maxPrice,Integer t[][]){
		
		if(n == 0 || capacity == 0) {
			return 0;
		}
		
		if(t[n][capacity] != null) {
			return  t[n][capacity];
		}
		
		if(items[n-1] > capacity) {
			return t[n][capacity] = boundedKnapsack(items,price,n-1,capacity,maxPrice,t);
		}
		else if(items[n-1] <= capacity) {
			int totalPrice = maxPrice+price[n-1];
			int priceFromLeftPath = boundedKnapsack(items,price,n-1,capacity-items[n-1],totalPrice,t);
			int priceFromRightPath = boundedKnapsack(items,price,n-1,capacity,maxPrice,t);
			t[n][capacity] = Math.max(Math.max(totalPrice, priceFromLeftPath),priceFromRightPath);
		}
		return t[n][capacity];
		
	}
	
	private static int boundedKnapsack(int items[],int price[],int n,int capacity,Integer t[][]){
		
		
		if(n == 0 || capacity == 0) {
			return 0;
		}
		
		if(t[n][capacity] != null) {
			return t[n][capacity];
		}
		
		if(items[n-1] > capacity) {
		return	t[n][capacity]= boundedKnapsack(items,price,n-1,capacity,t);
		}
		else if(items[n-1] <= capacity) {
			int price1 = price[n-1]+boundedKnapsack(items,price,n-1,capacity-items[n-1],t);
			int price2 = boundedKnapsack(items,price,n-1,capacity,t);
			t[n][capacity] =  Math.max(price1,price2);
		}
		return t[n][capacity];
		
	}
	
	private static int boundedKnapsackConcise(int items[],int price[],int n,int capacity,Integer t[][]){
		
		if(n == 0 || capacity == 0) {
			return 0;
		}
		
		if(t[n][capacity] != null) {
			return t[n][capacity];
		}
		
		if(items[n-1] > capacity) {
			return t[n][capacity] = boundedKnapsackConcise(items,price,n-1,capacity,t);
		}
		else if(items[n-1] <= capacity) {
			return t[n][capacity] = Math.max(price[n-1]+boundedKnapsackConcise(items,price,n-1,capacity-items[n-1],t),
					boundedKnapsackConcise(items,price,n-1,capacity,t));
		}
		return -1;
		
	}
	
	/*private static int boundedKnapsackWithLoop(int items[],int price[],int n,int capacity,Integer t[][]){
		
		int maxPrice = Integer.MIN_VALUE;
		
		if(n == 0 || capacity == 0) {
			return 0;
		}
		
		if(t[n][capacity] != null) {
			return t[n][capacity];
		}
		
		for(int i=n-1; i>=0; i--) {
			
			 if(items[i] <= capacity) {
				int totalPrice = price[i]+boundedKnapsackWithLoop(items,price,i,capacity-items[i],t);
				 t[n][capacity] = Math.max(totalPrice,maxPrice);
			}	
		}
		return t[n][capacity];
	}*/
	

	public static void main(String[] args) {
		
		int items[]= {1,3,4,5};
		int price[]= {1,4,5,7};
		int capacity = 7;
		System.out.println(BoundedKnapsackDPWithTopDown.boundedKnapsack(items,price,capacity));
	}

}
