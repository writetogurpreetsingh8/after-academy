package after.academy.week2.divide.and.conquer;

public class CalucatePowerFunction {

// brute forch approach having O(N) TC, no extra space , not extra stack
//
	
	private static int calculatePowerFunction(int value, int powerValue) {
		
		int result = 1;
				
		for(int i=1;i<=powerValue;i++) {
			result = (result * value);
		}
		return result;	
	}
	// improved approach divide and conquer approach O(LOGN) TC no extra space , logn extra stack
	private static int calculatePowerFunctionRecursively(int base,int power) {
		
		if(power < 0) {
			return -1; // invalid power
		}
		if(power == 0) {
			return 1;//  base case
		}
		if(power == 1) {
			return base; // base case
		}
		
		int p = calculatePowerFunctionRecursively(base,power/2);
		
		if(power % 2 == 0) {
			p = p * p;
		}
		else {
			p = base * p * p;
		}
		return p;
	}
	
	// improved approach divide and conquer approach O(LOGN) TC no extra space , no extra stack
		private static int calculatePowerFunctionIteratively(int base,int power) {
			
			if(power < 0) {
				return -1; // invalid power
			}
			if(power == 0) {
				return 1;
			}
			if(power == 1) {
				return base; 
			}
			
			int result = base;
			int p = power;
			
			while(p >= 1) {
				
				result = result * base;
				p = p / 2;
			}
			if(power % 2 != 0) {
				result = result * base;
			}
			return result;
		}
	
	public static void main(String[] args) {

		
		System.out.println(CalucatePowerFunction.calculatePowerFunctionIteratively(2, 4));
	}

}
