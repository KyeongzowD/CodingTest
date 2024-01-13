import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N=Integer.parseInt(br.readLine());

    StringTokenizer st=new StringTokenizer(br.readLine());
    int[] arr=new int[N];

    for(int i=0;i<N;i++){
      arr[i]=Integer.parseInt(st.nextToken());
    }

    for(int i=1;i<N;i++){
      for(int j=0;j<=i/2;j++){
        if(arr[i]>arr[j]+arr[i-j-1]){
          arr[i]=arr[j]+arr[i-j-1];
        }
      }
    }

    bw.write(String.valueOf(arr[N-1]));
    bw.flush();
    bw.close();
    br.close();
  }
}