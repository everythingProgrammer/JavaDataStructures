package bitmasking;

public class rightmostSetBit {
	
	
	public static void rightmostSetBit(int n) {
		int pos = 1;
		int mask = 1;
		
		while( (n&mask) == 0) {
			pos++;
			mask = mask<<1;
		}
		System.out.println(pos);
	}

	public static void main(String args[]) {
		rightmostSetBit(6);
	}
}
