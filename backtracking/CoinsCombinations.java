package backtracking;

/*Coins combination to make coins upto some amount without repetetion 
 * */

/*The can be minor changes in this program 
 * instead of returning when curr> amt what we can do is check if amt >= curr+coins[i]  and then only call next level. 
 * */

public class CoinsCombinations {
	
	static int count = 0; 
	
	public static void printCombinations(int amt, int curr,int coins[], int prevcoin , String ans) {
		
		if(curr == amt)
		{
			count++; 
			System.out.println(ans);
			return ;
		}
	/*	if ( curr> amt) {
			return ;
		}
	*/
		
		
		for(int i = prevcoin;  i<coins.length; i++) {
			if(curr+coins[i]<= amt) {
				printCombinations(amt , curr+coins[i] , coins, i , ans+" "+coins[i]+"," );
			}
			
		}
		return ;
	}
	public static void main(String args[]) {
		int coins[] = {2,3,5,6};
		printCombinations(12,0,coins,0,"");
		//System.out.println(count);
		
		
	}

}
