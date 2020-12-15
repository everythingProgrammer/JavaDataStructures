package linkedList;



public class DoublyLinkedList {
	

	class Node{
		int data; 
		Node next; 
		Node prev;
	}
	public Node head; 
	private Node tail; 
	private int size; 
	
	
	public void addLast(int a) {
		Node temp = head; 
		Node nn = new Node();
		nn.data = a; 
		nn.next = null; 
		nn.prev = null;
		
		//attach
		if(this.size >=1) {
			nn.prev = this.tail;
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
