import java.util.*;
import java.io.*;

public class Main {
  static int[] L;
  static int[] J;
  static int N;
  static int ans;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st=new StringTokenizer(br.readLine());
    N=Integer.parseInt(st.nextToken());
    
    L=new int[N];//체력
    J=new int[N];//기쁨

    ans=0;

    st=new StringTokenizer(br.readLine());
    for(int i=0;i<N;i++){
      L[i]=Integer.parseInt(st.nextToken());
    }
    
    st=new StringTokenizer(br.readLine());
    for(int i=0;i<N;i++){
      J[i]=Integer.parseInt(st.nextToken());
    }

    fun(0,100,0);
    
    bw.write(String.valueOf(ans));
    bw.flush();
    bw.close();
    br.close();
  }

  static void fun(int idx,int HP,int answer){
    if(HP<=0)
      return;
    
    if(answer>ans)
      ans=answer;
    
    if(idx<N)
    {
      fun(idx+1,HP,answer);

      HP-=L[idx];
      answer+=J[idx];
      fun(idx+1,HP,answer);
    } 
  }
}