import java.util.*;
import java.io.*;

public class Main {
  static int N,M;
  static boolean[][] arr;
  static int[] dirX={0,0,1,-1};
  static int[] dirY={1,-1,0,0};
  
  public static void main(String[] args)throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st=new StringTokenizer(br.readLine());
    M=Integer.parseInt(st.nextToken());
    N=Integer.parseInt(st.nextToken());

    arr=new boolean[M][N];

    String s=new String();

    for(int i=0;i<M;i++){
      s=br.readLine();

      for(int j=0;j<N;j++){
        if(s.charAt(j)=='1') //1은 검정색으로 전류가 통하지 않는다
          arr[i][j]=true;
      }
    }

    for(int i=0;i<N;i++){
      if(!arr[0][i])
        dfs(0,i);
    }

    String ans="NO";

    for(int i=0;i<N;i++){
      if(s.charAt(i)=='0'&&arr[M-1][i]){
        ans="YES";
        break;
      }
    }

    bw.write(ans);
    bw.flush();
    bw.close();
    br.close();
  }

  static void dfs(int i,int j){
    arr[i][j]=true;
    for(int k=0;k<4;k++){
      if(i+dirX[k]>=0&&i+dirX[k]<M&&j+dirY[k]>=0&&j+dirY[k]<N&&!arr[i+dirX[k]][j+dirY[k]])
        dfs(i+dirX[k],j+dirY[k]);
    }
  }
  
}