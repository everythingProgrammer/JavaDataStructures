package GridDP;
import java.util.*;
public class NumberOfWays {
	
	/*Simple question to find number of ways to reach the end from start. 
	 *Base variation of blocked paths variation ...*/
	
	
	/********************************************************
	 * Also in this function going in one direction is counted as 1 way
	 * for example from 00 you go to 03 and thats just one way to reach 03
	 * 
	 * in another approach going from 00 to 03 can mean multiple steps depending upon how many cells we 
	 * traverse at once 
	 *eg  00 - 03
	 *    00 - 01 - 03
	 * 	  00 - 02 - 03
	 * 	  00 - 01 - 02 - 03
	 * This method is explained as elephant traverse . 
	 * */
	
	public static int countWays(int x, int y ) {
		int dp[][] = new int[x][y];
		
		for(int i = 0 ; i< x; i++) {
			dp[i][0] = 1;
		}
		for(int i = 0 ; i<y; i++) {
			dp[0][i] = 1;
		}
		
		
		for(int i = 1 ; i<x; i++) {
			for(int j = 1 ; j<y; j++) {
				dp[i][j] = dp[i-1][j]+dp[i][j-1];
			}
		}
		return dp[x-1][y-1];
	}
	
	public static int countElephantWays(int x, int y ) {
		/*Initialization here will be sum of row and column instead of direct 1 ...*/
		
		
		/*The reccurence for this would be like this...
		 * 
		 * 
		 * dp[x][y] = some of that row till the cell + sum of the column till the cell.]
		 * Time complexity O(N^3) 
		 * */
		int dp[][] = new int[x][y];
		
		for(int arr[] :dp) {
			Arrays.fill(arr, 0);
		}
		
		dp[0][0] = 1;
		int sum = 1;
		
		for(int i = 1 ;i<dp.length; i++ ) {
			dp[i][0] = sum;
			sum = sum+dp[i][0];
		}
		sum = 1; 
		for(int i = 1; i<dp[0].length; i++) {
			
			dp[0][i] = sum;
			sum += dp[0][i];
		}
		
		
		
		for(int i =1 ; i<dp.length; i++) {
			for(int j =1; j<dp[0].length; j++) {
				int rsum = 0; 
				int csum = 0;
				for(int k = 0 ; k<i ; k++) {
					csum = dp[k][j]+csum;
				}
				for(int k = 0 ; k<j ; k++) {
					rsum = dp[i][k] + rsum;
				}
				dp[i][j] =rsum+csum;
				
			}
		}
		for(int i = 0 ; i<dp.length; i++) {
			for(int j = 0 ; j<dp[0].length ; j++ ) {
				System.out.print(dp[i][j]+" ");;
			}
			System.out.println();
		}
		return dp[x-1][y-1];
	}
	
	public static void main(String args[]) {
		System.out.println(countElephantWays(2,5));
	}
	
	
	
	
	
	
}
