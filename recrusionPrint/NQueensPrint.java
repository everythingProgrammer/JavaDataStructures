package recrusionPrint;

public class NQueensPrint {
	
	
	public static int printPos(boolean matrix[][] , int row , String result ) {
		
		if( row >= matrix.length) {
			System.out.println(result);
			return 1; 
		}
		
		int count = 0; 
		
		for(int col = 0 ; col<matrix[row].length; col++ ) {
			if(isItSafe(matrix, row, col)) {

				matrix[row][col] = true;
				count = count + printPos(matrix, row+1 , result + " {" + (row+1)+"-"+(col+1)+"}");
				matrix[row][col] = false; 
			
			}
			
			
		}
		return count;
	}
	
	
	private static boolean isItSafe(boolean matrix[][] , int row , int col) {
		
	/*for loop for checking above*/	
		for(int i = row ; i >= 0 ; i-- )
		{
			if(matrix[i][col] == true)
				return false;
		}
	/*for loop to check LD*/
		for(int i = row,j = col ; i>=0 && j>=0 ; i-- , j-- ) {
			if(matrix[i][j] == true)
				return false;
		}
	/*for loop to check RD*/
		for(int i= row , j = col ; i>=0 && j< matrix[0].length ; i--,j++) {
			if(matrix[i][j] == true)
				return false;
		}
	return true;
	}
	public static void main(String args[]) {
		/*boolean matrix [][] = {
				{false , true  , true , true},
				{true  , false , false  , false},
				{true  , true  , true  , true},
				{true  , true  , true  , true}
		};*/
		boolean matrix[][] = new boolean[8][8];
		System.out.println("\n Number of arrangements " +printPos(matrix, 0 , ""));
		
	}
}
