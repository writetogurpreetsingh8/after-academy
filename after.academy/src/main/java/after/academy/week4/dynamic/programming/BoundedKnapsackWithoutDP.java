package after.academy.week4.dynamic.programming;

/**
 * 
 *   @author Tony.Stark
 *	This is bounded or 0-1 knapsack recursive problem without DP......
 *below are 4 different methods having same TC , aux and stack
 *but the only difference is the way how I wrote the code!!!!
 *	TC is O(2^N) , Aux Space is O(1) and Stack Space is O(N)
 *https://www.youtube.com/watch?v=kvyShbFVaY8&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=3
 */
public class BoundedKnapsackWithoutDP {
	
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
		
		return boundedKnapsack(items,price,items.length,capacity,0);
		//return boundedKnapsack(items,price,items.length,capacity);
		//return boundedKnapsackConcise(items,price,items.length,capacity);
		//return boundedKnapsackWithLoop(items,price,items.length,capacity);
		
	}
	private static int boundedKnapsack(int items[],int price[],int n,int capacity,int maxPrice){
		
		if(n == 0 || capacity == 0) {
			return 0;
		}
		
		if(items[n-1] > capacity) {
			return boundedKnapsack(items,price,n-1,capacity,maxPrice);
		}
		else if(items[n-1] <= capacity) {
			int totalPrice = maxPrice+price[n-1];
			int priceFromLeftPath = boundedKnapsack(items,price,n-1,capacity-items[n-1],totalPrice);
			int priceFromRightPath = boundedKnapsack(items,price,n-1,capacity,maxPrice);
			maxPrice = Math.max(Math.max(totalPrice, priceFromLeftPath),priceFromRightPath);
		}
		return maxPrice;
		
	}
	
	private static int boundedKnapsack(int items[],int price[],int n,int capacity){
		
		int maxPrice = 0;
		
		if(n == 0 || capacity == 0) {
			return 0;
		}
		
		if(items[n-1] > capacity) {
			return boundedKnapsack(items,price,n-1,capacity);
		}
		else if(items[n-1] <= capacity) {
			int price1 = price[n-1]+boundedKnapsack(items,price,n-1,capacity-items[n-1]);
			int price2 = boundedKnapsack(items,price,n-1,capacity);
			maxPrice =  Math.max(price1,price2);
		}
		return maxPrice;
		
	}
	
	private static int boundedKnapsackConcise(int items[],int price[],int n,int capacity){
		
		if(n == 0 || capacity == 0) {
			return 0;
		}
		
		if(items[n-1] > capacity) {
			return boundedKnapsackConcise(items,price,n-1,capacity);
		}
		else if(items[n-1] <= capacity) {
			return Math.max(price[n-1]+boundedKnapsackConcise(items,price,n-1,capacity-items[n-1]),
					boundedKnapsackConcise(items,price,n-1,capacity));
		}
		return -1;
		
	}
	
	private static int boundedKnapsackWithLoop(int items[],int price[],int n,int capacity){
		
		int maxPrice = Integer.MIN_VALUE;
		if(n == 0 || capacity == 0) {
			return 0;
		}
		
		for(int i=n-1; i>=0; i--) {
			
			/*
			 * if(items[i] > capacity) { return
			 * boundedKnapsackWithLoop(items,price,i,capacity); } else
			 */ if(items[i] <= capacity) {
				int totalPrice = price[i];
				int p = boundedKnapsackWithLoop(items,price,i,capacity-items[i]);
				//int priceRight = boundedKnapsackWithLoop(items,price,i,capacity,totalPrice);
				maxPrice = Math.max(totalPrice+p,maxPrice);
			}	
			
		}
			return maxPrice;
		
		
	}
	

	public static void main(String[] args) {
		
		int items[]= {1,3,4,5,7,4,5,3,7,8,9,0,4,5,3,4,7,8,77,9,8,3,2,5,4,6,8,9,1,2,7,4,5,6,1,3,4,5,7,4,5,3,7,8,9,0,4,5,3,4,7,8,77,9,8,3,2,5,4,6,8,9,1,2,7,4,5,6,1,3,4,5,7,4,5,3,7,8,9,0,4,5,3,4,7,8,77,9,8,3,2,5,4,6,8,9,1,2,7,4,5,6,1,3,4,5,7,4,5,3,7,8,9,0,4,5,3,4,7,8,77,9,8,3,2,5,4,6,8,9,1,2,7,4,5,6,1,3,4,5,7,4,5,3,7,8,9,0,4,5,3,4,7,8,77,9,8,3,2,5,4,6,8,9,1,2,7,4,5,6,1,3,4,5,7,4,5,3,7,8,9,0,4,5,3,4,7,8,77,9,8,3,2,5,4,6,8,9,1,2,7,4,5,6,1,3,4,5,7,4,5,3,7,8,9,0,4,5,3,4,7,8,77,9,8,3,2,5,4,6,8,9,1,2,7,4,5,6,1,3,4,5,7,4,5,3,7,8,9,0,4,5,3,4,7,8,77,9,8,3,2,5,4,6,8,9,1,2,7,4,5,6,1,3,4,5,7,4,5,3,7,8,9,0,4,5,3,4,7,8,77,9,8,3,2,5,4,6,8,9,1,2,7,4,5,6,1,3,4,5,7,4,5,3,7,8,9,0,4,5,3,4,7,8,77,9,8,3,2,5,4,6,8,9,1,2,7,4,5,6,1,3,4,5,7,4,5,3,7,8,9,0,4,5,3,4,7,8,77,9,8,3,2,5,4,6,8,9,1,2,7,4,5,6,1,3,4,5,7,4,5,3,7,8,9,0,4,5,3,4,7,8,77,9,8,3,2,5,4,6,8,9,1,2,7,4,5,6,1,3,4,5,7,4,5,3,7,8,9,0,4,5,3,4,7,8,77,9,8,3,2,5,4,6,8,9,1,2,7,4,5,6,1,3,4,5,7,4,5,3,7,8,9,0,4,5,3,4,7,8,77,9,8,3,2,5,4,6,8,9,1,2,7,4,5,6,1,3,4,5,7,4,5,3,7,8,9,0,4,5,3,4,7,8,77,9,8,3,2,5,4,6,8,9,1,2,7,4,5,6,1,3,4,5,7,4,5,3,7,8,9,0,4,5,3,4,7,8,77,9,8,3,2,5,4,6,8,9,1,2,7,4,5,6,1,3,4,5,7,4,5,3,7,8,9,0,4,5,3,4,7,8,77,9,8,3,2,5,4,6,8,9,1,2,7,4,5,6,1,3,4,5,7,4,5,3,7,8,9,0,4,5,3,4,7,8,77,9,8,3,2,5,4,6,8,9,1,2,7,4,5,6};
		int price[]= {1,3,4,5,7,4,5,3,7,8,9,0,4,5,3,4,7,8,77,9,8,3,2,5,4,6,8,9,1,2,7,4,5,6,1,3,4,5,7,4,5,3,7,8,9,0,4,5,3,4,7,8,77,9,8,3,2,5,4,6,8,9,1,2,7,4,5,6,1,3,4,5,7,4,5,3,7,8,9,0,4,5,3,4,7,8,77,9,8,3,2,5,4,6,8,9,1,2,7,4,5,6,1,3,4,5,7,4,5,3,7,8,9,0,4,5,3,4,7,8,77,9,8,3,2,5,4,6,8,9,1,2,7,4,5,6,1,3,4,5,7,4,5,3,7,8,9,0,4,5,3,4,7,8,77,9,8,3,2,5,4,6,8,9,1,2,7,4,5,6,1,3,4,5,7,4,5,3,7,8,9,0,4,5,3,4,7,8,77,9,8,3,2,5,4,6,8,9,1,2,7,4,5,6,1,3,4,5,7,4,5,3,7,8,9,0,4,5,3,4,7,8,77,9,8,3,2,5,4,6,8,9,1,2,7,4,5,6,1,3,4,5,7,4,5,3,7,8,9,0,4,5,3,4,7,8,77,9,8,3,2,5,4,6,8,9,1,2,7,4,5,6,1,3,4,5,7,4,5,3,7,8,9,0,4,5,3,4,7,8,77,9,8,3,2,5,4,6,8,9,1,2,7,4,5,6,1,3,4,5,7,4,5,3,7,8,9,0,4,5,3,4,7,8,77,9,8,3,2,5,4,6,8,9,1,2,7,4,5,6,1,3,4,5,7,4,5,3,7,8,9,0,4,5,3,4,7,8,77,9,8,3,2,5,4,6,8,9,1,2,7,4,5,6,1,3,4,5,7,4,5,3,7,8,9,0,4,5,3,4,7,8,77,9,8,3,2,5,4,6,8,9,1,2,7,4,5,6,1,3,4,5,7,4,5,3,7,8,9,0,4,5,3,4,7,8,77,9,8,3,2,5,4,6,8,9,1,2,7,4,5,6,1,3,4,5,7,4,5,3,7,8,9,0,4,5,3,4,7,8,77,9,8,3,2,5,4,6,8,9,1,2,7,4,5,6,1,3,4,5,7,4,5,3,7,8,9,0,4,5,3,4,7,8,77,9,8,3,2,5,4,6,8,9,1,2,7,4,5,6,1,3,4,5,7,4,5,3,7,8,9,0,4,5,3,4,7,8,77,9,8,3,2,5,4,6,8,9,1,2,7,4,5,6,1,3,4,5,7,4,5,3,7,8,9,0,4,5,3,4,7,8,77,9,8,3,2,5,4,6,8,9,1,2,7,4,5,6,1,3,4,5,7,4,5,3,7,8,9,0,4,5,3,4,7,8,77,9,8,3,2,5,4,6,8,9,1,2,7,4,5,6};
		int capacity = 10;
		System.out.println(BoundedKnapsackWithoutDP.boundedKnapsack(items,price,capacity));
	}

}
