package after.academy.week3.fundamentals.of.data.structures;

/**
 * https://www.rapidtables.com/convert/number/hex-dec-bin-converter.html
 * https://www.youtube.com/watch?v=kAnBaQoJkpo
 *
 *TC O(LOGN) 
 *stack space O(1)
 *aux space O(1) => here I am using stringbuilder to hold the oupt but sb isn't treated as 
 *constant sapce whenever is needed it will increase our size,, but while converting into binary
 *max to max size will go upto either 32 or 64 bits... so we can say its O(1) only
 *
 */
public class ConvertDecimalToBinary {

	private static int convertDecimalToBinary(int number) {
		
		if(number == 0 || number == 1) {
			return number;
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(number > 0) {
			
			sb.append( ((number & 1) ==1 ) ? 1 : 0);
			number >>= 1;
		}
		return Integer.parseInt(sb.reverse().toString());
	}
	
	public static void main(String[] args) {
		
		System.out.println(ConvertDecimalToBinary.convertDecimalToBinary(25));
	}

}
