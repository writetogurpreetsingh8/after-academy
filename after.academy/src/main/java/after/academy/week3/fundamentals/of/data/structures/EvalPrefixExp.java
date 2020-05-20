package after.academy.week3.fundamentals.of.data.structures;

import java.util.Stack;

public class EvalPrefixExp {

	/**
	 * evaluate prefix expresssion with the help of stack
	 * TC O(N) , aux O(1) becoz constant stack space
	 * Stack O(1)
	 * below program able to handle if having digit in 1s th place i.e(-+23/*48*22)
	 * 
	 * but if we have digits like this. -+23/*48*122 then this progame not able to handle
	 * becaze 122 would be treated as three separate digit infact they are two separate digit not 3
	 * i.e 12 2 , so we have to modify little bit.......
	 *  
	 *  same logic would be used to evalPostfixExpression , we just need to traverse the given
	 *  expression from starting instead of last..........
	 */
	
	private static int evalPrefixExpression(String expression) {
		
		System.out.println("Prefix Expression =========> "+expression);
		
		if(expression == null || expression.isEmpty()) {
			System.out.println("invalid expression.......");
			return -1;
		}
		// in case of prefix, expression must have operators only at the left side
		// it should not be contains any digit & variables at its left side
		if(isOperend(expression.charAt(0)) || isVariable(expression.charAt(0))) {
			System.out.println("invalid expression");
			return -1;
		}
		
		// in case of prefix, expression must have digit & variable only at the right side
		// it should not be contains any operators at its right side....
		if(!isOperend(expression.charAt(expression.length()-1)) && !isVariable(expression.charAt(expression.length()-1))) {
			System.out.println("invalid expression");
			return -1;
		}
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i=expression.length()-1; i>=0; i--) {
			
				if(isOperend(expression.charAt(i))) {
					stack.push((expression.charAt(i) - 48));
				}
				else {
					stack.push(performCalculation(stack.pop(),stack.pop(),expression.charAt(i)));
				}
		}
		if(stack.size() > 1) {
			System.out.println("invalid expression......");
			return -1;
		}
		return stack.pop();
	}
	
	private  static boolean isOperend(char operend) {
		
		return (operend >=48 && operend <=57);
	}
	
	private static boolean isVariable(char variable) {
		
		return Character.isLetter(variable);
	}
	
	private static int performCalculation(int op1,int op2,char expressionVal) {
		
		int result =  0;
		switch(expressionVal) {
		
		case '+':
			result = (op1+op2);
			break;
		
		case '-':
		result = (op1-op2);
		break;
		
		case '*':
			result = (op1*op2);
			break;
		
		case '/':
			result = (op1/op2);
			break;
			
		case '%':
			result = (op1%op2);
			break;
		}
		return result;
	}
	
	public static void main(String[] args) {

		System.out.println("Total after eval ======> "+EvalPrefixExp.evalPrefixExpression("-+23/*48*22"));
	}

}
