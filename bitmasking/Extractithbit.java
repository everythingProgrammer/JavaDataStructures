package bitmasking;

public class Extractithbit {
	
	
	public static void main(String arg[]) {
		
		extractBit(6,2);
	}
	
	public static void extractBit(int n, int i ) {
		
		int j = 1;  /*j will be the mask*/
		j = 1 << i; /*this is basically to create the mask */
		
		n = n & j;
		
		System.out.println(n);
	}

}
