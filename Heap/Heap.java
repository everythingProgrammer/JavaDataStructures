package Heap;
import java.util.*;

/*This is zero based indexing */

public class Heap {
	
	
	ArrayList<Integer> data = new ArrayList<>();
	int size;
	public int top() {
		if(empty()) {
			return -1;
		}
		return data.get(0);
	}
	public int pop() {
		if (this.empty()) {
			return -1;
		}
		int element = this.top();
		swap(0,data.size() -1);
		int root = 0 ;
		while(true) {
			if( (root *2) +1 > data.size() )
				break;
			int l =Integer.MIN_VALUE , r =Integer.MIN_VALUE;
			if( (root*2) + 1 <= data.size()) {
				r = data.get(root*2 +2);
			}
			l = data.get(root*2 +1);
			int gr = l>r?root*2+1 : root*2+2;
			swap(root, gr);
			root = gr;
		}
		
		
		return element;
	}
	public boolean empty() {
		
		if(data.size() == 0) {
			return true;
		}
		
		return false;
	}
	
	private void swap(int i , int j ) {
		int ith = data.get(i);
		int jth = data.get(j);
		data.set(i, jth);
		data.set(j, ith);
		
	}
	
	private void upheapify(int ci) {
		
		int pi = (ci-1)/2; 
		
		if(data.get(ci) < data.get(pi)){
			 swap(pi, ci);
			 upheapify(pi);
		}

	}
	
	public void add(int item) {
		
		data.add(item);
		
		this.upheapify(data.size() -1);
	}
	
	public void display() {
		System.out.println(this.data);
	}
	public int size() {
		return  this.data.size();
	}
	
	public boolean isEmpty() {
		return this.size() == 0;
	}
	
	

}
