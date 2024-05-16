import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    int N=Integer.parseInt(br.readLine());
    int[] T=new int[N];
    int[] P=new int[N];
    long[] dp=new long[N+1];

    for(int i=0;i<N;i++){
      StringTokenizer st=new StringTokenizer(br.readLine());
      T[i]=Integer.parseInt(st.nextToken());//기간
      P[i]=Integer.parseInt(st.nextToken());//임금
    }
      
    for(int i=N-1;i>=0;i--){
      if(i+T[i]<=N){
        dp[i]=Math.max(dp[i+1],P[i]+dp[T[i]+i]);
      }else{
        dp[i]=dp[i+1];
      }
    }
    
    bw.write(String.valueOf(dp[0]));
    bw.flush();
    bw.close();
    br.close();
  }
}