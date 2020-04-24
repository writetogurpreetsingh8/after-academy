package after.academy.week1.fundamentals.of.algos;

/**
 * 
 * @author 91783
 * Time complexity is O(1)
 * stack and aux space complexity is O(1)
 *
 */

public class CalculateGCD {

	private static int calculateGCD(int a,int b) {
		
		if(b == 0) {
			return a;
		}
		
		return calculateGCD(b,(a%b));
		
	}
	
	public static void main(String[] args) {
		
		System.out.println(CalculateGCD.calculateGCD(12, 3));
	}

}
