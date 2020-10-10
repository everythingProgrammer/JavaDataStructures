package Heap;
import java.util.*;
public class Heap {
	ArrayList<Integer> data = new ArrayList<>();
	
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
