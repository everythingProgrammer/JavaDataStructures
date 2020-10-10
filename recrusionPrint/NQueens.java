package recrusionPrint;
import java.util.*;
public class NQueens {

	public static int findPos(boolean matrix[][] , int row ) {
		
		if( row >= matrix.length) {
			return 1; 
		}
		
		int count = 0; 
		
		for(int col = 0 ; col<matrix[row].length; col++ ) {
			if(isItSafe(matrix, row, col)) {
				/* col loop is basically for the column iteration of the  queen at row "row"*/
				/* isItSafe function will tell us if its safe
				 * if its safe then we'll place our queen there and mark that by 
				 * 	making that position true on the matrix*/
				/* then we'll do count = count+ recusion to go till the end */
				/* if the row number is greater than the length then all the queens have been placed in correct way otherwise it would have break*/
				matrix[row][col] = true;
				count = count + findPos(matrix, row+1);
				matrix[row][col] = false; 
				/*after calculating all the posibilities of one side we set it to false...*/
			}
		}
		
		return count;
		
	}
	
	/*IsItSafe() function in NQueens */
	/*This function is calling 3 other individual functions that are checking for 
	 *	if the queen is really safe. */
	private static boolean isItSafe(boolean matrix[][] , int row , int col) {
		return isItSafeLD(matrix, row -1, col-1) && isItSafeRD(matrix, row-1 , col+1) && isItSafeUP(matrix, row-1 ,col);
	}
	private static boolean isItSafeUP(boolean matrix[][], int row , int col) {
		if(row<0 ) {
			return true;
		}
		if(matrix[row][col] == true) {
			return false;
		}
		
		return isItSafeUP(matrix, row-1 , col);
	}
	private static boolean isItSafeRD(boolean matrix[][], int row , int col)
	{
		if(row <0  || col >= matrix[0].length) {
			return true;
		}
		if(matrix[row][col] == true) {
			return false;
		}
		
		return isItSafeRD(matrix, row-1 , col+1);
	}
	private static boolean isItSafeLD(boolean matrix[][], int row , int col) {
		if(row < 0 || col <0) {
			return true;
		}
		if(matrix[row][col] == true) {
			return false;
		}
		
		
//		System.out.println("row "+ row +" column "+ col  );
		
		 return isItSafeLD(matrix , row -1 , col -1 );
		
	}
	public static void main(String args[]) {
		/*boolean matrix [][] = {
				{false , true  , true , true},
				{true  , false , false  , false},
				{true  , true  , true  , true},
				{true  , true  , true  , true}
		};*/
		boolean matrix[][] = new boolean[8][8];
		/*Matrix is the representation of Board .
		 *Here True means that queen is already present in that row column.*/		
		System.out.println(findPos(matrix, 0));
	}
}
