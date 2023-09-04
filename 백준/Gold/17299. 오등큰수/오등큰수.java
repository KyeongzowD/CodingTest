import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    Stack<Integer> st=new Stack<Integer>();
    
    int N=Integer.parseInt(br.readLine());
    int[] arr=new int[N];//(i)
    int[] cnt=new int[1000001];//원소의 값 (Ai)
    int[] ans=new int[N];

    StringTokenizer stk=new StringTokenizer(br.readLine());
    for(int i=0;i<N;i++){
      arr[i]=Integer.parseInt(stk.nextToken());
      cnt[arr[i]]++;
    }

    for(int i=0;i<N;i++){
      while(!st.isEmpty()&&cnt[arr[st.peek()]]<cnt[arr[i]]){
        ans[st.pop()]=arr[i];
      }
      st.add(i);
    }

    while(!st.isEmpty())
      ans[st.pop()]=-1;

    for(int i=0;i<N-1;i++){
      sb.append(ans[i]+" ");
    }sb.append(ans[N-1]);

    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
}

