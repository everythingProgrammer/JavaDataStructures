package dynamic;



/* TestCase  failed
 * 32644
 * 2212 34 2
 * ans 22024

 */

public class Mitosis {
	
	/*Top Down approach will give TLE for big cases .*/
	public static int top_down(int n, int x, int y , int z , int dp[]) {
		
		if(n <= 1) {
			return 0;
		}
		if( n == 2) {
			return dp[n] = y;
		}
		/*dp array should be of length n+1 since here indexing is being mapped 1-1.*/
		if(dp[n] != 0) {
			return dp[n];
		}
		
		
		int td1 = top_down(n-1, x, y,z, dp)+ y;
		int costn = td1;
//		System.out.println(" "+ td1);
		if(n%2 != 0) {
			costn = Math.min(costn , Math.min((top_down( (int)Math.ceil(n/2),x,y,z,dp)+x+z ), (top_down(n/2, x,y,z,dp)+x+y) ));   
		}
		else {
			costn = Math.min(costn, top_down(n/2, x,y,z,dp)+x+y);
		}
		
		return dp[n] = costn;
	}
	
	
	/*above code is not clean at all...*/
	public static int bottoms_up(int n, int x, int y , int z) {
		 
		int dp[] = new int[n+1];
		dp[0] = 0;
		dp[1] = 0;
		for(int i = 2  ; i<=n; i++) {
			if(i%2 == 0) {
				dp[i] = Math.min(dp[i-1]+y, dp[i/2]+x);
			}
			else {
				dp[i] = Math.min(dp[i-1]+y, dp[(i+1)/2]+x+z);
			}
			
		}
		
		return dp[n];
		
	}
	

	
	
	public static long give(long[] arr,int n,int x,int y,int z)
    {
        arr[0]=0;
        arr[1]=0;
        for(int i=2;i<=n;i++)
        {
            if(i%2==0)
            {
                arr[i]=Math.min(arr[i/2]+x, arr[i-1]+y);
            }
            else
            {
                arr[i]=Math.min(arr[i-1]+y,arr[(i+1)/2]+z+x);
            }
        }
        return arr[n];
    }
	
	public static void main(String args[]) {
		int dp[] = new int[32645];
		dp[0] = 0;
		dp[1] = 1;
		long arr[] = new long[32645];
//		System.out.println(top_down(32644,2212,34,2,dp));
		System.out.println(bottoms_up(32644,2212,34,2));
		System.out.println(give(arr,32644,2212,34,2));
//		for(int a : dp) {
//			System.out.print(a+" ");
//		}
	}
	
}
