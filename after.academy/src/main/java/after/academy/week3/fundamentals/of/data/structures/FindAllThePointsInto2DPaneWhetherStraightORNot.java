package after.academy.week3.fundamentals.of.data.structures;

/**
 * TC O(N) , aux space O(1) and stack space O(1)
 * below algo only applicable to check whether having straight line or not 
 * with in 2D plan means all the points must be in the same line line else it will return false
 * https://www.youtube.com/watch?v=f2n9NOkqvZQ&list=RDCMUCnxhETjJtTPs37hOZ7vQ88g&start_radio=1&t=45
 */
public class FindAllThePointsInto2DPaneWhetherStraightORNot {
	
	private static boolean findAllThePointsInto2DPaneWhetherStraightORNot( int coordinates[][]) {
		
		int points = coordinates.length;
        int xdiff = Math.abs(coordinates[1][0]-coordinates[0][0]);
        int ydiff = Math.abs(coordinates[1][1]-coordinates[0][1]);
        int curr_xdiff,curr_ydiff;
        
        for(int i=2;i<points;++i)
        {
            curr_xdiff = Math.abs(coordinates[i][0]-coordinates[i-1][0]);
            curr_ydiff = Math.abs(coordinates[i][1]-coordinates[i-1][1]);
            if(ydiff*curr_xdiff != xdiff*curr_ydiff)
                return false;
        }
        return true;
	}
	
	public static void main(String[] args) {
		
		//int[][] cooridinates={{3,2},{5,3},{4,1},{2,3},{1,4}};
		int[][] cooridinates={{3,2},{4,1},{2,3},{1,4}};
		System.out.println(FindAllThePointsInto2DPaneWhetherStraightORNot.findAllThePointsInto2DPaneWhetherStraightORNot(cooridinates));
	}

}
