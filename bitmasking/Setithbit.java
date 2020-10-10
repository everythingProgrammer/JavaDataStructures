package bitmasking;

public class Setithbit {
	public static void main(String args[]) {
		setBit(2,3);
	}
	
	
	public static void setBit(int n , int i) {
		int mask = 1; 
		mask = 1 << (i-1);
		
		n = n | mask;
		
		System.out.println(n);
	}

}
