package recursion;

public class firstIndex {
	
	public static int index(int arr[] , int si , int data) {
		
		if(si >=arr.length) {
			return -1;
		}
		
		int indexa;
		if(arr[si] == data)
			indexa =  si;
		else 
			indexa = index(arr, si+1 , data);
		return indexa;
	}
	public static void main(String args[]) {
		int arr[] = {6,8,1,1,8,3,4};
		
		System.out.println(index(arr, 0, 4));
		
	}
	
}
