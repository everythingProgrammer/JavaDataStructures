package recursion;

public class Fibonacci {
	
	
	public int num(int n , int dp[]) {
		if(n == 0) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}
		if(dp[n] != 0) {
			return dp[n];
		}
		int sum = 0;
		sum = num(n-1 , dp) + num(n-2 , dp);
		return dp[n] =sum;
	}
	
	public static void main(String args[]) {
		Fibonacci f = new Fibonacci();
		int dp[] = new int[20];
		System.out.println(f.num(8, dp));
	}

}
