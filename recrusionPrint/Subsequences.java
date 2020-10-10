/*Print subsequences without using ArrayList to store anything*/

package recrusionPrint;

public class Subsequences {
	
	public static void printSubsequences(String str , String result) {
		if(str.length() == 0) {
			System.out.println(result);
			return ; 
		}
		char sub = str.charAt(0);
		printSubsequences(str.substring(1) , result);
		printSubsequences(str.substring(1) , result+sub);
		return ;
	}
	
	public static void main(String args[]) {
		printSubsequences("abc", "");
	}
}
