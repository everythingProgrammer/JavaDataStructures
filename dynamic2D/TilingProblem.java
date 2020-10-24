package dynamic2D;

public class TilingProblem {
	/*Floor Size is of m*n and tile size is of 1*m    */
	/*Floor is of n rows and m coloumns 
	 *
	 *Tiles can be placed horizontally or vertically 
	 *Horizontally 
	 *
	 * */
	
	
	/*Top Down approach*/
	public static int ways(int n , int m, int dp[]) {
		if(n<0) {
			return 0;
			
		}
		if(n==0) {
			return 1;
		}
		
		int count = ways(n-1, m , dp)+ ways(n-m,m,dp);
		
	    dp[n] = count;
		return count;
	}
	
	/*Bottom's up approach
	 * from geeksforgeeks wasn't able to understand*/
	
	
	public static int bottomup(int n , int m) {
		int dp[] = new int[n+1];
		dp[0] = 0;
		dp[1] = 2;
		for(int i = (n-3) ;i<= n ; i++) {
			if( i >0 ) {	
			}
		}
		return 0;
	}
	
	
//	public static int 
	
	
	public static void main(String args[]) {
		int dp[] = new int[100];
		int n = 7;
		int m = 4;
		
		System.out.println(ways(n,m,dp));
	}
	
}
