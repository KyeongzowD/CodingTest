import java.util.*;
import java.io.*;

public class Main {
  static int [] arr;
  static int N;
  static int K;
  static boolean[] visited;
  
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st=new StringTokenizer(br.readLine());

    N=Integer.parseInt(st.nextToken());
    K=Integer.parseInt(st.nextToken());

    st=new StringTokenizer(br.readLine());

    arr=new int[N];
    visited=new boolean[N];
    
    for(int i=0;i<N;i++){
      arr[i]=Integer.parseInt(st.nextToken());
    }

    visited[0]=true;
    for(int i=0;i<N-1;i++){
      if(!visited[i])
        continue;
      
      for(int j=i+1;j<N;j++){
        power(i,j);
      }
    }

    if(visited[N-1]==false)
      bw.write("NO");
    else
      bw.write("YES");
    
    bw.flush();
    bw.close();
    br.close();
  }

  static void power(int i,int j){
    int k=arr[i]>arr[j]?arr[i]-arr[j]:arr[j]-arr[i];
    k=(k+1)*(j-i);

    if(k<=K)
      visited[j]=true;
  }
}