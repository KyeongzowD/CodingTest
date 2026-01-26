import java.io.*;
import java.util.*;

public class Main
{
	static class Teach{
		int start, finish;

		Teach(int start, int finish){
			this.start=start;
			this.finish=finish;
		}
	}

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N=Integer.parseInt(br.readLine());
		PriorityQueue<Teach> que=new PriorityQueue<>(
			Comparator.comparingInt((Teach t)-> t.start)
			.thenComparingInt((Teach t)-> t.finish));
	    
	    for(int i=0;i<N;i++){
	        StringTokenizer st=new StringTokenizer(br.readLine());
			que.offer(new Teach(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
	    }

		PriorityQueue<Integer> list=new PriorityQueue<>();
		list.offer(que.poll().finish);
		for(int i=0;i<N-1;i++){
			Teach t = que.poll();
			if(list.peek() <= t.start)
				list.poll();
			
			list.offer(t.finish);
		}

		System.out.println(list.size());
	}	
}
