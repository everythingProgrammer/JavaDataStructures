package dynamic;

public class MaximumSumKPartition {
	
	public static int maxSumKPartition(int arr[] , int len , int k) {
		int max1 = arr[0];
		int max2 = Integer.MIN_VALUE;
		int maxp1 = 0 , maxp2= 0;
		int ans = 0;
		
		int dp[] =  new int[arr.length];
		/*do initial loop where you build the first segment of dp array of k elements*/
		
		for(int i = 0 ; i<k ; i++) {
			dp[i] = arr[i];
			if(arr[i]>max1) {
				max1= arr[i];
				maxp1 = i;
			}
			else if(arr[i]> max2 ) {
				max2 = arr[i];
				maxp2 = i;
			}
		}
		ans = Math.max(ans,max1);
		
		/*now traverse over*/
//		int a = 1;
		int maxc1 = max1;
		int maxc2 = max2;
		int maxc1p = maxp1;
		int maxc2p = maxp2;
		
		for(int a = 1; a*k <= len; a++) {
			for(int i = k*a ; i<len && i<k*(a+1) ;i++) {
				
				if(arr[i] < 0) {
					dp[i] = max1;
					continue;
				}
				
				if(i-maxp1 != k) {
					dp[i] = max1+arr[i];
				}
				else {
					dp[i] = max2 + arr[i];
				}
				
				
				if(dp[i] > maxc1) {
					maxc1 = dp[i];
					maxc1p = i;
				}
				else if(dp[i] > maxc2) {
					maxc2 = dp[i];
					maxc2p = i;
				}
			}
			ans = Math.max(ans, maxc1);
			max1 = maxc1;
			max2 = maxc2;
			maxp2 = maxc2p;
			maxp1 = maxc1p;
		}
		return ans;
	}
	

	public static void main(String args[]) {
//		int arr[] = {1,2,5,2,3,4,5,1,2,0,1,5,9,2};
		int arr[] = {1,2,3,-1,-2 };
		System.out.println(maxSumKPartition(arr, arr.length , 3));
	}
}