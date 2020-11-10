package GridDP;
import java.util.*;
public class MinimumCostPath {
	
	
	/*A cell with the cost to traverse it is given , now find the cost to traverse through grid*/
	/*bottom's up dp */
	public static int minCost(int grid[][], int x , int y) {
		
		int dp[][] = new int[grid.length][grid[0].length];
		for(int arr[] : dp) {
			Arrays.fill(arr, 0);
		}
		
		/*Fill the first row and first coloumn with their respective values .*/
		dp[0][0] = grid[0][0];
		for(int i = 1 ;i<grid.length; i++) {
			dp[i][0] = dp[i-1][0]+grid[i][0];
		}
		
		
		for(int i = 1 ;i<grid.length; i++) {
			dp[0][i] = dp[0][i-1]+grid[0][i];
		}
		
		
		for(int i= 1 ; i< grid.length; i++) {
			for(int j= 1 ; j< grid[0].length; j++) {
				dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])+grid[i][j];
			}
		}
		
		for(int i = 0 ; i<grid.length; i++) {
			for(int j = 0 ; j< grid.length ; j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		
		
		return dp[x-1][y-1];
	}

	/*This is greedy approach ... 
	 *Choose the first smallest number first 
	 *and this doesn't even work ........ :)*/
	public static int minCost2(int grid[][] , int x, int y ) {
		int cost = 0;
		
		for(int i = x-1 ; i>0 ; ) {
			for(int j = y-1; y> 0 ;) {
				cost = cost + Math.min(grid[i-1][j], grid[i][j-1]);
				if(grid[i-1][j]< grid[i][j-1]) {
					i = i-1; 
					
				}else
					j = j-1;
			}
		}
		
		
		return 0;
	}
	
	public static void main(String args[]) {
		int arr[][] = {{1,5,2},{7,1,1},{8,1,3}};
		System.out.println(minCost(arr, 3,3));
		
	}
}
