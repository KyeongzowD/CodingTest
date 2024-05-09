import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st=new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    int N=Integer.parseInt(st.nextToken());
    int M=Integer.parseInt(st.nextToken());

    int[][] arr=new int[N+1][N+1];
    
    for(int i=1;i<N+1;i++){//누적합으로 입력
      st=new StringTokenizer(br.readLine());
      for(int j=1;j<N+1;j++){
        arr[i][j]=Integer.parseInt(st.nextToken());
        arr[i][j]+=arr[i-1][j]+arr[i][j-1]-arr[i-1][j-1];
      }
    }    

    for(int k=0;k<M;k++){//누적합 계산하기
      st=new StringTokenizer(br.readLine());
      int x1=Integer.parseInt(st.nextToken());
      int y1=Integer.parseInt(st.nextToken());
      int x2=Integer.parseInt(st.nextToken());
      int y2=Integer.parseInt(st.nextToken());

      sb.append(arr[x2][y2]-arr[x2][y1-1]-arr[x1-1][y2]+arr[x1-1][y1-1]).append('\n');
    }

    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
}