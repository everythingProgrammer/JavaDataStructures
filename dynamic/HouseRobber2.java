package dynamic;
import java.util.*;
public class HouseRobber2 {
	
	public static int rob(int[] nums) {
		if(nums.length == 1)
			return nums[0];
		if(nums.length == 2)
			return Math.max(nums[0], nums[1]);
		
		int dp[] = new int[nums.length+1];
		dp[0] = 0;
		dp[1] = nums[0];
		dp[2] = nums[1];
		
		for(int i = 3; i<dp.length ; i++) {
			dp[i] = Math.max(dp[i-2], dp[i-3])+ nums[i-1];
		}
		
		
		/*Cyclic check*/
		if(nums.length %2 != 0) {
			dp[dp.length-1] = nums[0]>nums[nums.length-1]? dp[dp.length-1]-nums[nums.length-1]: dp[dp.length-1]-nums[0] ;
		}
		for(int i = 0 ; i<dp.length ; i++)
			System.out.print(dp[i]+" " );
		
		return Math.max(dp[nums.length-1], dp[nums.length]);
    }
	
	
	public static void main(String args[]) {
		int arr[] = {1,3,1,3,100};
//		int arr[] = {2,1,1,2};
		rob(arr);
	}
	
	
}
