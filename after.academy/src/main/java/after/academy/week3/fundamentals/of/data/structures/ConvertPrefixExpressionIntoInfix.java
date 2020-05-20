package after.academy.week3.fundamentals.of.data.structures;

import java.util.Stack;

/**
 * evaluate prefix expresssion with the help of stack
 * TC O(N) , aux O(1) becoz constant stack space
 * Stack O(1)
 *  same logic would be used to evalPostfixExpression , we just need to traverse the given
 *  expression from starting instead of last..........
 */
public class ConvertPrefixExpressionIntoInfix {

	private static String convertPrefixExpressionIntoInfix(String expression) {
		
		System.out.println("Prefix Expression =====> "+expression);
		
		StringBuilder sb = new StringBuilder("-1");
		
		if(expression == null || expression.isEmpty()) {
			System.out.println("invalid expression.......");
			return sb.toString();
		}
		
		// in case of prefix, expression must have operators only at the left side
		// it should not be contains any digit & variables at its left side
		if(isOperend(expression.charAt(0)) || isVariable(expression.charAt(0))) {
			System.out.println("invalid expression");
			return sb.toString();
		}
		
		// in case of prefix, expression must have digit & variable only at the right side
		// it should not be contains any operators at its right side....
		if(!isOperend(expression.charAt(expression.length()-1)) && !isVariable(expression.charAt(expression.length()-1))) {
				System.out.println("invalid expression");
				return sb.toString();
		}
		
		Stack<String> stack = new Stack<>();
		
		for(int i=expression.length()-1; i>=0; i--) {
			
				if(isOperend(expression.charAt(i)) || isVariable(expression.charAt(i))) {
					stack.push(Character.toString(expression.charAt(i)));
				}
				else {
					stack.push(accumulateExpression(stack.pop(),stack.pop(),expression.charAt(i),sb));
				}
		}
		if(stack.size() > 1) {
			System.out.println("invalid expression......");
			return "-1";
		}
		return stack.pop();
	}
	
	private  static boolean isOperend(char operend) {
		
		return (operend >=48 && operend <=57);
	}
	
	private static boolean isVariable(char variable) {
		
		return Character.isLetter(variable);
	}
	
	private static String accumulateExpression(String op1,String op2,char expressionVal,StringBuilder sb) {
		
		sb.setLength(0);
		
		switch(expressionVal) {
		case '+':
			 sb.append(op1).append(" + ").append(op2);
			break;
		
		case '-':
			sb.append(op1).append(" - ").append(op2);
		break;
		
		case '*':
			sb.append(op1).append(" * ").append(op2);
			break;
		
		case '/':
			sb.append(op1).append(" / ").append(op2);
			break;
			
		case '%':
			sb.append(op1).append(" % ").append(op2);
			break;
			
		case '^':
			sb.append(op1).append(" ^ ").append(op2);
			break;	
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		//System.out.println(ConvertPrefixExpressionIntoInfix.evalPrefixExpression("-+23/*48^22"));
		System.out.println("Infix Expression ======> "+ConvertPrefixExpressionIntoInfix.convertPrefixExpressionIntoInfix("-+AB/*/*CD*EFG^HI"));

	}

}
