import java.io.*;

public class Main {  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N=Integer.parseInt(br.readLine());
    long answer=0;

    long [][] dp=new long[N][10];

    for(int i=0;i<10;i++){
      dp[0][i]=1;
    }

    for(int i=1;i<N;i++){
      dp[i][9]=1;
      for(int j=8;j>=0;j--){
        dp[i][j]=(dp[i-1][j]+dp[i][j+1])%10007;
      }
    }

    for(int i=0;i<10;i++){
      answer+=dp[N-1][i];
    }

    bw.write(Long.toString(answer%10007));
    bw.flush();
    br.close();
    bw.close();
  }
}