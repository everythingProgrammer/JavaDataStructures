package recursion;

public class LastIndex {
	public static int index(int arr[], int si , int data) {
		
		if(si == arr.length) {
			return -1;
		}
		
		int indx = 0; 
		int indx2=-1;
		if(arr[si] == data) {
			indx = si;
		}
		else {
			indx2 = index(arr, si+1, data);
		}
		return Math.max(indx, indx2);
		
	}
	
	
	public static void main(String args[]) {
		int arr[] = {6,8,1,1,8,3,4};
		System.out.println(index(arr, 0 , 1));
	}
}
