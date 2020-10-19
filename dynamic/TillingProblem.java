package dynamic;

public class TillingProblem {
	/*bottom's up approach*/
	public static int ways(int N) {
		
		int dp[] = new int[N+1];
		dp[0] = 1;
		dp[1] = 1;
		for(int i = 2 ; i< dp.length ; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[dp.length-1];
		
	}
	
	
	public static void main(String args[]) {
		System.out.println( ways(4));
	}
}
