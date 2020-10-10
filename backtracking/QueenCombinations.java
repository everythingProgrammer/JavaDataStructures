package backtracking;

public class QueenCombinations {
	static int count;
	
	public static void  queenCombinations(boolean boxes[], int qpsf, int tq , String ans , int last){
		/*Base Case */
		if(qpsf == tq)
		{
			count++;
			System.out.println(count + ". "+ ans);
			return;
		}
		
		
		for(int i = last+1 ; i< boxes.length ; i++ ) {
			if(boxes[i] == false) {

				boxes[i] = true;
				queenCombinations(boxes, qpsf+1, tq, ans + " q"+qpsf+" box-"+i+" " , i);
				boxes[i] = false; // Undo Step - BackTracking Main Step
			}
		}
			
	}
	
	public static void main(String args[]) {
		
		long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
		System.out.println("Queen Combinations ");
		boolean boxes[] = new boolean[4] ;
		queenCombinations(boxes , 0 , 2, "" , -1);
//		long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
		
//		System.out.println("Used memory is megabytes: "+( afterUsedMem - beforeUsedMem));
	}

}
