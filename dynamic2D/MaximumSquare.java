package dynamic2D;
import java.util.*;
public class MaximumSquare {
	
	/*Brute Force Approach 
	 * When we see a 1 we start travelling diagonally and keep checking if all the elements of 
	 * that row and coloumn are 1 as well and keep updating our maximum_square vairable.
	 *  
	 *  
	 *  Time Complexity O((mn)^2) 
	 * */
	
	public static int maximalSquare(int matrix[][]) {
		
		int rows = matrix.length;
		int cols = rows>0?matrix[0].length : 0;
		int maxsq = 0;
		
		for(int i = 0 ; i<rows; i++) {
			for(int j = 0 ; j<cols; j++) {
				if(matrix[i][j] == 1) {
					int sqlen = 1;
					boolean flag = true;
					
					while(sqlen+i < rows && sqlen+j < cols && flag) {
						/*Checking rows and columns are 1 or not*/
						for(int k = j ; k<= sqlen ; k++) {
							if(matrix[i+sqlen][k] == 0) {
								flag = false;
								break;
								
							}
						}
						for(int k = i ; k<= sqlen +i ; k++) {
							if(matrix[k][j+sqlen] == 0) {
								flag = false;
								break;
							}
						}
						if(flag) {
							sqlen++;
						}
					}
					if(maxsq<sqlen)
						maxsq = sqlen;
				}
			}
		}
		return maxsq;
	}
	
	
	/*Dynamic Programming approach
	 * We initialize another matrix (dp) with the same dimensions as the original one initialized with all 0’s.
	 * dp(i,j) represents the side length of the maximum square whose bottom right corner is the cell with
	 * index (i,j) in the original matrix.
	 * 
	 * dp(i,j)=min(dp(i-1,j),dp(i-1,j-1),dp(i,j-1))+1.
	 * 
	 * 
	 * */
	public static int maximalSquare(int matrix[][]) {
		
		
		
		return 0;
	}
	
	
	public static void main(String args[]) {
		
	}
	
	
	
}
