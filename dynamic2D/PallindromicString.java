package dynamic2D;

public class PallindromicString {
	
	/*Double Dimensional Dp question*/
	/*Haven't introduced dp in this yet*/
	
	public static boolean pallindromicString(String str, int l , int r) {
		/*Recurrence relation function(r,l) = function(l+1, r-1) && s[l] == s[r]*/
		if(l>r) {
			return false;
		}
		
		if(l == r || (l== (r-1) && str.charAt(l) == str.charAt(r))) {
			return true;
		}
		
		
		
		return pallindromicString(str, l+1, r-1) && (str.charAt(l)== str.charAt(r));
	}
	
	
	public static void main(String args[]) {
		/*indexing has to be 0 based in this. so adjust accordingly.*/
		System.out.println(pallindromicString("abbac", 0,3));
		
		
	}
	
}
