package linkedListChallenges;

public class OddEvenDriver {
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
