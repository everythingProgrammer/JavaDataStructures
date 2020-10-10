package linkedList;

public class LinkedList {
	
	
	class Node{
		int data; 
		Node next; 
		
	}
	
	public Node head; 
	private Node tail; 
	private int size; 
	
	/*Traversing LinkedList */
	
	public void display() {
		Node temp = this.head;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
		System.out.println("Size of LinkedList = "+ this.size);
	}
	
	
	public void addLast(int a) {
		Node temp = head; 
		Node nn = new Node();
		nn.data = a; 
		nn.next = null; 
		
		
		//attach
		if(this.size >=1) {
			this.tail.next = nn	;
		}
		
		//Summary Object update 
		
		if(this.size == 0) {
			this.head = nn; 
			this.tail = nn; 
			this.size++;
		}
		else {
			this.tail = nn ; 
			this.size ++;
		}
		
		
	}
	
	
}
