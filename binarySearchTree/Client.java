package binarySearchTree;

public class Client {
	public static void main(String args[]) {
		int in[] = {10, 20, 30, 40 , 50,60,70};   /*Constructing Tree using InOrder Traversal. */
		BST t1 = new BST(in);
		t1.display();
		t1.search(36);
		t1.findmax();
		t1.add(100);
		t1.add(65);
		t1.display();
	}

}
