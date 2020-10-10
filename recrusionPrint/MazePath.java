package recrusionPrint;

public class MazePath {
	
	public static void printPath(int cc, int cr , int ec, int er , String cp) {
		
		if( cc == ec && cr == er) {
			System.out.println(cp);
			return;
		}
		else if(cc>ec || cr> er) {
			return ;
		}
		
		printPath(cc+1 , cr, ec, er, cp+"H");
		printPath(cc, cr+1 , ec, er , cp+"V");
		printPath(cc+1 , cr+1 , ec, er , cp+"D");
		return;
	}
	
	public static int countPath(int cc , int cr, int ec, int er) {
		if( cc == ec && cr == er) {
			
			return 1;
		}
		else if(cc>ec || cr> er) {
			return 0;
		}
		
		int sum = 0 ; 
		sum = sum + countPath(cc+1 , cr, ec, er) + countPath(cc+1,cr+1, ec,er) + countPath(cc, cr+1 , ec, er);
		
		return sum;	
	}
	
	
	public static void main(String args[]) {
		printPath(0,0,2,2,"");
		System.out.println(countPath(0,0,2,2));
	}

}
