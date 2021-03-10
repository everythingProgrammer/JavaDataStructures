package arrays;
import java.util.*;

/*in previous programs since we had to find current index of correct element
 * everytime we found a wrong element we we're having a time complexity of O(n^2)
 * so instead use a hashmap to store and retrieve indexes*/
public class SortByMinSwaps2 {
	
	static int minSwaps(int arr[]) {
		int n = arr.length;
		int ans = 0 ;
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0 ; i< arr.length ; i++) {
			map.put(arr[i] , i);
		}

		for(int i = 1 ;i<=n; i++) {
			if(arr[i-1] != i) {
				ans++;
				int temp = arr[i-1];
				swap(arr, i-1 , map.get(i) );
				/*i is correct number*/
				/*map.get(i) gives us its index
				 *arr[i-1] was our wrong index
				 *  */
				int tv = map.get(temp);
				map.put(temp, map.get(i));
				map.put(i, tv);
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
