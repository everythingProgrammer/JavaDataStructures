package recursion;

public class sortedArray {
	
	public static boolean isSorted(int arr[], int si) {
		
		if(si == 1) {
			if(arr[si] > arr[si-1]) {
				return true;
			}
			else return false;
		}
		
		
		
		if(isSorted(arr, si-1)) {
			if(arr[si] > arr[si-1]) {
				return true;
			}
			else 
				return false;
		}
		else 
			return false;
		
	}
	
	public static void main(String args[]) {
//		int arr[] = {3,8,6,1,9,7};
		int arr[] = {1,2,3,4,5};
		System.out.println(isSorted(arr,arr.length-1));
	}
	
}
