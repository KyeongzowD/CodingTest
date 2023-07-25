import java.io.*;
import java.util.*;

class Main {
  static int len=0;
  static LinkedList<Integer> adj[];
  static int[] visited;
  static int N,x,y;

  public static void BFS(){
    LinkedList<Integer> queue = new LinkedList<Integer>();

    visited[x]=2;
    queue.add(x);
    

    while(!queue.isEmpty()){
      x=queue.poll();
      Iterator <Integer> i=adj[x].listIterator();
      while(i.hasNext()){
        int n=i.next();
        if(n==y){len=visited[x]-1;return;}
        if(visited[n]==1){
          visited[n]=visited[x]+1;
          queue.add(n);
        }
      }
    }len=-1;
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    N=Integer.parseInt(br.readLine());
    
    StringTokenizer st=new StringTokenizer(br.readLine());
    x=Integer.parseInt(st.nextToken());
    y=Integer.parseInt(st.nextToken());
    
    int M=Integer.parseInt(br.readLine());
    
    adj = new LinkedList[N+1];
		for (int i = 0; i < N+1; i++) {
			adj[i] = new LinkedList(); 
		}
    visited=new int[N+1];
    
    for(int i=0;i<M;i++){
      st=new StringTokenizer(br.readLine());
      int a=Integer.parseInt(st.nextToken());
      int b=Integer.parseInt(st.nextToken());
      visited[a]=1;
      visited[b]=1;

      adj[a].add(b);
      adj[b].add(a);
    }
    
    BFS(); 
    
    bw.write(String.valueOf(len));
    bw.flush();
    bw.close();
    br.close();
  }
}

