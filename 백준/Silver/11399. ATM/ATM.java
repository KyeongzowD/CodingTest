import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    StringTokenizer st=new StringTokenizer(br.readLine());
    
    int N=Integer.parseInt(st.nextToken());
    int[] arr=new int[N];

    st=new StringTokenizer(br.readLine());

    for(int i=0;i<N;i++){
      arr[i]=Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);

    int num=0;
    int ans=0;
    
    for(int i=0;i<N;i++){
      ans+=arr[i];
      num+=ans;
    }
    
    bw.write(String.valueOf(num));
    bw.flush();
    bw.close();
    br.close();
  }
}