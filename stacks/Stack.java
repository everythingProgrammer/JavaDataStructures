package stacks;
import java.util.*;


/*This is a DLL implementation of Stack */

public class Stack {
	
	class DLLNode{
		DLLNode prev;
		int data ; 
		DLLNode next;
		DLLNode(int d){
			data = d;
		}
	}
	class myStack{
		DLLNode head;
		DLLNode mid;
		int count;
	}
	/*Function to create myStack datastructure*/
	myStack createMyStack(){
		myStack ms = new myStack();
		ms.count = 0;
		return ms;
	}
	
	void push(myStack ms , int new_data) {
		/*allocate DLLNode and put in data*/
		DLLNode new_DLLNode = new DLLNode(new_data);
		/*Since we are adding at the beginning, prev is always null*/
		new_DLLNode.prev = null;
		
		/*link the old list off the new DLLNode */
		new_DLLNode.next = ms.head;
		
		ms.count+=1;
		/*Change mid pointer in two cases
		 * Linked List is empty 
		 * Number of nodes in linkedlist is odd*/
		if(ms.count == 1) {
			ms.mid = new_DLLNode;
		}
		else {
			ms.head.prev = new_DLLNode;
			if((ms.count%2) != 0)
				ms.mid= ms.mid.prev;
		}
		ms.head = new_DLLNode;
	}
	
	

	/*Find Middle and Delete Middle in O(1)*/
	public void findMiddle() {
		
	}
}
