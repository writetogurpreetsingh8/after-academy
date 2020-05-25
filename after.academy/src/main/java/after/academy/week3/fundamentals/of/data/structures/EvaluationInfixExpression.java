package after.academy.week3.fundamentals.of.data.structures;

import java.util.Stack;


/**
 * 
 * infix to postfix conversion with the help of stack
 * TC O(N) and stack O(1) and aux space O(N)..........
 * 
 * uses two stack ,,,.. one for oerators and second for operends....
 * Rules would be as same as infix to postfix conversion.........
 */
public class EvaluationInfixExpression {

	private static int evaluateInfixExpresion(String expression) {
		
		if(expression == null || expression.isEmpty()) {
			System.out.println("invalid infix expression.......");
			return -1;
		}
		
		Stack<Character> operatorStack = new Stack<>();
		Stack<Integer> operendStack = new Stack<Integer>();
		
		int precedencExpression = 0, precedenceStack = 0;
		int associativityExpression = 0, associativityStack = 0;
		
		for(int i=0;i<expression.length(); i++) {
			
			if(Character.isDigit(expression.charAt(i))) {
				operendStack.push((expression.charAt(i) - 48));
			}
			else {
				if(expression.charAt(i) == '(') {
					operatorStack.push(expression.charAt(i));
				}
				else {
					if(expression.charAt(i) == ')') {
						
						while(!operatorStack.isEmpty() && operatorStack.peek() != '(') {
							operendStack.push(performCalculation(operendStack.pop(),operendStack.pop(),operatorStack.pop()));
						}
						if(operatorStack.isEmpty() || operatorStack.peek() != '(') {
							System.out.println("invalid infix expression......");
							return -1;
						}else {
							operatorStack.pop();
						}
					}else {
						
						while(!operatorStack.isEmpty()) {
							
							precedencExpression = checkPrecedence(expression.charAt(i));
							precedenceStack = checkPrecedence(operatorStack.peek());
							
							if(precedencExpression > precedenceStack) {
								break;
							}
							if(precedencExpression == precedenceStack) {
								
								associativityExpression = checkAssociativity(expression.charAt(i));
								associativityStack = checkAssociativity(operatorStack.peek());
								// if asssociativity R - To - L just break and statement present end of the loop will enter the operator into stack...... 
								if( (associativityExpression == -1 && associativityStack == -1) ) {
									break;
								}
							}
							operendStack.push(performCalculation(operendStack.pop(),operendStack.pop(),operatorStack.pop()));
						}
						operatorStack.push(expression.charAt(i));
					}
				}
			}
		}// end of for loop
		
		while(!operatorStack.isEmpty()) {
			operendStack.push(performCalculation(operendStack.pop(),operendStack.pop(),operatorStack.pop()));
		}
		return operendStack.pop();
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

	private static int performCalculation(int op1,int op2,char expressionVal) {
		
		int result =  0;
		switch(expressionVal) {
		
		case '+':
			result = (op2+op1);
			break;
		
		case '-':
		result = (op2-op1);
		break;
		
		case '*':
			result = (op2*op1);
			break;
		
		case '/':
			result = (op2/op1);
			break;
			
		case '%':
			result = (op2%op1);
			break;
		}
		return result;
	}

	
	public static void main(String[] args) {

		System.out.println(EvaluationInfixExpression.evaluateInfixExpresion("2+3-(4*8)/(2*2)"));
		
	}

}
