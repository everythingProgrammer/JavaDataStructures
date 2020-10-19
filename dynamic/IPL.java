package dynamic;

public class IPL {
	
	/*Bottom's up approach to get maximum
	 * In supw program we selected minimum in 3 such that no 3 elements are consequtive and missed
	 * meaning out of every 3 one is selected.
	 * now using same program what I can do is just substract it from total sum which will give 
	 * me maximum possible sum (when I don't select minimum element)*/
	public static int maximumEarning(int nums[]) {
		
		int size = nums.length;
		int tsum = 0;
		if(size == 3) {
			for(int a: nums) {
				tsum = tsum + a;
				
			}
			return tsum - Math.min(Math.min(nums[0], nums[1]),nums[2]);
		}
		
		
		int dp[] = new int[size];
		dp[0] = nums[0];
		dp[1] = nums[1];
		dp[2] = nums[2];
		tsum  = tsum + nums[0]+nums[1]+nums[2];
		for(int i = 3 ; i< size ; i++) {
			tsum = tsum+nums[i];
			dp[i] = nums[i] + Math.min(Math.min(dp[i-1], dp[i-2]), dp[i-3]);
		}
		
		return tsum- Math.min(Math.min(dp[size-1], dp[size -2]),dp[size-3]) ;
		
	}
	public static void main(String args[]) {
		int nums[] = {3 ,2 ,3 ,2 ,3 ,5 ,1 ,3};
		System.out.println(maximumEarning(nums));
	}
	
}
