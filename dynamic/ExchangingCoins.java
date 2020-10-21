package dynamic;

public class ExchangingCoins {
	
	/*Top Down approach since , in bottom's up approach we'll have to calculate maximum gold for
	 * all the coins till size n , and let's say we have a coin of weight 10^9 then well have to 
	 * calculate all the gold for 10^9 size, and in top down approach we'll only have to calculate 
	 * weight of only a few elements because n/2,n/3,n/4.
	 * 
	 **/
	public static int maxGold(int n, int dp[]) {
		if(n==1) {
			return 1;
		}
		if(n == 2) {
			return 2;
		}
		if(n ==3 ) {
			return 3;
		}
		
		if(dp[n] != 0) {
			return dp[n];
		}
		
		int max = 0;
		max = Math.max(n,   maxGold(n/2,dp)+maxGold(n/3, dp)+ maxGold(n/4, dp) );
		return dp[n] = max;
		
		
	}
	
	public static void main(String args[]) {
		int n = 8956;
		int dp[] = new int[n+1];
		System.out.println(maxGold(n,dp));
	}
	
}
