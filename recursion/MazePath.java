/* Reach from home to destination and print how to reach there like
 * HVHV
 * HHHVVV something of this sort. */

package recursion;
import java.util.*;
public class MazePath {
	
	public static ArrayList<String> getPath(int startr ,int startc  , int endr, int endc  ) {
		/*Conditions that we reach end by H or V and return H or V*/
		if( startr == endr && startc == endc) {
			ArrayList<String> rr = new ArrayList<>();
			rr.add(" ");
			return rr;
		}
		/*Conditions that we may go out of bounds and never reach end*/
		if(startr > endr || startc > endc) {
			ArrayList<String> rr = new ArrayList<>();
			return rr;
		}
		
		
		
		ArrayList<String> mr = new ArrayList<>();
		/* this is horizontal*/
		ArrayList<String> rr = getPath(startr , startc+1 , endr , endc);
		
		for(String s: rr) {
			mr.add("H"+s);
		}
		
		/*Increment in H and then increment in V*/
		// increment in H means increment in column.
		// increment in V means increment in row. 
		
		rr = getPath(startr+1 , startc , endr , endc);
		for(String s: rr) {
			mr.add("V"+s);
		}
		
		rr = getPath(startr+1, startc+1 , endr, endc);
		for(String s :rr) {
			mr.add("D"+s);
		}
		return mr;
	}
	
	public static void main(String args[]) {
		System.out.println(getPath(0,0,2,2));
	}
	
	
	
	
}
