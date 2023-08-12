import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st=new StringTokenizer(br.readLine());
    int N=Integer.parseInt(st.nextToken());
    int K=Integer.parseInt(st.nextToken());

    int ans=0;

    int[] arr=new int[N];

    for(int i=0;i<N;i++){
      arr[i]=Integer.parseInt(br.readLine());
    }

    for(int i=N-1;i>=0;i--){
      while(arr[i]<=K){
        K-=arr[i];
        ans++;
      }
    }

    bw.write(String.valueOf(ans));
    bw.flush();
    bw.close();
    br.close();
  }
}