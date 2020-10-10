/*get board path from start to end all possibilities.
 * */

package recursion;
import java.util.*;
public class BoardPath {
	
	public static ArrayList<String> getPath(int curr, int end){
		
		if(curr == end) {
			ArrayList<String> ir = new ArrayList<>();
			ir.add("");
			return ir;
		}
		if(curr > end) {
			ArrayList<String> ir = new ArrayList<>();
			return ir;
		}
		
		
		ArrayList<String> mr = new ArrayList<>();
		for(int dice = 1 ; dice<= 6 ; dice++) {
			
			ArrayList<String> rr = getPath(curr+dice, end);
			
			for(String st : rr) {
				st = dice+ st ; 
				mr.add(st);
			}
		}
		
		return mr;
		
	}
	
	public static void main(String args[]) {
		System.out.println(getPath(2,2).size());
	}
}
