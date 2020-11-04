package dynamic2D;

import java.util.Arrays;

public class LongestPallindromicSubstring {
	
	
	public static String BottomsUp(String str) {
		
		int dp[][] = new int[str.length()][str.length()];
		int n = str.length();
		
		int maxlength = 0;
		int start = 0;
		int end = 0;
		/*This is initialization for diagonal*/
		for(int i = 0 ; i<n ; i++) {
			dp[i][i] = 1;
		}
		
		
		/*Initialization of second diagonal i.e. for length = 2; */
		int i = 0;
		for(i = 0 ; i< n-1; i++){
			if(str.charAt(i) == str.charAt(i+1)) {
				dp[i][i+1] = 1;
				maxlength = 2;
				start = i;
			}
			else {
				dp[i][i+1] = 0;
			}
			
		}
		
		for(int row[]: dp) {
			System.out.println(Arrays.toString(row));
		}
		
		/*now for length >=3 */
		
		/*for(i =0; i< n-3; i++) {
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
		}*/
		
		
		
//		for( i = 0 ; i<n; i++) {
//			for(int j = 0 ; j<n ; j++) {
//				System.out.print(dp[i][j]+ " ");
//			}
//			System.out.println();
//		}
//		
		System.out.println("Max Length = "+maxlength);
		
		
		return str.substring(start, end+1);
	}
	
	
	public static void main(String args[]) {
		System.out.println(BottomsUp("aaaaa"));
		
		
	}
	
	
}
