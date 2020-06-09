package after.academy.week4.dynamic.programming;

import java.util.Date;

public class FabonaciSeries {
	
private static long fabo(int n,long[] array) {
		
		if(n <=1 ) {
			return n;
		}
		if(array[n] !=0 ) {
			return array[n];
		}
		array[n] = fabo(n-1,array)+fabo(n-2,array);
		return array[n];
	}
	public static void main(String[] args) {
		System.out.println(new Date());
		int n = 5;
		System.out.println(FabonaciSeries.fabo(n,new long[n+1]));
		System.out.println(new Date());
	}
}
