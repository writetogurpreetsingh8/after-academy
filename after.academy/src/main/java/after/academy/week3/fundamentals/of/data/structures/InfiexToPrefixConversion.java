package after.academy.week3.fundamentals.of.data.structures;


// covert infix to prefix Rules would be as same as infix to postfix
//conversion except 5 things would be changed
// 
/**
 * 1 point =>  need to reverse the infix expression completely (or we can start the loop from array.length to 0)
 * 
 * 2.1 point => if precedence is same of incoming operator and top of the stack operator then need to check
 * 				associativity , if associativity if L To R then simply push the incoming operator in the stack(but in case of 
 * 				infix to postfix conversion, if associativity L To R we remove the top of the stack operator and again 
 * 				check incoming operator with the new top of the stack operator.. so until stack is empty or found lower
 * 				precedence against incoming operator)
 *
 * 2.2 point =>  if precedence is same of incoming operator and top of the stack operator then need to check
 * 				associativity , if associativity if R To L then we remove the top of the stack operator and again
 * 				check incoming operator with the new top of the stack operator till then stack become empty or found lower
 * 				precedence against incoming operator (but in case of infix to postix coversion, if the associavitiy
 * 				is R To L , we simply push the incoming operator into the stack.)
 * 
 * 3 point  => if incoming operator is closing paranthesies i.e ')' simply put that into stack (but in case of infix to postfix
 * 				conversion we  pop out all the operators from the stack one by one till stack is empty or we found closing paranthesies)
 * 
 * 4 point  => if incoming operator is opening paranthesies i.e '(' then pop out all the operators from the stack one by one
 * 				till stack is empty or we found closing paranthesies.... (but in case of infix to postfix conversion 
 * 				we simply put opening paranthesis '(' into stack......)
 * 
 * 5 point  => after exhausting the given infix expression if there is any operator left into stack
 * 				then pop out all the operator one by one and added to postfix expression, after that reverse the postfix expression
 * 				to get as prefix expression, if we did reverse the infix expression eariler else just print the expression from backward
 */

public class InfiexToPrefixConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
