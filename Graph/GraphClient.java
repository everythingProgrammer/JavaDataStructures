package Graph;
import java.util.*;
public class GraphClient {
	
	public static void main(String args[]) {
		Graph graph = new Graph();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");
//		graph.addVertex("X");
		graph.addEdge("A", "B", 2);
		graph.addEdge("A", "D", 2);
		graph.addEdge("B", "C", 2);
		graph.addEdge("C", "D", 2);
		graph.addEdge("D", "E", 2);
		graph.addEdge("E", "F", 2);
		graph.addEdge("E", "G", 2);
		graph.addEdge("F", "G", 2);
//		graph.addEdge("A", "X",2);
		
		graph.display();
		//		System.out.println("Number of Vertices "+graph.numVertex());
		//		System.out.println("Number of Edges " +graph.numberOfEdges());
		//		
		//		
		//		graph.removeEdge("A", "B");
		//		graph.display();
		//		System.out.println();
		//		graph.removeVertex("E");
		//		graph.display();
		
//		HashMap<String, Boolean> str = new HashMap<>();
//		graph.removeEdge("D","E");
		
//		System.out.println(graph.hasPath("A", "F", new HashMap<String, Boolean>() , ""));
//		graph.bfs("A","G");
//		graph.dfs("A", "G");
//		graph.bft();
		graph.dft();
	}
}
