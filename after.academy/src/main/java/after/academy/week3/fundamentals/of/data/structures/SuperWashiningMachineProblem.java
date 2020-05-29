package after.academy.week3.fundamentals.of.data.structures;

/**
 *You have n super washing machines on a line. Initially, each washing machine has some dresses or is empty.
For each move, you could choose any m (1 ≤ m ≤ n) washing machines, and pass one dress of each washing machine 
to one of its adjacent washing machines at the same time .

Given an integer array representing the number of dresses in each washing machine from left to right on the line,
 you should find the minimum number of moves to make all the washing machines have the same number of dresses. 
 If it is not possible to do it, return -1.
 
 Example 1: Input: [1,0,5] Output: 3 
 Explanation: 1st move:    1     0 <-- 5    =>    1     1     4 
 			  2nd move:    1 <-- 1 <-- 4    =>    2     1     3    
 			  3rd move:    2     1 <-- 3    =>    2     2     2   

Example 2: Input: [0,3,0] Output: 2 
Explanation: 1st move:    0 <-- 3     0    =>    1     2     0    
			 2nd move:    1     2 --> 0    =>    1     1     1 
			 
Example 3: Input: [0,2,0] Output: -1 
Explanation: It's impossible to make all the three washing machines have the same number of dresses
 *
 *
 *TC O(N), stack space O(1) and aux space O(1)
 *
 */
public class SuperWashiningMachineProblem {
	
	private static int findMoves(int washingMachine[]) {
		
		if(washingMachine == null || washingMachine.length <=1 ) {
			return -1;
		}
		int totalDress =0;
		for(int i : washingMachine) {
			totalDress+=i;
		}
		if(totalDress % washingMachine.length != 0) {
			return -1;
		}
		
		int goal = totalDress / washingMachine.length;
		int current = 0, maxDress =0;
		for(int dress:washingMachine) {
			
			current = dress - goal;
			maxDress = Math.max(current, maxDress);
		}
		return maxDress;
	}


	public static void main(String[] args) {

		//int washingMachine[]= {1,0,5};
		//int washingMachine[]= {0,1,1,1,1,1,1,1,1,2};
		//int washingMachine[]= {0,3,0};
		//int washingMachine[]= {0,2,0};
		//int washingMachine[]= {4,0,0,4};
		int washingMachine[]= {11,0,0,1};
		System.out.println(SuperWashiningMachineProblem.findMoves(washingMachine));
	}

}
