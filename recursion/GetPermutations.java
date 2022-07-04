/*Get permutations of string*/
 

package recursion;
import java.util.*;
public class GetPermutations {
	
	public static ArrayList<String> getPermutations(String str){
		if(str.length() == 0) {
			ArrayList<String> rs = new ArrayList<>();
			rs.add("");
			return rs;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> rr = getPermutations(ros);
		ArrayList<String> mr = new ArrayList<>();
		
		
		for(String rrs: rr) {
			for(int i = 0 ; i<=rrs.length(); i++) {
				String val = rrs.substring(0,i) + ch + rrs.substring(i);
				mr.add(val);
			}
		}
//		System.out.println(mr);
		return mr;
	}
	public static void main(String args[]) {
		//ArrayList<String> result = getPermutations("abc");
		System.out.println(getPermutations("abc"));
	}
	
	
}
