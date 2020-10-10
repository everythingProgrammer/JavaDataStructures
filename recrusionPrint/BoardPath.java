package recrusionPrint;
import java.util.*;
public class BoardPath {
	public static void printBoardPath(int curr, int end , String path) {
		
		if(curr == end) {
			System.out.println("path =>"+path);
			return;
		}
		if(curr> end) {
			return; 
		}
		
		for(int i = 1 ; i<= 6 ; i++) {
			printBoardPath(curr+i, end , path+","+i+"");
		}
		
	}

	
	public static int countBoardPath(int curr , int end ) {
		if(curr>end) {
			return 0;
		}
		if( curr == end) {
			return 1; 
		}
		
		int sum = 0;
		for(int i = 1 ; i<= 6 ; i++) {
			sum = sum + countBoardPath(curr+i , end);
		}
		
		return sum;
	}
	
	
	public static void main(String args[]) {
		printBoardPath(1, 10 , "");
		System.out.println(countBoardPath(1,10));
	}
}
