package after.academy.week2.divide.and.conquer;

import java.util.Date;

public class KarastubaAlgo {

	private static int multipleFastNumber(int x,int y) {
		
		if( x < 10 && y < 10) {
			return (x * y);
		}
		int largeLength = 0;
		int xLength = String.valueOf(x).length();
		int yLength = String.valueOf(y).length();
		
		if(xLength > yLength) {
			largeLength = xLength;
		}else {
			largeLength = yLength;
		}
		
		int m = (int)Math.ceil((double)largeLength / 2);
		
		int xR = (x % (int)Math.pow(10, m));
		int xL = (x / (int)Math.pow(10, m));
		
		int yR = (y % (int)Math.pow(10, m));
		int yL = (y / (int)Math.pow(10, m));
		
		int s1 = multipleFastNumber(xL,yL);
		int s2 = multipleFastNumber(yR,xR);
		int s3 = multipleFastNumber((xL+xR),(yL+yR));
		int s4 = s3 - s2 - s1;
		
		return (s1 *  (int)Math.pow(10, (m*2)) + s4 * (int)Math.pow(10, m) + s2);
		
	}
	// below logic is not as much as effective as above logic
	private static int multipleFastNumber1(int x,int y) {
		
		if( x < 10 && y < 10) {
			return (x * y);
		}
		int largeLength = 0;
		int xLength = String.valueOf(x).length();
		int yLength = String.valueOf(y).length();
		
		if(xLength > yLength) {
			largeLength = xLength;
		}else {
			largeLength = yLength;
		}
		
		int m = (int)Math.ceil((double)largeLength / 2);
		
		int xL = (x / (int)Math.pow(10, m));
		int xR = (x % (int)Math.pow(10, m));
		
		int yL = (y / (int)Math.pow(10, m));
		int yR = (y % (int)Math.pow(10, m));
		
		int s1 = multipleFastNumber1(xL,yL);
		int s2 = multipleFastNumber1(yR,xR);
		////int s3 = multipleFastNumber((xL+xR),(yL+yR));
		//int s4 = s3 - s2 - s1;
		
		//return (s1 *  (int)Math.pow(10, (m*2)) + s4 * (int)Math.pow(10, m) + s2);
		return (((int)Math.pow(10, (m*2)) * s1) + ((int)Math.pow(10, m) * ((xR*yL) + (xL*yR))) + s2);
		
	}
	
	public static void main(String[] args) {
		long start = new Date().getTime();
		System.out.println(KarastubaAlgo.multipleFastNumber1(1234567,567899));
		long end = new Date().getTime();
		
		long finalTime = end - start;
		System.out.println(finalTime);
		System.out.println((int)Math.ceil((double)5/2));
	}

}
