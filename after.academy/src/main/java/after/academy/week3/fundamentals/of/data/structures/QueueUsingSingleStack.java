package after.academy.week3.fundamentals.of.data.structures;

import java.util.Stack;

/**
 *  implement queue using single stack could only be done by using recursion,
 *   can't implement by iterative approach ,, 
 *	TC = O(N) 
 *	stack = (N)
 *	aux space = O(N)
 */
public class QueueUsingSingleStack {

	private static Stack<Integer> stack = new Stack<>();
	
	
	private static void enqueue(int data) {
		
		stack.push(data);
	}
	
	private static int deQueue() {
		
		int result = 0, lastPopedOutValue =0;
		
		if(stack.isEmpty()) {
			return -1;
		}
		if(stack.size() == 1) {
			return stack.pop();
		}
		
		lastPopedOutValue = stack.pop();
		result = deQueue();
		//enqueue(lastPopedOutValue);
		stack.push(lastPopedOutValue);
		return result;
	}
	
	public static void main(String[] args) {

		QueueUsingSingleStack.enqueue(1);
		QueueUsingSingleStack.enqueue(2);
		QueueUsingSingleStack.enqueue(3);
		
		System.out.println(QueueUsingSingleStack.deQueue());
		
		
	}

}
