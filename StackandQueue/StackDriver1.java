package StackandQueue;

public class StackDriver1 {
	public static void main(String args[]) throws Exception{
		Stack s1 = new Stack();
		s1.push(4);
		System.out.println(s1.pop());
		s1.push(3);
		s1.push(4);
		s1.push(5);
		System.out.println(s1.pop());
		System.out.println(s1.pop());
		System.out.println(s1.pop());
		
		
//		s1.display();
//		System.out.println(s1.size());
//		s1.pop();
//		System.out.println(s1.size());
	}
}
