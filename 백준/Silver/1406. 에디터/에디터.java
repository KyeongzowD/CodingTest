import java.util.*;
import java.io.*;
public class Main{
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> st_1=new Stack<>();
        Stack<Character> st_2=new Stack<>();
        String str=br.readLine();
        
        for(int i=0;i<str.length();i++){
            st_1.push(str.charAt(i));
        }
        
        int N=Integer.parseInt(br.readLine());
        
        for(int i=0;i<N;i++){
            String S=br.readLine();
            switch(S.charAt(0)){
                case 'L':
                    if(st_1.empty()==false){
                        st_2.push(st_1.pop());
                    }
                    break;
                case 'D':
                    if(st_2.empty()==false){
                        st_1.push(st_2.pop());
                    }
                    break;
                case 'B':
                    if(st_1.empty()==false){
                        st_1.pop();
                    }
                    break;
                case 'P':
                    st_1.push(S.charAt(2));
                    break;
                default:
            }
        }
        while(!st_1.empty()){
            st_2.push(st_1.pop());
        }
        while(!st_2.empty()){
            bw.write(st_2.pop());
        }
        bw.flush();
	}
}