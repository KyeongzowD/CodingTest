import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N=Integer.parseInt(br.readLine());

    int[] arr=new int[N+1];
    arr[0]=1; arr[1]=1;
    for(int i=2;i<=N;i++){
      arr[i]=(arr[i-1]+arr[i-2]*2)%10007;
    }

    bw.write(String.valueOf(arr[N]));
    bw.flush();
    bw.close();
    br.close();
  }
}