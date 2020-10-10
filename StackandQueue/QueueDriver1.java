package StackandQueue;

public class QueueDriver1 {
	public static void main(String args[]) {
		Queue q1 = new Queue();
		q1.enqueue(15);
		q1.enqueue(34);
		q1.display();
		q1.dequeue();
		q1.dequeue();
	}
}
