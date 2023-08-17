import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    StringTokenizer st=new StringTokenizer(br.readLine());
    int N=Integer.parseInt(st.nextToken());

    int[] arr=new int[N];
    
    for(int i=0;i<N;i++){
      st=new StringTokenizer(br.readLine());
      arr[i]=Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);

    int ans=arr[N-1];
    int j=2;
    for(int i=N-2;i>=0;i--){
      if(ans<arr[i]*j){
        ans=arr[i]*j;
      }
        j++;
    }
    
    bw.write(String.valueOf(ans));
    bw.flush();
    bw.close();
    br.close();
  }
}