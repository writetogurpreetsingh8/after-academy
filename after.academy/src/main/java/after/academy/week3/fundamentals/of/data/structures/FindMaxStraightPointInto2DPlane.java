package after.academy.week3.fundamentals.of.data.structures;

import java.util.HashMap;
import java.util.Map;

/***
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line
 * 
 * Example 1: Input: [[1,1],[2,2],[3,3]] 
 * Output: 3 Explanation: ^ 
 * 						| 
 * 						|    o 
 * 						|     o 
 * 						|  		o  
 * 						+-------------> 
 * 						0  1  2  3  4
 * 
Example 2: Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]] 
Output: 4 Explanation: 	^ 
						|
						|  o 
						|     o        o 
						|        o 
						|  o        o 
						+-------------------> 
						0  1  2  3  4  5  6
 *
 *
 *
 *https://www.youtube.com/watch?v=f2n9NOkqvZQ
 *https://www.youtube.com/watch?v=9VCD8q_FgPU
 *https://www.youtube.com/watch?v=5jbyxwWI8iM
 *https://www.khanacademy.org/math/algebra/x2f8bb11595b61c86:linear-equations-graphs/x2f8bb11595b61c86:slope/v/slope-of-a-line-2
 *https://gist.github.com/zhouhao/9614569
 *
 */

public class FindMaxStraightPointInto2DPlane {

	/**
	 * TC (N^2) , aux space O(N) for taking map
	 *Stack space O(1) 
	 */
	private static int findMaxStraightPointInto2DPlane( int cooridinates[][]) {
		
		if(cooridinates == null) {
			System.out.println("invalid coordinates....");
			return -1;
		}
		if(cooridinates.length < 3) {
			System.out.println(cooridinates.length);
			return cooridinates.length;
		}
		
		Map<Double,Integer> hashMap = new HashMap<>();
		
		int slopeMax = 0;
		int duplicateCount = 0;
		int slope = 0;
		Double slopeCount = 0.0;
		int globalMaxCount = 1;

		int x1 = 0,x2 = 0, y1 = 0, y2 = 0;
		for(int i=0; i<cooridinates.length - 2;i++) {
			
			slopeCount = 0.0;
			x1 = cooridinates[i][0]; 
			y1 = cooridinates[i][1];
			
			for(int j=i+1;j<cooridinates.length;j++) {
			
				x2 = cooridinates[j][0]; 
				y2 = cooridinates[j][1];
				
				if(x1 == x2 && y1 == y2) {
					
					duplicateCount = 1;
					continue;
				}
				else if(x1 == x2) {
					
					slopeCount = Double.MIN_NORMAL; // for x coordinates  horizonatally lines
					
				}else if(y1 == y2) {
					slopeCount = Double.MAX_VALUE; // for y coordinates for vertically lines
				}
				else {
					slopeCount = (double)((y2-y1) / (double)(x2-x1)); // for slopes...........
				}	
				if(hashMap.containsKey(slopeCount)) {
						slope = hashMap.get(slopeCount)+1;
						hashMap.put(slopeCount, slope);
						if(slope > slopeMax) {
							slopeMax = slope;
						}
					}
					else {
						hashMap.put(slopeCount, 2);
						if(slopeMax == 0) {
							slopeMax = 2;
						}
					}
			}// end inner loop;
			if(globalMaxCount < slopeMax) {
				globalMaxCount = slopeMax + duplicateCount;
			}	
			hashMap.clear();
		}
		return globalMaxCount;
		}

	
	
	
	public static void main(String[] args) {
		int[][] cooridinates={{3,2},{5,3},{4,1},{2,3},{1,4}};
		//int[][] cooridinates={{1,1},{3,2},{5,3},{4,1},{2,3},{1,4},{1,2},{1,3},{1,4},{1,5},{1,6}};
		System.out.println(FindMaxStraightPointInto2DPlane.findMaxStraightPointInto2DPlane(cooridinates));
		
	}

}
