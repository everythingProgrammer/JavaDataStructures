package randomCodes;

public class HarryPotter {
	public static int countcuts(String input1,  int input2 , int input3) {
		
		if(input2 > input1.length() || input3>input1.length()) {
			return 0;
		}
		String newstr = input1;
		int count = 1;
		int m = input2;
		int n = input3;
		int len = newstr.length();
		boolean flag = false;
		
		newstr = newstr.substring(len-m )+ newstr.substring(0, len-m);
		
		
		while(!newstr.equalsIgnoreCase(input1)) {
			System.out.println(newstr);
			if(flag) {
				newstr = newstr.substring(len - m)+ newstr.substring(0, len -m);
				flag = !flag;
			}
			else {
				newstr = newstr.substring(len-n) + newstr.substring(0,len -n);
				flag = !flag;
			}
			count++;
		}
		return count;
	}
	
	public static void main(String args[]) {
		System.out.println(countcuts("Ankur", 2, 1));
		}
	
}
