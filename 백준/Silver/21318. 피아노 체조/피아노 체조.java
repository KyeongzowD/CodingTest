import java.util.*;
import java.io.*;

public class Main {
  static int N,Q;
  static int[] N_arr;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringBuilder sb=new StringBuilder();//for answer

    StringTokenizer st=new StringTokenizer(br.readLine());
    N=Integer.parseInt(st.nextToken());
    N_arr=new int[N];
    int[] sum_miss=new int[N];

    st=new StringTokenizer(br.readLine());
    N_arr[0]=Integer.parseInt(st.nextToken());
    sum_miss[0]=0;
    for(int i=1;i<N;i++){
      N_arr[i]=Integer.parseInt(st.nextToken());
      if(N_arr[i]<N_arr[i-1]){
        sum_miss[i]=1+sum_miss[i-1];
      }else{
        sum_miss[i]=sum_miss[i-1];
      }
    }

    st=new StringTokenizer(br.readLine());
    Q=Integer.parseInt(st.nextToken());

    for(int i=0;i<Q;i++){
      st=new StringTokenizer(br.readLine());
      int str=Integer.parseInt(st.nextToken())-1;
      int end=Integer.parseInt(st.nextToken())-1;
      int miss=sum_miss[end]-sum_miss[str];

      sb.append(String.valueOf(miss)).append("\n");
    }
  
    bw.write(String.valueOf(sb));
    bw.flush();
    br.close();
    bw.close();
  
  }

}