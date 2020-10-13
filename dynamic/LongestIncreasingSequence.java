package dynamic;

import java.util.Arrays;

/*for input 50 3 10 7 40 80
 * 
 * the ans would be 4  3-10-40-80*/


public class LongestIncreasingSequence {
	
	
	public static int lis(int arr[], int len) {
		
		int lis[] = new int [arr.length];
		
		
//		Arrays.fill(lis, 1);
		
		for(int i = 0  ; i< lis.length ; i++) {
			lis[i] = 1;
		}
		
		for(int i = 1 ; i< len ; i++) {
			
			for(int j = 0 ; j< i ; j++) {
				if( arr[i] > arr[j] && lis[i] < lis[j]+1) {
						lis[i] = lis[j]+1;
				}
			}
			
		}
		int max = lis[0];
		for(int i = 0 ; i< len ; i++) {
			if( lis[i]> max) {
				max  = lis[i];
			}
		}
		
		return max;
	}
	public static void main(String args[]) {
		int arr[] = {10,22,9,33,21,50,41,60};
		System.out.println(lis(arr, arr.length));
	}
}
