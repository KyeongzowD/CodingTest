import java.util.*;
import java.io.*;

public class Main{
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    long ans=0;

    StringTokenizer st=new StringTokenizer(br.readLine());
    int N=Integer.parseInt(st.nextToken());
    int K=Integer.parseInt(st.nextToken());
    
    long[][] arr=new long[N+1][K];

    for(int i=1;i<N+1;i++){
      arr[i][0]=1;
    }

    for(int j=0;j<K;j++){
      arr[0][j]=1; 
    }

    for(int i=1;i<N+1;i++) {
      for(int j=1;j<K;j++){
        arr[i][j]=(arr[i-1][j]+arr[i][j-1])%1000000000;
      }
    }

    ans=arr[N][K-1];

    bw.write(String.valueOf(ans%1000000000));
    bw.flush();
    bw.close();
    br.close();
  }
}