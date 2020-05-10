package after.academy.week1.fundamentals.of.algos;

/**
 * 
 * @author 91783
 * Time complexity is O(1)
 * stack and aux space complexity is O(1)
 *
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
	
	public static void main(String[] args) {
		
		System.out.println(CalculateGCD.calculateGCD(42421, 8));
		System.out.println(Math.floor(3/10));
		System.out.println("c is "+c);
	}

}
