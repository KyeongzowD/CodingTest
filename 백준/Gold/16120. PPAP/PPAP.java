import java.util.*;
import java.io.*;
public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    Stack<Character> st=new Stack<Character>();
    String S=br.readLine();
    if(S.equals("P")){st.push('P');}
    else if(S.length()>3){
      for(int i=0;i<S.length();i++){
        if((st.size()>1)&&(S.charAt(i)=='A')&&(i!=S.length()-1)){
          if((st.pop()=='P')&&(st.peek()=='P')&&(S.charAt(i+1)=='P')){
            i++;
          }
          else{
            st.push('P');
            st.push(S.charAt(i));
            break;
          }
        }else{st.push(S.charAt(i));}
      }
    }
    if(st.size()==1){
      bw.write("PPAP");bw.flush();
    }else{
      bw.write("NP");bw.flush();
    }
	}
}