import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s=br.readLine();
    String[] arr=s.split(" ");
    int N=Integer.parseInt(arr[0]);
    int M=Integer.parseInt(arr[1]);

    int ans=0;
    
    LinkedList<Integer> adj[]=new LinkedList[N+1];
    boolean[] visited=new boolean[N+1];
    LinkedList<Integer> queue=new LinkedList<>();
    for(int i=0;i<N+1;i++){
      adj[i]=new LinkedList();
    }

    for(int i=0;i<M;i++){
      s=br.readLine();
      arr=s.split(" ");
      adj[Integer.parseInt(arr[0])].add(Integer.parseInt(arr[1]));
      adj[Integer.parseInt(arr[1])].add(Integer.parseInt(arr[0]));
    }

    for(int i=1;i<N+1;i++){
      int n=i;
      if(visited[n]==true){
        continue;
      }
      ans++;
      visited[n]=true;
      queue.add(n);
  
      while(queue.size()!=0){
        n=queue.poll();

        Iterator <Integer> it = adj[n].listIterator();
  			while (it.hasNext()) {
  				int k = it.next();
  				if (!visited[k]) {
  					visited[k] = true;
  					queue.add(k);
  				}
  			}
      }
    }
    System.out.print(ans);
  }  
}