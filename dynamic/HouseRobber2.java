package dynamic;
import java.util.*;
public class HouseRobber2 {
	
	public static int rob(int[] nums) {
        if(nums.length ==1)
        	return nums[0];
        if(nums.length ==2) {
        	return Math.max(nums[0], nums[1]);
        }
		int j = nums.length%2==0? nums.length: nums.length-1 ;
		int dp[] = new int[nums.length];
		dp[0]= nums[0];
		dp[1] = nums[1];
		
		for(int i = 2 ; i<j ; i++) {
			
			dp[i] = nums[i]+dp[i-2];
			
		}
		 
		if(nums.length%2 != 0) {
			dp[nums.length-1] = nums[0]>nums[nums.length-1]?dp[nums.length-3]:(dp[nums.length-3]+nums[nums.length-1]-dp[0]);
		}
		
//		
		for(int i = 0 ; i<dp.length; i++) {
			System.out.print(dp[i]+" " );
		}
		
		return Math.max(dp[nums.length-1], dp[nums.length -2]);
    }
	
	
	public static void main(String args[]) {
		int arr[] = {1,3,1,3,100};
		rob(arr);
	}
	
	
}
