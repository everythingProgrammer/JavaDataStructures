package dynamic;

public class ProfitMaximization {
	
	/*Dynamic Programming.
	 * Top Down - memoization
	 * Bottoms Up */
	
	public static int maxProfit(int nums[]) {
		int dp[] = new int[nums.length];
		
		int max_profit = 0;
		dp[0] = nums[0];
		
		for(int i = 1 ; i<nums.length ; i++) {
			for(int j = 0; j<i ; j++) {
				if(nums[i]%nums[j] == 0) {
					
					dp[i] = Math.max(nums[i], dp[j] + nums[i]);
					if(dp[i] > max_profit) {
						max_profit= dp[i];
					}
				}
			}
		}
//		for(int a: dp) {
//			System.out.print(a+" ");
//		}
//		
		
		return max_profit;
	}
	
	public static void main(String args[]) {
		int nums[] = {1,2,3,4,9,8};
		System.out.println(maxProfit(nums));
	}
}
