package dynamic2D;

public class WinesTopDown {
	static int countprofit(int i , int j , int year, int wines[],int dp[][])
	{
		//year denotes which year it is. 
		//wines stores bottle values. 
		// double dimension array will be used. 
		//Base Case
		// i > j will be our base case it means that no bottle is left
		if(i>j)
		{
			return 0;
		}
		
		
		if(dp[i][j] != 0)
		{
			return dp[i][j];
		}	
		//Recursive Case
		int op1 = wines[i]*year + countprofit(i+1, j , year++, wines,dp);
		int op2 = wines[i]*year + countprofit(i, j-1, year++, wines,dp);
		
		return dp[i][j] = Math.max(op1, op2);
		
	}
	
	public static void main(String args[]) {
		int year = 1;
		int wines[] = {2,3,5,1,4};
		int dp[][] = new int [100][100];
		
		System.out.println("Profit => "+countprofit(0, wines.length-1 , 1, wines,dp));
	}
}
