/* All subsequences of string passed. 
 * "abc" - {"" , c , b , a , bc ...} 
 * return arrayList */



// For any String total number of subsequences are 2^n.
// where n is length of string. 
// abc = 2^3 = 8.
package recursion;
import java.util.*;
public class Subsequences {
	
	public static ArrayList<String> getSequence(String abc){
		if(abc.length() == 0)
		{
			ArrayList<String> baseResult = new ArrayList<>();
			baseResult.add(" ");
			return baseResult;
		}
		char cc = abc.charAt(0);
		String ros = abc.substring(1);
		ArrayList<String> result = new ArrayList<>();
		ArrayList<String> recursionresult = getSequence(ros);
		for(int i = 0 ; i< recursionresult.size(); i++) {
			result.add(recursionresult.get(i));
			result.add(cc+recursionresult.get(i));
		}
		return result ;
	}
	
	public static void main(String args[]) {
		ArrayList<String> result = getSequence("abc");
		/*for(String a: result) {
			System.out.println(a);
		}*/
		System.out.println(result);
	}
	
}
