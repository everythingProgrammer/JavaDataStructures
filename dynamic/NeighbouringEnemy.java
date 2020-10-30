package dynamic;
import java.util.*;
public class NeighbouringEnemy {
	/*This code still needs to be fixed since  1>=Ai<= n and so here frequency array need to be fixed.
	 * and then dp array also needs to be changed otherwise this code fails for Ai == n.*/
	
	
	/* There are n numbers in array , from a1 to an , no number can be greater 
	 * than the size of array  */
	
	
	
	public static int bottomnsUp(int freq[] , int n) {
		int dp[] = new int[n];
		dp[0] = 0;
		dp[1] = freq[1];
		
		for(int i= 2; i<n; i++) {
			
			dp[i] = Math.max(dp[i-1], freq[i]*i+ dp[i-2]);
		}
		
		
		return dp[n-1];
	}
	
	
	
	
	
	public static void main(String args[]) {
		
		Scanner sr = new Scanner(System.in);
//		int n = sr.nextInt();
//		int nums = new int[n];
		int n = 9;
		int nums[] = {1,2,1,3,2,2,2,2,3};
	
		/*First we'll be making frequency array out of element array
		 *then using that array we'll make our dp array*/
		
		int freq[] = new int[n];
		Arrays.fill(freq, 0);
		for(int i = 0 ; i< nums.length; i++) {
			freq[nums[i]] = freq[nums[i]] + 1;
		}

		
		/*In this frequency array we'll have elements from 0 to m
		 *Some elements will also have adjacent 0's on both sides. 
		 **/
		
		System.out.println(bottomnsUp(freq, n));
		
	}
	
	
	
	
}
