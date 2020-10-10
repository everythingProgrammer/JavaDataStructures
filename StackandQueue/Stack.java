/*
 * last in first out 
 * Stack using int array . 
 * 
 * */

package StackandQueue;
import java.util.*;
public class Stack {
	/*Starting Stack top from -1*/
	
	
	int stack[] ;
	int top = -1;
	public static final int DEFAULT = 100;
	
	
	public Stack(int a){
		stack = new int[a];
	}
	
	
	public Stack() {
		stack = new int[this.DEFAULT];
	}
	
	public int size() {
		return this.top + 1;
	}
	
	
	public boolean isEmpty() {
		if(this.top == -1) {
			return true;
		}
		else 
			return false;
	}
	
	
	public  void push(int i) throws Exception{
		this.top ++;
		if(this.top <  this.stack.length){
			this.stack[top] = i;
		}
		else {
			throw new Exception("stackOverflow");
		}
	}
	
	public int pop() throws Exception {
		if(this.top == -1) {
			throw new Exception("stack underflow"); 
		}
		else{
			int a = this.stack[this.top];
			this.stack[this.top ] = 0;
			this.top --;
			return a;
		}
	}
	
	public void display() {
		for(int i = this.top ; i>= 0 ; i--) {
			System.out.print(this.stack[i]+" ,");
		}
		System.out.println("END");
	}

}
