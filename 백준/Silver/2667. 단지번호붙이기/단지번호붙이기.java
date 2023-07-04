import java.io.*;
import java.util.*;

class Main {
  static int N;
  static int ans;
  static boolean[][] graph;
  static int dirY[]={-1,1,0,0};
  static int dirX[]={0,0,-1,1};
  static ArrayList<Integer> arr =new ArrayList<>();

  public static void DFS(int x,int y,int t){
    graph[x][y]=false;
    arr.set(t,arr.get(t)+1);
    
    for(int i=0;i<4;i++){
      int newX=x+dirX[i];
      int newY=y+dirY[i];
      if(graph[newX][newY]){
        DFS(newX,newY,t);
      }
    }
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    boolean visit=false;
    int total=0;
    
    N=Integer.parseInt(br.readLine())+1;

    graph=new boolean[N+1][N+1];
    
    for(int i=0;i<N-1;i++){//집이 있는 곳을 true로 채우기
      String s=br.readLine(); 
      for(int j=0;j<N-1;j++){
        if(s.charAt(j)=='1')
          graph[i+1][j+1]=true;
      }
    }
    
    int i,j;
    int newN=N*N;
    while(newN-->0){
      visit=false;
      
      i=0;j=0;
      for(i=0;i<N;i++){
        for(j=0;j<N;j++){
          if(graph[i][j]){//방문하지 않았는데 집이 있는 위치
            arr.add(0);
            DFS(i,j,total);
            total++;
            visit=true;
            break;
          }
        }
        if(visit==true)
          break;
      }
    }
    
    bw.write(String.valueOf(total));
    
    bw.newLine();

    Collections.sort(arr);
      
    for(i=0;i<arr.size();i++){
      bw.write(String.valueOf(arr.get(i)));
      bw.newLine();
    }
    
    br.close();
    bw.close();
  }
}