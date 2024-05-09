import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st=new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    int N=Integer.parseInt(st.nextToken());
    int M=Integer.parseInt(st.nextToken());

    st=new StringTokenizer(br.readLine());
    int arr[]=new int[N+1];

    arr[0]=0;
    for(int i=1;i<N+1;i++){//누적합으로 입력
      arr[i]=Integer.parseInt(st.nextToken())+arr[i-1];
    }

    for(int k=0;k<M;k++){//누적합 계산하기
      st=new StringTokenizer(br.readLine());
      int i=Integer.parseInt(st.nextToken());
      int j=Integer.parseInt(st.nextToken());

      int sum=arr[j]-arr[i-1];

      sb.append(Integer.toString(sum)).append('\n');
    }

    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
}