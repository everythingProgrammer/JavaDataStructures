package StackandQueue;

public class CircularQueue {
	private int front = 0;
	private int size = 0; 
	private int data = 0; 
	private int queue[]; 
	
	public CircularQueue(int size) {
		queue = new int [size];
	}
	public CircularQueue() {
		queue = new int [5];
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		if(this.size() == 0) {
			return true;
		}
		else 
			return false;	
	}
	
	
	
	public void enqueue(int value) {
		
		if(this.size == this.queue.length) {
			System.out.println("Queue Overflow");
			return ;
		}
		
		int indx = (this.front+this.size)%this.queue.length;
		this.size++; 
		this.queue[indx] = value;
		
	}
	
	public void dequeue() {
		
		if(this.size == 0) {
			System.out.println("Queue Underflow");
			return ;
		}
		
		System.out.println("Dequeue "+this.queue[this.front]);
		this.front = (this.front+1)%this.queue.length ; 
		this.size--;
		
	}
	
	public void display() {
		for(int i =0 ; i< this.size ; i++) {
			System.out.print(" "+this.queue[(this.front+i)%this.queue.length]+",");
		}
		System.out.println();
	}
	
	
}
