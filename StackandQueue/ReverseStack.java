package StackandQueue;

public class ReverseStack {
	public static void main(String args[])throws Exception {
		Stack s1 = new Stack(5);
		Stack s2 = new Stack(5);
		for(int i = 1 ; i<=5 ; i++) {
			s1.push(i);
		}
		
		reverse(s1, s2);
	}
	
	public static void reverse(Stack s1, Stack s2)throws Exception {
		
		System.out.println("**************");
		s1.display();
		System.out.println();
		System.out.println("**************");
		for(int i = s1.size()-1; i>=0; i--)
		{
			
			int a = s1.pop();
			s2.push(a);
		}
//		s2.push(3);
		s2.display();
		
		
	}
	
}
