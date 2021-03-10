package arrays;
import java.util.*;
public class SortByMinSwaps {
	/*So the question says arr[1...N] so here I have modified minSwaps accordingly*/
	static int minSwaps(int arr[]) {
		int n = arr.length;
		int ans = 0 ;
//		int temp[] = Arrays.copyOf(arr, n);
//		Arrays.sort(temp);
		for(int i = 1 ;i<=n; i++) {
			if(arr[i-1] != i) {
				ans++;
				swap(arr, i-1 , indexOf(i, arr) );
			}
		}
		return ans;
	}
	static void swap(int arr[] , int i , int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	static int indexOf(int num , int arr[]) {
		for(int i = 0 ; i<arr.length; i++) {
			if(arr[i] == num)
				return i;
		}
		return -1;
	}
	
	public static void main(String args[]) {
		Scanner sr = new Scanner(System.in);
		int n = sr.nextInt();
		int arr[]  = new int[n];
		for(int i = 0; i< n ; i++) {
			arr[i]  = sr.nextInt();
		}
		System.out.println(minSwaps(arr));
	}
	
	
}
