package binaryTree;
import java.util.*;
public class ClientClass {
	public static void main(String args[]) {
		BinaryTree b = new BinaryTree();
		
		b.display();
//		System.out.println(b.height());
//		System.out.println("PreOrder");
		//b.preorder();
//		System.out.println();
//		System.out.println("Post Order");
		//b.postorder();
		
//		System.out.println("\nLevel Order");
		//b.levelorder();
//		System.out.println("BST : "+b.isBST());
//		System.out.println(b.preOrderTraversal());
//		System.out.println(b.postOrderTraversal());
//		System.out.println("Sum of Leaf Nodes "+ b.leafSum());
		System.out.println(b.leftSideView());
	}
}
/*50 true 25 true 38 false false true 48 true 18 false false false true 45 true 85 false false true 60 false false*/
/*50 true 25 false false true 75 false false*/

/*50 true 25 true 38 false false true 48 false false  true 45 false false*/