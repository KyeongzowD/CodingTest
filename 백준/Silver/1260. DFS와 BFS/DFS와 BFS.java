import java.util.*;
import java.lang.*;
import java.io.*;

public class Main{
	public static void main(String[] args)  throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s=br.readLine();
    String[] arr=s.split(" ");
    int N=Integer.parseInt(arr[0]);
    int M=Integer.parseInt(arr[1]);
    int V=Integer.parseInt(arr[2]);
    
    Graph d = new Graph(N+1);
    Graph b = new Graph(N+1);
    
    for(int i=0;i<M;i++){
      s=br.readLine();
      arr=s.split(" ");
      d.addEdge(Integer.parseInt(arr[0]),Integer.parseInt(arr[1]));
      b.addEdge(Integer.parseInt(arr[0]),Integer.parseInt(arr[1]));
    }

    d.forSort();  b.forSort();
    d.DFS(V);  b.BFS(V);
    d.returnDBfs();  b.returnDBfs();
	}
}

class Graph {
	private int V;
	private LinkedList<Integer> adj[]; 
	StringBuffer dbfs=new StringBuffer("");

  void forSort(){
    for(int i=0;i<adj.length;i++){
      Collections.sort(adj[i]);
    }
  }

  void returnDBfs(){
    System.out.println(dbfs);
  }
  
	Graph (int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList(); 
		}
	}
  
	void addEdge (int v, int w) {
		adj[v].add(w);
    adj[w].add(v);
	}
  
	void DFS(int v) {
		boolean visited[] = new boolean[V]; 
		DFSUtil(v, visited);
	}
  
	void DFSUtil(int v, boolean visited[])  {
		visited[v] = true;
		dbfs.append(v+" ");
		
		Iterator <Integer> it = adj[v].listIterator();
		while (it.hasNext()) {
			int n = it.next();
			if (!visited[n])
				DFSUtil(n, visited); 
		}
	}
  
	void BFS(int s) {
		boolean visited[] = new boolean[V]; 
		LinkedList<Integer> queue = new LinkedList<Integer>();
		visited[s] = true;
		queue.add(s);
		
		while (queue.size() != 0) {
			s = queue.poll();
			dbfs.append(s+" ");
      
			Iterator <Integer> i = adj[s].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}
}