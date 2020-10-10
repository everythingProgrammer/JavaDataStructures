package backtracking;

public class QueenPermutations {
	static int count ;
	
	public static void  queenPermutations(boolean boxes[], int qpsf, int tq , String ans){
		/*Base Case */
		if(qpsf == tq)
		{
		
			System.out.println(count+1+"."+ans);
			count++;
			return;
		}
		
		
		for(int i = 0 ; i< boxes.length ; i++ ) {
			if(boxes[i] == false) {

				boxes[i] = true;
				queenPermutations(boxes, qpsf+1, tq, ans + " q-"+qpsf+" box-"+i+" ");
				boxes[i] = false; // Undo Step - BackTracking Main Step
			}
		}
			
	}
	
	public static void main(String args[]) {
		System.out.println("Queen Permutations ");
		boolean boxes[] = new boolean[4] ;
		queenPermutations(boxes , 0 , 2 , "");
	}
}
