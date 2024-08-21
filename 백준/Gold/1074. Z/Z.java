import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int r=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		int n=N;
		
		long ans=0;
		while(n!=1) {
			long value=(long)Math.pow(2, n)/2;//현재 배열 길이의 반
			int p=2*n-2;
			if(c>=value&&r<value) {//제 1사분면
				ans+=Math.pow(2, p);
				c-=value;
			}else if(c<value&&r>=value) {//제 3사분면
				ans+=Math.pow(2, p)*2;
				r-=value;
			}else if(c>=value&&r>=value){//제 4사분면
				ans+=Math.pow(2, p)*3;
				r-=value;
				c-=value;
			}//제 2사분면은 배열 사이즈를 줄일 필요가 없음
			n--;
		}
		
		if(r==0&&c==1)
			ans+=1;
		else if(r==1&&c==0)
			ans+=2;
		else if(r==1&&c==1)
			ans+=3;

		bw.write(String.valueOf(ans)); 
		bw.flush();
		bw.close();
		br.close();
	}
	
}
