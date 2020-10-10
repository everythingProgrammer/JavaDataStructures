
/*print permutations */
package recrusionPrint;

public class Permutations {
	
	
	public static void printPermutations(String str, String ans) {
		
		if(str.length() == 0) {
			System.out.println(ans);
			return ;
		}
		
		
		for(int i= 0 ; i<str.length(); i++) {
			char ch = str.charAt(i);
			String roq = str.substring(0,i) + str.substring(i+1);
			printPermutations(  str.substring(0,i) + str.substring(i+1) , ch+ans);
		}
		
	}
	
	
	
	public static void main(String args[]) {
		printPermutations("abc", "");
	}
}
