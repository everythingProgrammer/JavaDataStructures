package linkedListChallenges;


public class kthFromEnd {
	
	class Node{
		int data; 
		Node next; 
	}
	private int size= 0;
	private Node head = null; 
	private Node tail = null;
	
	
	public void addLast(int a) {
		Node nn = new Node();
		nn.data = a; 
		nn.next = null;
		
		if(this.size >= 1) {
			this.tail.next = nn;
		}
		if(this.size == 0) {
			this.head = nn; 
			this.tail = nn; 
			this.size ++;
		}
		else {
			this.tail = nn; 
			this.size++;
		}
	}
	
	public  void display( ) {
		Node temp =  this.head;
		while(temp != null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public void skipN(int num) {
		Node fast = this.head;
		Node slow = this.head;
		
		/*Give head_start to fast*/
		while(num>0) {
			fast = fast.next;
			num--;
		}
		
		/*Now run both lists till fast.next!= null , when this happens slow will be at right place*/
		
		for(; fast.next!= null; ) {
			fast= fast.next; 
			slow= slow.next; 
		}
		
		/*at this point slow is at such a place where we just need to skip the next num so, */
		
		slow.next = slow.next.next; 
		
		//Now we have skipped somethings...
		
	}
	
	public static void main(String args[]) {
		kthFromEnd abc = new kthFromEnd();
		abc.addLast(5);
		abc.addLast(8);
		abc.addLast(18);
		abc.display();
//		abc.skipN(3);
		System.out.println("After skipping");
		abc.display();
	}
}
