
package binarySearchTree;

public class BST {
	
	class Node{
		int data;
		Node left; 
		Node right; 
		
	}
	
	private Node root; 
	
	
	public BST( int arr[]) {
		
		this.root = construct(arr, 0 , arr.length -1 );
	}
	
	private Node construct( int arr[] , int lo , int hi) {
		
		if(lo > hi) {
			return null;
		}
		
		
		
		int mid = (lo+ hi)/2;
		
		// create node
		Node nn = new Node();
		nn.data = arr[mid];
		nn.left = construct(arr, lo, mid-1);
		nn.right = construct(arr, mid+1 ,hi);
		
		
		
		return nn; 
		
		
	}

	public void display() {
		this.display(this.root);
	}
	
	private void display(Node node) {
		
		if(node == null) {
			return ;
		}
		
		String str = "";
		if(node.left == null) {
			str= "."+str;	
		}
		else {
			str = node.left.data +str;
		}
		
		str = str +" => "+ node.data+" <= " ;
		
		if(node.right == null) {
			str = str+ ".";
		}
		else {
			str= str + node.right.data;
		}
		
		System.out.println(str);
		display(node.left);
		display(node.right);
	}

	public void search(int data) {
		this.search(this.root, data);
	}

	private void search(Node node, int data) {
		if(node == null) {
			System.out.println("data doesn't exist");
			return;
		}
		if( node.data == data) {
			System.out.println("Data Found");
			return ;
		}
		
		if( node.data > data) {
			search(node.left ,  data);
		}
		if(node.data < data) {
			search(node.right , data);
		}
	}



	public void findmax() {
		System.out.println(this.findmax(this.root));
	}
	private int findmax(Node node) {
		
		
		if(node.right == null ) {
			return node.data;
		}
		
		return findmax(node.right);
		
	}



	/*Adding a node in BST */
	
	public void add( int data) {
		this.add( this.root , data);
	}
	
	private void add( Node node , int item) {
		
		if( item > node.data) {
			if(node.right == null) {
				Node nn = new Node(); 
				nn.data = item; 
				node.right = nn; 
			}
			else {
				add(node.right, item);
			}
		}else {
			if(node.left == null) {
				Node nn = new Node();
				nn.data = item; 
				node.left = nn; 
			}else {
				add(node.left , item);
			}
		}
	}
	
	
	


}
