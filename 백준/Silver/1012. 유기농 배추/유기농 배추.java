import java.io.*;
import java.util.*;

class Main {
  final static int MAX=50+10;//가로 세로의 최대 길이가 50, 넉넉하게 10칸 여분
  static boolean map[][];//입력받는 칸
  static int T, N, M, K;
  static int dirY[]={-1,1,0,0};
  static int dirX[]={0,0,-1,1};

  static void DFS(int y, int x){
    map[y][x]=false;//방문했다

    for(int i=0;i<4;i++){
      int newY=y+dirY[i];
      int newX=x+dirX[i];
      if(map[newY][newX]){
        DFS(newY,newX);
      }
    }
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 

    T=Integer.parseInt(br.readLine());
    
    while(T-- > 0){
      StringTokenizer st=new StringTokenizer(br.readLine());
  	  M=Integer.parseInt(st.nextToken());
      N=Integer.parseInt(st.nextToken());
      K=Integer.parseInt(st.nextToken());

      map=new boolean[MAX][MAX];

      for(int i=0;i<K;i++){
        st=new StringTokenizer(br.readLine());
        int x=Integer.parseInt(st.nextToken());
        int y=Integer.parseInt(st.nextToken());
        map[y+1][x+1]=true;
      }

      int answer=0;
      for(int i=1;i<=N;i++){
        for(int j=1;j<=M;j++){
          if(map[i][j]){//map[i][j]에 배추가 존재하고, 방문을 하지 않았다면 dfs함수 사용
            answer++;//지렁이 추가
            DFS(i,j);
          }
        }
      }
      bw.write(String.valueOf(answer));
      bw.newLine();
    }
    
    br.close();
    bw.close();
  }
}