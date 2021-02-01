package after.academy.week1.fundamentals.of.algos;

/**
 * 
 * @author 91783
 * Time complexity is O(logB)
 * stack and aux space complexity is O(1)
 * https://www.youtube.com/watch?v=px89hlqf0Nw
 * brute force approach for GCD would be O(min(a,b)) iterations!!
 * EUCLID'S ALGO	
 */

public class CalculateGCD {

	private static int c = -1;
	private static int calculateGCD(int a,int b) {
		
		c++;
		if(b == 0) {
			return a;
		}
		
		return calculateGCD(b,(a%b));
		
	}
	
	private static void calculateGCDIterative(int a,int b) {
		
		int c = -1;
		while(true) {
			if(c == 0) {
				break;
			}
			c = a%b;
			a = b;
			b = c;
			
		}
		System.out.println("GCD with iterative approach is "+a);
	}
	
	public static void main(String[] args) {
		
		System.out.println(CalculateGCD.calculateGCD(150, 10));
		System.out.println(Math.floor(3/10));
		System.out.println("c is "+c);
		CalculateGCD.calculateGCDIterative(150, 10);
	}

}
