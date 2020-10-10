package Graph;
import java.util.*;

public class Graph {
	
	private class Vertex{
		HashMap<String, Integer> nbrs  = new HashMap<>();
	}
	
	HashMap<String , Vertex> vtces ;
	
	Graph(){
		vtces = new HashMap<>();
	}
	
	 
	
	public boolean containsVertex(String vname) {
		boolean flag = false;
		if(this.vtces.containsKey(vname) == true) {
			flag = true;
		}
		return flag;
	}

	public int numVertex() {
		return this.vtces.size();
	}

	public void addVertex(String vname) {
		Vertex vtx = new Vertex(); 	/*an empty neighbor hashmap, since initally it will be a isolated node */
		vtces.put(vname , vtx); 	/*Now add this node to our graph  */
	}
	
	public int numberOfEdges() {
		/*Count all the edges of all the vertexes and lookout for duplicate edges... divide by 2 to eliminate repeating edges. */
		
		int count = 0;	
		Set<String> vtx = vtces.keySet();
		for(String str : vtx) {
			Vertex n = vtces.get(str);
			count+= n.nbrs.size();
		}
		return count/2;
	}
	public boolean containsEdge(String vname1 , String vname2) {
		
		Vertex vt1 = vtces.get(vname1);
		Vertex vt2 = vtces.get(vname2);
		
		/*First check if the two vertex(nodes) even exists or not.
		 * vt1.nbrs.containsKey - returns true or false if vname2 is in nbrs of vname1
		 * if it does then then this expression will return true which is then interverted to false
		 * so that it does not goes into the if . */
		if(vt1 == null || vt2 == null || !vt1.nbrs.containsKey(vname2)  )
			return false;
		return true;
		
	}
	
	
	public void addEdge(String vname1 , String vname2 , int cost) {
		/*to add an edge first check if there are verteces present or not (both)
		 *then check if path edge already exists , if yes then don't do anything*/
		Vertex vt1 = vtces.get(vname1);
		Vertex vt2 = vtces.get(vname2);
		if(vt1 == null || vt2 == null || vt1.nbrs.containsKey(vname2)  )
			return ;
		
		/*If you're here then that means that there is no edge present from before.*/
		
		vt1.nbrs.put(vname2, cost); // add vertex2 to nbrs of vertex1 with cost.
		vt2.nbrs.put(vname1, cost); // add vertex1 to nbrs of vertex2 with cost.
	}
	
	public void removeEdge(String vname1, String vname2) {
		Vertex vt1 = vtces.get(vname1);
		Vertex vt2 = vtces.get(vname2);
		if(vt1 == null || vt2 == null || !vt1.nbrs.containsKey(vname2)  )
			return ;
		
		vt1.nbrs.remove(vname2); // remove vertex2 from nbrs of vertex1
		vt2.nbrs.remove(vname1);
		
	}
	
	public void removeVertex(String vname) {
		/*First visit the vertex (say A) to be deleted
		 *Then go through its('A') neighbor table and visit every neighbor vertex 
		 *and from its nbrs table delete this vertex say A
		 *Then delete A*/
		Vertex toDelete = vtces.get(vname);
		Set<String> neighToVisit = toDelete.nbrs.keySet();
		
//		ArrayList<String> keys = 	new ArrayList<>(toDelete.nbrs.keySet());
		
		for(String key: neighToVisit) {
			Vertex nnode = vtces.get(key);
			nnode.nbrs.remove(vname);
		}
		vtces.remove(vname);
	}
	
	
	public void display() {
		ArrayList<String> vertices = new ArrayList<>( vtces.keySet());
		for( String vertex: vertices) {
			Vertex vtx = vtces.get(vertex);
			System.out.println(vertex +": "+vtx.nbrs);
		}
	}
	
	public boolean hasPath(String vname1 , String vname2, HashMap<String,Boolean> processed, String str) {
		
		processed.put(vname1, true);
		
		// direct edge
		if(containsEdge(vname1, vname2)) {
			System.out.println(str);
			return true;
		}
		
		/*If there is no direct edge form a vertex to another vertex then 
		 * get all the neighbors of current vertex and ask all of them if they have a path .*/
		
		Vertex vtx = vtces.get(vname1);
		ArrayList<String> nbrs = new ArrayList<>( vtx.nbrs.keySet());
		/*take care of hasPath recursive call*/
		for(String nbr : nbrs) {
			if( !processed.containsKey(nbr) && hasPath(nbr, vname2, processed , str+nbr) )
				{
					return true;
				}
		}
		return false;
		
	}
	
	/*For BFS in a graph
	 * BFS gives shortest path
	 * If there are two ways to reach a point in graph then there's a cycle present.*/
	
	private class Pair{
		String vname;
		String psf;
	}
	
	
	/*Searching two nodes using BFS*/
	public boolean bfs(String src , String dst) {
		LinkedList<Pair> queue = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();
		// Create a new Pair
		Pair sp = new Pair();
		sp.vname = src;
		sp.psf = src;
		
		// put the new pair in queue.
		queue.addLast(sp);
		
		// while queue is not empty keep on removing 
		while(!queue.isEmpty()) {
			// remove a pair form your queue.
			Pair rp = queue.removeFirst();
			
			/*the pair that has been extracted must be checked weather it has been extracted for the first time or not
			 * if not then we'll not process it again.*/
			if( processed.containsKey(rp.vname))
				continue;
			
			// add this pair to processed 
			processed.put(rp.vname , true);
			
			if(containsEdge(rp.vname, dst)) {
				System.out.println(rp.psf +dst);
				return true;
			}
			
			Vertex names = vtces.get(rp.vname);
			ArrayList<String> neighbors = new ArrayList<>(names.nbrs.keySet());
			
			for(String neighbor: neighbors) {
				//process only unprocessed neighbors
				if(!processed.containsKey(neighbor)) {
					// make a new pair and insert in queue
					Pair ap = new Pair();
					ap.vname = neighbor;
					ap.psf = rp.psf+neighbor;
					queue.addLast(ap);
				}
			}
					
		}
		return false;	
	}
	
	/*Searching Two nodes using DFS*/
	
	public boolean dfs(String src , String dst) {
		LinkedList<Pair> stack = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();
		// Create a new Pair
		Pair sp = new Pair();
		sp.vname = src;
		sp.psf = src;
		
		// put the new pair in queue.
		stack.addFirst(sp);
		
		// while queue is not empty keep on removing 
		while(!stack.isEmpty()) {
			// remove a pair form your queue.
			Pair rp = stack.removeFirst();
			
			/*the pair that has been extracted must be checked weather it has been extracted for the first time or not
			 * if not then we'll not process it again.*/
			if( processed.containsKey(rp.vname))
				continue;
			
			// add this pair to processed 
			processed.put(rp.vname , true);
			
			if(containsEdge(rp.vname, dst)) {
				System.out.println(rp.psf +dst);
				return true;
			}
			
			Vertex names = vtces.get(rp.vname);
			ArrayList<String> neighbors = new ArrayList<>(names.nbrs.keySet());
			
			for(String neighbor: neighbors) {
				//process only unprocessed neighbors
				if(!processed.containsKey(neighbor)) {
					// make a new pair and insert in queue
					Pair ap = new Pair();
					ap.vname = neighbor;
					ap.psf = rp.psf+neighbor;
					stack.addFirst(ap);
				}
			}
					
		}
		return false;	
	}

	/*Breath First Traversal for all nodes i.e. fixing one node and doing a BFS for it and repeating it for all the nodes.*/
	public void bft() {
		LinkedList<Pair> queue = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		
			for(String key: keys) {
				
				/*This is used if when graph is disconnected ,  if graph is disconnected then the disconnected part won't be
				 * there in processed part.*/
				if(processed.containsKey(key)) {
					continue;
				}
					
				// Create a new Pair
				Pair sp = new Pair();
				sp.vname = key;
				sp.psf = key;
				
				// put the new pair in queue.
				queue.addLast(sp);
				
				// while queue is not empty keep on removing 
				while(!queue.isEmpty()) {
					// remove a pair form your queue.
					Pair rp = queue.removeFirst();
					
					/*the pair that has been extracted must be checked weather it has been extracted for the first time or not
					 * if not then we'll not process it again.*/
					if( processed.containsKey(rp.vname))
						continue;
					
					// add this pair to processed 
					processed.put(rp.vname , true);
					
					Vertex names = vtces.get(rp.vname);
					ArrayList<String> neighbors = new ArrayList<>(names.nbrs.keySet());
					
					for(String neighbor: neighbors) {
						//process only unprocessed neighbors
						if(!processed.containsKey(neighbor)) {
							// make a new pair and insert in queue
							Pair ap = new Pair();
							ap.vname = neighbor;
							ap.psf = rp.psf+neighbor;
							queue.addLast(ap);
						}
					}		
			}
		} 	
	}
	
	
	public void dft() {
		LinkedList<Pair> stack = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		
			for(String key: keys) {
				
				/*This is used if when graph is disconnected ,  if graph is disconnected then the disconnected part won't be
				 * there in processed part.*/
				if(processed.containsKey(key)) {
					continue;
				}
					
				// Create a new Pair
				Pair sp = new Pair();
				sp.vname = key;
				sp.psf = key;
				
				// put the new pair in queue.
				stack.addFirst(sp);
				
				// while queue is not empty keep on removing 
				while(!stack.isEmpty()) {
					// remove a pair form your queue.
					Pair rp = stack.removeFirst();
					
					/*the pair that has been extracted must be checked weather it has been extracted for the first time or not
					 * if not then we'll not process it again.*/
					if( processed.containsKey(rp.vname))
						continue;
					// add this pair to processed 
					processed.put(rp.vname , true);
					System.out.println(rp.vname+" via "+ rp.psf);
					Vertex names = vtces.get(rp.vname);
					ArrayList<String> neighbors = new ArrayList<>(names.nbrs.keySet());
					
					for(String neighbor: neighbors) {
						//process only unprocessed neighbors
						if(!processed.containsKey(neighbor)) {
							// make a new pair and insert in queue
							Pair ap = new Pair();
							ap.vname = neighbor;
							ap.psf = rp.psf+neighbor;
							stack.addFirst(ap);
						}
					}
				}
			}
	}

	
	public boolean cyclic() {
		LinkedList<Pair> queue = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
			for(String key: keys) {
				
				/*This is used if when graph is disconnected ,  if graph is disconnected then the disconnected part won't be
				 * there in processed part.*/
				if(processed.containsKey(key)) {
					return false;
				}
				// Create a new Pair
				Pair sp = new Pair();
				sp.vname = key;
				sp.psf = key;
				// put the new pair in queue.
				queue.addLast(sp);
				// while queue is not empty keep on removing 
				while(!queue.isEmpty()) {
					// remove a pair form your queue.
					Pair rp = queue.removeFirst();
					/*the pair that has been extracted must be checked weather it has been extracted for the first time or not
					 * if not then we'll not process it again.*/
					if( processed.containsKey(rp.vname))
						continue;
					// add this pair to processed 
					processed.put(rp.vname , true);
					System.out.println(rp.vname+" via "+ rp.psf);
					Vertex names = vtces.get(rp.vname);
					ArrayList<String> neighbors = new ArrayList<>(names.nbrs.keySet());
					
					for(String neighbor: neighbors) {
						//process only unprocessed neighbors
						if(!processed.containsKey(neighbor)) {
							// make a new pair and insert in queue
							Pair ap = new Pair();
							ap.vname = neighbor;
							ap.psf = rp.psf+neighbor;
							queue.addLast(ap);
						}
					}		
			}
		} 	
			return true;
	}
	
	
	public boolean isConnected() {
		LinkedList<Pair> queue = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		int flag = 0;
			for(String key: keys) {
				
				/*This is used if when graph is disconnected ,  if graph is disconnected then the disconnected part won't be
				 * there in processed part.*/
				if(processed.containsKey(key)) {
					continue;
				}
				flag++;
				// Create a new Pair
				Pair sp = new Pair();
				sp.vname = key;
				sp.psf = key;
				
				// put the new pair in queue.
				queue.addLast(sp);
				
				// while queue is not empty keep on removing 
				while(!queue.isEmpty()) {
					// remove a pair form your queue.
					Pair rp = queue.removeFirst();
					
					/*the pair that has been extracted must be checked weather it has been extracted for the first time or not
					 * if not then we'll not process it again.*/
					if( processed.containsKey(rp.vname))
						continue;
					
					// add this pair to processed 
					processed.put(rp.vname , true);
					
					Vertex names = vtces.get(rp.vname);
					ArrayList<String> neighbors = new ArrayList<>(names.nbrs.keySet());
					
					for(String neighbor: neighbors) {
						//process only unprocessed neighbors
						if(!processed.containsKey(neighbor)) {
							// make a new pair and insert in queue
							Pair ap = new Pair();
							ap.vname = neighbor;
							ap.psf = rp.psf+neighbor;
							queue.addLast(ap);
						}
					}		
			}
		} 
		return flag>=2 ? false:true;		
	}

	
	public ArrayList<ArrayList<String>> getConnectedComponents() {
		LinkedList<Pair> queue = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		ArrayList<ArrayList<String>> finalans = new ArrayList<>();
			for(String key: keys) {
				
				/*This is used if when graph is disconnected ,  if graph is disconnected then the disconnected part won't be
				 * there in processed part.*/
				if(processed.containsKey(key)) {
					continue;
				}
				// for new components create a new arraylist
				ArrayList<String> subans = new ArrayList<>();
				
				
				// Create a new Pair
				Pair sp = new Pair();
				sp.vname = key;
				sp.psf = key;
				
				// put the new pair in queue.
				queue.addLast(sp);
				
				// while queue is not empty keep on removing 
				while(!queue.isEmpty()) {
					// remove a pair form your queue.
					Pair rp = queue.removeFirst();
					
					/*the pair that has been extracted must be checked weather it has been extracted for the first time or not
					 * if not then we'll not process it again.*/
					if( processed.containsKey(rp.vname))
						continue;
					
					// add this pair to processed 
					processed.put(rp.vname , true);
					
					// put the pair in subans
					subans.add(rp.vname);
					
					Vertex names = vtces.get(rp.vname);
					ArrayList<String> neighbors = new ArrayList<>(names.nbrs.keySet());
					
					for(String neighbor: neighbors) {
						//process only unprocessed neighbors
						if(!processed.containsKey(neighbor)) {
							// make a new pair and insert in queue
							Pair ap = new Pair();
							ap.vname = neighbor;
							ap.psf = rp.psf+neighbor;
							queue.addLast(ap);
						}
					}		
			}
				// put subans arraylist in finalans arraylist
				finalans.add(subans);
		} 	
			return finalans;
	}
}

