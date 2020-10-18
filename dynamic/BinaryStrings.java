package dynamic;

public class BinaryStrings {
	
	/*Bottom's up approach*/
	public static int validBinaryStrings(int n) {
		int dp[][] = new int[n][n];
		dp[0][0] = 1;
		dp[0][1] = 1;
		
		for(int i = 1 ; i< n ; i++) {
			dp[i][0] = dp[i-1][0] + dp[i-1][1];
			dp[i][1] = dp[i-1][0];
		}
		return (dp[n-1][0]+ dp[n-1][1]) ;
	}
	
	public static void main(String args[]) {
		System.out.println(validBinaryStrings(3));
	}
}


/*If we would have generated all the strings and then checked , that would give us complexity of O(N^2) . 
 *Here complexity is O(n). */
