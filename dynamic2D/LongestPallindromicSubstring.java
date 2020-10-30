package dynamic2D;

public class LongestPallindromicSubstring {
	
	
	public static String BottomsUp(String str) {
		
		int dp[][] = new int[str.length()][str.length()];
		int n = str.length();
		
		int maxlength = 0;
		int start = 0;
		int end = 0;
		/*This is initialization for diagonal*/
		for(int i = 0 ; i<n ; i++) {
			for(int j = i; j<=i ; j++) {
				
					dp[i][j] = 1;
			}
		}
		
		
		/*Initialization of second diagonal i.e. for length = 2; */
		int i = 0;
		for(i = 0 ; i< n-2; i++);{
//			for(int j = i+1 ; j==i+1 ; j++) {
////				if( (int)str.charAt(i) == (int)(str.charAt(j) ) )
//				if(str.substring(i,i+1).equals(str.substring(j, j+1)))
//				{
//					if(j-i+1 >= maxlength) {
//						maxlength = i-j+1;
//						start = i;
//						end = j;
//					}
//					dp[i][j] = 1;
//				}
//				else
//					dp[i][j] = 0;
//			}
			
			
			if(str.charAt(i) == str.charAt(i+1)) {
				dp[i][i+1] = 1;
			}
			else {
				dp[i][i+1] = 0;
			}
			
		}
		
		/*now for length >=3 */
		
		for(i =0; i< n-3; i++) {
			for(int j = i+2; j<i+4; j++) {
				if(str.charAt(i) == str.charAt(j) && dp[i+1][j-1] == 1) {
					dp[i][j]= 1;
					if(j-i+1 >= maxlength) {
						maxlength = j-i+1;
						start = i;
						end = j;
					}
					
				}
				else
					dp[i][j] = 0;
			}
		}
		
		
		
		for( i = 0 ; i<n; i++) {
			for(int j = 0 ; j<n ; j++) {
				System.out.print(dp[i][j]+ " ");
			}
			System.out.println();
		}
		
		
		return str.substring(start, end+1);
	}
	
	
	public static void main(String args[]) {
		BottomsUp("aaaaa");
		
		
	}
	
	
}
