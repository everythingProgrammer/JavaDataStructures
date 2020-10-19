package dynamic;

public class ProfitMaximization {
	
	
	public static int maxProfit(int nums[]) {
		int dp[] = new int[nums.length];
		dp[0] = nums[0];
		
		for(int i = 1 ; i<nums.length ; i++) {
			for(int j = 0; j<i ; j++) {
				if(nums[i]%nums[j] == 0) {
					dp[i] = Math.max(nums[i], dp[j] + nums[i]);
				}
			}
		}
//		for(int a: dp) {
//			System.out.print(a+" ");
//		}
//		
		
		return dp[dp.length-1];
	}
	
	public static void main(String args[]) {
		int nums[] = {1,2,3,4,9,8};
		System.out.println(maxProfit(nums));
	}
}
