package after.academy.week3.fundamentals.of.data.structures;

import java.util.Stack;

/**
 * 
 * infix to postfix conversion with the help of stack
 * TC O(N) and stack O(1) and aux space O(N)..........
 * 
 */
public class InfixToPostFixConverstion {

	private static void infixToPostfixConversion(String expression) {
	
		if(expression == null || expression.isEmpty()) {
			System.out.println("invalid expression......");
			return;
		}
		Stack<Character> stack = new Stack<>();
		
		int precedencExpression = 0, precedenceStack = 0;
		int associativityExpression = 0, associativityStack = 0;
		
		for(int i=0; i<expression.length();i++) {
			
			// if operend just print them.......
			if(isLeterOrDigit(expression.charAt(i))) {
				
				System.out.print(expression.charAt(i));
			}
			else {
				// if found incoming operator is ( just push them into stack...........
				if(expression.charAt(i) == '(') {
					stack.push(expression.charAt(i));
				}
				else {
					// if found incoming operator is ) then pop all the operators from stack till stack become empty or found ( 
					if(expression.charAt(i) == ')') {
						
						while(!stack.isEmpty() && stack.peek() != '(') {
							System.out.print(stack.pop());
						}
						//if ( not found into stack that means invalid expression
						if(!stack.isEmpty() && stack.peek() != '(') {
							System.out.println("invalid expression");
						}else {
							// now need to remove ( from stack and no need to push ) into stack.......
							stack.pop();
						}
					}
					else {
						// if found incoming operator...........
						while(!stack.isEmpty()) {
								
							precedencExpression = checkPrecedence(expression.charAt(i));
							precedenceStack = checkPrecedence(stack.peek());
							
							// if precedence of incomming operator is higher than stack operator....break the loop..
							// statement present end of the loop will enter the operator into stack......
							if(precedencExpression > precedenceStack) {
								break;
							}
							// if precedence of both the operators are same then check the associavitiy rule
							// if associavitiy R - TO - L then directly push into the stack
							// else pop out from stack then again check the precedence of new top operator with incoming operator... recurisevly...
							else if(precedencExpression == precedenceStack) {
								
								associativityExpression = checkAssociativity(expression.charAt(i));
								associativityStack = checkAssociativity(stack.peek());
								// if asssociativity R - To - L just break and statement present end of the loop will enter the operator into stack...... 
								if( (associativityExpression == -1 && associativityStack == -1) ) {
									break;
								}
							}
							// responsible to remove/pop out the operator from the stack in case of incoming operator has lower precedence than top operator
							// or associavity is L - TO - R..........
							System.out.print(stack.pop());
						}
						stack.push(expression.charAt(i));
					}
				}
			}
		}
		// after elemenating outer loop whatever we have into stack just pop out and print them.......
		while (!stack.isEmpty()){ 
            if(stack.peek() == '(' || stack.peek() == ')') 
            	System.out.println("invalid expression......");
            System.out.print(stack.pop());
         } 
		
	}
	
	private static boolean  isLeterOrDigit(char operand) {
		
		return Character.isLetterOrDigit(operand);
	}
	
	private static int checkPrecedence(char operator) {
		
		switch (operator) {
		
		case '^':
			return 4;
			
		case '/' :
		case '%' :
		case '*' :
			return 3;
		
		case '+' :
		case '-' :
			return 2;
			
		default:
		return 0;
		}
	}
	
	private static int checkAssociativity(char operator) {
		
		if(operator == '^') {
			return -1;
		}
		return 0;
	}
	
	
	public static void main(String[] args) {
		
		//InfixToPostFixConverstion.infixToPostfixConversion("2+3-4*8/2^2");
		InfixToPostFixConverstion.infixToPostfixConversion("A+B-C*D/E^(F*G)/(H^I)");
	}

}
