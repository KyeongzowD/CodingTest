import java.io.*;
import java.util.*;

class Main {
  static int N,M;
  static int ans;
  static boolean[] visited;
  static boolean[][] graph;

  public static void DFS(int idx){
    visited[idx]=true;
    ans++;

    for (int i = 1; i <=N ; i++) {
      if(visited[i]==false&&graph[idx][i]){
        DFS(i);
      }
    }
    
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
    
    N=Integer.parseInt(br.readLine());
    M=Integer.parseInt(br.readLine());

    graph=new boolean[N+1][N+1];
    visited=new boolean[N+1];

    int x,y;
    for(int i=0;i<M;i++){
      StringTokenizer st=new StringTokenizer(br.readLine());
      x=Integer.parseInt(st.nextToken());
      y=Integer.parseInt(st.nextToken());

      graph[x][y]=true;
      graph[y][x]=true;
    }

    DFS(1);
    
    bw.write(String.valueOf(ans-1));
    bw.flush();
    br.close();
    bw.close();
  }
}