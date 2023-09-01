import java.util.*;
import java.io.*;
class Main {
  public static void main(String[] args)throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    Stack<Character> st = new Stack<>();
    StringBuilder sb = new StringBuilder(br.readLine());//입력 받은 string

    for(int i=0;i<sb.length();i++){//띄어쓰기
      if(sb.charAt(i)=='<'||sb.charAt(i)==' '){
        while(!st.empty()){
          bw.write(st.pop());
          bw.flush();
        }
        if(sb.charAt(i)==' '){
          bw.write(" ");
          continue;
        }else{
          int start=i;
          while(sb.charAt(i)!='>'){
            i++;
          }
          int end=i;
          bw.write(sb.substring(start,end+1));
          bw.flush();
        }
      }else{
        st.push(sb.charAt(i));
      }
    }
    
    while(!st.empty()){
      bw.write(st.pop());
      bw.flush();
    }
    
    bw.flush();
    bw.close();
    br.close();
  }
}