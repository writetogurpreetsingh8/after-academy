package after.academy.week4.dynamic.programming;

import java.util.Date;
import java.util.StringJoiner;
/**
 * 
 * @author Tony.Stark
 * https://www.youtube.com/watch?v=ElFrskby_7M (bottom-up approach itreative approach)
 * https://www.youtube.com/watch?v=crwvhiQTNyU (top down approach........)
 * https://www.youtube.com/watch?v=NVohfDGBV6k&list=PLeF0b8iqbx4lY5xVHHZdHUdmshE6_Izl4&index=19  (top down approach........)
 */
public class RodCutProblem {

	private static int frequenceCount = 0;
	
	private static int cutRodWithOutDP(int price[],int rodSize) {
		
		if (rodSize <= 0) 
            return 0; 
        int max_val = Integer.MIN_VALUE; 
        frequenceCount++;
        for (int i = 1; i<=rodSize; i++) {
        	int cr = cutRodWithOutDP(price, rodSize-i);
            max_val = Math.max(max_val,price[i-1] + cr); 
        }
  
        return max_val; 
	}
	
	private static int rodCutWithDPTopDownApproach(int price[],int rodSize,int memory[]) {
		
		if(rodSize == 0) {
			return 0;
		}
		if(memory[rodSize] != 0) {
			return memory[rodSize];
		}
		int maxPrice = Integer.MIN_VALUE;
		for(int i=1; i<=rodSize;i++) {
			maxPrice = Math.max(maxPrice, price[i-1]+rodCutWithDPTopDownApproach(price,rodSize-i,memory));
			memory[rodSize] = maxPrice;
		}
		return memory[rodSize];
	}
	
	private static int rodCutWithDPBottomUpApproach(int price[]){
       
		int max[] = new int [price.length+1];
		
		System.arraycopy(price, 0, max, 1, price.length);
		
		for(int i=1 ; i <= price.length; i++){
           
			for(int j=1; j <i ; j++){
				
				max[i] = Math.max(max[i],max[i-j] + max[j]);
            }
        }
		return max[price.length];
    }
	
	public static void main(String[] args) {
		
		 	int arr[] =  {1,5,2,4,5,7,3,4,8,9,6,7,2,3,7,4,8,9,0,12,2,3,4,5,6,7,8,9,8,7,6,5,4,3,2,1,2,3,4,5,7,8,9,6,7,55,4,6,3,4}; 
		//int arr[] = {1,5,2,4};
		//int arr[] = {2,1,0,1};
	       // System.out.println(RodCutProblem.cutRodWithOutDP(arr,arr.length));
		 	System.out.println(new Date());
	        System.out.println("Maximum Obtainable Value is "+ 
	        		RodCutProblem.rodCutWithDPTopDownApproach(arr, arr.length,new int[arr.length+1])); 
	        System.out.println("total count are "+frequenceCount);
	        System.out.println(new Date());
	        
	        System.out.println(RodCutProblem.rodCutWithDPBottomUpApproach(arr));
	}

}
