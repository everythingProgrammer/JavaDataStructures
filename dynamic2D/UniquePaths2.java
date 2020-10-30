package dynamic2D;

import java.util.Arrays;

public class UniquePaths2{
	
	
	
	/*obstacle is 1 and empty space 0*/
	 public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
	     int dp[][] = new int[obstacleGrid.length][obstacleGrid[0].length];
	     int n = obstacleGrid.length;
	     int m = obstacleGrid[0].length;
	     
	     dp[0][0] = 1;
	     
	     for(int arr[] : dp)
	    	 Arrays.fill(arr, 0);
	     
	     /*First fill our first row and first coloumn since they will be the base case.*/
	     for(int i = 0 ; i< m; i++) {
	    	 if(obstacleGrid[0][i] == 0) {
	    		 dp[0][i] = 1; 
	    		 
	    	 }
	    	 else {
	    		 break;
	    	 }
	    	 
	     }
	     /* first column now*/
	     for(int i = 0 ; i<n ; i++) {
	    	 if(obstacleGrid[i][0] == 0) {
	    		 dp[i][0] = 1;
	    	 }
	    	 else
	    		 break;
	     }
	     
	     
	     for(int i= 1; i<obstacleGrid.length ; i++) {
	    	 for(int j = 1 ; j< obstacleGrid[0].length; j++) {
	    		 if(obstacleGrid[i][j] ==0) {
	    			 dp[i][j] = dp[i-1][j] + dp[i][j-1];
	    		 }
	    	 }
	     }
	     
//	     for(int i= 0 ; i< n ; i++) {
//	    	 for(int j = 0 ; j< m ; j++) {
//	    		 System.out.print(dp[i][j]+" ");
//	    	 }
//	    	 System.out.println();
//	     }
	     
	     
	     return dp[n-1][m-1];
	     
	    }
	

	 
	 public static void main(String args[]) {
		 int grid[][] = {
						 {0,0,0},
						 {1,0,1},
						 {0,0,0}};
		 
		 System.out.println(uniquePathsWithObstacles(grid));
	 }
}
