package after.academy.week4.dynamic.programming;

import java.lang.reflect.Array;
import java.util.Arrays;
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
		// devellpent branch..........
		// aaded by server
	}

	private static int facto(int n) {
	
	if( n == 1) {
		return n;
	}
	return n*facto(n-1);
}
	public static void main(String[] args) {
		
		System.out.println(new Date());
		int n = 25;
		System.out.println(FabonaciSeries.fabo(n,new long[n+1]));
		System.out.println(new Date());
		System.out.println(FabonaciSeries.facto(5));
		
		Integer p [][] = (Integer[][]) Array.newInstance(Integer.class,2,3);
		System.out.println(p);
		Arrays.fill(p[0], -1);
		System.out.println(p);
		
	}
}
