/* Just Count How many Board Paths*/

package recursion;
import java.util.*;
public class CountBoardPath {
	
	public static int getPath(int curr, int end){
		
		if(curr == end) {
			return 1;
		}
		if(curr > end) {
			return 0;
		}
		
		
		int count = 0 ; 
		
		for(int dice = 1 ; dice<= 6 ; dice++) {
			
			int tcount = getPath(dice+curr, end);
			
			count = count+tcount;
		}
		
		return count;
		
	}
	
	public static void main(String args[]) {
		System.out.println(getPath(2,2));
	}
	
	

}
