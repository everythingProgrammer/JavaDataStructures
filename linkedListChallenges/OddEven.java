/* Odd Number nodes should appear before even number nodes 

 * odd number nodes in terms of index.
 * Solve it in O(n) time complexity.
 * */

/*Fang Question*/
package linkedListChallenges;



public class OddEven {
	
	class ListNode{
		int data;
		ListNode next;
	}
	private int size =0; 
	public ListNode head = null;
	private ListNode tail = null;
	
	
	public ListNode oddEvenList( ListNode head)
	{
		if(head == null) {
			return null;
		}
		ListNode odd_head = null; 
		ListNode odd_tail = null;
		ListNode even_head= null; 
		ListNode even_tail= null;
		boolean is_odd = true; 
		ListNode temp = head; 
		
		while( temp != null ) {
			if(is_odd) {
				
				/*now we know that this is an odd node 
				 * So we proceed to process it 
				 * either there has been no additions till now 
				 * */
				if( odd_head == null) {
					odd_head  = odd_tail =temp;
				}
				else {
					odd_tail.next = temp; 
					odd_tail = temp;	
				}
				odd_tail.next = null;
				temp = temp.next;
			}
			else {
				/*Now for even*/
				
				if( even_head == null) {
					even_head = even_tail = temp;
				}
				else {
					even_tail.next = temp;
					even_tail = temp;
				}
				even_tail.next = null;
				temp = temp.next;
			}
			/*Now do temp = temp.next to move the node forward*/
			is_odd = !is_odd; 
		}
		
		/*Now attach even at the back of odd*/
		odd_tail.next = even_head; 
		odd_tail = even_head;
		return odd_head;
	}
	
	public void addLast(int a) {
		
		ListNode nn = new ListNode();
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
	
	public  void display(ListNode head) {
		ListNode temp = head;
		while(temp != null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	
	
	public static void main(String args[]) {
		OddEven abc = new OddEven(); 
		abc.addLast(10);
		abc.addLast(15);
		abc.addLast(20);
		abc.addLast(25);
		abc.addLast(30);
		abc.display(abc.head);
		abc.display(abc.oddEvenList(abc.head));
	}
}
