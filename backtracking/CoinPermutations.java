package backtracking;
/*Just Print all the possible ways to pay a certain amount . 
 * 
 * 
 * */
public class CoinPermutations {
	
	static int count;
	
	public static void printPermutations(int curr, int amt , int coins[] , String ans) {
		
		
		if(curr == amt) {
			count++;
			System.out.println(ans);
			
		}
		
		for(int i = 0 ; i< coins.length ; i++) {
			if(curr+coins[i] <= amt) {
				
				printPermutations(curr+ coins[i] , amt , coins , ans+" "+coins[i]+",");
			}
		}
		return ;
		
	}
	
	
	
	public static void main(String args[]) {
		int coins[] = {2,3,5,6};
		printPermutations(0 , 10 , coins , "");
		System.out.println(count);
	}
}
