package dynamic;

public class Ladder1 {
	
	public static int countWays(int nums[] , int k ) {
		int dp[]  = new int[nums.length];
		dp[0] = 1;
		for(int i = 1 ; i< nums.length ; i++) {
			if(nums[i] == 1) {
				dp[i] = 0;
				continue;
			}
			for(int j = 1; j<=k && i-j >=0 ; j++) {
				dp[i] = dp[i] + dp[i-j]; 
			}
		}
		return dp[nums.length-1];
	}
	
	public static void main(String args[]) {
		int arr[] = {0,0,0,1,0};
		System.out.println(countWays(arr, 3));
	}
}
