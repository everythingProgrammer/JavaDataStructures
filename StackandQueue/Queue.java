/*This queue is not very good queue.*/

package StackandQueue;

public class Queue {
	
	private int front=-1;
	private int rear = 0;
	private int queue[] ;
	private int size = 0; 	// size = front - rear (if size 0 then there is 1 element).
	private int maxsize= 0;
	Queue(int size){
		queue= new int[size];
		this.maxsize = size;
	}
	Queue() {
		queue = new int[100];
	}
	public void size() {
		System.out.println("size"+this.size);
	}
	
	public boolean isEmpty() {
		if(size < 0) {
			return true;
		}
		else 
			return false;
	}
	
	public void display() {
		for(int i = rear ; i<= front  ; i++) {
			System.out.print(" -"+this.queue[i]);			
		}
		System.out.println();	
	}
	
	public void enqueue(int a) {
		this.front++;
		if(this.front < this.queue.length)
		{	
			this.queue[this.front]= a;
			this.size = this.front - this.rear;
		}
		else 
		{
			System.out.println("Queue Overflow");
			this.front--;
		}
	}
	
	public void dequeue() {
		if( rear <= front) {
			System.out.println("Dequeue ->" + this.queue[rear]);
			this.rear++; 
		}
		else {
			System.out.println("Queue Underflow");
		}
		
	}
	
	
	
	
	
	
}
