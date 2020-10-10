package linkedListChallenges;

public class SwapPairs {
	
	
	class Node{
		int data; 
		Node next; 
	}
	public Node head = null; 
	private Node tail = null;
	private int size ;
	
	
	public void addLast(int a) {
		Node nn = new Node();
		nn.data = a; 
		nn.next = null;
		if(this.size >=1 ) {
			tail.next = nn;
		}
		
		if(this.size == 0 ) {
			this.head = nn; 
			this.tail = nn;
			this.size++; 
		}
		else {
			this.tail = nn; 
			this.size++;
		}
	}


	public void display(Node nhead) {
		Node temp = nhead; 
		while(temp!= null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}


	public Node swapPairs(Node head) {
		
		/*Base case : If there is only 1 node or there is 0 Nodes then return head*/
		
		if(head== null || head.next == null) {
			return head;
		}
		
		Node newHead = swapPairs(head.next.next);
		
		Node temp = head.next; 
		temp.next = head; 
		head.next = newHead; 
		
		return temp;
	}
	
	public static void main(String args[]) {
		SwapPairs ll = new SwapPairs();
		ll.addLast(2);
		ll.addLast(1);
		ll.addLast(4);
		ll.addLast(3);
		ll.addLast(5);
//		ll.display(ll.head);
		ll.display(ll.swapPairs(ll.head));
	}
	
}
