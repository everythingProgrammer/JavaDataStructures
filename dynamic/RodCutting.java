package dynamic;

public class RodCutting {
	
	
	/*dp[0] = 0 and dp[1] = pricearr[0]*/
	
	public static int price(int len , int pricearr[], int dp[] ) {
		
		if(len <= 0) {
			return 0;
		}
		if(dp[len-1] != 0) {
			return dp[len-1];
		}
		
		for(int j= 1 ; j<= len ; j++) {
			dp[len-1] = Math.max(  Math.max(pricearr[len-1] , price(len - j, pricearr, dp) + dp[j-1]), dp[len-1]);
			 
		}		
		return dp[len-1];
 
	}
	
	
	
	public static int bottomsUp(int len, int price[]) {
		int dp[] = new int [len+1];
		
		
		for(int i = 1 ; i<= len ; i++) {
			int max_val = Integer.MIN_VALUE;
			for(int j=0; j<i ; j++) {
				max_val = Math.max(max_val , price[j] + dp[i-j-1]);
			}
			dp[i] = max_val;
		}
		return dp[len ];
		
		
	}
	
	
	public static void main(String args[]) {
		int pricearr[] = {1,5,8,9,10,17,17,15};
		int dp[] = new int[pricearr.length];
		 
		dp[0] = pricearr[0];
		System.out.println( bottomsUp(8, pricearr));
	}
	
}
