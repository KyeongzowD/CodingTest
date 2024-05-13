import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args)throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    long answer=1;

    int N=Integer.parseInt(br.readLine());
      
    int M=Integer.parseInt(br.readLine());

    int[] arr=new int[N+1];
    arr[0]=1;
    arr[1]=1;
    for(int i=2;i<N+1;i++){
      arr[i]=arr[i-2]+arr[i-1];
    } 

    int last_num=0;
    for(int i=0;i<M;i++){
      int m=Integer.parseInt(br.readLine());
      if(m-last_num<1)
        continue;
      answer*=arr[m-last_num-1];
      last_num=m;
    }

    if(N-last_num>0)
      answer*=arr[N-last_num];

    bw.write(String.valueOf(answer));
    bw.flush();
    bw.close();
    br.close();
  }
}