import java.util.*;
import java.io.*;

public class Main {

  static int N;
  
  static class Top{
    int idx;
    int height;

    Top(int height,int idx){
      this.idx=idx;
      this.height=height;
    }
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    N=Integer.parseInt(br.readLine());//탑의 수 N
    Stack<Top> st=new Stack<Top>();
    StringBuilder sb = new StringBuilder("");//출력을 위한 StringBuilder

    int i=0;
    StringTokenizer stn=new StringTokenizer(br.readLine());
    st.push(new Top(Integer.parseInt(stn.nextToken()),++i));//첫번째 탑 객체 삽입
    sb.append("0 ");
    
    while(N-->1){
      int element=Integer.parseInt(stn.nextToken());

      while(!st.isEmpty()&&st.peek().height<element){
        st.pop();
      }

      if(st.isEmpty())//현재 탑의 높이보다 큰 탑이 없을 경우 0을 출력
        sb.append("0 ");
      else
        sb.append(st.peek().idx).append(" ");
      
      st.push(new Top(element,++i));//탑 객체 삽입
    }


    bw.write(String.valueOf(sb));
    bw.flush();
    bw.close();
    br.close();
  }
}