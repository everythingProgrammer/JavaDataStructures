package GridDP;
import java.util.*;
public class GoldGrid {
	
	/*Task is to divide the grid into 4 parts by making two lines ... 
	 * every partition will have some numbers of gold coins ...
	 * sayam will get to pick last (the partition containing minimum number of coins) 
	 * sayam wants to make maximum number of coins ....*/
	
	/*6 13 - 6*6 matrix having 13 gold coins 
	 * next 13 lines are coordinates of those points
	 * using this construct 2D matrix*/
	
	public static int BruteForce(int arr[]) {
		/*Try all possible cuts at each (x, y)*/
		/*
		 * N^2 Cuts and N^2 Sum so O(N^4)
		 * 
		 * while doing this Max( min(1,2,3,4))
		 * 
		 * */
		
		
		/*Optimizations can be made where we are calculating sum. 
		 * prefix sum dp in 2D 
		 *
		 **/
	}
	
	
	public static void main(String args[]) {
		
	}
}
