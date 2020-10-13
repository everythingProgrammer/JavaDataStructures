package dynamic;

import java.util.Arrays;

public class MaximumSubarraySum {
	
	public static  int maxSum(int a[] , int n) {
		
		int dp[]= new int[100];
		Arrays.fill(dp, 0);
		
		dp[0] = a[0]>0?a[0]:0;
		int max_so_far= dp[0];
		for(int i= 1; i<n; i++ ) {
			dp[i] = dp[i-1] +a[i];
			if(dp[i]<0) {
				dp[i] = 0;
				
			}
			max_so_far = Math.max(max_so_far, dp[i]);
		}
		
		return max_so_far;
	}
	
	
	public static void main(String args[]) {
		int arr[] = {-3,2,5,-1,-6,3,-2,7,-5,-2};
		System.out.println(maxSum(arr, arr.length));
	}
}
