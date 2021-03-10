package arrays;
import java.util.*;
public class SortByMinSwaps {
	
	static int minSwaps(int arr[]) {
		int n = arr.length;
		int ans = 0 ;
		int temp[] = Arrays.copyOf(arr, n);
		Arrays.sort(temp);
		for(int i = 0 ;i<n; i++) {
			if(arr[i] != temp[i]) {
				ans++;
				swap(arr, i , indexOf(temp[i], arr) );
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
		int arr[] = {4,3,1,2};
		System.out.println(minSwaps(arr));
	}
	
	
}
