import java.util.*;
import java.io.*;
import java.lang.*;
public class Main{
	public static void main(String[] args) throws IOException{
        Stack<String> st=new Stack<>();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int N=Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            String S=br.readLine();
            if(S.contains("push")){
                st.push(S.substring(5));
            }else if(S.contains("pop")){
                if(st.empty()==true){bw.write("-1\n");bw.flush();}
                else{bw.write(st.pop().toString()+"\n");bw.flush();}
            }else if(S.contains("size")){
                bw.write(st.size()+"\n");bw.flush();
            }else if(S.contains("empty")){
                if(st.empty()==true){bw.write("1\n");bw.flush();}
                else{bw.write("0\n");bw.flush();}
            }else if(S.contains("top")){
                if(st.empty()==true){bw.write("-1\n");bw.flush();}
                else{bw.write(st.peek().toString()+"\n");bw.flush();}
            }
        }br.close();bw.close();
	}
}
