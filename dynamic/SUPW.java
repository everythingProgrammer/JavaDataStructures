package dynamic;

public class SUPW {
	
	/*Bottom's Up approach*/
	public static int minimumTime(int arr[]) {
		int size = arr.length;
		int dp[] = new int[size];
		if(size == 0) {
			return 0;
		}
		
		if(size <= 3) {
			return Math.min(Math.min(arr[0], arr[1]), arr[2]);
		}
		
		dp[0] = arr[0];
		dp[1] = arr[1];
		dp[2] = arr[2];
		
		for(int i = 3 ; i< size ; i++) {
			dp[i] = arr[i] + Math.min(Math.min(dp[i-1], dp[i-2]) , dp[i-3]);
		}
		return Math.min(Math.min(dp[size-1], dp[size-2]), dp[size -3 ]);
		
	}
	
	
	public static void main(String args[]) {
		int arr[] = {3 ,2 ,1 ,1 ,2 ,3 ,1 ,3 ,2 ,1};
		
		System.out.println(minimumTime(arr));
	}
}
