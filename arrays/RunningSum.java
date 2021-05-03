package arrays;
import java.util.*;
public class RunningSum {
	public static int[] runningSum(int[] nums) {
        int prevsum = 0;
        for(int i = 0 ; i<nums.length; i++){
            nums[i] = prevsum +nums[i];
            prevsum = nums[i];
        }
        return nums;
    }
	public static void main(String args[]) {
		int arr[] = {3,1,2,10,1};
		for(int a:runningSum(arr)) {
			System.out.print(a+" ");
		}
	}
	
}
