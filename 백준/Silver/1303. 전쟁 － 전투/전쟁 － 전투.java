import java.util.*;
import java.io.*;

public class Main{
  static int N,M;
  static boolean[][] teamW;
  static boolean[][] teamB;
  static int sumW=0,sumB=0;
  static final int[] dirX={-1,0,0,1};
  static final int[] dirY={0,1,-1,0};
  static int sum=1;
  
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st=new StringTokenizer(br.readLine());
    
    N=Integer.parseInt(st.nextToken());
    M=Integer.parseInt(st.nextToken());

    teamW=new boolean[M][N];
    teamB=new boolean[M][N];

    for(int i=0;i<M;i++){
      String s=br.readLine();
      for(int j=0;j<N;j++){
        if(s.charAt(j)=='W'){
          teamB[i][j]=true;
        }else{
          teamW[i][j]=true;
        }
      }
    }
    
    for(int i=0;i<M;i++){
      for(int j=0;j<N;j++){
        
        if(!teamW[i][j]){
          W_DFS(i,j);
          sumW+=sum*sum;
          sum=1;
        }
        
        if(!teamB[i][j]){
          B_DFS(i,j);
          sumB+=sum*sum;
          sum=1;
        }
      }
    }
    

    bw.write(String.valueOf(sumW)+" "+String.valueOf(sumB));
    bw.flush();
    bw.close();
    br.close();
  }

  static void W_DFS(int i,int j){
    teamW[i][j]=true;
    
    for(int k=0;k<4;k++){
      if(i+dirX[k]>=0&&i+dirX[k]<M&&j+dirY[k]>=0&&j+dirY[k]<N&&!teamW[i+dirX[k]][j+dirY[k]]){
        sum++;
        W_DFS(i+dirX[k],j+dirY[k]);
      }
    }
  }

  static void B_DFS(int i,int j){
    teamB[i][j]=true;
    
    for(int k=0;k<4;k++){
      if(i+dirX[k]>=0&&i+dirX[k]<M&&j+dirY[k]>=0&&j+dirY[k]<N&&!teamB[i+dirX[k]][j+dirY[k]]){
        sum++;
        B_DFS(i+dirX[k],j+dirY[k]);
      }
    }
  }
}