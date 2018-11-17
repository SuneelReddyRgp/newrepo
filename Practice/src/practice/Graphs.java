package practice;

import java.util.Iterator;
import java.util.LinkedList;

public class Graphs{
	
	private int V;
	private LinkedList[] adj;
	
	
	
	Graphs(int v){
		V = v;
		
		adj = new LinkedList[v];
		for(int i=0;i<v;i++) {
			adj[i] = new LinkedList<>();
		}
		
	}
	
	
	void addEdge(int v,int w) {
		adj[v].add(w);
	}
	
	
	void BFS(int s) {
		
		
		boolean[] visited = new boolean[V];
		
		visited[s] = true;
		
		LinkedList queue = new LinkedList<>();
		
		queue.push(s);
		
		while(queue.size() != 0) {
			
			s = (int) queue.poll();
			System.out.println(s);
			
			Iterator itr = adj[s].iterator();
			while(itr.hasNext()) {
				int n = (int) itr.next();
				if(!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
			
		}
		
		
		
	}
	
	
	public static void main(String args[]) {
		Graphs g = new Graphs(5);
		
		g.addEdge(0, 1); 
		g.addEdge(0, 2); 
		g.addEdge(1, 2); 
		g.addEdge(2, 0); 
		g.addEdge(2, 3); 
		g.addEdge(3, 2); 

		System.out.println("Following is Breadth First Traversal "+ 
						"(starting from vertex 0)"); 

		g.BFS(0); 
		
	}
	

}
