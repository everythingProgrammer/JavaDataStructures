package binaryTree;
import java.util.*;



public class BinaryTree {
	
	private class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data, Node left , Node right){
			this.data = data; 
			this.left = left;
			this.right = right;
		}
	}
	
	 Node root = null ;
	 int size = 0 ;
	 
	 BinaryTree(){
		 Scanner sr = new Scanner(System.in);
		 this.root = takeInput(sr, null , false);
	 }

	 private Node takeInput(Scanner s, Node parent , boolean isLeft) {
		 if(parent == null) {
			 System.out.println("Enter data for root " );
		 }
		 else {
			 if(isLeft) {
				 System.out.println("Enter data to left of "+parent.data);
			 }
			 else {
				 System.out.println("Enter data to right of "+parent.data);
			 }
		 }
		 
		 int data = s.nextInt();
		 
		 Node node = new Node(data, null , null);
		 this.size++;
		 
		 boolean choice = false; 
		 
		 System.out.println("Left child of "+node.data+" ? tf");
		 choice = s.nextBoolean();
		 
		 if(choice) {
			 node.left = takeInput(s, node, true);
		 }
		 choice = false;
		 System.out.println("Right Child of "+node.data+" ? tf");
		 choice = s.nextBoolean();
		 
		 if(choice) {
			 node.right = takeInput(s, node, false);
		 }
		 return node;
	 }
	 
	 
	 public void display() {
		 this.display(this.root);
	 }
	 
	 private void display(Node node) {
		 String str = "";
		 
		 if(node.left != null) {
			 str = str + node.left.data + "=>";
		 }
		 else {
			 str = str +" END =>";
		 }
		 str = str+ node.data;
		 
		 if(node.right != null) {
			 str = str+" <= "+ node.right.data;		 
		 }
		 else {
			 str = str + " <=END ";
		 }
		 System.out.println(str);
		 
		 if(node.left != null) {
			 this.display(node.left); 
		 }
		 if(node.right != null) {
			 this.display(node.right);
		 }
		 
	 }

	 
	 public int height() {
		 return this.height(this.root);
	 }
	 private int height(Node root) {
		 if( root == null) {
			 return -1;
		 }
		 
		 int rh = height(root.left);
		 int lh = height(root.right);
		 
		 return Math.max(rh, lh)+1;
		 
	 }
	 
	 
	 
	 
	 public void preorder() {
		 this.preorder(this.root);
	 }
	 
	 private void preorder(Node root) {
		 if(root == null) {
			 return;
		 }
		 System.out.print(" "+root.data);
		 this.preorder(root.left);
		 this.preorder(root.right);
	
		 return ;
	 }
	 
	 
	 public void postorder() {
		 this.postorder(this.root);
	 }
	 
	 private void postorder(Node root) {
		 
		 if(root == null) {
			 return ;
		 }
		 
		 postorder(root.left);
		 postorder(root.right);
		 System.out.print(root.data+", ");
		 return;
	 }

	 public void levelorder() {
		 LinkedList<Node> queue = new LinkedList<>(); /*use it as a queue*/
		 queue.add(this.root);
		 while(!queue.isEmpty()) {
			 
			 Node rv = queue.removeFirst();
			 System.out.print(rv.data +" ,");
			 if(rv.left!= null) {
				 queue.add(rv.left);
			 }
			 if(rv.right!= null) {
				 queue.add(rv.right);
			 }
		 }
		 System.out.println("END");
		 
	 }

	 public boolean isBST() {
		 return this.isBST(this.root , Integer.MAX_VALUE , Integer.MIN_VALUE);
	 }
	 
	 private boolean isBST(Node node , int max , int min) {
		 
		 if(node == null) {
			 return true;
		 }
		 
		 if( node.data> max || node.data < min) {
			 return false;
		 }
		 else if( !this.isBST(node.left , node.data, min)) {
			 return false;
		 }
		 else if( !this.isBST(node.right, max, node.data)) {
			 return false;
		 }
		
		 return true;
	 }
	 
	 
	 
	 public List<Integer> inorderTraversal(){
		 
		 return  this.inorderTraversal(this.root);
		 
		  
	 }
	 private List<Integer> inorderTraversal(Node node){
		 if(node == null) {
			 return new ArrayList<>();
		 }
		 Stack<Node>  stack = new Stack<>();
		 ArrayList<Integer> list = new ArrayList<>();
		 
		 while(true) {
			 if(node!= null) {
				 stack.push(node);
				 node = node.left;
			 }
			 else {
				 if(stack.isEmpty()) {
					 break;
				 }
				 node = stack.pop();
				 list.add(node.data);
				 node= node.right; 
			 } 
		 }
		 return list;
	 }
	 
	 /*preorder traversal using stack (iteratively).*/
	 
	 public ArrayList<Integer> preOrderTraversal(){
		 return preOrderTraversal(this.root);
	 }
	 
	 private ArrayList<Integer> preOrderTraversal(Node node){
		 if(node == null) {
			 return new ArrayList<>();
		 }
		 Stack<Node> stack = new Stack<>();
		 ArrayList<Integer> list = new ArrayList<>();
		 stack.push(node);
		 while(stack.empty() == false) {
			 Node n = stack.pop();
			 list.add(n.data);
			 if ( n.right != null) { 
	                stack.push( n.right); 
	            } 
	            if ( n.left != null) { 
	                stack.push( n.left); 
	            } 
		 }
		 return list;
	 }
	 
	 /*Iterative Post Order traversal using two stacks*/
	 public ArrayList<Integer> postOrderTraversal(){
		 return postOrderTraversal(this.root);
	 }
	 
	 private ArrayList<Integer> postOrderTraversal(Node node){
		 if(node == null)
			 return new ArrayList<>();
		 Stack<Node> stack = new Stack<>();
		 Stack<Integer> stack2 = new Stack<>();
		 ArrayList<Integer> list = new ArrayList<>();
		 stack.push(node);
		 while(!stack.isEmpty()) {
			 Node n = stack.pop();
			 stack2.add(n.data);
			 if(n.left != null)
				 stack.push(n.left);
			 if(n.right != null)
				 stack.push(n.right);
		 }
		 
		 while(!stack2.isEmpty()) {
			 list.add(stack2.pop());
		 }
		 
		 return list;
	 }
	 
	 
	 public int leafSum() {
		 return this.leafSum(this.root);
	 }
	 
	 private int leafSum(Node node) {
		 
		 /*If node = leaf node then return data*/
		 if(node.left == null && node.right == null) {
			 return node.data;
		 }
		 int sum = 0; 
		 
		 if(node.left != null)
			 sum+= this.leafSum(node.left);
		 if(node.right != null)
			 sum+= this.leafSum( node.right);
		 return sum;
	 }
	 
	 
	 /*left side view of tree (form doc) .*/
	 /*Left side view of tree.*/
	 public ArrayList<Integer> leftSideView(){
		 return leftSideView(this.root);
	 }
	 private ArrayList<Integer> leftSideView(Node root){
			ArrayList<Integer> ans = new ArrayList<>();

			if(root == null){
				return ans;
			}
			Queue<Node> q = new LinkedList<>();
			q.add(root);
			q.add(null);
			ans.add(root.data);

		while(!q.isEmpty()){
				Node n= q.poll();
				if(n == null){
					if(!q.isEmpty()){
						q.add(null);
						Node ne = q.peek();
						if(ne!=null)
							ans.add(ne.data);
					}
				}
				else{
					if(n.left != null){
						q.add(n.left);
					}
					if(n.right != null){
						q.add(n.right);
					}
					
				}
			}
		return ans;
		}
	 
}
