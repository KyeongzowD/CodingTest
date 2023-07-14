import java.io.*;
import java.util.*;

class Main {
  static int N,M;
  static int[][] graph;
  static boolean[][] visited;
  static int dirY[]={-1,1,0,0};
  static int dirX[]={0,0,-1,1};
  static Queue<Spot> queue=new LinkedList<>();
  static int len;

  public static class Spot{//큐에 들어가는 값을 객체로 만들어서 판별
    int x,y;
    Spot(int x,int y){
      this.x=x;
      this.y=y;
    }
  } 
   
  
  public static void BFS(int x,int y) {
    queue.add(new Spot(x,y));

    while(!queue.isEmpty()){
      Spot s=queue.poll();

      for(int i=0;i<4;i++){
        int X=s.x+dirX[i];
        int Y=s.y+dirY[i];
        
        if(graph[X][Y]!=0&&visited[X][Y]){
          queue.add(new Spot(X,Y));
          graph[X][Y]=graph[s.x][s.y]+1;
          visited[X][Y]=false;
        }
        
        if(X==N-1&&Y==M-1){
          len=graph[N-1][M-1];
          return;
        }
      }
    }
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    StringTokenizer st=new StringTokenizer(br.readLine());
    N=Integer.parseInt(st.nextToken())+1;
    M=Integer.parseInt(st.nextToken())+1;

    graph=new int[N+1][M+1];
    visited=new boolean[N+1][M+1];
    
    for(int i=1;i<N;i++){//1이 있는 곳을 true로 채우기//좌우상하로 이동하기 위해 인덱스 0 이동
      String s=br.readLine(); 
      for(int j=0;j<M-1;j++){//1부터 시작
        if(s.charAt(j)=='1'){
          graph[i][j+1]=1;
          visited[i][j+1]=true;
        }
      }
    }
    
    BFS(1,1);
    
    bw.write(String.valueOf(len));
    
    br.close();
    bw.close();
  }
}