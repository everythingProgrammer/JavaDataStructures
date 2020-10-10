package StackandQueue;

public class CircularQueueDriver {
	public static void main(String args[]) {
		CircularQueue q1 = new CircularQueue();
		q1.dequeue();
		q1.enqueue(15);
		q1.enqueue(5);
		q1.enqueue(2);
		q1.enqueue(3);
		q1.enqueue(6);
		q1.dequeue();
		q1.enqueue(45);
		q1.display();
		q1.dequeue();
		q1.dequeue();
		q1.dequeue();
		q1.display();
	}

}
