package genericTree;
import java.util.ArrayList;
import java.util.Scanner;
public class GenericTree {
	
	private class Node{
		int data;
		ArrayList<Node> children; 
		
		Node(int data){
			this.data = data; 
			this.children = new ArrayList<>();
			
		}
	}
	
	private Node root = null; 
	private int size = 0;
	
	/*as soon as object of GenericTree is created it creates whole tree.*/
	GenericTree(){
		Scanner s = new Scanner(System.in); // for taking input
		this.root = takeInput(s, null , 0 );
	}
	
	// to take input of generic tree 
	private Node takeInput(Scanner s , Node parent , int ithchild) {
		if(parent == null) {
			System.out.println("Enter the data for the root node");
		}
		else {
			System.out.println("Enter the data for "+( ithchild + 1)+" child of "+parent.data);
		}
		
		int nodedata = s.nextInt(); 
		Node node = new Node(nodedata);
		this.size++;
		
		System.out.println("Enter Number of Childers for " + node.data);
		int children = s.nextInt();
		
		
		// will be executed according to value of children 
		for(int i = 0 ;  i< children ; i++) {
			Node child = this.takeInput(s, node , i );
			node.children.add(child);
		}
		
		return node; 
	}

	
	public void display(){
		this.display(this.root);
	}
	
	private void display(Node node) {
		String str  = node.data+" =>";
		/*This creates string of current level tree*/
		for(int i = 0 ; i<node.children.size(); i++) {
			str = str+ node.children.get(i).data+", "; 
		}
		
		str = str+" , END";
		
		System.out.println(str);
		/*This will create recursion stack to print the subtree of all child nodes. */
		for(int i = 0 ; i<node.children.size(); i++) {
			this.display(node.children.get(i));
		}
		
		/*_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_*/
		return ; 	
	}
}
