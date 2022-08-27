import java.util.*;
import java.lang.*;
import java.io.*;
public class Main{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            StringBuilder sb=new StringBuilder();
		    StringTokenizer st=new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()==true){
                sb.insert(0,st.nextToken()+" ");
            }
            System.out.println(sb.reverse().toString().trim());
        }
	}
}