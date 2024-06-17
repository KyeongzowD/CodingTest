import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st=new StringTokenizer(br.readLine());

    int ans=0; 
    int A=Integer.parseInt(st.nextToken());
    int K=Integer.parseInt(st.nextToken());

    while(K!=A){
      if(K>=A*2){
        if(K%2==1){
          K--;
        }else{
          K/=2;
        }
        ans++;
      }else{
        ans+=K-A;
        break;
      }
    }


    bw.write(String.valueOf(ans));
    bw.flush();
    bw.close();
    br.close();
  }
}