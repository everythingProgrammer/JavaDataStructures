package dynamic;
import java.util.*;
public class HouseRobber2 {
	
//	public static int rob(int[] nums) {
//		if(nums.length == 1)
//			return nums[0];
//		if(nums.length == 2)
//			return Math.max(nums[0], nums[1]);
//		
//		int dp[] = new int[nums.length+1];
//		dp[0] = 0;
//		dp[1] = nums[0];
//		dp[2] = nums[1];
//		
//		for(int i = 3; i<dp.length ; i++) {
//			dp[i] = Math.max(dp[i-2], dp[i-3])+ nums[i-1];
//		}
		
		
		/*Cyclic check*/
//		if(nums.length %2 != 0) {
//			dp[dp.length-1] = nums[0]>nums[nums.length-1]? dp[dp.length-1]-nums[nums.length-1]: dp[dp.length-1]-nums[0] ;
//		}
//		for(int i = 0 ; i<dp.length ; i++)
//			System.out.print(dp[i]+" " );
//		return Math.max(dp[nums.length -1], dp[nums.length]);
//		
//
//		int dp1[] = new int[nums.length-1];
//		int dp2[] = new int[nums.length-1];
//		dp1[0] = nums[0];
//		dp1[1] = nums[1];
//		for(int i = 2 ; i<nums.length -1 ; i++) {
//			dp1[i] = nums[i] + dp1[i-2];
//		}
//		
//		dp2[0] = nums[1];
//		dp2[1] = nums[2];
//		for(int i = 2; i<dp2.length ; i++) {
//			dp2[i] = nums[i+1] + dp2[i-2];
//		}
//		
//		for(int i = 0 ; i< dp1.length ; i++)
//			System.out.print(dp1[i]+" " );
//		System.out.println();
//		for(int i = 0 ; i<dp2.length ; i++)
//			System.out.print(dp2[i]+" ");
//		System.out.println();
//		return Math.max(dp1[dp1.length], dp2[dp2.length]);
//    }
//	
    public static int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2, new Integer[nums.length]), rob(nums, 1, nums.length - 1, new Integer[nums.length]));
    }
    
    private static int rob(int[] nums, int st, int i, Integer[] dp) {
        if(i < st) return 0;
        if(dp[i] != null) return dp[i];
        return dp[i] = Math.max(rob(nums, st, i - 2, dp) + nums[i], rob(nums, st, i - 1, dp));
    }
	public static void main(String args[]) {
		int arr[] = {1,3,1,3,100};
//		int arr[] = {2,1,1,2};
		rob(arr);
	}
	
	
}
